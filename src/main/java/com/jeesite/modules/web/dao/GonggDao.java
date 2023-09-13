package com.jeesite.modules.web.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.web.entity.Gongg;

import java.util.List;
import java.util.Map;

/**
 * 公告表DAO接口
 * @author tulabu
 * @version 2023-02-09
 */
@MyBatisDao
public interface GonggDao extends CrudDao<Gongg> {

    List<Map<String, Object>> findbaomingtj(Gongg gongg);
}