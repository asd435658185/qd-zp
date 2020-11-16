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
 * @Description 设备信息
 */

@Table(name="zn_device_base_info")
@Entity
public class ZnDeviceBaseInfoEntity {

	private Integer id;

	private String deviceId;

	private String deviceQrcode;

	private String devicePassword;

	private Integer brandId;

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
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Column(name="device_qrcode")
	public String getDeviceQrcode() {
		return deviceQrcode;
	}
	public void setDeviceQrcode(String deviceQrcode) {
		this.deviceQrcode = deviceQrcode;
	}

	@Column(name="device_password")
	public String getDevicePassword() {
		return devicePassword;
	}
	public void setDevicePassword(String devicePassword) {
		this.devicePassword = devicePassword;
	}

	@Column(name="brand_id")
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}


}
