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
 * @Description 班级视频实体类
 */

@Table(name="class_mvs")
@Entity
public class ClassMvsEntity {
	private Integer id;
	private Integer termId;
	private Integer classId;
	private String classMv;
	
	@Id
  	@GeneratedValue(strategy=GenerationType.AUTO)
  	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="term_id")
	public Integer getTermId() {
		return termId;
	}
	public void setTermId(Integer termId) {
		this.termId = termId;
	}
	
	@Column(name="class_id")
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	
	@Column(name="class_mv")
	public String getClassMv() {
		return classMv;
	}
	public void setClassMv(String classMv) {
		this.classMv = classMv;
	}
	
}
