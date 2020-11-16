package com.zhiyu.baseplatform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 学生请假
 * @author wdj
 *
 */
@Table(name = "student_leave")
@Entity
public class StudentLeaveEntity {
	private Integer id;
	private Integer studentId;//	学生id
	private String leaveYmd;//	请假日期（格式：yyyyMMdd）
	private Integer leavePeriod;//	请假期间（0：上午 1：下午 2：整天）
	private String leaveReason;//	请假理由
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
	@Column(name = "leave_ymd")
	public String getLeaveYmd() {
		return leaveYmd;
	}
	public void setLeaveYmd(String leaveYmd) {
		this.leaveYmd = leaveYmd;
	}
	@Column(name = "leave_period")
	public Integer getLeavePeriod() {
		return leavePeriod;
	}
	public void setLeavePeriod(Integer leavePeriod) {
		this.leavePeriod = leavePeriod;
	}
	@Column(name = "leave_reason")
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

}
