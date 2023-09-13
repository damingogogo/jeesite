package com.jeesite.modules.web.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.web.entity.ToupiaoStastic;
import com.jeesite.modules.web.dao.ToupiaoStasticDao;

/**
 * 投票统计Service
 * @author tulabu
 * @version 2023-02-14
 */
@Service
public class ToupiaoStasticService extends CrudService<ToupiaoStasticDao, ToupiaoStastic> {
	
	/**
	 * 获取单条数据
	 * @param toupiaoStastic
	 * @return
	 */
	@Override
	public ToupiaoStastic get(ToupiaoStastic toupiaoStastic) {
		return super.get(toupiaoStastic);
	}
	
	/**
	 * 查询分页数据
	 * @param toupiaoStastic 查询条件
	 * @param toupiaoStastic.page 分页对象
	 * @return
	 */
	@Override
	public Page<ToupiaoStastic> findPage(ToupiaoStastic toupiaoStastic) {
		return super.findPage(toupiaoStastic);
	}
	
	/**
	 * 查询列表数据
	 * @param toupiaoStastic
	 * @return
	 */
	@Override
	public List<ToupiaoStastic> findList(ToupiaoStastic toupiaoStastic) {
		return super.findList(toupiaoStastic);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param toupiaoStastic
	 */
	@Override
	@Transactional
	public void save(ToupiaoStastic toupiaoStastic) {
		super.save(toupiaoStastic);
	}
	
	/**
	 * 更新状态
	 * @param toupiaoStastic
	 */
	@Override
	@Transactional
	public void updateStatus(ToupiaoStastic toupiaoStastic) {
		super.updateStatus(toupiaoStastic);
	}
	
	/**
	 * 删除数据
	 * @param toupiaoStastic
	 */
	@Override
	@Transactional
	public void delete(ToupiaoStastic toupiaoStastic) {
		super.delete(toupiaoStastic);
	}
	
}