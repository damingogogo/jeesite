package com.jeesite.modules.web.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.jeesite.modules.web.entity.SubjectGl;
import com.jeesite.modules.web.service.SubjectGlService;

/**
 * 科目管理表Controller
 * @author tulabu
 * @version 2023-02-09
 */
@Controller
@RequestMapping(value = "${adminPath}/web/subjectGl")
public class SubjectGlController extends BaseController {

	@Autowired
	private SubjectGlService subjectGlService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SubjectGl get(String subjectId, boolean isNewRecord) {
		return subjectGlService.get(subjectId, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("web:subjectGl:view")
	@RequestMapping(value = {"list", ""})
	public String list(SubjectGl subjectGl, Model model) {
		model.addAttribute("subjectGl", subjectGl);
		return "modules/web/subjectGlList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("web:subjectGl:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<SubjectGl> listData(SubjectGl subjectGl, HttpServletRequest request, HttpServletResponse response) {
		subjectGl.setPage(new Page<>(request, response));
		Page<SubjectGl> page = subjectGlService.findPage(subjectGl);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("web:subjectGl:view")
	@RequestMapping(value = "form")
	public String form(SubjectGl subjectGl, Model model) {
		model.addAttribute("subjectGl", subjectGl);
		return "modules/web/subjectGlForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("web:subjectGl:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated SubjectGl subjectGl) {
		subjectGlService.save(subjectGl);
		return renderResult(Global.TRUE, text("保存科目管理表成功！"));
	}
	
	/**
	 * 停用数据
	 */
	@RequiresPermissions("web:subjectGl:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(SubjectGl subjectGl) {
		subjectGl.setStatus(SubjectGl.STATUS_DISABLE);
		subjectGlService.updateStatus(subjectGl);
		return renderResult(Global.TRUE, text("停用科目管理表成功"));
	}
	
	/**
	 * 启用数据
	 */
	@RequiresPermissions("web:subjectGl:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(SubjectGl subjectGl) {
		subjectGl.setStatus(SubjectGl.STATUS_NORMAL);
		subjectGlService.updateStatus(subjectGl);
		return renderResult(Global.TRUE, text("启用科目管理表成功"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("web:subjectGl:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(SubjectGl subjectGl) {
		subjectGlService.delete(subjectGl);
		return renderResult(Global.TRUE, text("删除科目管理表成功！"));
	}
	
}