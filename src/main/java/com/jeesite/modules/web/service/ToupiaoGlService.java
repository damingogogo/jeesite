package com.jeesite.modules.web.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.web.entity.ToupiaoGl;
import com.jeesite.modules.web.dao.ToupiaoGlDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 投票管理Service
 * @author tulabu
 * @version 2023-02-14
 */
@Service
public class ToupiaoGlService extends CrudService<ToupiaoGlDao, ToupiaoGl> {
	
	/**
	 * 获取单条数据
	 * @param toupiaoGl
	 * @return
	 */
	@Override
	public ToupiaoGl get(ToupiaoGl toupiaoGl) {
		return super.get(toupiaoGl);
	}
	
	/**
	 * 查询分页数据
	 * @param toupiaoGl 查询条件
	 * @param toupiaoGl.page 分页对象
	 * @return
	 */
	@Override
	public Page<ToupiaoGl> findPage(ToupiaoGl toupiaoGl) {
		return super.findPage(toupiaoGl);
	}
	
	/**
	 * 查询列表数据
	 * @param toupiaoGl
	 * @return
	 */
	@Override
	public List<ToupiaoGl> findList(ToupiaoGl toupiaoGl) {
		return super.findList(toupiaoGl);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param toupiaoGl
	 */
	@Override
	@Transactional
	public void save(ToupiaoGl toupiaoGl) {
		super.save(toupiaoGl);
		// 保存上传附件
		FileUploadUtils.saveFileUpload(toupiaoGl, toupiaoGl.getId(), "toupiaoGl_file");
	}
	
	/**
	 * 更新状态
	 * @param toupiaoGl
	 */
	@Override
	@Transactional
	public void updateStatus(ToupiaoGl toupiaoGl) {
		super.updateStatus(toupiaoGl);
	}
	
	/**
	 * 删除数据
	 * @param toupiaoGl
	 */
	@Override
	@Transactional
	public void delete(ToupiaoGl toupiaoGl) {
		super.delete(toupiaoGl);
	}
	
}