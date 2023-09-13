package com.jeesite.modules.web.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.web.entity.BtoupiaoUser;
import com.jeesite.modules.web.dao.BtoupiaoUserDao;

/**
 * 被投票人Service
 * @author tulabu
 * @version 2023-03-04
 */
@Service
public class BtoupiaoUserService extends CrudService<BtoupiaoUserDao, BtoupiaoUser> {
	
	/**
	 * 获取单条数据
	 * @param btoupiaoUser
	 * @return
	 */
	@Override
	public BtoupiaoUser get(BtoupiaoUser btoupiaoUser) {
		return super.get(btoupiaoUser);
	}
	
	/**
	 * 查询分页数据
	 * @param btoupiaoUser 查询条件
	 * @param btoupiaoUser.page 分页对象
	 * @return
	 */
	@Override
	public Page<BtoupiaoUser> findPage(BtoupiaoUser btoupiaoUser) {
		return super.findPage(btoupiaoUser);
	}
	
	/**
	 * 查询列表数据
	 * @param btoupiaoUser
	 * @return
	 */
	@Override
	public List<BtoupiaoUser> findList(BtoupiaoUser btoupiaoUser) {
		return super.findList(btoupiaoUser);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param btoupiaoUser
	 */
	@Override
	@Transactional
	public void save(BtoupiaoUser btoupiaoUser) {
		super.save(btoupiaoUser);
	}
	
	/**
	 * 更新状态
	 * @param btoupiaoUser
	 */
	@Override
	@Transactional
	public void updateStatus(BtoupiaoUser btoupiaoUser) {
		super.updateStatus(btoupiaoUser);
	}
	
	/**
	 * 删除数据
	 * @param btoupiaoUser
	 */
	@Override
	@Transactional
	public void delete(BtoupiaoUser btoupiaoUser) {
		super.delete(btoupiaoUser);
	}
	
}