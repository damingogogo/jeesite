package com.jeesite.modules.web.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.web.entity.BaomingStastic;
import com.jeesite.modules.web.service.BaomingGlService;
import com.jeesite.modules.web.service.BaomingStasticService;
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
import com.jeesite.modules.web.entity.ToupiaoStastic;
import com.jeesite.modules.web.service.ToupiaoStasticService;

/**
 * 投票统计Controller
 * @author tulabu
 * @version 2023-02-14
 */
@Controller
@RequestMapping(value = "${adminPath}/web/toupiaoStastic")
public class ToupiaoStasticController extends BaseController {


	@Autowired
	private BaomingStasticService baomingStasticService;
	@Autowired
	private BaomingGlService baomingGlService;

	/**
	 * 获取数据
	 */
	@ModelAttribute
	public BaomingStastic get(String id, boolean isNewRecord) {
		return baomingStasticService.get(id, isNewRecord);
	}

	/**
	 * 查询列表
	 */
	@RequiresPermissions("web:baomingStastic:view")
	@RequestMapping(value = "list")
	public String list(BaomingStastic baomingStastic, Model model) {
		baomingStastic.setBtType("3");
		int zb = baomingStasticService.findList(baomingStastic).size();
		baomingStastic.setZb(String.valueOf(zb));
		model.addAttribute("baomingStastic", baomingStastic);
		return "modules/web/toupiaoStasticList";
	}



	@RequiresPermissions("web:baomingStastic:view")
	@RequestMapping(value = "listToupr")
	public String listToupr(BaomingStastic baomingStastic, Model model) {
		model.addAttribute("baomingStastic", baomingStastic);
		return "modules/web/touprStasticList";
	}

//	@RequiresPermissions("web:baomingStastic:view")
//	@RequestMapping(value = "index")
//	public String index(BaomingStastic baomingStastic, Model model) {
//		model.addAttribute("baomingStastic", baomingStastic);
//		return "modules/web/toupiaoStasticIndex";
//	}
	/**
	 * 查看编辑表单
	 */
//	@RequiresPermissions("web:baomingStastic:view")
//	@RequestMapping(value = "form")
//	public String form(BaomingStastic baomingStastic, Model model) {
//		model.addAttribute("baomingStastic", baomingStastic);
//		return "modules/web/tianbaoStasticForm";
//	}
}
