package com.zhiyu.baseplatform.dto;

public class GradeBaseInfoDto {
	/**
	  * 年级id
	  * */
	private Integer id;
	/**
	  * 年级编号
	  * */
	private String code;
	/**
	  * 年级名称
	  * */
	private String name;
	/**
	  * 年级年段长老师id
	  * */
	private Integer masterTeacherId;
	/**
	  * 所在学校id
	  * */
	private Integer schoolId;
	
	private String masterTeacherName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMasterTeacherId() {
		return masterTeacherId;
	}

	public void setMasterTeacherId(Integer masterTeacherId) {
		this.masterTeacherId = masterTeacherId;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public String getMasterTeacherName() {
		return masterTeacherName;
	}

	public void setMasterTeacherName(String masterTeacherName) {
		this.masterTeacherName = masterTeacherName;
	}
	
	
	
}
