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
 * @Description 班级老师关联实体类
 */

@Table(name="class_teacher_rel")
@Entity
public class ClassTeacherRelEntity {
   /**
   * 关联id
   * */
   private Integer relId;
   /**
    * 老师id
    * */
   private Integer teacherId;
   /**
    * 班级id
    * */
   private Integer classId;
   
   private Integer termId;
   
   private Integer curfocus;
   
   private Integer updateType;
   
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
	
	@Column(name="class_id")
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	
	@Column(name="term_id")
	public Integer getTermId() {
		return termId;
	}
	public void setTermId(Integer termId) {
		this.termId = termId;
	}
	
	@Column(name="curfocus")
	public Integer getCurfocus() {
		return curfocus;
	}
	public void setCurfocus(Integer curfocus) {
		this.curfocus = curfocus;
	}
   
	@Column(name="update_type")
	public Integer getUpdateType() {
		return updateType;
	}
	public void setUpdateType(Integer updateType) {
		this.updateType = updateType;
	}
   
}
