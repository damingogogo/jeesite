package com.jeesite.modules.web.entity;

import javax.validation.constraints.Size;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;
import lombok.Data;

import java.util.List;

/**
 * 成绩管理Entity
 * @author tulabu
 * @version 2023-02-16
 */
@Table(name="sys_chengj_gl", alias="a", label="成绩管理信息", columns={
		@Column(name="chengj_id", attrName="chengjId", label="id", isPK=true),
		@Column(name="chengj_type", attrName="chengjType", label="成绩类型"),
		@Column(name="title", attrName="title", label="标题", queryType=QueryType.LIKE),
		@Column(name="content", attrName="content", label="内容"),
		@Column(name="kemu_id", attrName="kemuId", label="kemu_id"),
		@Column(name="kemu_name", attrName="kemuName", label="kemu_name", queryType=QueryType.LIKE),
		@Column(name="login_code", attrName="loginCode", label="login_code"),
		@Column(name="user_name", attrName="userName", label="user_name", queryType=QueryType.LIKE),
		@Column(name="user_code", attrName="userCode", label="user_code"),
		@Column(name="office_code", attrName="officeCode", label="office_code"),
		@Column(name="chengj_wenjian", attrName="chengjWenjian", label="成绩文件"),
		@Column(name="create_by", attrName="createBy", label="创建者", isUpdate=false, isQuery=false),
		@Column(name="create_date", attrName="createDate", label="创建时间", isUpdate=false, isQuery=false, isUpdateForce=true),
		@Column(name="update_by", attrName="updateBy", label="更新者", isQuery=false),
		@Column(name="update_date", attrName="updateDate", label="更新时间", isQuery=false, isUpdateForce=true),
		@Column(name="status", attrName="status", label="状态", isUpdate=false),
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
public class ChengjGl extends DataEntity<ChengjGl> {
	
	private static final long serialVersionUID = 1L;
	private String chengjId;		// id
	private String subjectIds;		// id
	private String chengjType;		// 成绩类型
	private String title;		// 标题
	private String content;		// 内容
	private String kemuId;		// kemu_id
	private String kemuName;		// kemu_name
	private String loginCode;		// login_code
	private String userName;		// user_name
	private String userCode;		// user_code
	private String officeCode;		// office_code
	private String chengjWenjian;		// 成绩文件
	private String extend1;		// 扩展 String 1
	private String extend2;		// 扩展 String 2
	private String extend3;		// 扩展 String 3
	private String extend4;		// 扩展 String 4
	private String extend5;		// 扩展 String 5
	private String extend6;		// 扩展 String 6
	private String extend7;		// 扩展 String 7
	private String extend8;		// 扩展 String 8
	private List<SubjectGl> subjectGlList;

	public ChengjGl() {
		this(null);
	}
	
	public ChengjGl(String id){
		super(id);
	}
	
	public String getChengjId() {
		return chengjId;
	}

	public void setChengjId(String chengjId) {
		this.chengjId = chengjId;
	}

	@Size(min=0, max=100, message="标题长度不能超过 100 个字符")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Size(min=0, max=500, message="内容长度不能超过 500 个字符")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Size(min=0, max=255, message="kemu_id长度不能超过 255 个字符")
	public String getKemuId() {
		return kemuId;
	}

	public void setKemuId(String kemuId) {
		this.kemuId = kemuId;
	}
	
	@Size(min=0, max=255, message="kemu_name长度不能超过 255 个字符")
	public String getKemuName() {
		return kemuName;
	}

	public void setKemuName(String kemuName) {
		this.kemuName = kemuName;
	}
	
	@Size(min=0, max=255, message="login_code长度不能超过 255 个字符")
	public String getLoginCode() {
		return loginCode;
	}

	public void setLoginCode(String loginCode) {
		this.loginCode = loginCode;
	}
	
	@Size(min=0, max=255, message="user_name长度不能超过 255 个字符")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Size(min=0, max=255, message="user_code长度不能超过 255 个字符")
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	@Size(min=0, max=255, message="office_code长度不能超过 255 个字符")
	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}
	
	@Size(min=0, max=100, message="成绩文件长度不能超过 100 个字符")
	public String getChengjWenjian() {
		return chengjWenjian;
	}

	public void setChengjWenjian(String chengjWenjian) {
		this.chengjWenjian = chengjWenjian;
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