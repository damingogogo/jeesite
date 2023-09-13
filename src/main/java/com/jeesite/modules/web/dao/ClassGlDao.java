package com.jeesite.modules.web.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.web.entity.ClassGl;

import java.util.List;

/**
 * 班级管理表DAO接口
 * @author tulabu
 * @version 2023-02-09
 */
@MyBatisDao
public interface ClassGlDao extends CrudDao<ClassGl> {

    List<ClassGl> findListNj(ClassGl classGl, String type);
}