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
 * @Description 课节信息实体类
 */

@Table(name="class_lession_detail")
@Entity
public class ClassLessionDetailEntity {
	/**
	  * 课节信息id
	  * */
    private Integer id;
    /**
	  * 课节信息编号
	  * */
    private Integer code;
    /**
	  * 课节信息名称
	  * */
    private String name;
    /**
	  * 课节信息上课时间
	  * */
    private String beginTime;
    /**
	  * 课节信息下课时间
	  * */
    private String endTime;
    /**
	  * 学期id
	  * */
    private Integer termId;
    /**
	  * 年级id
	  * */
    private Integer gradeId;
    
    @Id
  	@GeneratedValue(strategy=GenerationType.AUTO)
  	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="code")
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="begin_time")
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	
	@Column(name="end_time")
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	@Column(name="term_id")
	public Integer getTermId() {
		return termId;
	}
	public void setTermId(Integer termId) {
		this.termId = termId;
	}
	@Column(name="grade_id")
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
    
    
}
