package com.zhiyu.baseplatform.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.zhiyu.baseplatform.enumcode.DataState;

/**
 * 
 * @author wdj
 *
 */

@Table(name="third_party_dock")
@Entity
public class ThirdPartyDockEntity {

	private Long id;
	
	private Integer partyId;
	
	private String enterSchoolId;
	
	private String moralRoleId;
	
	private Date createTime;
	
	private Date updateTime;
	
	private DataState dataState;
	
	private String updateUserName;
	
	private String updateUserPassword;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="enter_school_id")
	public String getEnterSchoolId() {
		return enterSchoolId;
	}

	public void setEnterSchoolId(String enterSchoolId) {
		this.enterSchoolId = enterSchoolId;
	}

	@Column(name="create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name="update_time")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Enumerated
	@Column(name="data_state")
	public DataState getDataState() {
		return dataState;
	}

	public void setDataState(DataState dataState) {
		this.dataState = dataState;
	}

	@Column(name="party_id")
	public Integer getPartyId() {
		return partyId;
	}

	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}
	
	@Column(name="moral_role_id")
	public String getMoralRoleId() {
		return moralRoleId;
	}

	public void setMoralRoleId(String moralRoleId) {
		this.moralRoleId = moralRoleId;
	}

	@Column(name="update_user_name")
	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	@Column(name="update_user_password")
	public String getUpdateUserPassword() {
		return updateUserPassword;
	}

	public void setUpdateUserPassword(String updateUserPassword) {
		this.updateUserPassword = updateUserPassword;
	}

	
}
