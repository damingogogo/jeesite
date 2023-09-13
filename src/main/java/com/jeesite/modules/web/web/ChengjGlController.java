package com.jeesite.modules.web.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONValidator;
import com.jeesite.common.codec.EncodeUtils;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.modules.sys.entity.EmpUser;
import com.jeesite.modules.sys.entity.Employee;
import com.jeesite.modules.sys.entity.Office;
import com.jeesite.modules.sys.entity.User;
import com.jeesite.modules.sys.service.EmployeeService;
import com.jeesite.modules.sys.service.UserService;
import com.jeesite.modules.web.entity.SubjectGl;
import com.jeesite.modules.web.service.SubjectGlService;
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
import com.jeesite.modules.web.entity.ChengjGl;
import com.jeesite.modules.web.service.ChengjGlService;

/**
 * 成绩管理Controller
 * @author tulabu
 * @version 2023-02-16
 */
@Controller
@RequestMapping(value = "${adminPath}/web/chengjGl")
public class ChengjGlController extends BaseController {

	@Autowired
	private ChengjGlService chengjGlService;
	@Autowired
	private SubjectGlService subjectGlService;
	@Autowired
	private UserService userService;
	@Autowired
	private EmployeeService employeeService;

	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ChengjGl get(String chengjId, boolean isNewRecord) {
		return chengjGlService.get(chengjId, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("web:chengjGl:view")
	@RequestMapping(value = {"list", ""})
	public String list(ChengjGl chengjGl, Model model) {
		model.addAttribute("chengjGl", chengjGl);
		return "modules/web/chengjGlList";
	}
	@RequiresPermissions("web:chengjGl:view")
	@RequestMapping(value = "index")
	public String index(Office office, Model model) {
		model.addAttribute("office", office);
		model.addAttribute("ctrlPermi", Global.getConfig("user.adminCtrlPermi", "2"));
		return "modules/web/chengjiIndex";
	}

	@RequestMapping(value = "kemuSelect")
	public String kkemuSelect(SubjectGl subjectGl, String selectData, Model model) {
		String selectDataJson = EncodeUtils.decodeUrl(selectData);
		if (selectDataJson != null && JSONValidator.from(selectDataJson).validate()){
			model.addAttribute("selectData", selectDataJson);
		}
		// 获取角色列表
//		Role role = new Role();
//		role.setUserType(User.USER_TYPE_MEMBER);
//		model.addAttribute("roleList", roleService.findList(role));
		model.addAttribute("subjectGl", subjectGl);
		return "modules/web/kemuSelect";
	}
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("web:chengjGl:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ChengjGl> listData(ChengjGl chengjGl, HttpServletRequest request, HttpServletResponse response) {
		chengjGl.setPage(new Page<>(request, response));
		Page<ChengjGl> page = chengjGlService.findPage(chengjGl);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("web:chengjGl:view")
	@RequestMapping(value = "form")
	public String form(ChengjGl chengjGl, Model model) {
		if (StringUtils.isNoneEmpty(chengjGl.getChengjId())){
			chengjGl.setSubjectIds(chengjGl.getKemuId());
		}
//		List<String> split =new ArrayList<>();
//		if (chengjGl.getSubjectIds()!=null){
//			split= Arrays.asList(chengjGl.getSubjectIds().split(","));
//			List<SubjectGl> subjectGls =subjectGlService.findKemu(split);
//			if (subjectGls.size()>0){
//				chengjGl.setSubjectGlList(subjectGls);
//			}
//		}
//		if (chengjGl.getKemuId()!=null){
//			SubjectGl subjectGl = subjectGlService.get(chengjGl.getKemuId());
//			if (subjectGl!=null){
//				chengjGl.setKemuName(subjectGl.getSubjectName());
//			}
//
//		}
		model.addAttribute("chengjGl", chengjGl);
		return "modules/web/chengjGlForm";
	}
	@RequiresPermissions("web:chengjGl:view")
	@RequestMapping(value = "kemuListData")
	@ResponseBody
	public List<SubjectGl> kemuListData(ChengjGl chengjGl, Model model) {
		List<String> split =new ArrayList<>();
		if (chengjGl.getSubjectIds()!=null){
			split= Arrays.asList(chengjGl.getSubjectIds().split(","));
		}
		List<SubjectGl> subjectGls =new ArrayList<>();
		if (StringUtils.isEmpty(chengjGl.getChengjId())){
			subjectGls = subjectGlService.findKemu(split);
		}else {
			ChengjGl cj = chengjGlService.get(chengjGl.getChengjId());
			subjectGls = subjectGlService.findKemu(split);
			subjectGls.get(0).setExtend3(cj.getExtend3());

		}

		return subjectGls;
	}
	/**
	 * 保存数据
	 */
	@RequiresPermissions("web:chengjGl:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ChengjGl chengjGl) {
		User user = new User();
		user.setLoginCode(chengjGl.getLoginCode());
		User byLoginCode = userService.getByLoginCode(user);
		if (byLoginCode!=null){
			chengjGl.setUserName(byLoginCode.getUserName());
			Employee employee = employeeService.get(byLoginCode.getUserCode());
			if (employee!=null){
				chengjGl.setOfficeCode(employee.getOffice().getOfficeCode());
				chengjGl.setExtend1(employee.getOffice().getOfficeName());
			}
		}
		if (StringUtils.isEmpty(chengjGl.getChengjId())){
			//插入操作
			if (chengjGl.getSubjectGlList().size()>0){
				for (SubjectGl subjectGl:chengjGl.getSubjectGlList()){
					chengjGl.setChengjId(UUID.randomUUID().toString());
					chengjGl.setKemuId(subjectGl.getSubjectId());
					chengjGl.setKemuName(subjectGl.getSubjectName());
					chengjGl.setExtend3(subjectGl.getExtend3());
					chengjGlService.insert(chengjGl);
				}
			}
		}else {
			if (chengjGl.getSubjectGlList().size()>0){
				for (SubjectGl subjectGl:chengjGl.getSubjectGlList()){
					chengjGl.setKemuId(subjectGl.getSubjectId());
					chengjGl.setKemuName(subjectGl.getSubjectName());
					chengjGl.setExtend3(subjectGl.getExtend3());
					chengjGlService.update(chengjGl);
				}
			}
		}


		return renderResult(Global.TRUE, text("保存成绩管理成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("web:chengjGl:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ChengjGl chengjGl) {
		chengjGlService.delete(chengjGl);
		return renderResult(Global.TRUE, text("删除成绩管理成功！"));
	}
	
}