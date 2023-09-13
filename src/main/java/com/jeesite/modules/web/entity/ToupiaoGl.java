package com.jeesite.modules.web.entity;

import javax.validation.constraints.Size;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 投票管理Entity
 * @author tulabu
 * @version 2023-02-14
 */
@Table(name="sys_toupiao_gl", alias="a", label="投票管理信息", columns={
		@Column(name="toupiao_id", attrName="toupiaoId", label="id", isPK=true),
		@Column(name="toupiao_type", attrName="toupiaoType", label="投票类型"),
		@Column(name="title", attrName="title", label="标题", queryType=QueryType.LIKE),
		@Column(name="content", attrName="content", label="内容", queryType=QueryType.LIKE),
		@Column(name="toupiao_wenjian", attrName="toupiaoWenjian", label="投票文件"),
		@Column(name="toupiao_status", attrName="toupiaoStatus", label="投票状态", comment="投票状态(0:已截止;1:未截止"),
		@Column(name="toupiao_ms", attrName="toupiaoMs", label="投票描述"),
		@Column(name="toupiao_xq", attrName="toupiaoXq", label="投票详情"),
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
public class ToupiaoGl extends DataEntity<ToupiaoGl> {
	
	private static final long serialVersionUID = 1L;
	private String toupiaoId;		// id
	private String toupiaoType;		// 投票类型
	private String title;		// 标题
	private String content;		// 内容
	private String toupiaoWenjian;		// 投票文件
	private String toupiaoStatus;		// 投票状态(0:已截止;1:未截止
	private String toupiaoMs;		// 投票描述
	private String toupiaoXq;		// 投票详情
	private String extend1;		// 扩展 String 1
	private String extend2;		// 扩展 String 2
	private String extend3;		// 扩展 String 3
	private String extend4;		// 扩展 String 4
	private String extend5;		// 扩展 String 5
	private String extend6;		// 扩展 String 6
	private String extend7;		// 扩展 String 7
	private String extend8;		// 扩展 String 8

	public ToupiaoGl() {
		this(null);
	}
	
	public ToupiaoGl(String id){
		super(id);
	}
	
	public String getToupiaoId() {
		return toupiaoId;
	}

	public void setToupiaoId(String toupiaoId) {
		this.toupiaoId = toupiaoId;
	}
	
	@Size(min=0, max=2, message="投票类型长度不能超过 2 个字符")
	public String getToupiaoType() {
		return toupiaoType;
	}

	public void setToupiaoType(String toupiaoType) {
		this.toupiaoType = toupiaoType;
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
	
	@Size(min=0, max=100, message="投票文件长度不能超过 100 个字符")
	public String getToupiaoWenjian() {
		return toupiaoWenjian;
	}

	public void setToupiaoWenjian(String toupiaoWenjian) {
		this.toupiaoWenjian = toupiaoWenjian;
	}
	
	@Size(min=0, max=2, message="投票状态长度不能超过 2 个字符")
	public String getToupiaoStatus() {
		return toupiaoStatus;
	}

	public void setToupiaoStatus(String toupiaoStatus) {
		this.toupiaoStatus = toupiaoStatus;
	}
	
	@Size(min=0, max=100, message="投票描述长度不能超过 100 个字符")
	public String getToupiaoMs() {
		return toupiaoMs;
	}

	public void setToupiaoMs(String toupiaoMs) {
		this.toupiaoMs = toupiaoMs;
	}
	
	@Size(min=0, max=100, message="投票详情长度不能超过 100 个字符")
	public String getToupiaoXq() {
		return toupiaoXq;
	}

	public void setToupiaoXq(String toupiaoXq) {
		this.toupiaoXq = toupiaoXq;
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