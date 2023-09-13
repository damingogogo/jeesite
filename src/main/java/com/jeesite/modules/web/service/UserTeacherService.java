package com.jeesite.modules.web.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.web.entity.UserTeacher;
import com.jeesite.modules.web.dao.UserTeacherDao;

/**
 * 用户表Service
 * @author Tr
 * @version 2023-06-26
 */
@Service
public class UserTeacherService extends CrudService<UserTeacherDao, UserTeacher> {
	
	/**
	 * 获取单条数据
	 * @param userTeacher
	 * @return
	 */
	@Override
	public UserTeacher get(UserTeacher userTeacher) {
		return super.get(userTeacher);
	}
	
	/**
	 * 查询分页数据
	 * @param userTeacher 查询条件
	 * @param userTeacher.page 分页对象
	 * @return
	 */
	@Override
	public Page<UserTeacher> findPage(UserTeacher userTeacher) {
		return super.findPage(userTeacher);
	}
	
	/**
	 * 查询列表数据
	 * @param userTeacher
	 * @return
	 */
	@Override
	public List<UserTeacher> findList(UserTeacher userTeacher) {
		return super.findList(userTeacher);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param userTeacher
	 */
	@Override
	@Transactional
	public void save(UserTeacher userTeacher) {
		super.save(userTeacher);
	}
	
	/**
	 * 更新状态
	 * @param userTeacher
	 */
	@Override
	@Transactional
	public void updateStatus(UserTeacher userTeacher) {
		super.updateStatus(userTeacher);
	}
	
	/**
	 * 删除数据
	 * @param userTeacher
	 */
	@Override
	@Transactional
	public void delete(UserTeacher userTeacher) {
		super.delete(userTeacher);
	}
	
}