package com.zhiyu.baseplatform.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author csk
 * @Description 日期信息实体类
 */

@Table(name="day_base_info")
@Entity
public class DayBaseInfoEntity {
	 /**
	  *日期id 
	  * */
	 private Integer id;
	 /**
	  *日期名称（星期几） 
	  * */
	 private String name;
	 /**
	  *日期时间 （2016-11-10）
	  * */
	 private Date dayDate;
	 /**
	  *所属周id 
	  * */
	 private Integer weekId;
	 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="day_date")
	public Date getDayDate() {
		return dayDate;
	}
	public void setDayDate(Date dayDate) {
		this.dayDate = dayDate;
	}
	
	@Column(name="week_id")
	public Integer getWeekId() {
		return weekId;
	}
	public void setWeekId(Integer weekId) {
		this.weekId = weekId;
	}

}
