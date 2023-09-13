package com.jeesite.modules.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jeesite.modules.sys.entity.User;
import com.jeesite.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.web.entity.BaomingStastic;
import com.jeesite.modules.web.dao.BaomingStasticDao;

/**
 * 报名统计Service
 * @author tulabu
 * @version 2023-02-13
 */
@Service
public class BaomingStasticService extends CrudService<BaomingStasticDao, BaomingStastic> {

	@Autowired
	UserService userService;
	/**
	 * 获取单条数据
	 * @param baomingStastic
	 * @return
	 */
	@Override
	public BaomingStastic get(BaomingStastic baomingStastic) {
		return super.get(baomingStastic);
	}

	/**
	 * 查询分页数据
	 * @param baomingStastic 查询条件
	 * @param baomingStastic.page 分页对象
	 * @return
	 */
	@Override
	public Page<BaomingStastic> findPage(BaomingStastic baomingStastic) {
		return super.findPage(baomingStastic);
	}

	/**
	 * 查询列表数据
	 * @param baomingStastic
	 * @return
	 */
	@Override
	public List<BaomingStastic> findList(BaomingStastic baomingStastic) {
		return super.findList(baomingStastic);
	}

	/**
	 * 保存数据（插入或更新）
	 * @param baomingStastic
	 */
	@Override
	@Transactional
	public void save(BaomingStastic baomingStastic) {
		super.save(baomingStastic);
	}

	/**
	 * 更新状态
	 * @param baomingStastic
	 */
	@Override
	@Transactional
	public void updateStatus(BaomingStastic baomingStastic) {
		super.updateStatus(baomingStastic);
	}

	/**
	 * 删除数据
	 * @param baomingStastic
	 */
	@Override
	@Transactional
	public void delete(BaomingStastic baomingStastic) {
		super.delete(baomingStastic);
	}

	public Page<BaomingStastic> findPageData(BaomingStastic baomingStastic) {
		Page<BaomingStastic> page = new Page<>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", baomingStastic.getPageNo());
		map.put("length", baomingStastic.getPageSize());
		baomingStastic.setPageNo(page.getPageNo());
		baomingStastic.setPageSize(page.getPageSize());
		List<BaomingStastic> list =new ArrayList<>();
		long count = 0;
		if (baomingStastic.getBtType().equals("2")){
			list=dao.findPageDataTb(map,baomingStastic);
			count=dao.getCountTb(baomingStastic);
		}else if (baomingStastic.getBtType().equals("3")){

		}else {
			list=dao.findPageData(map,baomingStastic);
			count=dao.getCount(baomingStastic);
		}

		page.setList(list);
		page.setCount(count);
		page.setPageSize(map.get("length"));
		page.setPageNo(map.get("start"));
		return page;
	}

	public Page<BaomingStastic> findPageDataToupaio(BaomingStastic baomingStastic) {
		Page<BaomingStastic> page = new Page<>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", baomingStastic.getPageNo());
		map.put("length", baomingStastic.getPageSize());
		baomingStastic.setPageNo(page.getPageNo());
		baomingStastic.setPageSize(page.getPageSize());
//		List<User> list1 = userService.findList(baomingStastic.getUser());
//		if (list1.size()>=0){
//			baomingStastic.setExtend1(list1.get(0).getLoginCode());
//		}
		List<BaomingStastic> list = dao.findPageDataToupaio(map,baomingStastic);
//		for (BaomingStastic bbb:list){
//			list.get(0).getB
//		}
		long count = dao.getCountToupaio(baomingStastic);
		page.setList(list);
		page.setCount(count);
		page.setPageSize(map.get("length"));
		page.setPageNo(map.get("start"));
		return page;
	}


	public List<BaomingStastic> findToupiaoList(BaomingStastic baomingStastic) {
		return dao.findToupiaoList(baomingStastic);
	}
}
