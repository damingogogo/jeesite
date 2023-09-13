package com.jeesite.modules.web.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.sys.entity.User;
import com.jeesite.modules.sys.utils.UserUtils;
import com.jeesite.modules.web.entity.Gongg;
import com.jeesite.modules.web.service.GonggService;
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
import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.entity.Page;
import com.jeesite.common.lang.DateUtils;
import com.jeesite.common.utils.excel.ExcelExport;
import com.jeesite.common.utils.excel.annotation.ExcelField.Type;
import org.springframework.web.multipart.MultipartFile;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.web.entity.GonggHuiy;
import com.jeesite.modules.web.service.GonggHuiyService;

/**
 * 公告回应Controller
 * @author tulabu
 * @version 2023-02-11
 */
@Controller
@RequestMapping(value = "${adminPath}/web/gonggHuiy")
public class GonggHuiyController extends BaseController {


	private GonggHuiyService gonggHuiyService;
	@Autowired
	private GonggService gonggService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public GonggHuiy get(String id, boolean isNewRecord) {
		return gonggHuiyService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("web:gonggHuiy:view")
	@RequestMapping(value = {"list", ""})
	public String list(GonggHuiy gonggHuiy, Model model) {
		model.addAttribute("gonggHuiy", gonggHuiy);
		return "modules/web/gonggHuiyList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("web:gonggHuiy:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<GonggHuiy> listData(GonggHuiy gonggHuiy, HttpServletRequest request, HttpServletResponse response) {
		gonggHuiy.setPage(new Page<>(request, response));
		Page<GonggHuiy> page = gonggHuiyService.findPage(gonggHuiy);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("web:gonggHuiy:view")
	@RequestMapping(value = "form")
	public String form(GonggHuiy gonggHuiy, Model model) {
		Gongg gongg = gonggService.get(gonggHuiy.getGonggId());
		if (gongg!=null){
			gonggHuiy.setTitle(gongg.getTitle());
		}
		model.addAttribute("gonggHuiy", gonggHuiy);
		return "modules/web/gonggHuiyForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("web:gonggHuiy:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated GonggHuiy gonggHuiy) {
		User currentUser = UserUtils.getUser();
		gonggHuiy.setXinxiCode(currentUser.getLoginCode());
		gonggHuiy.setXinxiName(currentUser.getUserName());
		gonggHuiyService.save(gonggHuiy);
		Gongg gongg = new Gongg();
		gongg.setId(gonggHuiy.getGonggId());
		gongg.setHuiyingType("1");
		gonggService.update(gongg);
		return renderResult(Global.TRUE, text("保存公告回应成功！"));
	}

	/**
	 * 导出数据
	 */
	@RequiresPermissions("web:gonggHuiy:view")
	@RequestMapping(value = "exportData")
	public void exportData(GonggHuiy gonggHuiy, HttpServletResponse response) {
		List<GonggHuiy> list = gonggHuiyService.findList(gonggHuiy);
		String fileName = "公告回应" + DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx";
		try(ExcelExport ee = new ExcelExport("公告回应", GonggHuiy.class)){
			ee.setDataList(list).write(response, fileName);
		}
	}

	/**
	 * 下载模板
	 */
	@RequiresPermissions("web:gonggHuiy:view")
	@RequestMapping(value = "importTemplate")
	public void importTemplate(HttpServletResponse response) {
		GonggHuiy gonggHuiy = new GonggHuiy();
		List<GonggHuiy> list = ListUtils.newArrayList(gonggHuiy);
		String fileName = "公告回应模板.xlsx";
		try(ExcelExport ee = new ExcelExport("公告回应", GonggHuiy.class, Type.IMPORT)){
			ee.setDataList(list).write(response, fileName);
		}
	}

	/**
	 * 导入数据
	 */
	@ResponseBody
	@RequiresPermissions("web:gonggHuiy:edit")
	@PostMapping(value = "importData")
	public String importData(MultipartFile file) {
		try {
			String message = gonggHuiyService.importData(file);
			return renderResult(Global.TRUE, "posfull:"+message);
		} catch (Exception ex) {
			return renderResult(Global.FALSE, "posfull:"+ex.getMessage());
		}
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("web:gonggHuiy:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(GonggHuiy gonggHuiy) {
		gonggHuiyService.delete(gonggHuiy);
		return renderResult(Global.TRUE, text("删除公告回应成功！"));
	}
	
}