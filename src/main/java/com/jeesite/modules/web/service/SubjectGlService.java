package com.jeesite.modules.web.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.web.entity.SubjectGl;
import com.jeesite.modules.web.dao.SubjectGlDao;

/**
 * 科目管理表Service
 * @author tulabu
 * @version 2023-02-09
 */
@Service
public class SubjectGlService extends CrudService<SubjectGlDao, SubjectGl> {
	
	/**
	 * 获取单条数据
	 * @param subjectGl
	 * @return
	 */
	@Override
	public SubjectGl get(SubjectGl subjectGl) {
		return super.get(subjectGl);
	}
	
	/**
	 * 查询分页数据
	 * @param subjectGl 查询条件
	 * @param subjectGl.page 分页对象
	 * @return
	 */
	@Override
	public Page<SubjectGl> findPage(SubjectGl subjectGl) {
		return super.findPage(subjectGl);
	}
	
	/**
	 * 查询列表数据
	 * @param subjectGl
	 * @return
	 */
	@Override
	public List<SubjectGl> findList(SubjectGl subjectGl) {
		return super.findList(subjectGl);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param subjectGl
	 */
	@Override
	@Transactional
	public void save(SubjectGl subjectGl) {
		super.save(subjectGl);
	}
	
	/**
	 * 更新状态
	 * @param subjectGl
	 */
	@Override
	@Transactional
	public void updateStatus(SubjectGl subjectGl) {
		super.updateStatus(subjectGl);
	}
	
	/**
	 * 删除数据
	 * @param subjectGl
	 */
	@Override
	@Transactional
	public void delete(SubjectGl subjectGl) {
		super.delete(subjectGl);
	}

	public List<SubjectGl> findKemu(List<String> split) {
		return dao.findKemu(split);
	}
}