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
 * @Description 年级信息实体类
 */

@Table(name="grade_base_info")
@Entity
public class GradeBaseInfoEntity {
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
	
	
	@Id
 	@GeneratedValue(strategy=GenerationType.AUTO)
 	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="master_teacher_id")
	public Integer getMasterTeacherId() {
		return masterTeacherId;
	}
	public void setMasterTeacherId(Integer masterTeacherId) {
		this.masterTeacherId = masterTeacherId;
	}
	@Column(name="school_id")
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

}
