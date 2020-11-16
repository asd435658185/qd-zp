package com.zhiyu.baseplatform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.zhiyu.baseplatform.enumcode.UsageState;


/**
 * 电子班牌信息表
 * @author wdj
 *
 */

@Table(name="electronic_card_info")
@Entity
public class EcardInfoEntity {

	private String deviceId;
	
	private String remark;
	
	private Integer classId;
	
	private String deviceName;
	
	private UsageState state;

	@Id
	@Column(name="device_id")
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Column(name="remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name="class_id")
	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	@Column(name="device_name")
	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	@Enumerated
	@Column(name="state")
	public UsageState getState() {
		return state;
	}

	public void setState(UsageState state) {
		this.state = state;
	}
	
	
}
