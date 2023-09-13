package com.jeesite.modules.web.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.web.entity.BtoupiaoUser;

/**
 * 被投票人DAO接口
 * @author tulabu
 * @version 2023-03-04
 */
@MyBatisDao
public interface BtoupiaoUserDao extends CrudDao<BtoupiaoUser> {
	
}