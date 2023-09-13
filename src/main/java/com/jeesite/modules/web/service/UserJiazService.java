package com.jeesite.modules.web.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.web.entity.UserJiaz;
import com.jeesite.modules.web.dao.UserJiazDao;

/**
 * 用户表Service
 * @author Tr
 * @version 2023-06-26
 */
@Service
public class UserJiazService extends CrudService<UserJiazDao, UserJiaz> {
	
	/**
	 * 获取单条数据
	 * @param userJiaz
	 * @return
	 */
	@Override
	public UserJiaz get(UserJiaz userJiaz) {
		return super.get(userJiaz);
	}
	
	/**
	 * 查询分页数据
	 * @param userJiaz 查询条件
	 * @param userJiaz.page 分页对象
	 * @return
	 */
	@Override
	public Page<UserJiaz> findPage(UserJiaz userJiaz) {
		return super.findPage(userJiaz);
	}
	
	/**
	 * 查询列表数据
	 * @param userJiaz
	 * @return
	 */
	@Override
	public List<UserJiaz> findList(UserJiaz userJiaz) {
		return super.findList(userJiaz);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param userJiaz
	 */
	@Override
	@Transactional
	public void save(UserJiaz userJiaz) {
		super.save(userJiaz);
	}
	
	/**
	 * 更新状态
	 * @param userJiaz
	 */
	@Override
	@Transactional
	public void updateStatus(UserJiaz userJiaz) {
		super.updateStatus(userJiaz);
	}
	
	/**
	 * 删除数据
	 * @param userJiaz
	 */
	@Override
	@Transactional
	public void delete(UserJiaz userJiaz) {
		super.delete(userJiaz);
	}
	
}