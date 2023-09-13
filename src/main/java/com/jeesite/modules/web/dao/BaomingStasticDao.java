package com.jeesite.modules.web.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.web.entity.BaomingStastic;

import java.util.List;
import java.util.Map;

/**
 * 报名统计DAO接口
 * @author tulabu
 * @version 2023-02-13
 */
@MyBatisDao
public interface BaomingStasticDao extends CrudDao<BaomingStastic> {

    List<BaomingStastic> findPageData(Map<String, Integer> map, BaomingStastic baomingStastic);

    long getCount(BaomingStastic baomingStastic);

    List<BaomingStastic> findPageDataToupaio(Map<String, Integer> map, BaomingStastic baomingStastic);

    long getCountToupaio(BaomingStastic baomingStastic);

    List<BaomingStastic> findToupiaoList(BaomingStastic baomingStastic);

    List<BaomingStastic> findPageDataTb(Map<String, Integer> map, BaomingStastic baomingStastic);

    long getCountTb(BaomingStastic baomingStastic);
}
