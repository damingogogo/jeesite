package com.jeesite.modules.web.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;
import lombok.Data;

/**
 * 班级管理表Entity
 * @author tulabu
 * @version 2023-02-09
 */
@Table(name="sys_class_gl", alias="a", label="班级管理表信息", columns={
		@Column(name="class_id", attrName="classId", label="班级id", isPK=true),
		@Column(name="nj_id", attrName="njId", label="年级id"),
		@Column(name="class_name", attrName="className", label="班级名称", queryType=QueryType.LIKE),
		@Column(name="class_type", attrName="classType", label="班级类型"),
		@Column(name="bzrxm", attrName="bzrxm", label="班主任姓名"),
		@Column(name="bzrphone", attrName="bzrphone", label="班主任电话"),
		@Column(name="bjzrs", attrName="bjzrs", label="班级总人数"),
		@Column(name="bj_pic", attrName="bjPic", label="班级相册"),
		@Column(name="bj_stu", attrName="bjStu", label="班级学生"),
		@Column(name="bjms", attrName="bjms", label="班级描述"),
		@Column(name="create_by", attrName="createBy", label="创建者", isUpdate=false, isQuery=false),
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
@Data
public class ClassGl extends DataEntity<ClassGl> {
	
	private static final long serialVersionUID = 1L;
	private String classId;		// 班级id
	private String njId;		// 年级id
	private String className;		// 班级名称
	private String classType;		// 班级类型
	private String bzrxm;		// 班主任姓名
	private String bzrphone;		// 班主任电话
	private String bjzrs;		// 班级总人数
	private String bjPic;		// 班级相册
	private String bjStu;		// 班级学生
	private String bjms;		// 班级描述
	private String extend1;		// 扩展 String 1
	private String extend2;		// 扩展 String 2
	private String extend3;		// 扩展 String 3
	private String extend4;		// 扩展 String 4
	private String extend5;		// 扩展 String 5
	private String extend6;		// 扩展 String 6
	private String extend7;		// 扩展 String 7
	private String extend8;		// 扩展 String 8

	private String code;
	private String pId;
	private String name;
	private String shuxing;
	private String indexType;

	public ClassGl() {
		this(null);
	}
	
	public ClassGl(String id){
		super(id);
	}
	
	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}
	
	@NotBlank(message="年级id不能为空")
	@Size(min=0, max=100, message="年级id长度不能超过 100 个字符")
	public String getNjId() {
		return njId;
	}

	public void setNjId(String njId) {
		this.njId = njId;
	}
	
	@Size(min=0, max=100, message="班级名称长度不能超过 100 个字符")
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	@Size(min=0, max=2, message="班级类型长度不能超过 2 个字符")
	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}
	
	@Size(min=0, max=100, message="班主任姓名长度不能超过 100 个字符")
	public String getBzrxm() {
		return bzrxm;
	}

	public void setBzrxm(String bzrxm) {
		this.bzrxm = bzrxm;
	}
	
	@Size(min=0, max=100, message="班主任电话长度不能超过 100 个字符")
	public String getBzrphone() {
		return bzrphone;
	}

	public void setBzrphone(String bzrphone) {
		this.bzrphone = bzrphone;
	}
	
	@Size(min=0, max=100, message="班级总人数长度不能超过 100 个字符")
	public String getBjzrs() {
		return bjzrs;
	}

	public void setBjzrs(String bjzrs) {
		this.bjzrs = bjzrs;
	}
	
	@Size(min=0, max=500, message="班级相册长度不能超过 500 个字符")
	public String getBjPic() {
		return bjPic;
	}

	public void setBjPic(String bjPic) {
		this.bjPic = bjPic;
	}
	
	@Size(min=0, max=500, message="班级学生长度不能超过 500 个字符")
	public String getBjStu() {
		return bjStu;
	}

	public void setBjStu(String bjStu) {
		this.bjStu = bjStu;
	}
	
	@Size(min=0, max=500, message="班级描述长度不能超过 500 个字符")
	public String getBjms() {
		return bjms;
	}

	public void setBjms(String bjms) {
		this.bjms = bjms;
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