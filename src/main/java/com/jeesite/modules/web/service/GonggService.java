package com.jeesite.modules.web.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.web.entity.Gongg;
import com.jeesite.modules.web.dao.GonggDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 公告表Service
 * @author tulabu
 * @version 2023-02-09
 */
@Service
public class GonggService extends CrudService<GonggDao, Gongg> {

	/**
	 * 获取单条数据
	 * @param gongg
	 * @return
	 */
	@Override
	public Gongg get(Gongg gongg) {
		return super.get(gongg);
	}

	/**
	 * 查询分页数据
	 * @param gongg 查询条件
	 * @param gongg.page 分页对象
	 * @return
	 */
	@Override
	public Page<Gongg> findPage(Gongg gongg) {
		return super.findPage(gongg);
	}

	/**
	 * 查询列表数据
	 * @param gongg
	 * @return
	 */
	@Override
	public List<Gongg> findList(Gongg gongg) {
		return super.findList(gongg);
	}

	/**
	 * 保存数据（插入或更新）
	 * @param gongg
	 */
	@Override
	@Transactional
	public void save(Gongg gongg) {
		super.save(gongg);
		// 保存上传附件
		FileUploadUtils.saveFileUpload(gongg, gongg.getId(), "gongg_file");
	}

	/**
	 * 更新状态
	 * @param gongg
	 */
	@Override
	@Transactional
	public void updateStatus(Gongg gongg) {
		super.updateStatus(gongg);
	}

	/**
	 * 删除数据
	 * @param gongg
	 */
	@Override
	@Transactional
	public void delete(Gongg gongg) {
		super.delete(gongg);
	}

	public List<Map<String, Object>> findbaomingtj(Gongg gongg) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		if (gongg.getShujuDay()==null){
			calendar.add(Calendar.MONTH, -1); //减几就是几个月之前
		}else {
			calendar.add(Calendar.DAY_OF_MONTH, -Integer.parseInt(gongg.getShujuDay())); //当前时间减去一天，即一天前的时间
		}

		Date m = calendar.getTime();
//		String mon = format.format(m);
		gongg.setCreateDate(m);
		return dao.findbaomingtj(gongg);
	}
}
