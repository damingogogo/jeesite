package com.jeesite.modules.web.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.web.entity.NjGl;
import com.jeesite.modules.web.dao.NjGlDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 年级管理表Service
 * @author tulabu
 * @version 2023-02-09
 */
@Service
public class NjGlService extends CrudService<NjGlDao, NjGl> {
	
	/**
	 * 获取单条数据
	 * @param njGl
	 * @return
	 */
	@Override
	public NjGl get(NjGl njGl) {
		return super.get(njGl);
	}
	
	/**
	 * 查询分页数据
	 * @param njGl 查询条件
	 * @param njGl.page 分页对象
	 * @return
	 */
	@Override
	public Page<NjGl> findPage(NjGl njGl) {
		return super.findPage(njGl);
	}
	
	/**
	 * 查询列表数据
	 * @param njGl
	 * @return
	 */
	@Override
	public List<NjGl> findList(NjGl njGl) {
		return super.findList(njGl);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param njGl
	 */
	@Override
	@Transactional
	public void save(NjGl njGl) {
		super.save(njGl);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(njGl, njGl.getId(), "njGl_image");
		// 保存上传附件
		FileUploadUtils.saveFileUpload(njGl, njGl.getId(), "njGl_file");
	}
	
	/**
	 * 更新状态
	 * @param njGl
	 */
	@Override
	@Transactional
	public void updateStatus(NjGl njGl) {
		super.updateStatus(njGl);
	}
	
	/**
	 * 删除数据
	 * @param njGl
	 */
	@Override
	@Transactional
	public void delete(NjGl njGl) {
		super.delete(njGl);
	}
	
}