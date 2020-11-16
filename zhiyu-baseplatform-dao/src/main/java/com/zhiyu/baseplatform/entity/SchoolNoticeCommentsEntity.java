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
 * @Description 学校通知评论实体类
 */

@Table(name="school_notice_comments")
@Entity
public class SchoolNoticeCommentsEntity {
	private Integer id;//学校通知评论id
	private Integer schoolNoticeId;//学校通知id
	private String commentsContent;//学校通知评论内容
	private Date commentsTime;//学校通知评论时间
	private Integer userId;//学校通知评论人
	private Integer type;//学校通知评论人类型   0家长1老师
	
	@Id
 	@GeneratedValue(strategy=GenerationType.AUTO)
 	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="school_notice_id")
	public Integer getSchoolNoticeId() {
		return schoolNoticeId;
	}
	public void setSchoolNoticeId(Integer schoolNoticeId) {
		this.schoolNoticeId = schoolNoticeId;
	}
	
	@Column(name="comments_content")
	public String getCommentsContent() {
		return commentsContent;
	}
	public void setCommentsContent(String commentsContent) {
		this.commentsContent = commentsContent;
	}
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="comments_time")
	public Date getCommentsTime() {
		return commentsTime;
	}
	public void setCommentsTime(Date commentsTime) {
		this.commentsTime = commentsTime;
	}
	
	@Column(name="user_id")
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Column(name="type")
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	
}
