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
 * @Description 班级课程实体类
 */

@Table(name="class_schedule")
@Entity
public class ClassScheduleEntity {
	 /**
	  * 班级课程id
	  * */
      private Integer id;
      /**
 	  * 班级id
 	  * */
      private Integer classId;
      /**
  	  * 学期id
  	  * */
      private Integer termId;
      
    @Id
   	@GeneratedValue(strategy=GenerationType.AUTO)
   	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
      
      
}
