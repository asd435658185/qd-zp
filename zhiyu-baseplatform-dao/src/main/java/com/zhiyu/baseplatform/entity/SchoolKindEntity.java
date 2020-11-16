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
 * @Description 学校性质实体类
 */

@Table(name="school_kind")
@Entity
public class SchoolKindEntity {
	private Integer schoolKindId;//	学校性质id
	private String schoolKindCode;//	学校性质编号
	private String schoolKindName;//	学校性质名称
	
	@Id
 	@GeneratedValue(strategy=GenerationType.AUTO)
 	@Column(name="school_kind_id")
	public Integer getSchoolKindId() {
		return schoolKindId;
	}
	public void setSchoolKindId(Integer schoolKindId) {
		this.schoolKindId = schoolKindId;
	}
	
	@Column(name="school_kind_code")
	public String getSchoolKindCode() {
		return schoolKindCode;
	}
	public void setSchoolKindCode(String schoolKindCode) {
		this.schoolKindCode = schoolKindCode;
	}
	
	@Column(name="school_kind_name")
	public String getSchoolKindName() {
		return schoolKindName;
	}
	public void setSchoolKindName(String schoolKindName) {
		this.schoolKindName = schoolKindName;
	}

}
