package com.zhiyu.baseplatform.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 学生褒奖信息
 * 
 * @author wdj
 *
 */
@Table(name = "electronic_card_student_praise_info")
@Entity
public class StudentPraiseInfoEntity {
	
	private Integer id;
	
	private String praiseDec;
	
	private Integer praiseType;
	
	private Date praiseTime;
	
	private String studentIds;
	
	private Integer termId;
	
	private Integer classId;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "praise_dec")
	public String getPraiseDec() {
		return praiseDec;
	}

	public void setPraiseDec(String praiseDec) {
		this.praiseDec = praiseDec;
	}

	@Column(name = "student_ids")
	public String getStudentIds() {
		return studentIds;
	}
	
	public void setStudentIds(String studentIds) {
		this.studentIds = studentIds;
	}

	@Column(name = "term_id")
	public Integer getTermId() {
		return termId;
	}

	public void setTermId(Integer termId) {
		this.termId = termId;
	}

	@Column(name = "class_id")
	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	@Column(name = "praise_time")
	public Date getPraiseTime() {
		return praiseTime;
	}

	public void setPraiseTime(Date praiseTime) {
		this.praiseTime = praiseTime;
	}
	
	@Column(name = "praise_type")
	public Integer getPraiseType() {
		return praiseType;
	}

	public void setPraiseType(Integer praiseType) {
		this.praiseType = praiseType;
	}
}
