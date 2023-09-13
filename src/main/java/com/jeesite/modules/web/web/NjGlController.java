package com.jeesite.modules.web.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.common.entity.Extend;
import com.jeesite.common.idgen.IdGen;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.modules.sys.entity.EmpUser;
import com.jeesite.modules.sys.entity.Office;
import com.jeesite.modules.sys.service.EmpUserService;
import com.jeesite.modules.sys.service.OfficeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.web.entity.NjGl;
import com.jeesite.modules.web.service.NjGlService;

/**
 * 年级管理表Controller
 * @author tulabu
 * @version 2023-02-09
 */
@Controller
@RequestMapping(value = "${adminPath}/web/njGl")
public class NjGlController extends BaseController {

	@Autowired
	private NjGlService njGlService;
	@Autowired
	private OfficeService officeService;
	@Autowired
	private EmpUserService empUserService;
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public NjGl get(String njId, boolean isNewRecord) {
		return njGlService.get(njId, isNewRecord);
	}

	/**
	 * 查询列表
	 */
	@RequiresPermissions("web:njGl:view")
	@RequestMapping(value = "list")
	public String list(Office office, Model model) {
		model.addAttribute("office", office);
		model.addAttribute("ctrlPermi", Global.getConfig("user.adminCtrlPermi", "2"));
		return "modules/web/njGlList";
	}
	@RequiresPermissions("web:njGl:view")
	@RequestMapping(value = "index")
	public String index(Office office, Model model) {
		model.addAttribute("office", office);
		model.addAttribute("ctrlPermi", Global.getConfig("user.adminCtrlPermi", "2"));
		return "modules/web/njGlIndex";
	}
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("web:njGl:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<NjGl> listData(NjGl njGl, HttpServletRequest request, HttpServletResponse response) {
		njGl.setPage(new Page<>(request, response));
		Page<NjGl> page = njGlService.findPage(njGl);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("web:njGl:view")
	@ExceptionHandler(value = {NullPointerException.class})
	@RequestMapping(value = "form")
	public String form(Office office, Model model){
		if (office.getOfficeCode()!=null){
			office =officeService.get(office.getOfficeCode());
		}
		if (office.getExtend()!=null) {
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
			if (last != null){
				office.setTreeSort(last.getTreeSort() + 30);
				office.setViewCode(IdGen.nextCode(last.getViewCode()));
			}else if (office.getParent() != null){
				office.setViewCode(office.getParent().getViewCode() + "001");
			}
		}
		List<EmpUser> collect =new ArrayList<>();
		if (office.getOfficeCode()!=null && office.getOfficeCode()!="null"){
			int stunum =0;
			List<Office> nianji = officeService.findList(new Office());
			List<EmpUser> userList = empUserService.findList(new EmpUser());
			Office finalOffice = office;
			try {
				collect =
						userList.stream().filter(s -> s.getEmployee().getOffice().getOfficeCode().equals(finalOffice.getOfficeCode())).collect(Collectors.toList());

			}catch (Exception e){

			}
		if (collect.size()>0){
				stunum +=collect.size();
			}
			if (nianji.size()>0){
				List<Office> banjilist =new ArrayList<>();
				try {
					banjilist=nianji.stream().filter(s -> s.getParentCode().equals(finalOffice.getOfficeCode())).collect(Collectors.toList());
				}catch (Exception e){

				}

				if (banjilist.size()>0){
					office.setExtend(new Extend());
					office.getExtend().setExtendI2(Long.valueOf(banjilist.size()));
						for (int i=0;i<banjilist.size();i++){
							String officeCode = banjilist.get(i).getOfficeCode();
							try {
								collect =
										userList.stream().filter(s -> s.getEmployee().getOffice().getOfficeCode().equals(officeCode)).collect(Collectors.toList());

							}catch (Exception e){

							}
						if (collect.size()>0){
								stunum +=collect.size();
							}

						}



				}
			}
			if (stunum!=0){
				office.getExtend().setExtendI3((long) stunum);
			}

		}
		model.addAttribute("office", office);
		model.addAttribute("ctrlPermi", Global.getConfig("user.adminCtrlPermi", "2"));
		return "modules/web/njGlForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("web:njGl:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated NjGl njGl) {
		njGlService.save(njGl);
		return renderResult(Global.TRUE, text("保存年级管理表成功！"));
	}

	/**
	 * 停用数据
	 */
	@RequiresPermissions("web:njGl:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(NjGl njGl) {
		njGl.setStatus(NjGl.STATUS_DISABLE);
		njGlService.updateStatus(njGl);
		return renderResult(Global.TRUE, text("停用年级管理表成功"));
	}

	/**
	 * 启用数据
	 */
	@RequiresPermissions("web:njGl:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(NjGl njGl) {
		njGl.setStatus(NjGl.STATUS_NORMAL);
		njGlService.updateStatus(njGl);
		return renderResult(Global.TRUE, text("启用年级管理表成功"));
	}

	/**
	 * 删除数据
	 */
	@RequiresPermissions("web:njGl:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(NjGl njGl) {
		njGlService.delete(njGl);
		return renderResult(Global.TRUE, text("删除年级管理表成功！"));
	}
	/**
	 * 创建并初始化下一个节点信息，如：排序号、默认值
	 */
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
			if (last != null){
				office.setTreeSort(last.getTreeSort() + 30);
				office.setViewCode(IdGen.nextCode(last.getViewCode()));
			}else if(office.getParent() != null){
				office.setViewCode(office.getParent().getViewCode() + "001");
			}
		}
		// 以下设置表单默认数据
		if (office.getTreeSort() == null){
			office.setTreeSort(Office.DEFAULT_TREE_SORT);
		}
		return office;
	}

}
