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
 * @Description 班级信息实体类
 */

@Table(name="class_base_info")
@Entity
public class ClassBaseInfoEntity {
	/**
	  * 班级id
	  * */
	private Integer id;
	/**
	  * 班级编号
	  * */
	private String code;
	/**
	  * 班级名称
	  * */
	private String name;
	/**
	  * 班级班主任老师id
	  * */
	private Integer masterTeacherId;
	/**
	  * 所在年级id
	  * */
	private Integer gradeId;
	
	private String logoImg;
	
	private String classAddress;
	
	private Integer stuMasterId;
	
	private Integer termId;
	
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
	
	@Column(name="grade_id")
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	
	@Column(name="logo_img")
	public String getLogoImg() {
		return logoImg;
	}
	
	public void setLogoImg(String logoImg) {
		this.logoImg = logoImg;
	}
	
	@Column(name="class_address")
	public String getClassAddress() {
		return classAddress;
	}
	public void setClassAddress(String classAddress) {
		this.classAddress = classAddress;
	}
	
	@Column(name="stu_master_id")
	public Integer getStuMasterId() {
		return stuMasterId;
	}
	public void setStuMasterId(Integer stuMasterId) {
		this.stuMasterId = stuMasterId;
	}
	
	@Column(name="term_id")
	public Integer getTermId() {
		return termId;
	}
	public void setTermId(Integer termId) {
		this.termId = termId;
	}
}
