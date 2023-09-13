package com.jeesite.modules.web.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.web.entity.SubjectGl;

import java.util.List;

/**
 * 科目管理表DAO接口
 * @author tulabu
 * @version 2023-02-09
 */
@MyBatisDao
public interface SubjectGlDao extends CrudDao<SubjectGl> {

    List<SubjectGl> findKemu(List<String> list);
}