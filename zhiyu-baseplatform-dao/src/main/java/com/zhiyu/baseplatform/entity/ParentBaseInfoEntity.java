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
 * @Description 家长信息
 */

@Table(name="parent_base_info")
@Entity
public class ParentBaseInfoEntity {
	
	private Integer id;
	
	private String parentCode;
	
	private String parentName;
	
	private String parentPassword;
	
	private String openId;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="parent_code")
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	
	@Column(name="parent_name")
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
	@Column(name="parent_password")
	public String getParentPassword() {
		return parentPassword;
	}
	public void setParentPassword(String parentPassword) {
		this.parentPassword = parentPassword;
	}
	
	@Column(name="open_id")
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
}
