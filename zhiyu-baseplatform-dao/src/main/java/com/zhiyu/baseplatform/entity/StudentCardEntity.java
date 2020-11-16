package com.zhiyu.baseplatform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author wdj
 *
 */
@Table(name = "student_card_info")
@Entity
public class StudentCardEntity {
	private Integer id;
	private Integer studentId;
	private String studentCard;
	private Integer schoolId;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@Column(name = "student_card")
	public String getStudentCard() {
		return studentCard;
	}

	public void setStudentCard(String studentCard) {
		this.studentCard = studentCard;
	}

	@Column(name = "school_id")
	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

}
