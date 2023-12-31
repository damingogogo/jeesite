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
import com.jeesite.modules.web.entity.UserStudent;
import com.jeesite.modules.web.service.UserStudentService;

/**
 * 用户表Controller
 * @author Tr
 * @version 2023-06-26
 */
@Controller
@RequestMapping(value = "${adminPath}/web/userStudent")
public class UserStudentController extends BaseController {

	@Autowired
	private UserStudentService userStudentService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public UserStudent get(String userCode, boolean isNewRecord) {
		return userStudentService.get(userCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("web:userStudent:view")
	@RequestMapping(value = {"list", ""})
	public String list(UserStudent userStudent, Model model) {
		model.addAttribute("userStudent", userStudent);
		return "modules/web/userStudentList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("web:userStudent:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<UserStudent> listData(UserStudent userStudent, HttpServletRequest request, HttpServletResponse response) {
		userStudent.setPage(new Page<>(request, response));
		Page<UserStudent> page = userStudentService.findPage(userStudent);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("web:userStudent:view")
	@RequestMapping(value = "form")
	public String form(UserStudent userStudent, Model model) {
		model.addAttribute("userStudent", userStudent);
		return "modules/web/userStudentForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("web:userStudent:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated UserStudent userStudent) {
		userStudentService.save(userStudent);
		return renderResult(Global.TRUE, text("保存用户表成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("web:userStudent:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(UserStudent userStudent) {
		userStudentService.delete(userStudent);
		return renderResult(Global.TRUE, text("删除用户表成功！"));
	}
	
}