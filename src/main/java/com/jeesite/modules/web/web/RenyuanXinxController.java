package com.jeesite.modules.web.web;

import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.collect.MapUtils;
import com.jeesite.common.config.Global;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.modules.sys.entity.Office;
import com.jeesite.modules.sys.service.OfficeService;
import com.jeesite.modules.sys.web.user.EmpUserController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "${adminPath}/web/office")
public class RenyuanXinxController {
    @Autowired
    private OfficeService officeService;
    @Autowired
    private EmpUserController empUserController;
    @RequiresPermissions("user")
    @RequestMapping(value = "treeData")
    @ResponseBody
    public List<Map<String, Object>> treeData(String excludeCode, String parentCode, Boolean isAll,
                                              String officeTypes, String companyCode, String isShowCode, String isShowFullName,
                                              String isLoadUser, String userIdPrefix, String postCode, String roleCode, String ctrlPermi, String shuxing) {
        List<Map<String, Object>> mapList = ListUtils.newArrayList();
        Office where = new Office();
        where.setStatus(Office.STATUS_NORMAL);
        where.setCompanyCode(companyCode);
        where.setShuxing(shuxing);
        if (!(isAll != null && isAll) || Global.isStrictMode()){
            officeService.addDataScopeFilter(where, ctrlPermi);
        }
        // 根据父节点过滤数据
        if (StringUtils.isNotBlank(parentCode)){
            where.setParentCode(parentCode);
        }
        // 根据部门类型过滤数据
        if (StringUtils.isNotBlank(officeTypes)){
            where.setOfficeType_in(officeTypes.split(","));
        }
        List<String> idList = ListUtils.newArrayList();
        List<Office> list = officeService.findList(where);
        for (int i = 0; i < list.size(); i++) {
            Office e = list.get(i);
            // 过滤非正常的数据
            if (!Office.STATUS_NORMAL.equals(e.getStatus())){
                continue;
            }
            // 过滤被排除的编码（包括所有子级）
            if (StringUtils.isNotBlank(excludeCode)){
                if (e.getId().equals(excludeCode)){
                    continue;
                }
                if (e.getParentCodes().contains("," + excludeCode + ",")){
                    continue;
                }
            }
            idList.add(e.getId());
            Map<String, Object> map = MapUtils.newHashMap();
            map.put("id", e.getId());
            map.put("pId", e.getParentCode());
            String name = e.getOfficeName();
            if ("true".equals(isShowFullName) || "1".equals(isShowFullName)){
                name = e.getFullName();
            }
            map.put("code", e.getViewCode());
            map.put("name", StringUtils.getTreeNodeName(isShowCode, e.getViewCode(), name));
            map.put("title", e.getFullName());
            // 返回是否是父节点，如果需要加载用户，则全部都是父节点，来加载用户数据
            map.put("isParent", !e.getIsTreeLeaf() || StringUtils.inString(isLoadUser, "true", "lazy"));
            mapList.add(map);
        }
        // 一次性后台加载用户，若数据量比较大，建议使用懒加载
        if (StringUtils.equals(isLoadUser, "true") && idList.size() > 0) {
            List<Map<String, Object>> userList =
                    empUserController.treeData(userIdPrefix, idList.toArray(new String[idList.size()]),
                            companyCode, postCode, roleCode, isAll, isShowCode, ctrlPermi);
            mapList.addAll(userList);
        }
        // 懒加载用户，点击叶子节点的时候再去加载部门（懒加载无法回显，数据量大时，建议使用 listselect 实现列表选择用户）
        if (StringUtils.inString(isLoadUser, "lazy") && StringUtils.isNotBlank(parentCode)) {
            List<Map<String, Object>> userList =
                    empUserController.treeData(userIdPrefix, new String[]{parentCode},
                            companyCode, postCode, roleCode, isAll, isShowCode, ctrlPermi);
            mapList.addAll(userList);
        }
        return mapList;
    }
}
