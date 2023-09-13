package com.jeesite.modules.web.service;

import java.text.SimpleDateFormat;
import java.util.*;

import com.jeesite.modules.sys.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.web.entity.BaomingGl;
import com.jeesite.modules.web.dao.BaomingGlDao;

/**
 * 报名管理Service
 * @author tulabu
 * @version 2023-02-11
 */
@Service
public class BaomingGlService extends CrudService<BaomingGlDao, BaomingGl> {

	/**
	 * 获取单条数据
	 * @param baomingGl
	 * @return
	 */
	@Override
	public BaomingGl get(BaomingGl baomingGl) {
		return super.get(baomingGl);
	}

	/**
	 * 查询分页数据
	 * @param baomingGl 查询条件
	 * @param baomingGl.page 分页对象
	 * @return
	 */
	@Override
	public Page<BaomingGl> findPage(BaomingGl baomingGl) {
		return super.findPage(baomingGl);
	}

	/**
	 * 查询列表数据
	 * @param baomingGl
	 * @return
	 */
	@Override
	public List<BaomingGl> findList(BaomingGl baomingGl) {
		return super.findList(baomingGl);
	}

	/**
	 * 保存数据（插入或更新）
	 * @param baomingGl
	 */
	@Override
	@Transactional
	public void save(BaomingGl baomingGl) {
		super.save(baomingGl);
	}

	/**
	 * 更新状态
	 * @param baomingGl
	 */
	@Override
	@Transactional
	public void updateStatus(BaomingGl baomingGl) {
		super.updateStatus(baomingGl);
	}

	/**
	 * 删除数据
	 * @param baomingGl
	 */
	@Override
	@Transactional
	public void delete(BaomingGl baomingGl) {
		super.delete(baomingGl);
	}

	public List<Map<String, Object>> findbaomingtj(BaomingGl baomingGl) {
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
		List<Map<String, Object>> list =new ArrayList<>();
		if (baomingGl.getBtType().equals("1")){
			list=dao.findbaomingtj(baomingGl);
		}else if (baomingGl.getBtType().equals("2")){
			list=dao.findtianbaotj(baomingGl);
		}else if (baomingGl.getBtType().equals("3")){
			list=dao.findtouptj(baomingGl);
		}
		return list;
	}

	public List<User> finduser(List<String> split) {
		return dao.finduser(split);
	}
}
