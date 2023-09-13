package com.jeesite.modules.web.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.web.entity.TianbGl;
import com.jeesite.modules.sys.dao.TianbGlDao;

/**
 * 报名管理Service
 * @author Tr
 * @version 2023-06-25
 */
@Service
public class TianbGlService extends CrudService<TianbGlDao, TianbGl> {
	
	/**
	 * 获取单条数据
	 * @param tianbGl
	 * @return
	 */
	@Override
	public TianbGl get(TianbGl tianbGl) {
		return super.get(tianbGl);
	}
	
	/**
	 * 查询分页数据
	 * @param tianbGl 查询条件
	 * @param tianbGl.page 分页对象
	 * @return
	 */
	@Override
	public Page<TianbGl> findPage(TianbGl tianbGl) {
		return super.findPage(tianbGl);
	}
	
	/**
	 * 查询列表数据
	 * @param tianbGl
	 * @return
	 */
	@Override
	public List<TianbGl> findList(TianbGl tianbGl) {
		return super.findList(tianbGl);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param tianbGl
	 */
	@Override
	@Transactional
	public void save(TianbGl tianbGl) {
		super.save(tianbGl);
	}
	
	/**
	 * 更新状态
	 * @param tianbGl
	 */
	@Override
	@Transactional
	public void updateStatus(TianbGl tianbGl) {
		super.updateStatus(tianbGl);
	}
	
	/**
	 * 删除数据
	 * @param tianbGl
	 */
	@Override
	@Transactional
	public void delete(TianbGl tianbGl) {
		super.delete(tianbGl);
	}
	
}