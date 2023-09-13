package com.jeesite.modules.web.web;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.collect.MapUtils;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.modules.sys.entity.Employee;
import com.jeesite.modules.sys.entity.Office;
import com.jeesite.modules.sys.entity.User;
import com.jeesite.modules.sys.service.EmployeeService;
import com.jeesite.modules.sys.service.UserService;
import com.jeesite.modules.sys.utils.UserUtils;
import com.jeesite.modules.web.entity.*;
import com.jeesite.modules.web.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.BeanUtils;
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

/**
 * 报名管理Controller
 * @author tulabu
 * @version 2023-02-11
 */
@Controller
@RequestMapping(value = "${adminPath}/web/baomingGl")
public class BaomingGlController extends BaseController {
	@Autowired
	private ToupGlService toupGlService;
	@Autowired
	private TianbGlService tianbGlService;
	@Autowired
	private BaomingGlService baomingGlService;
	@Autowired
	private BaomingStasticService baomingStasticService;

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private GonggService gonggService;
	@Autowired
	private GonggHuiyService gonggHuiyService;
	@Autowired
	private BtoupiaoUserService btoupiaoUserService;
	@Autowired
	private ToupiaoUserService toupiaoUserService;
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public BaomingGl get(String baomingId, boolean isNewRecord) {
		return baomingGlService.get(baomingId, isNewRecord);
	}

	/**
	 * 查询列表
	 */
	@RequiresPermissions("web:baomingGl:view")
	@RequestMapping(value = {"list", ""})
	public String list(BaomingGl baomingGl, Model model) {
		model.addAttribute("baomingGl", baomingGl);
		return "modules/web/baomingGlList";
	}

	@RequiresPermissions("web:baomingGl:view")
	@RequestMapping(value = "baominglist")
	public String baominglist(BaomingGl baomingGl, Model model) {
		model.addAttribute("baomingGl", baomingGl);
		return "modules/web/baominglist";
	}

	@RequiresPermissions("web:baomingGl:view")
	@RequestMapping(value ="baomingStastic")
	@ResponseBody
	public String baomingStastic(BaomingStastic baomingStastic ) {
		String title;
		User user = UserUtils.getUser();
		Employee employee = employeeService.get(user.getRefCode());
//		Office office = employee.getOffice();
		baomingStastic.setOfficeCode(employee.getOffice().getOfficeCode());
		String extend2 =baomingStastic.getExtend1();
		baomingStastic.setExtend1(user.getLoginCode());
		List<BaomingStastic> list = baomingStasticService.findList(baomingStastic);
		BaomingGl baomingGl =new BaomingGl();
		if (baomingStastic.getBtType().equals("2")){
			TianbGl tianbGl =new TianbGl();
			tianbGl=tianbGlService.get(baomingStastic.getBaomingId());
			BeanUtils.copyProperties(tianbGl,baomingGl);
		}else if (baomingStastic.getBtType().equals("3")){
			ToupGl toupGl =new ToupGl();
			toupGl=toupGlService.get(baomingStastic.getBaomingId());
			BeanUtils.copyProperties(toupGl,baomingGl);
		}else{
			baomingGl=baomingGlService.get(baomingStastic.getBaomingId());
		}
		if (baomingGl.getBtType().equals("3")){
			ToupiaoUser toupiaoUser = new ToupiaoUser();
			toupiaoUser.setExtend1(user.getUserCode());
			toupiaoUser.setToupiaoId(baomingStastic.getBaomingId());
			List<ToupiaoUser> list1 = toupiaoUserService.findList(toupiaoUser);
			if (list1.size()>0){
				return renderResult(Global.TRUE, text("已投票，不能重复投票!"));
			}else {
				BaomingStastic stastic = new BaomingStastic();
				stastic.setBaomingId(baomingStastic.getBaomingId());
				stastic.setCreateBy(user.getUserCode());
				List<BaomingStastic> stasticList = baomingStasticService.findList(stastic);
				if (stasticList.size()==0){
					baomingStasticService.save(baomingStastic);
				}
				toupiaoUser.setExtend2(user.getLoginCode());
				toupiaoUser.setBtpId(baomingStastic.getExtend8());
				toupiaoUser.setUserName(user.getUserName());
				toupiaoUserService.insert(toupiaoUser);
			}
		}else {
			if (baomingGl!=null) {
				if (baomingGl.getBaomingStatus().equals("2")) {
					if (baomingGl.getBtType().equals("1")){
						title="报名";
					}else if (baomingGl.getBtType().equals("2")){
						title="填报";
					}else {
						title="投票";
					}
					if (list.size() == 0) {
						baomingStastic.setExtend2(extend2);
						baomingStasticService.save(baomingStastic);
					} else {
						return renderResult(Global.TRUE, text("已"+title+"!"));
					}
				}else {
					return renderResult(Global.TRUE, text("已截止！"));
				}
			}else {
				return renderResult(Global.FALSE, text("数据错误！"));
			}
		}


		return renderResult(Global.TRUE, text("成功！"));
	}
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("web:baomingGl:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<BaomingGl> listData(BaomingGl baomingGl, HttpServletRequest request, HttpServletResponse response) {
		baomingGl.setPage(new Page<>(request, response));
		Page<BaomingGl> page = baomingGlService.findPage(baomingGl);
		return page;
	}

