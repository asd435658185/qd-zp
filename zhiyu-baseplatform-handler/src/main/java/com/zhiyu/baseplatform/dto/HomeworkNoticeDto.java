package com.zhiyu.baseplatform.dto;

import java.util.Date;

/**
 * 家庭作业通知
 * @author wdj
 *
 */
public class HomeworkNoticeDto {
	private Integer id;// 作业通知id
	private String homeworkNoticeTitle;// 作业通知标题
	private String homeworkNoticeContent;// 作业通知内容
	private String homeworkNoticeImg1;// 作业通知图片
	private String homeworkNoticeImg2;// 作业通知图片
	private String homeworkNoticeImg3;// 作业通知图片
	private Date homeworkNoticeTime;// 作业通知发布时间
	private Integer homeworkNoticeTeacherId;// 作业通知发布人
	private Integer homeworkNoticeClassId;// 班级id
	private String homeworkNoticeTeacherName;
	private String homeworkNoticeClassName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHomeworkNoticeTitle() {
		return homeworkNoticeTitle;
	}

	public void setHomeworkNoticeTitle(String homeworkNoticeTitle) {
		this.homeworkNoticeTitle = homeworkNoticeTitle;
	}

	public String getHomeworkNoticeContent() {
		return homeworkNoticeContent;
	}

	public void setHomeworkNoticeContent(String homeworkNoticeContent) {
		this.homeworkNoticeContent = homeworkNoticeContent;
	}

	public String getHomeworkNoticeImg1() {
		return homeworkNoticeImg1;
	}

	public void setHomeworkNoticeImg1(String homeworkNoticeImg1) {
		this.homeworkNoticeImg1 = homeworkNoticeImg1;
	}

	public String getHomeworkNoticeImg2() {
		return homeworkNoticeImg2;
	}

	public void setHomeworkNoticeImg2(String homeworkNoticeImg2) {
		this.homeworkNoticeImg2 = homeworkNoticeImg2;
	}

	public String getHomeworkNoticeImg3() {
		return homeworkNoticeImg3;
	}

	public void setHomeworkNoticeImg3(String homeworkNoticeImg3) {
		this.homeworkNoticeImg3 = homeworkNoticeImg3;
	}

	public Date getHomeworkNoticeTime() {
		return homeworkNoticeTime;
	}

	public void setHomeworkNoticeTime(Date homeworkNoticeTime) {
		this.homeworkNoticeTime = homeworkNoticeTime;
	}

	public Integer getHomeworkNoticeTeacherId() {
		return homeworkNoticeTeacherId;
	}

	public void setHomeworkNoticeTeacherId(Integer homeworkNoticeTeacherId) {
		this.homeworkNoticeTeacherId = homeworkNoticeTeacherId;
	}

	public Integer getHomeworkNoticeClassId() {
		return homeworkNoticeClassId;
	}

	public void setHomeworkNoticeClassId(Integer homeworkNoticeClassId) {
		this.homeworkNoticeClassId = homeworkNoticeClassId;
	}

	public String getHomeworkNoticeTeacherName() {
		return homeworkNoticeTeacherName;
	}

	public void setHomeworkNoticeTeacherName(String homeworkNoticeTeacherName) {
		this.homeworkNoticeTeacherName = homeworkNoticeTeacherName;
	}

	public String getHomeworkNoticeClassName() {
		return homeworkNoticeClassName;
	}

	public void setHomeworkNoticeClassName(String homeworkNoticeClassName) {
		this.homeworkNoticeClassName = homeworkNoticeClassName;
	}

}
