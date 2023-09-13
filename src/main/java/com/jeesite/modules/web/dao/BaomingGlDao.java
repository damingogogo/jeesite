package com.jeesite.modules.web.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.sys.entity.User;
import com.jeesite.modules.web.entity.BaomingGl;

import java.util.List;
import java.util.Map;

/**
 * 报名管理DAO接口
 * @author tulabu
 * @version 2023-02-11
 */
@MyBatisDao
public interface BaomingGlDao extends CrudDao<BaomingGl> {

    List<Map<String, Object>> findbaomingtj(BaomingGl baomingGl);

    List<User> finduser(List<String> list);

    List<Map<String, Object>> findtianbaotj(BaomingGl baomingGl);

    List<Map<String, Object>> findtouptj(BaomingGl baomingGl);
}