	@RequestMapping(value = "listDataTb")
	@ResponseBody
	public Page<TianbGl> listDataTb(TianbGl tianbGl, HttpServletRequest request, HttpServletResponse response) {
		tianbGl.setPage(new Page<>(request, response));
		Page<TianbGl> page = tianbGlService.findPage(tianbGl);
		return page;
	}

	@RequestMapping(value = "listDataTp")
	@ResponseBody
	public Page<ToupGl> listDataTp(ToupGl toupGl, HttpServletRequest request, HttpServletResponse response) {
		toupGl.setPage(new Page<>(request, response));
		Page<ToupGl> page = toupGlService.findPage(toupGl);
		User user = UserUtils.getUser();
		for (int i=0;i<page.getList().size();i++){
			BaomingStastic stastic =new BaomingStastic();
			stastic.setCreateBy(user.getUserCode());
			stastic.setBaomingId(page.getList().get(i).getBaomingId());
			List<BaomingStastic> list = baomingStasticService.findList(stastic);
			if (list!=null && list.size()>0){
				page.getList().get(i).setZt("1");
			}
		}
		return page;
	}

	@RequestMapping(value = "getBaomingInd")
	@ResponseBody
	public List<Map<String, Object>> getBaomingInd(BaomingGl baomingGl) {
		List<Map<String, Object>> mapList=baomingGlService.findbaomingtj(baomingGl);
		return mapList;
	}
	@RequestMapping(value = "countTotal")
	@ResponseBody
	public String  countTotal(BaomingGl baomingGl) {
		Map<String, Integer> countTotalMap = MapUtils.newHashMap();
		baomingGl.setStatus(StringUtils.EMPTY);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		if (baomingGl.getShujuDay()==null){
			calendar.add(Calendar.MONTH, -1); //减几就是几个月之前
		}else {
			calendar.add(Calendar.DAY_OF_MONTH, -Integer.parseInt(baomingGl.getShujuDay())); //当前时间减去一天，即一天前的时间
		}

		Date m = calendar.getTime();
//		String mon = format.format(m);
		baomingGl.setCreateDate(m);
		List<BaomingGl> baomingGls = baomingGlService.findList(baomingGl);
		TianbGl tianbGl =new TianbGl();
		BeanUtils.copyProperties(baomingGl,tianbGl);
		List<TianbGl> tianbGls = tianbGlService.findList(tianbGl);
		ToupGl toupGl =new ToupGl();
		BeanUtils.copyProperties(baomingGl,tianbGl);
		List<ToupGl> toupGls = toupGlService.findList(toupGl);
		BaomingStastic baomingStastic = new BaomingStastic();
		baomingStastic.setCreateDate(m);
		List<BaomingStastic> baomingStastics = baomingStasticService.findList(baomingStastic);
		Gongg gongg = new Gongg();
		gongg.setCreateDate(m);
		List<Gongg> gonggList = gonggService.findList(gongg);
		GonggHuiy gonggHuiy =new GonggHuiy();
		gonggHuiy.setCreateDate(m);
		List<GonggHuiy> gonggHuiyList = gonggHuiyService.findList(gonggHuiy);
		if (ListUtils.isNotEmpty(baomingGls)) {
			countTotalMap.put("baomingsj", baomingGls.size());
		}
		if (ListUtils.isNotEmpty(tianbGls)) {
			countTotalMap.put("tianbiaosj", tianbGls.size());
		}
		if (ListUtils.isNotEmpty(toupGls)) {
			countTotalMap.put("toupiaosj", toupGls.size());
		}
		if (ListUtils.isNotEmpty(baomingStastics)) {
			countTotalMap.put("baomingtjs", (int) baomingStastics.stream().filter(string->string.getBtType().equals("1")).count());
			countTotalMap.put("tianbiaotjs", (int) baomingStastics.stream().filter(string->string.getBtType().equals("2")).count());
			countTotalMap.put("toupiaotjs", (int) baomingStastics.stream().filter(string->string.getBtType().equals("3")).count());
		}
		if (ListUtils.isNotEmpty(gonggList)) {
			countTotalMap.put("gonggsj", gonggList.size());
		}
		if (ListUtils.isNotEmpty(gonggHuiyList)) {
			countTotalMap.put("gonggtjs", gonggHuiyList.size());
		}

		return renderResult(Global.TRUE, null, countTotalMap);
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("web:baomingGl:view")
	@RequestMapping(value = "form")
	public String form(BaomingGl baomingGl, Model model) {
		model.addAttribute("baomingGl", baomingGl);
		return "modules/web/baomingGlForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("web:baomingGl:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated BaomingGl baomingGl) {
		if (StringUtils.isEmpty(baomingGl.getBaomingId())){
			if (baomingGl.getBtType().equals("3")){
				ToupGl bg = new ToupGl();
				bg.setExtend3(baomingGl.getExtend3());
				List<ToupGl> list = toupGlService.findList(bg);
				if (list.size()>0){
					return renderResult(Global.FALSE, text("投票信息不能重复！"));
				}else {
					ToupGl toupGl = new ToupGl();
					BeanUtils.copyProperties(baomingGl,toupGl);
					toupGlService.save(toupGl);
					if (toupGl.getUserList().size()>0){
						for (User users:baomingGl.getUserList()){
							BtoupiaoUser btoupiaoUser = new BtoupiaoUser();
							btoupiaoUser.setBtpId(UUID.randomUUID().toString());
							btoupiaoUser.setToupiaoId(toupGl.getBaomingId());
							btoupiaoUser.setExtend1(users.getUserCode());
							btoupiaoUser.setExtend2(users.getLoginCode());
							btoupiaoUser.setUserName(users.getUserName());
							btoupiaoUserService.insert(btoupiaoUser);
						}
					}
				}

			}else if (baomingGl.getBtType().equals("2")){
				TianbGl tianbGl =new TianbGl();
				BeanUtils.copyProperties(baomingGl,tianbGl);
				tianbGlService.save(tianbGl);
			}else {
				baomingGlService.save(baomingGl);
			}
		}else {
			if (baomingGl.getBtType().equals("1")){
				baomingGlService.save(baomingGl);
			} else if (baomingGl.getBtType().equals("2")){
				TianbGl tianbGl =new TianbGl();
				BeanUtils.copyProperties(baomingGl,tianbGl);
				tianbGlService.save(tianbGl);
			}else if (baomingGl.getBtType().equals("3")){
				ToupGl toupGl =new ToupGl();
				BeanUtils.copyProperties(baomingGl,toupGl);
				toupGlService.save(toupGl);
			}
		}


		return renderResult(Global.TRUE, text("保存成功！"));
	}

	/**
	 * 删除数据
	 */
	@RequiresPermissions("web:baomingGl:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(BaomingGl baomingGl) {
		baomingGlService.delete(baomingGl);
		return renderResult(Global.TRUE, text("删除成功！"));
	}
	@RequestMapping(value = "deleteTb")
	@ResponseBody
	public String deleteTb(TianbGl tianbGl) {
		tianbGlService.delete(tianbGl);
		return renderResult(Global.TRUE, text("删除成功！"));
	}
	@RequestMapping(value = "deleteTp")
	@ResponseBody
	public String deleteTp(ToupGl toupGl) {
		toupGlService.delete(toupGl);
		return renderResult(Global.TRUE, text("删除成功！"));
	}



	@RequiresPermissions("web:baomingGl:view")
	@RequestMapping(value = "userListData")
	@ResponseBody
	public List<User> userListData(BaomingGl baomingGl, Model model) {
		List<String> split =new ArrayList<>();
		if (baomingGl.getUserCodes()!=null){
			split= Arrays.asList(baomingGl.getUserCodes().split(","));
		}
		List<User> users =new ArrayList<>();
		if (StringUtils.isEmpty(baomingGl.getBaomingId())){
			users = baomingGlService.finduser(split);
		} else {
			BtoupiaoUser btoupiaoUser =new BtoupiaoUser();
			btoupiaoUser.setToupiaoId(baomingGl.getBaomingId());
			List<BtoupiaoUser> list = btoupiaoUserService.findList(btoupiaoUser);
			if (list.size()>0){
				for (BtoupiaoUser buser :list){
					User u = new User();
					u.setLoginCode(buser.getExtend2());
					u.setUserCode(buser.getExtend1());
					u.setUserName(buser.getUserName());
					users.add(u);
				}
			}

		}

		return users;
	}

}
