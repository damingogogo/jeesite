package com.jeesite.modules.web.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.web.entity.ToupiaoStastic;

/**
 * 投票统计DAO接口
 * @author tulabu
 * @version 2023-02-14
 */
@MyBatisDao
public interface ToupiaoStasticDao extends CrudDao<ToupiaoStastic> {
	
}