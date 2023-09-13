package com.jeesite.modules.web.entity;

import javax.validation.constraints.Size;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 科目管理表Entity
 * @author tulabu
 * @version 2023-02-09
 */
@Table(name="sys_subject_gl", alias="a", label="科目管理表信息", columns={
		@Column(name="subject_id", attrName="subjectId", label="科目id", isPK=true),
		@Column(name="subject_name", attrName="subjectName", label="科目名称", queryType=QueryType.LIKE),
		@Column(name="subject_type", attrName="subjectType", label="科目类型"),
		@Column(name="subject_zrmc", attrName="subjectZrmc", label="科目主任姓名"),
		@Column(name="subject_zrphone", attrName="subjectZrphone", label="科目主任电话"),
		@Column(name="subject_ms", attrName="subjectMs", label="科目描述"),
		@Column(name="create_by", attrName="createBy", label="创建者", isUpdate=false, isQuery=false),
		@Column(name="status", attrName="status", label="状态", isUpdate=false),
		@Column(name="create_date", attrName="createDate", label="创建时间", isUpdate=false, isQuery=false, isUpdateForce=true),
		@Column(name="update_by", attrName="updateBy", label="更新者", isQuery=false),
		@Column(name="update_date", attrName="updateDate", label="更新时间", isQuery=false, isUpdateForce=true),
		@Column(name="extend1", attrName="extend1", label="扩展 String 1"),
		@Column(name="extend2", attrName="extend2", label="扩展 String 2"),
		@Column(name="extend3", attrName="extend3", label="扩展 String 3"),
		@Column(name="extend4", attrName="extend4", label="扩展 String 4"),
		@Column(name="extend5", attrName="extend5", label="扩展 String 5"),
		@Column(name="extend6", attrName="extend6", label="扩展 String 6"),
		@Column(name="extend7", attrName="extend7", label="扩展 String 7"),
		@Column(name="extend8", attrName="extend8", label="扩展 String 8"),
	}, orderBy="a.update_date DESC"
)
public class SubjectGl extends DataEntity<SubjectGl> {
	
	private static final long serialVersionUID = 1L;
	private String subjectId;		// 科目id
	private String subjectName;		// 科目名称
	private String subjectType;		// 科目类型
	private String subjectZrmc;		// 科目主任姓名
	private String subjectZrphone;		// 科目主任电话
	private String subjectMs;		// 科目描述
	private String extend1;		// 扩展 String 1
	private String extend2;		// 扩展 String 2
	private String extend3;		// 扩展 String 3
	private String extend4;		// 扩展 String 4
	private String extend5;		// 扩展 String 5
	private String extend6;		// 扩展 String 6
	private String extend7;		// 扩展 String 7
	private String extend8;		// 扩展 String 8

	public SubjectGl() {
		this(null);
	}
	
	public SubjectGl(String id){
		super(id);
	}
	
	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	
	@Size(min=0, max=100, message="科目名称长度不能超过 100 个字符")
	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	@Size(min=0, max=2, message="科目类型长度不能超过 2 个字符")
	public String getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}
	
	@Size(min=0, max=100, message="科目主任姓名长度不能超过 100 个字符")
	public String getSubjectZrmc() {
		return subjectZrmc;
	}

	public void setSubjectZrmc(String subjectZrmc) {
		this.subjectZrmc = subjectZrmc;
	}
	
	@Size(min=0, max=100, message="科目主任电话长度不能超过 100 个字符")
	public String getSubjectZrphone() {
		return subjectZrphone;
	}

	public void setSubjectZrphone(String subjectZrphone) {
		this.subjectZrphone = subjectZrphone;
	}
	
	@Size(min=0, max=500, message="科目描述长度不能超过 500 个字符")
	public String getSubjectMs() {
		return subjectMs;
	}

	public void setSubjectMs(String subjectMs) {
		this.subjectMs = subjectMs;
	}
	
	@Size(min=0, max=500, message="扩展 String 1长度不能超过 500 个字符")
	public String getExtend1() {
		return extend1;
	}

	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}
	
	@Size(min=0, max=500, message="扩展 String 2长度不能超过 500 个字符")
	public String getExtend2() {
		return extend2;
	}

	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}
	
	@Size(min=0, max=500, message="扩展 String 3长度不能超过 500 个字符")
	public String getExtend3() {
		return extend3;
	}

	public void setExtend3(String extend3) {
		this.extend3 = extend3;
	}
	
	@Size(min=0, max=500, message="扩展 String 4长度不能超过 500 个字符")
	public String getExtend4() {
		return extend4;
	}

	public void setExtend4(String extend4) {
		this.extend4 = extend4;
	}
	
	@Size(min=0, max=500, message="扩展 String 5长度不能超过 500 个字符")
	public String getExtend5() {
		return extend5;
	}

	public void setExtend5(String extend5) {
		this.extend5 = extend5;
	}
	
	@Size(min=0, max=500, message="扩展 String 6长度不能超过 500 个字符")
	public String getExtend6() {
		return extend6;
	}

	public void setExtend6(String extend6) {
		this.extend6 = extend6;
	}
	
	@Size(min=0, max=500, message="扩展 String 7长度不能超过 500 个字符")
	public String getExtend7() {
		return extend7;
	}

	public void setExtend7(String extend7) {
		this.extend7 = extend7;
	}
	
	@Size(min=0, max=500, message="扩展 String 8长度不能超过 500 个字符")
	public String getExtend8() {
		return extend8;
	}

	public void setExtend8(String extend8) {
		this.extend8 = extend8;
	}
	
}