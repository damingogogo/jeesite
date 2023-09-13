package com.jeesite.modules.web.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.common.lang.StringUtils;
import com.jeesite.modules.sys.entity.User;
import com.jeesite.modules.sys.service.EmployeeService;
import com.jeesite.modules.sys.service.UserService;
import com.jeesite.modules.web.entity.BaomingGl;
import com.jeesite.modules.web.entity.ToupGl;
import com.jeesite.modules.web.service.BaomingGlService;
import com.jeesite.modules.web.service.BaomingStasticService;
import com.jeesite.modules.web.service.ToupGlService;
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
import com.jeesite.modules.web.entity.ToupiaoGl;
import com.jeesite.modules.web.service.ToupiaoGlService;

/**
 * 投票管理Controller
 * @author tulabu
 * @version 2023-02-14
 */
@Controller
@RequestMapping(value = "${adminPath}/web/toupiaoGl")
public class ToupiaoGlController extends BaseController {
	@Autowired
	private UserService userService;
	@Autowired
	private ToupGlService toupGlService;
	@Autowired
	private BaomingStasticService baomingStasticService;

	@Autowired
	private EmployeeService employeeService;

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
	@RequiresPermissions("web:baomingGl:view")
	@RequestMapping(value = {"list", ""})
	public String list(ToupGl baomingGl, Model model) {
		model.addAttribute("baomingGl", baomingGl);
		return "modules/web/toupiaoGlList";
	}

	@RequiresPermissions("web:baomingGl:view")
	@RequestMapping(value = "baominglist")
	public String baominglist(ToupGl baomingGl, Model model) {
		model.addAttribute("baomingGl", baomingGl);
		return "modules/web/toupiaolist";
	}
	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("web:baomingGl:view")
	@RequestMapping(value = "form")
	public String form(ToupGl baomingGl, Model model) {
		if (StringUtils.isEmpty(baomingGl.getBaomingId())  && StringUtils.isNoneEmpty(baomingGl.getUserCodes())){
//			User user = userService.get(baomingGl.getUserCode());
//			baomingGl.setLoginCode(user.getLoginCode());
//			baomingGl.setUserName(user.getUserName());
		}
		model.addAttribute("baomingGl", baomingGl);
		return "modules/web/toupiaoGlForm";
	}
}
