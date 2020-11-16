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
 * @Description 接收到的推送消息
 */

@Table(name="zn_recv_push_msg")
@Entity
public class ZnRecvPushMsgEntity {

	private Integer id;

	private String deviceId;

	private Date recvDatetime;

	private String recvContent;

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

	@Column(name="recv_datetime")
	public Date getRecvDatetime() {
		return recvDatetime;
	}

	public void setRecvDatetime(Date recvDatetime) {
		this.recvDatetime = recvDatetime;
	}

	@Column(name="recv_content")
	public String getRecvContent() {
		return recvContent;
	}

	public void setRecvContent(String recvContent) {
		this.recvContent = recvContent;
	}
}
