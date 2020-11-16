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
 * @Description 健康提醒
 */

@Table(name="zn_health_alert")
@Entity
public class ZnHealthAlertEntity {

	private Integer id;
	private Integer deviceId;
	private String alertDay;
	private String alertHour;
	private String alertMin;
	private String content;
	private Integer openFlg;

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
	@Column(name="alert_day")
	public String getAlertDay() {
		return alertDay;
	}
	@Column(name="alert_hour")
	public String getAlertHour() {
		return alertHour;
	}
	@Column(name="alert_min")
	public String getAlertMin() {
		return alertMin;
	}
	@Column(name="content")
	public String getContent() {
		return content;
	}
	@Column(name="open_flg")
	public Integer getOpenFlg() {
		return openFlg;
	}
	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}
	public void setAlertDay(String alertDay) {
		this.alertDay = alertDay;
	}
	public void setAlertHour(String alertHour) {
		this.alertHour = alertHour;
	}
	public void setAlertMin(String alertMin) {
		this.alertMin = alertMin;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setOpenFlg(Integer openFlg) {
		this.openFlg = openFlg;
	}
}
