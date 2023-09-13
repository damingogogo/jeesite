package com.jeesite.modules.web.web;

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
import com.jeesite.modules.web.entity.ToupGl;
import com.jeesite.modules.web.service.ToupGlService;

/**
 * 报名管理Controller
 * @author Tr
 * @version 2023-06-25
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/toupGl")
public class ToupGlController extends BaseController {

	@Autowired
	private ToupGlService toupGlService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ToupGl get(String baomingId, boolean isNewRecord) {
		return toupGlService.get(baomingId, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("sys:toupGl:view")
	@RequestMapping(value = {"list", ""})
	public String list(ToupGl toupGl, Model model) {
		model.addAttribute("toupGl", toupGl);
		return "modules/sys/toupGlList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("sys:toupGl:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ToupGl> listData(ToupGl toupGl, HttpServletRequest request, HttpServletResponse response) {
		toupGl.setPage(new Page<>(request, response));
		Page<ToupGl> page = toupGlService.findPage(toupGl);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("sys:toupGl:view")
	@RequestMapping(value = "form")
	public String form(ToupGl toupGl, Model model) {
		model.addAttribute("toupGl", toupGl);
		return "modules/sys/toupGlForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("sys:toupGl:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ToupGl toupGl) {
		toupGlService.save(toupGl);
		return renderResult(Global.TRUE, text("保存报名管理成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("sys:toupGl:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ToupGl toupGl) {
		toupGlService.delete(toupGl);
		return renderResult(Global.TRUE, text("删除报名管理成功！"));
	}
	
}