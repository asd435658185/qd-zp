package com.zhiyu.baseplatform.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 考试计划管理
 * @author wdj
 *
 */

@Table(name="examination_plan_manage")
@Entity
public class ExaminationPlanManageEntity {

	private Integer planId;
	
	private String code;
	
	private String name;
	
	private Integer termId;
	
	private Integer schoolId;
	
	private Integer gradeId;
	
	private Date examDate;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="plan_id")
	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	@Column(name="code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="term_id")
	public Integer getTermId() {
		return termId;
	}

	public void setTermId(Integer termId) {
		this.termId = termId;
	}

	@Column(name="school_id")
	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	@Column(name="grade_id")
	public Integer getGradeId() {
		return gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

	@Column(name="exam_date")
	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	
	
}
