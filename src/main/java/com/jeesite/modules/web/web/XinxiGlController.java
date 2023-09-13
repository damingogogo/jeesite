package com.jeesite.modules.web.web;

import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.collect.MapUtils;
import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.sys.entity.EmpUser;
import com.jeesite.modules.sys.entity.Post;
import com.jeesite.modules.sys.entity.Role;
import com.jeesite.modules.sys.entity.User;
import com.jeesite.modules.sys.service.PostService;
import com.jeesite.modules.sys.service.RoleService;
import com.jeesite.modules.web.entity.ClassGl;
import com.jeesite.modules.web.entity.NjGl;
import com.jeesite.modules.web.service.ClassGlService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "${adminPath}/web/xinxiGl")
public class XinxiGlController extends BaseController {

	@Autowired
	private ClassGlService classGlService;
	@Resource
	private PostService postService;
	@Resource
	private RoleService roleService;
	/**
	 * 查询列表
	 */
	@RequiresPermissions("web:xinxiGl:view")
	@RequestMapping(value = "listteacher")
	public String listteacher(EmpUser empUser, Model model) {
		// 获取角色列表
		Role role = new Role();
		role.setUserType(User.USER_TYPE_EMPLOYEE);
		model.addAttribute("roleList", roleService.findList(role));
		// 获取岗位列表
		Post post = new Post();
		model.addAttribute("postList", postService.findList(post));
		empUser.setXinxiType("1");
		model.addAttribute("empUser", empUser);
		// 获取控制权限类型
		model.addAttribute("ctrlPermi", Global.getConfig("user.adminCtrlPermi", "2"));
		return "modules/web/teacherList";
	}
	@RequiresPermissions("web:njGl:view")
	@RequestMapping(value = "teacherindex")
	public String teacherindex(EmpUser empUser, Model model) {
		model.addAttribute("empUser", empUser);
		return "modules/web/teacherListIndex";
	}


	@RequiresPermissions("web:xinxiGl:view")
	@RequestMapping(value = "liststudent")
	public String liststudent(EmpUser empUser, Model model) {
		// 获取角色列表
		Role role = new Role();
		role.setUserType(User.USER_TYPE_EMPLOYEE);
		model.addAttribute("roleList", roleService.findList(role));
		// 获取岗位列表
		Post post = new Post();
		model.addAttribute("postList", postService.findList(post));
		empUser.setXinxiType("3");
		model.addAttribute("empUser", empUser);
		// 获取控制权限类型
		model.addAttribute("ctrlPermi", Global.getConfig("user.adminCtrlPermi", "2"));
		return "modules/web/studentList";
	}
	@RequiresPermissions("web:njGl:view")
	@RequestMapping(value = "studentindex")
	public String studentindex(EmpUser empUser, Model model) {
		model.addAttribute("empUser", empUser);
		return "modules/web/studendIndex";
	}

	@RequiresPermissions("web:xinxiGl:view")
	@RequestMapping(value = "listjiaZhang")
	public String listjiaZhang(EmpUser empUser, Model model) {
		// 获取角色列表
		Role role = new Role();
		role.setUserType(User.USER_TYPE_EMPLOYEE);
		model.addAttribute("roleList", roleService.findList(role));
		// 获取岗位列表
		Post post = new Post();
		model.addAttribute("postList", postService.findList(post));
		empUser.setXinxiType("2");
		model.addAttribute("empUser", empUser);
		// 获取控制权限类型
		model.addAttribute("ctrlPermi", Global.getConfig("user.adminCtrlPermi", "2"));
		return "modules/web/jiaZhangList";
	}
	@RequiresPermissions("web:njGl:view")
	@RequestMapping(value = "jiaZhangindex")
	public String jiaZhangindex(EmpUser empUser, Model model) {
		model.addAttribute("empUser", empUser);
		return "modules/web/jiaZhangIndex";
	}
}