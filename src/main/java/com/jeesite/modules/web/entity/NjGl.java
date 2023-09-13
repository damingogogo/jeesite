package com.jeesite.modules.web.entity;

import javax.validation.constraints.Size;
import com.jeesite.common.entity.Extend;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;
import lombok.Data;

/**
 * 年级管理表Entity
 * @author tulabu
 * @version 2023-02-09
 */
@Table(name="sys_nj_gl", alias="a", label="年级管理表信息", columns={
		@Column(name="nj_id", attrName="njId", label="年级id", isPK=true),
		@Column(name="school_id", attrName="schoolId", label="学校id", isUpdateForce=true),
		@Column(name="nj_name", attrName="njName", label="年级名称", queryType=QueryType.LIKE),
		@Column(name="njzrxm", attrName="njzrxm", label="年级主任姓名"),
		@Column(name="njbjzs", attrName="njbjzs", label="年级班级总数"),
		@Column(name="njzrs", attrName="njzrs", label="年级总人数"),
		@Column(name="njms", attrName="njms", label="年级描述"),
		@Column(name="create_by", attrName="createBy", label="创建者", isUpdate=false, isQuery=false),
		@Column(name="create_date", attrName="createDate", label="创建时间", isUpdate=false, isQuery=false, isUpdateForce=true),
		@Column(name="update_by", attrName="updateBy", label="更新者", isQuery=false),
		@Column(name="extend1", attrName="extend1", label="扩展字段", isQuery=false),
		@Column(name="extend2", attrName="extend2", label="扩展字段", isQuery=false),
		@Column(name="extend3", attrName="extend3", label="扩展字段", isQuery=false),
		@Column(name="extend4", attrName="extend4", label="扩展字段", isQuery=false),
		@Column(name="extend5", attrName="extend5", label="扩展字段", isQuery=false),
		@Column(name="extend6", attrName="extend6", label="扩展字段", isQuery=false),
		@Column(name="extend7", attrName="extend7", label="扩展字段", isQuery=false),
		@Column(name="extend8", attrName="extend8", label="扩展字段", isQuery=false),

		@Column(name="update_date", attrName="updateDate", label="更新时间", isQuery=false, isUpdateForce=true),
	}, orderBy="a.update_date DESC"
)
@Data
public class NjGl extends DataEntity<NjGl> {
	
	private static final long serialVersionUID = 1L;
	private String njId;		// 年级id
	private String  schoolId;		// 学校id
	private String njName;		// 年级名称
	private String njzrxm;		// 年级主任姓名
	private String njbjzs;		// 年级班级总数
	private String njzrs;		// 年级总人数
	private String njms;		// 年级描述
	private String extend1;		// 扩展字段
	private String extend2;		// 扩展字段
	private String extend3;		// 扩展字段
	private String extend4;		// 扩展字段
	private String extend5;		// 扩展字段
	private String extend6;		// 扩展字段
	private String extend7;		// 扩展字段
	private String extend8;		// 扩展字段


	
}