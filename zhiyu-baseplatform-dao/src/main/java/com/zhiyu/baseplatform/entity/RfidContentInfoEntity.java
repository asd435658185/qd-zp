package com.zhiyu.baseplatform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 学校电子校徽芯片
 * @author wdj
 *
 */
@Table(name = "rfid_content_info")
@Entity
public class RfidContentInfoEntity {

	private Integer id;
	private Integer schoolId;//	学生ID
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
	@Column(name = "school_id")
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	@Column(name = "rfid_content")
	public String getRfidContent() {
		return rfidContent;
	}
	public void setRfidContent(String rfid_content) {
		this.rfidContent = rfid_content;
	}
}
