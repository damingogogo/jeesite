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
import com.jeesite.modules.web.entity.TianbGl;
import com.jeesite.modules.web.service.TianbGlService;

/**
 * 报名管理Controller
 * @author Tr
 * @version 2023-06-25
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/tianbGl")
public class TianbGlController extends BaseController {

	@Autowired
	private TianbGlService tianbGlService;
	
	/**
	 *
	 */
	@ModelAttribute
	public TianbGl get(String baomingId, boolean isNewRecord) {
		return tianbGlService.get(baomingId, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("sys:tianbGl:view")
	@RequestMapping(value = {"list", ""})
	public String list(TianbGl tianbGl, Model model) {
		model.addAttribute("tianbGl", tianbGl);
		return "modules/sys/tianbGlList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("sys:tianbGl:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TianbGl> listData(TianbGl tianbGl, HttpServletRequest request, HttpServletResponse response) {
		tianbGl.setPage(new Page<>(request, response));
		Page<TianbGl> page = tianbGlService.findPage(tianbGl);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("sys:tianbGl:view")
	@RequestMapping(value = "form")
	public String form(TianbGl tianbGl, Model model) {
		model.addAttribute("tianbGl", tianbGl);
		return "modules/sys/tianbGlForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("sys:tianbGl:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TianbGl tianbGl) {
		tianbGlService.save(tianbGl);
		return renderResult(Global.TRUE, text("保存报名管理成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("sys:tianbGl:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TianbGl tianbGl) {
		tianbGlService.delete(tianbGl);
		return renderResult(Global.TRUE, text("删除报名管理成功！"));
	}
	
}