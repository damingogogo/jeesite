package com.jeesite.modules.web.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
import com.jeesite.modules.web.entity.Gongg;
import com.jeesite.modules.web.service.GonggService;

/**
 * 公告表Controller
 * @author tulabu
 * @version 2023-02-09
 */
@Controller
@RequestMapping(value = "${adminPath}/web/gongg")
public class GonggController extends BaseController {

	@Autowired
	private GonggService gonggService;

	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Gongg get(String id, boolean isNewRecord) {
		return gonggService.get(id, isNewRecord);
	}

	/**
	 * 查询列表
	 */
	@RequiresPermissions("web:gongg:view")
	@RequestMapping(value = {"list", ""})
	public String list(Gongg gongg, Model model) {
		model.addAttribute("gongg", gongg);
		return "modules/web/gonggList";
	}

	@RequiresPermissions("web:gongg:view")
	@RequestMapping(value = {"listtzx"})
	public String listtzx(Gongg gongg, Model model) {
		gongg.setGonggType("1");
		model.addAttribute("gongg", gongg);
		return "modules/web/gonggTzxList";
	}

	@RequiresPermissions("web:gongg:view")
	@RequestMapping(value = {"listhyx"})
	public String listhyx(Gongg gongg, Model model) {
		gongg.setGonggType("2");
		model.addAttribute("gongg", gongg);
		return "modules/web/gonggHuiyxList";
	}

	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("web:gongg:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Gongg> listData(Gongg gongg, HttpServletRequest request, HttpServletResponse response) {
		gongg.setPage(new Page<>(request, response));
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(new Date());
//		if (gongg.getShujuDay()==null){
//			calendar.add(Calendar.MONTH, -1); //减几就是几个月之前
//		}else {
//			calendar.add(Calendar.DAY_OF_MONTH, -Integer.parseInt(gongg.getShujuDay())); //当前时间减去一天，即一天前的时间
//		}
//
//		Date m = calendar.getTime();
////		String mon = format.format(m);
//		gongg.setCreateDate(m);
		Page<Gongg> page = gonggService.findPage(gongg);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("web:gongg:view")
	@RequestMapping(value = "form")
	public String form(Gongg gongg, Model model) {
		model.addAttribute("gongg", gongg);
		return "modules/web/gonggForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("web:gongg:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Gongg gongg) {
		gonggService.save(gongg);
		return renderResult(Global.TRUE, text("保存公告表成功！"));
	}

	/**
	 * 停用数据
	 */
	@RequiresPermissions("web:gongg:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(Gongg gongg) {
		gongg.setStatus(Gongg.STATUS_DISABLE);
		gonggService.updateStatus(gongg);
		return renderResult(Global.TRUE, text("停用公告表成功"));
	}

	/**
	 * 启用数据
	 */
	@RequiresPermissions("web:gongg:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(Gongg gongg) {
		gongg.setStatus(Gongg.STATUS_NORMAL);
		gonggService.updateStatus(gongg);
		return renderResult(Global.TRUE, text("启用公告表成功"));
	}

	/**
	 * 删除数据
	 */
	@RequiresPermissions("web:gongg:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Gongg gongg) {
		gonggService.delete(gongg);
		return renderResult(Global.TRUE, text("删除公告表成功！"));
	}
	@RequestMapping(value = "getGonggInd")
	@ResponseBody
	public List<Map<String, Object>> getGonggInd(Gongg gongg) {
		List<Map<String, Object>> mapList=gonggService.findbaomingtj(gongg);
		return mapList;
	}

}
