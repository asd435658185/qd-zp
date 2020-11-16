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
 * @Description 作业通知评论实体类
 */

@Table(name="homework_notice_comments")
@Entity
public class HomeworkNoticeCommentsEntity {
	private Integer id;//作业通知评论id
	private Integer homeworkNoticeId;//作业通知id
	private String commentsContent;//作业通知评论内容
	private Date commentsTime;//作业通知评论时间
	private Integer parentId;//作业通知评论人
	
	@Id
 	@GeneratedValue(strategy=GenerationType.AUTO)
 	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="homework_notice_id")
	public Integer getHomeworkNoticeId() {
		return homeworkNoticeId;
	}
	public void setHomeworkNoticeId(Integer homeworkNoticeId) {
		this.homeworkNoticeId = homeworkNoticeId;
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
	
	@Column(name="parent_id")
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	
}
