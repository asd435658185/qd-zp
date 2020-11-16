package com.zhiyu.baseplatform.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author csk
 * @Description 学校类型实体类
 */
@Table(name="school_type")
@Entity
public class SchoolTypeEntity {
	private Integer schoolTypeId;//	学校类型id
	private String schoolTypeCode;//	学校类型编号
	private String schoolTypeName;//	学校类型名称
	
	@Id
 	@GeneratedValue(strategy=GenerationType.AUTO)
 	@Column(name="school_type_id")
	public Integer getSchoolTypeId() {
		return schoolTypeId;
	}
	public void setSchoolTypeId(Integer schoolTypeId) {
		this.schoolTypeId = schoolTypeId;
	}
	
	@Column(name="school_type_code")
	public String getSchoolTypeCode() {
		return schoolTypeCode;
	}
	public void setSchoolTypeCode(String schoolTypeCode) {
		this.schoolTypeCode = schoolTypeCode;
	}
	
	@Column(name="school_type_name")
	public String getSchoolTypeName() {
		return schoolTypeName;
	}
	public void setSchoolTypeName(String schoolTypeName) {
		this.schoolTypeName = schoolTypeName;
	}
}

