package com.jeesite.modules.web.entity;

import javax.validation.constraints.Size;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;
import lombok.Data;

/**
 * 公告表Entity
 * @author tulabu
 * @version 2023-02-09
 */
@Table(name="sys_gongg", alias="a", label="公告表信息", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="gongg_type", attrName="gonggType", label="公告类型", comment="公告类型(1:通知型公告;2:回应型公告)"),
		@Column(name="wenjian", attrName="wenjian", label="文件"),
		@Column(name="huiying_type", attrName="huiyingType", label="回应状态", comment="回应状态(1:已回应;2未回应:)"),
		@Column(name="miaos", attrName="miaos", label="描述"),
		@Column(name="create_by", attrName="createBy", label="创建者", isUpdate=false, isQuery=false),
		@Column(name="create_date", attrName="createDate", label="创建时间", isUpdate=false, queryType = QueryType.GTE, isUpdateForce=true),
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
		@Column(name="title", attrName="title", label="标题",queryType=QueryType.LIKE),
		@Column(name="content", attrName="content", label="内容",queryType=QueryType.LIKE),
	}, orderBy="a.update_date DESC"
)
@Data
public class Gongg extends DataEntity<Gongg> {

	private static final long serialVersionUID = 1L;
	private String gonggType;		// 公告类型(1:通知型公告;2:回应型公告)
	private String wenjian;		// 文件
	private String huiyingType;		// 回应状态(1:已回应;2未回应:)
	private String miaos;		// 描述
	private String title;		// 描述
	private String content;		// 描述
	private String extend1;		// 扩展 String 1
	private String extend2;		// 扩展 String 2
	private String extend3;		// 扩展 String 3
	private String extend4;		// 扩展 String 4
	private String extend5;		// 扩展 String 5
	private String extend6;		// 扩展 String 6
	private String extend7;		// 扩展 String 7
	private String extend8;		// 扩展 String 8
	private String shujuDay;		// 扩展 String 8

	public Gongg() {
		this(null);
	}

	public Gongg(String id){
		super(id);
	}

	@Size(min=0, max=2, message="公告类型长度不能超过 2 个字符")
	public String getGonggType() {
		return gonggType;
	}

	public void setGonggType(String gonggType) {
		this.gonggType = gonggType;
	}

	@Size(min=0, max=100, message="文件长度不能超过 100 个字符")
	public String getWenjian() {
		return wenjian;
	}

	public void setWenjian(String wenjian) {
		this.wenjian = wenjian;
	}

	@Size(min=0, max=2, message="回应状态长度不能超过 2 个字符")
	public String getHuiyingType() {
		return huiyingType;
	}

	public void setHuiyingType(String huiyingType) {
		this.huiyingType = huiyingType;
	}

	@Size(min=0, max=500, message="描述长度不能超过 500 个字符")
	public String getMiaos() {
		return miaos;
	}

	public void setMiaos(String miaos) {
		this.miaos = miaos;
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
