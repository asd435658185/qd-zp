package com.zhiyu.baseplatform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 学生校徽关系
 * @author wdj
 *
 */
@Table(name = "student_rfid_rel")
@Entity
public class StudentRfidRelEntity {
	private Integer id;	
	private Integer studentId;//	学生id
	private String rfidContent;//	校徽芯片内容
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
	@Column(name = "rfid_content")
	public String getRfidContent() {
		return rfidContent;
	}
	public void setRfidContent(String rfidContent) {
		this.rfidContent = rfidContent;
	}

}
