package com.jeesite.modules.web.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.web.entity.ClassGl;
import com.jeesite.modules.web.dao.ClassGlDao;

/**
 * 班级管理表Service
 * @author tulabu
 * @version 2023-02-09
 */
@Service
public class ClassGlService extends CrudService<ClassGlDao, ClassGl> {
	
	/**
	 * 获取单条数据
	 * @param classGl
	 * @return
	 */
	@Override
	public ClassGl get(ClassGl classGl) {
		return super.get(classGl);
	}
	
	/**
	 * 查询分页数据
	 * @param classGl 查询条件
	 * @param classGl.page 分页对象
	 * @return
	 */
	@Override
	public Page<ClassGl> findPage(ClassGl classGl) {
		return super.findPage(classGl);
	}
	
	/**
	 * 查询列表数据
	 * @param classGl
	 * @return
	 */
	@Override
	public List<ClassGl> findList(ClassGl classGl) {
		return super.findList(classGl);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param classGl
	 */
	@Override
	@Transactional
	public void save(ClassGl classGl) {
		super.save(classGl);
	}
	
	/**
	 * 更新状态
	 * @param classGl
	 */
	@Override
	@Transactional
	public void updateStatus(ClassGl classGl) {
		super.updateStatus(classGl);
	}
	
	/**
	 * 删除数据
	 * @param classGl
	 */
	@Override
	@Transactional
	public void delete(ClassGl classGl) {
		super.delete(classGl);
	}

	public List<ClassGl> findListNj(ClassGl classGl, String type) {
		return dao.findListNj(classGl,type);
	}
}