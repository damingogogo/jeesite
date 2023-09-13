package com.jeesite.modules.web.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.web.entity.ChengjGl;
import com.jeesite.modules.web.dao.ChengjGlDao;

/**
 * 成绩管理Service
 * @author tulabu
 * @version 2023-02-16
 */
@Service
public class ChengjGlService extends CrudService<ChengjGlDao, ChengjGl> {
	
	/**
	 * 获取单条数据
	 * @param chengjGl
	 * @return
	 */
	@Override
	public ChengjGl get(ChengjGl chengjGl) {
		return super.get(chengjGl);
	}
	
	/**
	 * 查询分页数据
	 * @param chengjGl 查询条件
	 * @param chengjGl.page 分页对象
	 * @return
	 */
	@Override
	public Page<ChengjGl> findPage(ChengjGl chengjGl) {
		return super.findPage(chengjGl);
	}
	
	/**
	 * 查询列表数据
	 * @param chengjGl
	 * @return
	 */
	@Override
	public List<ChengjGl> findList(ChengjGl chengjGl) {
		return super.findList(chengjGl);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param chengjGl
	 */
	@Override
	@Transactional
	public void save(ChengjGl chengjGl) {
		super.save(chengjGl);
	}
	
	/**
	 * 更新状态
	 * @param chengjGl
	 */
	@Override
	@Transactional
	public void updateStatus(ChengjGl chengjGl) {
		super.updateStatus(chengjGl);
	}
	
	/**
	 * 删除数据
	 * @param chengjGl
	 */
	@Override
	@Transactional
	public void delete(ChengjGl chengjGl) {
		super.delete(chengjGl);
	}
	
}