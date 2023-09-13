package com.jeesite.modules.web.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;
import com.jeesite.common.utils.excel.annotation.ExcelField;
import com.jeesite.common.utils.excel.annotation.ExcelField.Align;
import com.jeesite.common.utils.excel.annotation.ExcelFields;
import lombok.Data;

/**
 * 公告回应Entity
 * @author tulabu
 * @version 2023-02-11
 */
@Table(name="sys_gongg_huiy", alias="a", label="公告回应信息", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="gongg_id", attrName="gonggId", label="公告id"),
		@Column(name="xinxi_code", attrName="xinxiCode", label="账号"),
		@Column(name="xinxi_name", attrName="xinxiName", label="名称", queryType=QueryType.LIKE),
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
	}, orderBy="a.update_date DESC"
)
@Data
public class GonggHuiy extends DataEntity<GonggHuiy> {

	private static final long serialVersionUID = 1L;
	private String gonggId;		// 公告id
	private String xinxiCode;		// 账号
	private String xinxiName;		// 名称
	private String miaos;		// 描述
	private String title;		// 描述
	private String extend1;		// 扩展 String 1
	private String extend2;		// 扩展 String 2
	private String extend3;		// 扩展 String 3
	private String extend4;		// 扩展 String 4
	private String extend5;		// 扩展 String 5
	private String extend6;		// 扩展 String 6
	private String extend7;		// 扩展 String 7
	private String extend8;		// 扩展 String 8

	@ExcelFields({
		@ExcelField(title="id", attrName="id", align=Align.CENTER, sort=10),
		@ExcelField(title="公告id", attrName="gonggId", align=Align.CENTER, sort=20),
		@ExcelField(title="账号", attrName="xinxiCode", align=Align.CENTER, sort=30),
		@ExcelField(title="名称", attrName="xinxiName", align=Align.CENTER, sort=40),
		@ExcelField(title="描述", attrName="miaos", align=Align.CENTER, sort=50),
	})
	public GonggHuiy() {
		this(null);
	}

	public GonggHuiy(String id){
		super(id);
	}

	@NotBlank(message="公告id不能为空")
	@Size(min=0, max=100, message="公告id长度不能超过 100 个字符")
	public String getGonggId() {
		return gonggId;
	}

	public void setGonggId(String gonggId) {
		this.gonggId = gonggId;
	}

	@Size(min=0, max=100, message="账号长度不能超过 100 个字符")
	public String getXinxiCode() {
		return xinxiCode;
	}

	public void setXinxiCode(String xinxiCode) {
		this.xinxiCode = xinxiCode;
	}

	@Size(min=0, max=100, message="名称长度不能超过 100 个字符")
	public String getXinxiName() {
		return xinxiName;
	}

	public void setXinxiName(String xinxiName) {
		this.xinxiName = xinxiName;
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
