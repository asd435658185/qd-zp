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
 * @author wdj
 *
 */
@Table(name="main_log")
@Entity
public class MainLogEntity {
	private Integer id;
	private Integer schoolId;
    private Integer userId;
    private String userType;
    private String actionCapTion;
    private Date actionTime;
    @Id
 	@GeneratedValue(strategy=GenerationType.AUTO)
 	@Column(name="id")
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="school_id")
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	@Column(name="user_id")
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Column(name="user_type")
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Column(name="action_capTion")
	public String getActionCapTion() {
		return actionCapTion;
	}
	public void setActionCapTion(String actionCapTion) {
		this.actionCapTion = actionCapTion;
	}
	@Column(name="action_time")
	public Date getActionTime() {
		return actionTime;
	}
	public void setActionTime(Date actionTime) {
		this.actionTime = actionTime;
	}
}
