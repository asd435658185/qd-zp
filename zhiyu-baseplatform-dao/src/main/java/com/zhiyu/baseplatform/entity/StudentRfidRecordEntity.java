package com.zhiyu.baseplatform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 学生出入记录
 * @author wdj
 *
 */
@Table(name = "student_rfid_record")
@Entity
public class StudentRfidRecordEntity {
	private Integer id;
	private Integer studentRfidRelId;//	学生校徽关系ID
	private String rfidContent;//	校徽芯片内容
	private String readYmd;//	读取日期（格式：yyyyMMdd）
	private String readTime;//	读取时间（格式：HHMM）
	private String rfidData;//  读取时间（门禁接口原数据）

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "student_rfid_rel_id")
	public Integer getStudentRfidRelId() {
		return studentRfidRelId;
	}
	public void setStudentRfidRelId(Integer student_rfid_rel_id) {
		this.studentRfidRelId = student_rfid_rel_id;
	}
	@Column(name = "rfid_content")
	public String getRfidContent() {
		return rfidContent;
	}
	public void setRfidContent(String rfid_content) {
		this.rfidContent = rfid_content;
	}
	@Column(name = "read_ymd")
	public String getReadYmd() {
		return readYmd;
	}
	public void setReadYmd(String read_ymd) {
		this.readYmd = read_ymd;
	}
	@Column(name = "read_time")
	public String getReadTime() {
		return readTime;
	}
	public void setReadTime(String read_time) {
		this.readTime = read_time;
	}
	@Column(name = "rfid_data")
	public String getRfidData() {
		return rfidData;
	}
	public void setRfidData(String rfidData) {
		this.rfidData = rfidData;
	}
}
