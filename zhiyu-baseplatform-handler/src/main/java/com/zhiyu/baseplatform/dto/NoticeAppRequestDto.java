package com.zhiyu.baseplatform.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class NoticeAppRequestDto {
	private Integer id;// 通知id
	private String noticeTitle;// 通知标题
	private String noticeContent;// 通知内容
	private String noticeImg1;// 通知图片1
	private String noticeImg2;// 通知图片2
	private String noticeImg3;// 通知图片3
	private Date noticeTime;// 通知发布时间
	private Integer statue;// 已读未读
	private Integer userId;// 通知发布人id
	private String userName;// 通知发布人
	private Integer pageLimit;// 数量
	private Integer pageNumber;// 页
	private Integer type;// 类型
	private List<CommentsDto> commentsDtoList;
	private List<NoticeLogDto> noticeLogDtoList;
	private Integer parentId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeImg1() {
		return noticeImg1;
	}

	public void setNoticeImg1(String noticeImg1) {
		this.noticeImg1 = noticeImg1;
	}

	public String getNoticeImg2() {
		return noticeImg2;
	}

	public void setNoticeImg2(String noticeImg2) {
		this.noticeImg2 = noticeImg2;
	}

	public String getNoticeImg3() {
		return noticeImg3;
	}

	public void setNoticeImg3(String noticeImg3) {
		this.noticeImg3 = noticeImg3;
	}

	public Date getNoticeTime() {
		return noticeTime;
	}

	public void setNoticeTime(Date noticeTime) {
		this.noticeTime = noticeTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(Integer pageLimit) {
		this.pageLimit = pageLimit;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatue() {
		return statue;
	}

	public void setStatue(Integer statue) {
		this.statue = statue;
	}

	public List<CommentsDto> getCommentsDtoList() {
		return commentsDtoList;
	}

	public void setCommentsDtoList(List<CommentsDto> commentsDto) {
		this.commentsDtoList = commentsDto;
	}

	public List<NoticeLogDto> getNoticeLogDtoList() {
		return noticeLogDtoList;
	}

	public void setNoticeLogDtoList(List<NoticeLogDto> noticeLogDtoList) {
		this.noticeLogDtoList = noticeLogDtoList;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@SuppressWarnings("serial")
	public static class CommentsDto implements Serializable {
		private Integer id;// 通知评论id
		private Integer noticeId;// 通知id
		private String commentsContent;// 通知评论内容
		private Date commentsTime;// 通知评论时间
		private Integer commentsUserId;// 通知评论人
		private Integer commentsUserType;// 通知评论人类型 0家长1老师
		private String commentsUserName;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getNoticeId() {
			return noticeId;
		}

		public void setNoticeId(Integer noticeId) {
			this.noticeId = noticeId;
		}

		public String getCommentsContent() {
			return commentsContent;
		}

		public void setCommentsContent(String commentsContent) {
			this.commentsContent = commentsContent;
		}

		public Date getCommentsTime() {
			return commentsTime;
		}

		public void setCommentsTime(Date commentsTime) {
			this.commentsTime = commentsTime;
		}

		public Integer getCommentsUserId() {
			return commentsUserId;
		}

		public void setCommentsUserId(Integer commentsUserId) {
			this.commentsUserId = commentsUserId;
		}

		public Integer getCommentsUserType() {
			return commentsUserType;
		}

		public void setCommentsUserType(Integer commentsUserType) {
			this.commentsUserType = commentsUserType;
		}

		public String getCommentsUserName() {
			return commentsUserName;
		}

		public void setCommentsUserName(String commentsUserName) {
			this.commentsUserName = commentsUserName;
		}

	}

	@SuppressWarnings("serial")
	public static class NoticeLogDto implements Serializable {
		private Integer id;
		private Integer noticeId;
		private Integer noticeType;// 通知类型：0：学校通知，1：作业通知
		private Integer parentId;
		private Integer teacherId;
		private Integer status;// 通知阅读状态：0：未读，1：已读
		private Integer studentId;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getNoticeId() {
			return noticeId;
		}

		public void setNoticeId(Integer noticeId) {
			this.noticeId = noticeId;
		}

		public Integer getNoticeType() {
			return noticeType;
		}

		public void setNoticeType(Integer noticeType) {
			this.noticeType = noticeType;
		}

		public Integer getParentId() {
			return parentId;
		}

		public void setParentId(Integer parentId) {
			this.parentId = parentId;
		}

		public Integer getTeacherId() {
			return teacherId;
		}

		public void setTeacherId(Integer teacherId) {
			this.teacherId = teacherId;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public Integer getStudentId() {
			return studentId;
		}

		public void setStudentId(Integer studentId) {
			this.studentId = studentId;
		}

	}
}
