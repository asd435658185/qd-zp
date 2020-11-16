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
 * @Description 作业通知实体类
 */

@Table(name="homework_notice")
@Entity
public class HomeworkNoticeEntity {
	private Integer id;//作业通知id
	private String homeworkNoticeTitle;//作业通知标题
	private String homeworkNoticeContent;//作业通知内容
	private String homeworkNoticeImg1;//作业通知图片
	private String homeworkNoticeImg2;//作业通知图片
	private String homeworkNoticeImg3;//作业通知图片
	private Date homeworkNoticeTime;//作业通知发布时间
	private Integer homeworkNoticeTeacherId;//作业通知发布人
	private Integer homeworkNoticeClassId;//班级id
	
	@Id
 	@GeneratedValue(strategy=GenerationType.AUTO)
 	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="homework_notice_title")
	public String getHomeworkNoticeTitle() {
		return homeworkNoticeTitle;
	}
	public void setHomeworkNoticeTitle(String homeworkNoticeTitle) {
		this.homeworkNoticeTitle = homeworkNoticeTitle;
	}
	
	@Column(name="homework_notice_content")
	public String getHomeworkNoticeContent() {
		return homeworkNoticeContent;
	}
	public void setHomeworkNoticeContent(String homeworkNoticeContent) {
		this.homeworkNoticeContent = homeworkNoticeContent;
	}
	
	@Column(name="homework_notice_img1")
	public String getHomeworkNoticeImg1() {
		return homeworkNoticeImg1;
	}
	public void setHomeworkNoticeImg1(String homeworkNoticeImg1) {
		this.homeworkNoticeImg1 = homeworkNoticeImg1;
	}
	
	@Column(name="homework_notice_img2")
	public String getHomeworkNoticeImg2() {
		return homeworkNoticeImg2;
	}
	public void setHomeworkNoticeImg2(String homeworkNoticeImg2) {
		this.homeworkNoticeImg2 = homeworkNoticeImg2;
	}
	
	@Column(name="homework_notice_img3")
	public String getHomeworkNoticeImg3() {
		return homeworkNoticeImg3;
	}
	public void setHomeworkNoticeImg3(String homeworkNoticeImg3) {
		this.homeworkNoticeImg3 = homeworkNoticeImg3;
	}
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="homework_notice_time")
	public Date getHomeworkNoticeTime() {
		return homeworkNoticeTime;
	}
	public void setHomeworkNoticeTime(Date homeworkNoticeTime) {
		this.homeworkNoticeTime = homeworkNoticeTime;
	}
	
	@Column(name="homework_notice_teacher_id")
	public Integer getHomeworkNoticeTeacherId() {
		return homeworkNoticeTeacherId;
	}
	public void setHomeworkNoticeTeacherId(Integer homeworkNoticeTeacherId) {
		this.homeworkNoticeTeacherId = homeworkNoticeTeacherId;
	}
	
	@Column(name="homework_notice_class_id")
	public Integer getHomeworkNoticeClassId() {
		return homeworkNoticeClassId;
	}
	public void setHomeworkNoticeClassId(Integer homeworkNoticeClassId) {
		this.homeworkNoticeClassId = homeworkNoticeClassId;
	}
	
	
}
