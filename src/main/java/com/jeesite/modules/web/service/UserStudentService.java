package com.jeesite.modules.web.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.web.entity.UserStudent;
import com.jeesite.modules.web.dao.UserStudentDao;

/**
 * 用户表Service
 * @author Tr
 * @version 2023-06-26
 */
@Service
public class UserStudentService extends CrudService<UserStudentDao, UserStudent> {
	
	/**
	 * 获取单条数据
	 * @param userStudent
	 * @return
	 */
	@Override
	public UserStudent get(UserStudent userStudent) {
		return super.get(userStudent);
	}
	
	/**
	 * 查询分页数据
	 * @param userStudent 查询条件
	 * @param userStudent.page 分页对象
	 * @return
	 */
	@Override
	public Page<UserStudent> findPage(UserStudent userStudent) {
		return super.findPage(userStudent);
	}
	
	/**
	 * 查询列表数据
	 * @param userStudent
	 * @return
	 */
	@Override
	public List<UserStudent> findList(UserStudent userStudent) {
		return super.findList(userStudent);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param userStudent
	 */
	@Override
	@Transactional
	public void save(UserStudent userStudent) {
		super.save(userStudent);
	}
	
	/**
	 * 更新状态
	 * @param userStudent
	 */
	@Override
	@Transactional
	public void updateStatus(UserStudent userStudent) {
		super.updateStatus(userStudent);
	}
	
	/**
	 * 删除数据
	 * @param userStudent
	 */
	@Override
	@Transactional
	public void delete(UserStudent userStudent) {
		super.delete(userStudent);
	}
	
}