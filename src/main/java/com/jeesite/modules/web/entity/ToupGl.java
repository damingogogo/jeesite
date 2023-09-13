package com.jeesite.modules.web.entity;

import javax.validation.constraints.Size;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;
import com.jeesite.modules.sys.entity.User;
import lombok.Data;

import java.util.List;

/**
 * 报名管理Entity
 * @author Tr
 * @version 2023-06-25
 */
@Table(name="sys_toup_gl", alias="a", label="报名管理信息", columns={
		@Column(name="baoming_id", attrName="baomingId", label="id", isPK=true),
		@Column(name="title", attrName="title", label="标题", queryType=QueryType.LIKE),
		@Column(name="content", attrName="content", label="内容"),
		@Column(name="baoming_xuhao", attrName="baomingXuhao", label="报名序号"),
		@Column(name="bt_type", attrName="btType", label="属性", comment="属性(1:报名;2:填报)"),
		@Column(name="baoming_type", attrName="baomingType", label="报名类型"),
		@Column(name="baoming_wenjian", attrName="baomingWenjian", label="报名文件"),
		@Column(name="baoming_status", attrName="baomingStatus", label="报名状态", comment="报名状态(1:已截止;2:未截止"),
		@Column(name="baoming_ms", attrName="baomingMs", label="报名描述"),
		@Column(name="baoming_xq", attrName="baomingXq", label="报名详情"),
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
		@Column(name="login_code", attrName="loginCode", label="login_code"),
		@Column(name="user_code", attrName="userCode", label="user_code"),
		@Column(name="user_name", attrName="userName", label="user_name", queryType=QueryType.LIKE),
	}, orderBy="a.update_date DESC"
)
@Data
public class ToupGl extends DataEntity<ToupGl> {
	
	private static final long serialVersionUID = 1L;
	private List<User> userList;
	private String userCode;		//
	private String userCodes;		//
	private String loginCode;		//
	private String userName;		//
	private String baomingId;		// id
	private String title;		// 标题
	private String content;		// 内容
	private String baomingXuhao;		// 报名序号
	private String btType;		// 属性(1:报名;2:填报)
	private String baomingType;		// 报名类型
	private String baomingWenjian;		// 报名文件
	private String baomingStatus;		// 报名状态(1:已截止;2:未截止
	private String baomingMs;		// 报名描述
	private String baomingXq;		// 报名详情
	private String extend1;		// 扩展 String 1
	private String extend2;		// 扩展 String 2
	private String extend3;		// 扩展 String 3
	private String extend4;		// 扩展 String 4
	private String extend5;		// 扩展 String 5
	private String extend6;		// 扩展 String 6
	private String extend7;		// 扩展 String 7
	private String extend8;		// 扩展 String 8
	private String zt;		// 扩展 String 8


	public ToupGl() {
		this(null);
	}
	
	public ToupGl(String id){
		super(id);
	}
	
	public String getBaomingId() {
		return baomingId;
	}

	public void setBaomingId(String baomingId) {
		this.baomingId = baomingId;
	}
	
	@Size(min=0, max=255, message="标题长度不能超过 255 个字符")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Size(min=0, max=255, message="内容长度不能超过 255 个字符")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Size(min=0, max=100, message="报名序号长度不能超过 100 个字符")
	public String getBaomingXuhao() {
		return baomingXuhao;
	}

	public void setBaomingXuhao(String baomingXuhao) {
		this.baomingXuhao = baomingXuhao;
	}
	
	@Size(min=0, max=1, message="属性长度不能超过 1 个字符")
	public String getBtType() {
		return btType;
	}

	public void setBtType(String btType) {
		this.btType = btType;
	}
	
	@Size(min=0, max=2, message="报名类型长度不能超过 2 个字符")
	public String getBaomingType() {
		return baomingType;
	}

	public void setBaomingType(String baomingType) {
		this.baomingType = baomingType;
	}
	
	@Size(min=0, max=100, message="报名文件长度不能超过 100 个字符")
	public String getBaomingWenjian() {
		return baomingWenjian;
	}

	public void setBaomingWenjian(String baomingWenjian) {
		this.baomingWenjian = baomingWenjian;
	}
	
	@Size(min=0, max=2, message="报名状态长度不能超过 2 个字符")
	public String getBaomingStatus() {
		return baomingStatus;
	}

	public void setBaomingStatus(String baomingStatus) {
		this.baomingStatus = baomingStatus;
	}
	
	@Size(min=0, max=100, message="报名描述长度不能超过 100 个字符")
	public String getBaomingMs() {
		return baomingMs;
	}

	public void setBaomingMs(String baomingMs) {
		this.baomingMs = baomingMs;
	}
	
	@Size(min=0, max=100, message="报名详情长度不能超过 100 个字符")
	public String getBaomingXq() {
		return baomingXq;
	}

	public void setBaomingXq(String baomingXq) {
		this.baomingXq = baomingXq;
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
	
	@Size(min=0, max=255, message="login_code长度不能超过 255 个字符")
	public String getLoginCode() {
		return loginCode;
	}

	public void setLoginCode(String loginCode) {
		this.loginCode = loginCode;
	}
	
	@Size(min=0, max=255, message="user_code长度不能超过 255 个字符")
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	@Size(min=0, max=255, message="user_name长度不能超过 255 个字符")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}