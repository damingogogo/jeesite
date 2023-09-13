package com.jeesite.modules.web.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.collect.MapUtils;
import com.jeesite.common.entity.Extend;
import com.jeesite.common.idgen.IdGen;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.modules.sys.entity.EmpUser;
import com.jeesite.modules.sys.entity.Office;
import com.jeesite.modules.sys.service.EmpUserService;
import com.jeesite.modules.sys.service.OfficeService;
import com.jeesite.modules.web.entity.NjGl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.web.entity.ClassGl;
import com.jeesite.modules.web.service.ClassGlService;

/**
 * 班级管理表Controller
 *
 * @author tulabu
 * @version 2023-02-09
 */
@Controller
@RequestMapping(value = "${adminPath}/web/classGl")
public class ClassGlController extends BaseController {

    @Autowired
    private ClassGlService classGlService;
    @Autowired
    private OfficeService officeService;

    @Autowired
    private EmpUserService empUserService;

    /**
     * 获取数据
     */
    @ModelAttribute
    public ClassGl get(String classId, boolean isNewRecord) {
        return classGlService.get(classId, isNewRecord);
    }

    /**
     * 查询列表
     */
    @RequiresPermissions("web:classGl:view")
    @RequestMapping(value = "list")
    public String list(Office office, Model model) {
        model.addAttribute("office", office);
        model.addAttribute("ctrlPermi", Global.getConfig("user.adminCtrlPermi", "2"));
        return "modules/web/classGlList";
    }

    @RequiresPermissions("web:classGl:view")
    @RequestMapping(value = "index")
    public String index(Office office, Model model) {
        model.addAttribute("office", office);
        model.addAttribute("ctrlPermi", Global.getConfig("user.adminCtrlPermi", "2"));
        return "modules/web/classGlIndex";
    }

    /**
     * 查询列表数据
     */
    @RequiresPermissions("web:classGl:view")
    @RequestMapping(value = "listData")
    @ResponseBody
    public Page<ClassGl> listData(ClassGl classGl, HttpServletRequest request, HttpServletResponse response) {
        classGl.setPage(new Page<>(request, response));
        Page<ClassGl> page = classGlService.findPage(classGl);
        return page;
    }

    /**
     * 查看编辑表单
     */
    @RequiresPermissions("web:classGl:view")
    @RequestMapping(value = "form")
    public String form(Office office, Model model) {
        if (office.getOfficeCode() != null) {
            office = officeService.get(office.getOfficeCode());
        }

        if (office.getExtend() != null) {
            office.setExtend1(office.getExtend().getExtendS1());
        }
        // 创建并初始化下一个节点信息
        office = createNextNode(office);
        if (StringUtils.isNotBlank(office.getParentCode())) {
            office.setParent(officeService.get(office.getParentCode()));
        }
        if (office.getIsNewRecord()) {
            office.setTreeSort(30);
            Office where = new Office();
            where.setParentCode(office.getParentCode());
            Office last = officeService.getLastByParentCode(where);
            if (last != null) {
                office.setTreeSort(last.getTreeSort() + 30);
                office.setViewCode(IdGen.nextCode(last.getViewCode()));
            } else if (office.getParent() != null) {
                office.setViewCode(office.getParent().getViewCode() + "001");
            }
        }

        List<EmpUser> collect = new ArrayList<>();
        if (office.getOfficeCode() != null && office.getOfficeCode() != "null") {
            int stunum = 0;
            List<EmpUser> userList = empUserService.findList(new EmpUser());
            Office finalOffice = office;
            try {
                collect =
                        userList.stream().filter(s -> s.getEmployee().getOffice().getOfficeCode().equals(finalOffice.getOfficeCode())).collect(Collectors.toList());

            } catch (Exception e) {

            }
            if (collect.size() > 0) {
                stunum += collect.size();
            }
            if (stunum != 0) {
                office.getExtend().setExtendI3((long) stunum);
            }

        }

        model.addAttribute("office", office);
        model.addAttribute("ctrlPermi", Global.getConfig("user.adminCtrlPermi", "2"));
        return "modules/web/classGlForm";
    }

    /**
     * 保存数据
     */
    @RequiresPermissions("web:classGl:edit")
    @PostMapping(value = "save")
    @ResponseBody
    public String save(@Validated ClassGl classGl) {
        classGlService.save(classGl);
        return renderResult(Global.TRUE, text("保存班级管理表成功！"));
    }

    /**
     * 停用数据
     */
    @RequiresPermissions("web:classGl:edit")
    @RequestMapping(value = "disable")
    @ResponseBody
    public String disable(ClassGl classGl) {
        classGl.setStatus(ClassGl.STATUS_DISABLE);
        classGlService.updateStatus(classGl);
        return renderResult(Global.TRUE, text("停用班级管理表成功"));
    }

    /**
     * 启用数据
     */
    @RequiresPermissions("web:classGl:edit")
    @RequestMapping(value = "enable")
    @ResponseBody
    public String enable(ClassGl classGl) {
        classGl.setStatus(ClassGl.STATUS_NORMAL);
        classGlService.updateStatus(classGl);
        return renderResult(Global.TRUE, text("启用班级管理表成功"));
    }

    /**
     * 删除数据
     */
    @RequiresPermissions("web:classGl:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(ClassGl classGl) {
        classGlService.delete(classGl);
        return renderResult(Global.TRUE, text("删除班级管理表成功！"));
    }


    @RequestMapping(value = "treeNjData")
    @ResponseBody
    public List<Map<String, Object>> treeNjData(String type, String isShowCode) {
        List<Map<String, Object>> mapList = ListUtils.newArrayList();
        List<ClassGl> list = classGlService.findListNj(new ClassGl(), type);
        for (int i = 0; i < list.size(); i++) {
            ClassGl e = list.get(i);
            // 过滤非正常的数据
            if (!ClassGl.STATUS_NORMAL.equals(e.getStatus())) {
                continue;
            }
            Map<String, Object> map = MapUtils.newHashMap();
            map.put("id", e.getId());
            map.put("pId", e.getPId());
            map.put("name", e.getName());
            map.put("shuxing", e.getShuxing());
            map.put("indexType", e.getIndexType());

            mapList.add(map);
        }

        return mapList;
    }

    @RequiresPermissions("sys:office:edit")
    @RequestMapping(value = "createNextNode")
    @ResponseBody
    public Office createNextNode(Office office) {
        if (StringUtils.isNotBlank(office.getParentCode())) {
            office.setParent(officeService.get(office.getParentCode()));
        }
        if (office.getIsNewRecord()) {
            Office where = new Office();
            where.setParentCode(office.getParentCode());
            Office last = officeService.getLastByParentCode(where);
            // 获取到下级最后一个节点
            if (last != null) {
                office.setTreeSort(last.getTreeSort() + 30);
                office.setViewCode(IdGen.nextCode(last.getViewCode()));
            } else if (office.getParent() != null) {
                office.setViewCode(office.getParent().getViewCode() + "001");
            }
        }
        // 以下设置表单默认数据
        if (office.getTreeSort() == null) {
            office.setTreeSort(Office.DEFAULT_TREE_SORT);
        }
        return office;
    }
}
