package com.jeesite.modules.web.web;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.sys.entity.User;
import com.jeesite.modules.sys.utils.UserUtils;
import com.jeesite.modules.web.service.BaomingGlService;
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
import com.jeesite.modules.web.entity.BaomingStastic;
import com.jeesite.modules.web.service.BaomingStasticService;

/**
 * 报名统计Controller
 * @author tulabu
 * @version 2023-02-13
 */
@Controller
@RequestMapping(value = "${adminPath}/web/baomingStastic")
public class BaomingStasticController extends BaseController {

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
	@RequestMapping(value = {"list", ""})
	public String list(BaomingStastic baomingStastic, Model model) {
		model.addAttribute("baomingStastic", baomingStastic);
		return "modules/web/baomingStasticList";
	}

	@RequiresPermissions("web:baomingStastic:view")
	@RequestMapping(value = "index")
	public String index(BaomingStastic baomingStastic, Model model) {
		model.addAttribute("baomingStastic", baomingStastic);
		return "modules/web/baomingStasticIndex";
	}

	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("web:baomingStastic:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<BaomingStastic> listData(BaomingStastic baomingStastic, HttpServletRequest request, HttpServletResponse response) {
		baomingStastic.setPage(new Page<>(request, response));
		Page<BaomingStastic> page = baomingStasticService.findPageData(baomingStastic);
		return page;
	}

	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("web:baomingStastic:view")
	@RequestMapping(value = "listDataToupaio")
	@ResponseBody
	public List<BaomingStastic> listDataToupaio(BaomingStastic baomingStastic, HttpServletRequest request, HttpServletResponse response) {
		List<BaomingStastic> toupiaoList = baomingStasticService.findToupiaoList(baomingStastic);
		List<BaomingStastic> childList =new ArrayList<>();
		List<BaomingStastic> parentList = toupiaoList.stream().filter(s -> s.getParentCode().equals("0") ).collect(Collectors.toList());
		List<BaomingStastic> filter = new ArrayList<>();
		List<BaomingStastic> nums = new ArrayList<>();
		for (BaomingStastic list: parentList){
			filter =toupiaoList.stream().filter(s -> s.getParentCode().equals(list.getId()) ).collect(Collectors.toList());
			if (filter.size()>0){
				nums =toupiaoList.stream().filter(s -> s.getBaomingId().equals(list.getId()) && s.getTreeLevel().equals("2")).collect(Collectors.toList());
				list.setNum(String.valueOf(nums.size()));
				list.setZb("100");
				list.setIsTreeLeaf(false);
			}else {
				list.setIsTreeLeaf(true);
			}
			childList.add(list);
			for (BaomingStastic child:toupiaoList){
				if (list.getId().equals(child.getParentCode())){
					filter =toupiaoList.stream().filter(s -> s.getParentCode().equals(child.getId()) ).collect(Collectors.toList());
					if (filter.size()>0){
						nums =toupiaoList.stream().filter(s -> s.getBaomingId().equals(child.getBaomingId()) && s.getTreeLevel().equals("2") ).collect(Collectors.toList());
						if (nums.size()>0){
							int a = Integer.parseInt(child.getNum());
							int b= nums.size();
							float c = (float) a/b*100;
							DecimalFormat decimalFormat = new DecimalFormat("#.00");
							String ans = decimalFormat.format(c);
							child.setZb(ans);
						}
						child.setIsTreeLeaf(false);
					}else {
						child.setZb("0");
						child.setIsTreeLeaf(true);
					}
					childList.add(child);
					for (BaomingStastic tree :toupiaoList){
						if (child.getId().equals(tree.getParentCode())){
							filter =toupiaoList.stream().filter(s -> s.getParentCode().equals(tree.getId()) ).collect(Collectors.toList());
							if (filter.size()>0){
								list.setNum(String.valueOf(filter.size()));
								tree.setIsTreeLeaf(false);
							}else {
								tree.setIsTreeLeaf(true);
							}
							childList.add(tree);
						}
					}
				}
			}
		}
		System.out.println(childList);

		return childList;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("web:baomingStastic:view")
	@RequestMapping(value = "form")
	public String form(BaomingStastic baomingStastic, Model model) {
		model.addAttribute("baomingStastic", baomingStastic);
		return "modules/web/baomingStasticForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("web:baomingStastic:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated BaomingStastic baomingStastic) {
		baomingStasticService.save(baomingStastic);
		return renderResult(Global.TRUE, text("保存报名统计成功！"));
	}

	/**
	 * 删除数据
	 */
	@RequiresPermissions("web:baomingStastic:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(BaomingStastic baomingStastic) {
		baomingStasticService.delete(baomingStastic);
		return renderResult(Global.TRUE, text("删除报名统计成功！"));
	}

}
