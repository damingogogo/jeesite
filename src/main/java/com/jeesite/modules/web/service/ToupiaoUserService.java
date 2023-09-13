package com.jeesite.modules.web.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.web.entity.ToupiaoUser;
import com.jeesite.modules.web.dao.ToupiaoUserDao;

/**
 * 投票人Service
 * @author tulabu
 * @version 2023-03-04
 */
@Service
public class ToupiaoUserService extends CrudService<ToupiaoUserDao, ToupiaoUser> {
	
	/**
	 * 获取单条数据
	 * @param toupiaoUser
	 * @return
	 */
	@Override
	public ToupiaoUser get(ToupiaoUser toupiaoUser) {
		return super.get(toupiaoUser);
	}
	
	/**
	 * 查询分页数据
	 * @param toupiaoUser 查询条件
	 * @param toupiaoUser.page 分页对象
	 * @return
	 */
	@Override
	public Page<ToupiaoUser> findPage(ToupiaoUser toupiaoUser) {
		return super.findPage(toupiaoUser);
	}
	
	/**
	 * 查询列表数据
	 * @param toupiaoUser
	 * @return
	 */
	@Override
	public List<ToupiaoUser> findList(ToupiaoUser toupiaoUser) {
		return super.findList(toupiaoUser);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param toupiaoUser
	 */
	@Override
	@Transactional
	public void save(ToupiaoUser toupiaoUser) {
		super.save(toupiaoUser);
	}
	
	/**
	 * 更新状态
	 * @param toupiaoUser
	 */
	@Override
	@Transactional
	public void updateStatus(ToupiaoUser toupiaoUser) {
		super.updateStatus(toupiaoUser);
	}
	
	/**
	 * 删除数据
	 * @param toupiaoUser
	 */
	@Override
	@Transactional
	public void delete(ToupiaoUser toupiaoUser) {
		super.delete(toupiaoUser);
	}
	
}