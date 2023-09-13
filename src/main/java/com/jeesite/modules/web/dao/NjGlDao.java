package com.jeesite.modules.web.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.web.entity.NjGl;

/**
 * 年级管理表DAO接口
 * @author tulabu
 * @version 2023-02-09
 */
@MyBatisDao
public interface NjGlDao extends CrudDao<NjGl> {
	
}