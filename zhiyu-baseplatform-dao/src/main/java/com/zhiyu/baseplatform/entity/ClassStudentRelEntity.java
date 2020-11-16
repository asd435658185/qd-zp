package com.zhiyu.baseplatform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author csk
 * @Description 班级学生关联实体类
 */

@Table(name = "class_student_rel")
@Entity
public class ClassStudentRelEntity {
	/**
	 * 关联id
	 */
	private Integer relId;
	/**
	 * 学生id
	 */
	private Integer studentId;
	/**
	 * 班级id
	 */
	private Integer classId;

	private Integer termId;
	
	private Integer updateType;//更新状态：1、新增；2、更改，3、删除

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rel_id")
	public Integer getRelId() {
		return relId;
	}

	public void setRelId(Integer relId) {
		this.relId = relId;
	}

	@Column(name = "student_id")
	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	@Column(name = "class_id")
	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	@Column(name = "term_id")
	public Integer getTermId() {
		return termId;
	}

	public void setTermId(Integer termId) {
		this.termId = termId;
	}


	@Column(name="update_type")
	public Integer getUpdateType() {
		return updateType;
	}
	public void setUpdateType(Integer updateType) {
		this.updateType = updateType;
	}
   
}
