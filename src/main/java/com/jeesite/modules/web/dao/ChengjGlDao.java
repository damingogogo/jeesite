package com.jeesite.modules.web.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.web.entity.ChengjGl;

/**
 * 成绩管理DAO接口
 * @author tulabu
 * @version 2023-02-16
 */
@MyBatisDao
public interface ChengjGlDao extends CrudDao<ChengjGl> {
	
}