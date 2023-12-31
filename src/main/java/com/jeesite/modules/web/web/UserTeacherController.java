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
import com.jeesite.modules.web.entity.UserTeacher;
import com.jeesite.modules.web.service.UserTeacherService;

/**
 * 用户表Controller
 * @author Tr
 * @version 2023-06-26
 */
@Controller
@RequestMapping(value = "${adminPath}/web/userTeacher")
public class UserTeacherController extends BaseController {

	@Autowired
	private UserTeacherService userTeacherService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public UserTeacher get(String userCode, boolean isNewRecord) {
		return userTeacherService.get(userCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("web:userTeacher:view")
	@RequestMapping(value = {"list", ""})
	public String list(UserTeacher userTeacher, Model model) {
		model.addAttribute("userTeacher", userTeacher);
		return "modules/web/userTeacherList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("web:userTeacher:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<UserTeacher> listData(UserTeacher userTeacher, HttpServletRequest request, HttpServletResponse response) {
		userTeacher.setPage(new Page<>(request, response));
		Page<UserTeacher> page = userTeacherService.findPage(userTeacher);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("web:userTeacher:view")
	@RequestMapping(value = "form")
	public String form(UserTeacher userTeacher, Model model) {
		model.addAttribute("userTeacher", userTeacher);
		return "modules/web/userTeacherForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("web:userTeacher:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated UserTeacher userTeacher) {
		userTeacherService.save(userTeacher);
		return renderResult(Global.TRUE, text("保存用户表成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("web:userTeacher:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(UserTeacher userTeacher) {
		userTeacherService.delete(userTeacher);
		return renderResult(Global.TRUE, text("删除用户表成功！"));
	}
	
}