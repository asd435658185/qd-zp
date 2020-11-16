package com.zhiyu.baseplatform.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author csk
 * @Description 班级荣誉实体类
 */

@Table(name = "electronic_card_class_honor_info")
@Entity
public class ClassHonorInfoEntity {
	
	private Integer id;
	private Integer classId;
	
	private String honorImgUrl;
	
	private String honorDec;
	
	private Date addTime;
	
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

	@Column(name="class_id")
	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	@Column(name="honor_img_url")
	public String getHonorImgUrl() {
		return honorImgUrl;
	}

	public void setHonorImgUrl(String honorImgUrl) {
		this.honorImgUrl = honorImgUrl;
	}

	@Column(name="honor_dec")
	public String getHonorDec() {
		return honorDec;
	}

	public void setHonorDec(String honorDec) {
		this.honorDec = honorDec;
	}

	@Column(name="add_time")
	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
	@Column(name="term_id")
	public Integer getTermId() {
		return termId;
	}

	public void setTermId(Integer termId) {
		this.termId = termId;
	}

}
