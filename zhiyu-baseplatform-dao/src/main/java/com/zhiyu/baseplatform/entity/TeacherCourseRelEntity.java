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
 * @Description 班级老师科目关联实体类
 */

@Table(name="teacher_course_rel")
@Entity
public class TeacherCourseRelEntity {
	private Integer relId;//	关联id
	private Integer teacherId;//	老师id
	private Integer courseId;//	科目id
	private Integer classId;//	班级id
	
	@Id
 	@GeneratedValue(strategy=GenerationType.AUTO)
 	@Column(name="rel_id")
	public Integer getRelId() {
		return relId;
	}
	public void setRelId(Integer relId) {
		this.relId = relId;
	}
	
	@Column(name="teacher_id")
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	
	@Column(name="course_id")
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	
	@Column(name="class_id")
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}

}
