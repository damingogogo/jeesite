package com.jeesite.modules.web.web;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.sys.entity.Employee;
import com.jeesite.modules.sys.entity.User;
import com.jeesite.modules.sys.service.EmployeeService;
import com.jeesite.modules.sys.utils.UserUtils;
import com.jeesite.modules.web.entity.BaomingGl;
import com.jeesite.modules.web.entity.BaomingStastic;
import com.jeesite.modules.web.entity.TianbGl;
import com.jeesite.modules.web.service.BaomingGlService;
import com.jeesite.modules.web.service.BaomingStasticService;
import com.jeesite.modules.web.service.TianbGlService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 报名管理Controller
 * @author tulabu
 * @version 2023-02-11
 */
@Controller
@RequestMapping(value = "${adminPath}/web/tianbaoGl")
public class TianbaoGlController extends BaseController {

	@Autowired
	private TianbGlService tianbGlService;
	

	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TianbGl get(String baomingId, boolean isNewRecord) {
		return tianbGlService.get(baomingId, isNewRecord);
	}

	/**
	 * 查询列表
	 */
	@RequiresPermissions("web:baomingGl:view")
	@RequestMapping(value = {"list", ""})
	public String list(TianbGl baomingGl, Model model) {
		model.addAttribute("baomingGl", baomingGl);
		return "modules/web/tianbaoGlList";
	}

	@RequiresPermissions("web:baomingGl:view")
	@RequestMapping(value = "baominglist")
	public String baominglist(TianbGl baomingGl, Model model) {
		model.addAttribute("baomingGl", baomingGl);
		return "modules/web/tianbaolist";
	}
	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("web:baomingGl:view")
	@RequestMapping(value = "form")
	public String form(TianbGl baomingGl, Model model) {
		model.addAttribute("baomingGl", baomingGl);
		return "modules/web/tianbaoGlForm";
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "addfileform")
	public String addfileform(TianbGl baomingGl, Model model) {
		model.addAttribute("baomingGl", baomingGl);
		return "modules/web/tianbaoGlFileForm";
	}
}
