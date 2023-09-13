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
import com.jeesite.modules.web.entity.ToupiaoUser;
import com.jeesite.modules.web.service.ToupiaoUserService;

/**
 * 投票人Controller
 * @author tulabu
 * @version 2023-03-04
 */
@Controller
@RequestMapping(value = "${adminPath}/web/toupiaoUser")
public class ToupiaoUserController extends BaseController {

	@Autowired
	private ToupiaoUserService toupiaoUserService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ToupiaoUser get(String tpId, boolean isNewRecord) {
		return toupiaoUserService.get(tpId, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("web:toupiaoUser:view")
	@RequestMapping(value = {"list", ""})
	public String list(ToupiaoUser toupiaoUser, Model model) {
		model.addAttribute("toupiaoUser", toupiaoUser);
		return "modules/web/toupiaoUserList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("web:toupiaoUser:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ToupiaoUser> listData(ToupiaoUser toupiaoUser, HttpServletRequest request, HttpServletResponse response) {
		toupiaoUser.setPage(new Page<>(request, response));
		Page<ToupiaoUser> page = toupiaoUserService.findPage(toupiaoUser);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("web:toupiaoUser:view")
	@RequestMapping(value = "form")
	public String form(ToupiaoUser toupiaoUser, Model model) {
		model.addAttribute("toupiaoUser", toupiaoUser);
		return "modules/web/toupiaoUserForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("web:toupiaoUser:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ToupiaoUser toupiaoUser) {
		toupiaoUserService.save(toupiaoUser);
		return renderResult(Global.TRUE, text("保存投票人成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("web:toupiaoUser:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ToupiaoUser toupiaoUser) {
		toupiaoUserService.delete(toupiaoUser);
		return renderResult(Global.TRUE, text("删除投票人成功！"));
	}
	
}