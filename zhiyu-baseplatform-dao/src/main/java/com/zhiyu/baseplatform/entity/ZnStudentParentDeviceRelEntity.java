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
 * @Description 家长学生设备关联
 */

@Table(name="zn_student_parent_device_rel")
@Entity
public class ZnStudentParentDeviceRelEntity {
	
	private Integer id;
	
	private Integer deviceId;
	
	private Integer studentParentRelId;
	
	private Integer mainAccount;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="device_id")
	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}
	
	@Column(name="student_parent_rel_id")
	public Integer getStudentParentRelId() {
		return studentParentRelId;
	}

	public void setStudentParentRelId(Integer studentParentRelId) {
		this.studentParentRelId = studentParentRelId;
	}
	
	@Column(name="main_account")
	public Integer getMainAccount() {
		return mainAccount;
	}

	public void setMainAccount(Integer mainAccount) {
		this.mainAccount = mainAccount;
	}
	
	
}
