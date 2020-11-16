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
 * @Description 权限访问实体类
 */

@Table(name="access_base_info")
@Entity
public class AccessBaseInfoEntity {
	/**
	 * 权限访问id
	 * */
	private Integer id;
	/**
	 * 权限访问编号
	 * */
	private String code;
	/**
	 * 权限访问名称
	 * */
	private String name;
	
	private Integer privilidge;//权限优先级
	
	private Integer isSchoolAccess;//是否为学校角色权限（0:不是 1：是）
	
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

	@Column(name="privilidge")
	public Integer getPrivilidge() {
		return privilidge;
	}

	public void setPrivilidge(Integer privilidge) {
		this.privilidge = privilidge;
	}
	
	@Column(name="is_school_access")
	public Integer getIsSchoolAccess() {
		return isSchoolAccess;
	}

	public void setIsSchoolAccess(Integer isSchoolAccess) {
		this.isSchoolAccess = isSchoolAccess;
	}
	
	
}
