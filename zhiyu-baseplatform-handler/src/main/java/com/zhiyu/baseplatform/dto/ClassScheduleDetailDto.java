package com.zhiyu.baseplatform.dto;

public class ClassScheduleDetailDto {
	/**
	 * 课程明细id
	 */
	private Integer id;
	/**
	 * 任科老师id
	 */
	private Integer teacherId;
	/**
	 * 科目id
	 */
	private Integer courseId;
	/**
	 * 周几
	 */
	private Integer dayIndex;
	/**
	 * 课节id
	 */
	private Integer lessionId;
	/**
	 * 课程主表id
	 */
	private Integer scheduleId;

	private String lessionName;

	private String teacherName;
	
	private String teacherTel;

	private String courseName;

	private String dayName;

	
	/**
	 * 课节信息上课时间
	 */
	private String beginTime;
	/**
	 * 课节信息下课时间
	 */
	private String endTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getDayIndex() {
		return dayIndex;
	}

	public void setDayIndex(Integer dayIndex) {
		this.dayIndex = dayIndex;
	}

	public Integer getLessionId() {
		return lessionId;
	}

	public void setLessionId(Integer lessionId) {
		this.lessionId = lessionId;
	}

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getLessionName() {
		return lessionName;
	}

	public void setLessionName(String lessionName) {
		this.lessionName = lessionName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDayName() {
		return dayName;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getTeacherTel() {
		return teacherTel;
	}

	public void setTeacherTel(String teacherTel) {
		this.teacherTel = teacherTel;
	}

}
