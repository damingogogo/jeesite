package com.jeesite.modules.web.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONValidator;
import com.jeesite.common.codec.EncodeUtils;
import com.jeesite.modules.sys.entity.EmpUser;
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
import com.jeesite.modules.web.entity.BtoupiaoUser;
import com.jeesite.modules.web.service.BtoupiaoUserService;

/**
 * 被投票人Controller
 * @author tulabu
 * @version 2023-03-04
 */
@Controller
@RequestMapping(value = "${adminPath}/web/btoupiaoUser")
public class BtoupiaoUserController extends BaseController {

	@Autowired
	private BtoupiaoUserService btoupiaoUserService;

	/**
	 * 获取数据
	 */
	@ModelAttribute
	public BtoupiaoUser get(String btpId, boolean isNewRecord) {
		return btoupiaoUserService.get(btpId, isNewRecord);
	}

	/**
	 * 查询列表
	 */
	@RequiresPermissions("web:btoupiaoUser:view")
	@RequestMapping(value = {"list", ""})
	public String list(BtoupiaoUser btoupiaoUser, Model model) {
		model.addAttribute("btoupiaoUser", btoupiaoUser);
		return "modules/web/btoupiaoUserList";
	}

	/**
	 * 查询列表数据
	 */
//	@RequiresPermissions("web:btoupiaoUser:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<BtoupiaoUser> listData(BtoupiaoUser btoupiaoUser, HttpServletRequest request, HttpServletResponse response) {
		btoupiaoUser.setPage(new Page<>(request, response));
		Page<BtoupiaoUser> page = btoupiaoUserService.findPage(btoupiaoUser);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("web:btoupiaoUser:view")
	@RequestMapping(value = "form")
	public String form(BtoupiaoUser btoupiaoUser, Model model) {
		model.addAttribute("btoupiaoUser", btoupiaoUser);
		return "modules/web/btoupiaoUserForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("web:btoupiaoUser:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated BtoupiaoUser btoupiaoUser) {
		btoupiaoUserService.save(btoupiaoUser);
		return renderResult(Global.TRUE, text("保存被投票人成功！"));
	}

	/**
	 * 删除数据
	 */
	@RequiresPermissions("web:btoupiaoUser:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(BtoupiaoUser btoupiaoUser) {
		btoupiaoUserService.delete(btoupiaoUser);
		return renderResult(Global.TRUE, text("删除被投票人成功！"));
	}

	@RequestMapping(value = "UserSelect")
	public String UserSelect(BtoupiaoUser btoupiaoUser, String selectData, Model model) {
		String selectDataJson = EncodeUtils.decodeUrl(selectData);
		if (selectDataJson != null && JSONValidator.from(selectDataJson).validate()){
			model.addAttribute("selectData", selectDataJson);
		}
		// 获取角色列表
//		Role role = new Role();
//		role.setUserType(User.USER_TYPE_MEMBER);
//		model.addAttribute("roleList", roleService.findList(role));
		model.addAttribute("empUser", btoupiaoUser);
		return "modules/web/userSelectTp";
	}

}
