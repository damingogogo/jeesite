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
import com.jeesite.modules.web.entity.UserJiaz;
import com.jeesite.modules.web.service.UserJiazService;

/**
 * 用户表Controller
 * @author Tr
 * @version 2023-06-26
 */
@Controller
@RequestMapping(value = "${adminPath}/web/userJiaz")
public class UserJiazController extends BaseController {

	@Autowired
	private UserJiazService userJiazService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public UserJiaz get(String userCode, boolean isNewRecord) {
		return userJiazService.get(userCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("web:userJiaz:view")
	@RequestMapping(value = {"list", ""})
	public String list(UserJiaz userJiaz, Model model) {
		model.addAttribute("userJiaz", userJiaz);
		return "modules/web/userJiazList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("web:userJiaz:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<UserJiaz> listData(UserJiaz userJiaz, HttpServletRequest request, HttpServletResponse response) {
		userJiaz.setPage(new Page<>(request, response));
		Page<UserJiaz> page = userJiazService.findPage(userJiaz);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("web:userJiaz:view")
	@RequestMapping(value = "form")
	public String form(UserJiaz userJiaz, Model model) {
		model.addAttribute("userJiaz", userJiaz);
		return "modules/web/userJiazForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("web:userJiaz:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated UserJiaz userJiaz) {
		userJiazService.save(userJiaz);
		return renderResult(Global.TRUE, text("保存用户表成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("web:userJiaz:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(UserJiaz userJiaz) {
		userJiazService.delete(userJiaz);
		return renderResult(Global.TRUE, text("删除用户表成功！"));
	}
	
}