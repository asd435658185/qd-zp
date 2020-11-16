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
 * @Description 学校通知实体类
 */

@Table(name="school_notice")
@Entity
public class SchoolNoticeEntity {
	private Integer id;//学校通知id
	private Integer schoolId;//学校id
	private String schoolNoticeTitle;//学校通知标题
	private String schoolNoticeContent;//学校通知内容
	private String schoolNoticeImg1;//学校通知图片1
	private String schoolNoticeImg2;//学校通知图片2
	private String schoolNoticeImg3;//学校通知图片3
	private Date schoolNoticeTime;//学校通知发布时间
	
	@Id
 	@GeneratedValue(strategy=GenerationType.AUTO)
 	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="school_id")
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	
	@Column(name="school_notice_title")
	public String getSchoolNoticeTitle() {
		return schoolNoticeTitle;
	}
	public void setSchoolNoticeTitle(String schoolNoticeTitle) {
		this.schoolNoticeTitle = schoolNoticeTitle;
	}
	
	@Column(name="school_notice_content")
	public String getSchoolNoticeContent() {
		return schoolNoticeContent;
	}
	public void setSchoolNoticeContent(String schoolNoticeContent) {
		this.schoolNoticeContent = schoolNoticeContent;
	}
	
	@Column(name="school_notice_img1")
	public String getSchoolNoticeImg1() {
		return schoolNoticeImg1;
	}
	public void setSchoolNoticeImg1(String schoolNoticeImg1) {
		this.schoolNoticeImg1 = schoolNoticeImg1;
	}
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="school_notice_time")
	public Date getSchoolNoticeTime() {
		return schoolNoticeTime;
	}
	public void setSchoolNoticeTime(Date schoolNoticeTime) {
		this.schoolNoticeTime = schoolNoticeTime;
	}
	
	@Column(name="school_notice_img2")
	public String getSchoolNoticeImg2() {
		return schoolNoticeImg2;
	}
	public void setSchoolNoticeImg2(String schoolNoticeImg2) {
		this.schoolNoticeImg2 = schoolNoticeImg2;
	}
	
	@Column(name="school_notice_img3")
	public String getSchoolNoticeImg3() {
		return schoolNoticeImg3;
	}
	public void setSchoolNoticeImg3(String schoolNoticeImg3) {
		this.schoolNoticeImg3 = schoolNoticeImg3;
	}
	
}
