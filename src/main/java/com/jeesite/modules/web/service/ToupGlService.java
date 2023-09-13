package com.jeesite.modules.web.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.web.entity.ToupGl;
import com.jeesite.modules.sys.dao.ToupGlDao;

/**
 * 报名管理Service
 * @author Tr
 * @version 2023-06-25
 */
@Service
public class ToupGlService extends CrudService<ToupGlDao, ToupGl> {
	
	/**
	 * 获取单条数据
	 * @param toupGl
	 * @return
	 */
	@Override
	public ToupGl get(ToupGl toupGl) {
		return super.get(toupGl);
	}
	
	/**
	 * 查询分页数据
	 * @param toupGl 查询条件
	 * @param toupGl.page 分页对象
	 * @return
	 */
	@Override
	public Page<ToupGl> findPage(ToupGl toupGl) {
		return super.findPage(toupGl);
	}
	
	/**
	 * 查询列表数据
	 * @param toupGl
	 * @return
	 */
	@Override
	public List<ToupGl> findList(ToupGl toupGl) {
		return super.findList(toupGl);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param toupGl
	 */
	@Override
	@Transactional
	public void save(ToupGl toupGl) {
		super.save(toupGl);
	}
	
	/**
	 * 更新状态
	 * @param toupGl
	 */
	@Override
	@Transactional
	public void updateStatus(ToupGl toupGl) {
		super.updateStatus(toupGl);
	}
	
	/**
	 * 删除数据
	 * @param toupGl
	 */
	@Override
	@Transactional
	public void delete(ToupGl toupGl) {
		super.delete(toupGl);
	}
	
}