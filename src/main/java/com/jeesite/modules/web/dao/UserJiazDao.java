package com.jeesite.modules.web.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.web.entity.UserJiaz;

/**
 * 用户表DAO接口
 * @author Tr
 * @version 2023-06-26
 */
@MyBatisDao
public interface UserJiazDao extends CrudDao<UserJiaz> {
	
}