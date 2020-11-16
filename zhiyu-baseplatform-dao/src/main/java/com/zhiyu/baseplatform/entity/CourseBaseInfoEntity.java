package com.zhiyu.baseplatform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.zhiyu.baseplatform.enumcode.DataState;

/**
 * 
 * @author csk
 * @Description 科目信息实体类
 */

@Table(name="course_base_info")
@Entity
public class CourseBaseInfoEntity {
	/**
	    * 科目id
	    * */
  private Integer id;
  /**
   * 科目编号
   * */
  private String code;
  /**
   * 科目名称
   * */
  private String name;
  /**
   * 所属学校id
   * */
  private Integer schoolId;
  
  private Integer state = DataState.NORMAL.getValue();
  
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
	
	@Column(name="school_id")
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	
	@Column(name="state")
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
  
  
}
