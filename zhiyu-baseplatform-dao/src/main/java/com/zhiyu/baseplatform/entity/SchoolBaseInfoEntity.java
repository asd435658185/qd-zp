package com.zhiyu.baseplatform.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author csk
 * @Description 学校信息实体类
 */

@Table(name="school_base_info")
@Entity
public class SchoolBaseInfoEntity {
	 
	private Integer schoolId;//	学校id
	private String schoolCode;//	学校编号
	private String schoolName;//	学校名称
	private String schoolShortName;//	学校简称
	private String schoolEmail;//	学校邮箱
	private String schoolLinkMan;//	学校联系人
	private String schoolLinkTel;//	学校联系电话
	private String schoolSummary;//	学校简介
	private String schoolAddress;//	学校地址
	private Date schoolCreatetime;//	学校创建时间
	private Integer schoolTypeId;//	学校类型id
	private Integer schoolLevelId;//	学校等级id
	private Integer schoolKindId;//	学校性质id
	private Integer schoolProvinceId;//	学校所在省份id
	private Integer schoolCityId;//	学校所在市id
	private Integer schoolDistrictId;//	学校所在区id
	private String schoolImg;//学校图片
	private Integer parentId;
	@Id
 	@GeneratedValue(strategy=GenerationType.AUTO)
 	@Column(name="school_id")
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	
	@Column(name="school_code")
	public String getSchoolCode() {
		return schoolCode;
	}
	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}
	
	@Column(name="school_name")
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	@Column(name="school_short_name")
	public String getSchoolShortName() {
		return schoolShortName;
	}
	public void setSchoolShortName(String schoolShortName) {
		this.schoolShortName = schoolShortName;
	}
	
	@Column(name="school_email")
	public String getSchoolEmail() {
		return schoolEmail;
	}
	public void setSchoolEmail(String schoolEmail) {
		this.schoolEmail = schoolEmail;
	}
	
	@Column(name="school_link_man")
	public String getSchoolLinkMan() {
		return schoolLinkMan;
	}
	public void setSchoolLinkMan(String schoolLinkMan) {
		this.schoolLinkMan = schoolLinkMan;
	}
	
	@Column(name="school_link_tel")
	public String getSchoolLinkTel() {
		return schoolLinkTel;
	}
	public void setSchoolLinkTel(String schoolLinkTel) {
		this.schoolLinkTel = schoolLinkTel;
	}
	
	@Column(name="school_summary")
	public String getSchoolSummary() {
		return schoolSummary;
	}
	public void setSchoolSummary(String schoolSummary) {
		this.schoolSummary = schoolSummary;
	}
	
	@Column(name="school_address")
	public String getSchoolAddress() {
		return schoolAddress;
	}
	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="school_createtime")
	public Date getSchoolCreatetime() {
		return schoolCreatetime;
	}
	public void setSchoolCreatetime(Date schoolCreatetime) {
		this.schoolCreatetime = schoolCreatetime;
	}
	
	@Column(name="school_type_id")
	public Integer getSchoolTypeId() {
		return schoolTypeId;
	}
	public void setSchoolTypeId(Integer schoolTypeId) {
		this.schoolTypeId = schoolTypeId;
	}
	
	@Column(name="school_level_id")
	public Integer getSchoolLevelId() {
		return schoolLevelId;
	}
	public void setSchoolLevelId(Integer schoolLevelId) {
		this.schoolLevelId = schoolLevelId;
	}
	
	@Column(name="school_kind_id")
	public Integer getSchoolKindId() {
		return schoolKindId;
	}
	public void setSchoolKindId(Integer schoolKindId) {
		this.schoolKindId = schoolKindId;
	}
	
	@Column(name="school_province_id")
	public Integer getSchoolProvinceId() {
		return schoolProvinceId;
	}
	public void setSchoolProvinceId(Integer schoolProvinceId) {
		this.schoolProvinceId = schoolProvinceId;
	}
	
	@Column(name="school_city_id")
	public Integer getSchoolCityId() {
		return schoolCityId;
	}
	public void setSchoolCityId(Integer schoolCityId) {
		this.schoolCityId = schoolCityId;
	}
	
	@Column(name="school_district_id")
	public Integer getSchoolDistrictId() {
		return schoolDistrictId;
	}
	public void setSchoolDistrictId(Integer schoolDistrictId) {
		this.schoolDistrictId = schoolDistrictId;
	}
	
	@Column(name="school_img")
	public String getSchoolImg() {
		return schoolImg;
	}
	public void setSchoolImg(String schoolImg) {
		this.schoolImg = schoolImg;
	}
	
	@Column(name="parent_id")
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
}
