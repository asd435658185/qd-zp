package com.zhiyu.baseplatform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 学生考勤
 * @author wdj
 *
 */
@Table(name = "student_attend")
@Entity
public class StudentAttendEntity {
	private Integer id;
	private Integer studentId;//	学生id
	private String attendYmd;//	考勤日（格式：yyyyMMdd）
	private String startStatus1;
	private String startTime1;
	private String endStatus1;
	private String endTime1;
	private String startStatus2;
	private String startTime2;
	private String endStatus2;
	private String endTime2;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "student_id")
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	@Column(name = "attend_ymd")
	public String getAttendYmd() {
		return attendYmd;
	}
	public void setAttendYmd(String attendYmd) {
		this.attendYmd = attendYmd;
	}
	@Column(name = "start_status_1")
	public String getStartStatus1() {
		return startStatus1;
	}
	public void setStartStatus1(String startStatus1) {
		this.startStatus1 = startStatus1;
	}
	@Column(name = "start_time_1")
	public String getStartTime1() {
		return startTime1;
	}
	public void setStartTime1(String startTime1) {
		this.startTime1 = startTime1;
	}
	@Column(name = "end_status_1")
	public String getEndStatus1() {
		return endStatus1;
	}
	public void setEndStatus1(String endStatus1) {
		this.endStatus1 = endStatus1;
	}
	@Column(name = "end_time_1")
	public String getEndTime1() {
		return endTime1;
	}
	public void setEndTime1(String endTime1) {
		this.endTime1 = endTime1;
	}
	@Column(name = "start_status_2")
	public String getStartStatus2() {
		return startStatus2;
	}
	public void setStartStatus2(String startStatus2) {
		this.startStatus2 = startStatus2;
	}
	@Column(name = "start_time_2")
	public String getStartTime2() {
		return startTime2;
	}
	public void setStartTime2(String startTime2) {
		this.startTime2 = startTime2;
	}
	@Column(name = "end_status_2")
	public String getEndStatus2() {
		return endStatus2;
	}
	public void setEndStatus2(String endStatus2) {
		this.endStatus2 = endStatus2;
	}
	@Column(name = "end_time_2")
	public String getEndTime2() {
		return endTime2;
	}
	public void setEndTime2(String endTime2) {
		this.endTime2 = endTime2;
	}

}
