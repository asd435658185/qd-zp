package com.zhiyu.baseplatform.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author wdj
 * @Description 学期信息实体类
 */

@Table(name="term_base_info")
@Entity
public class TermBaseInfoEntity {
	private Integer id;//	学期id
	private String code;//	学期编号
	private String name;//	学期名称
	private Date beginDate;//	开学时间
	private Date endDate;//	放假时间
	private Date holidayBeginDate;//	假期开始时间
	private Date holidayEndDate;//	假期结束时间
	private Integer state;//	是否当前学期   0不是，1是
	private Integer schoolId;//	所属学校id
	
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
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="begin_date")
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="end_date")
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="holiday_begin_date")
	public Date getHolidayBeginDate() {
		return holidayBeginDate;
	}
	public void setHolidayBeginDate(Date holidayBeginDate) {
		this.holidayBeginDate = holidayBeginDate;
	}
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="holiday_end_date")
	public Date getHolidayEndDate() {
		return holidayEndDate;
	}
	
	public void setHolidayEndDate(Date holidayEndDate) {
		this.holidayEndDate = holidayEndDate;
	}
	@Column(name="state")
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	@Column(name="school_id")
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

}
