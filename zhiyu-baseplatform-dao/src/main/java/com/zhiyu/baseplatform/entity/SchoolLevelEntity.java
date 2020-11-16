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
 * @Description 学校等级实体类
 */

@Table(name="school_level")
@Entity
public class SchoolLevelEntity {
	private Integer schoolLevelId;//	学校等级id
	private String schoolLevelCode;//	学校等级编号
	private String schoolLevelName;//	学校等级名称
	
	@Id
 	@GeneratedValue(strategy=GenerationType.AUTO)
 	@Column(name="school_level_id")
	public Integer getSchoolLevelId() {
		return schoolLevelId;
	}
	public void setSchoolLevelId(Integer schoolLevelId) {
		this.schoolLevelId = schoolLevelId;
	}
	
	@Column(name="school_level_code")
	public String getSchoolLevelCode() {
		return schoolLevelCode;
	}
	public void setSchoolLevelCode(String schoolLevelCode) {
		this.schoolLevelCode = schoolLevelCode;
	}
	
	@Column(name="school_level_name")
	public String getSchoolLevelName() {
		return schoolLevelName;
	}
	public void setSchoolLevelName(String schoolLevelName) {
		this.schoolLevelName = schoolLevelName;
	}
}
