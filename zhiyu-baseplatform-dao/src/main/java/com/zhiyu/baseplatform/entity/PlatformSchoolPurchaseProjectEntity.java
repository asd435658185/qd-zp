package com.zhiyu.baseplatform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.zhiyu.baseplatform.enumcode.DataState;

/**
 * 知育信息化管理系统学校购买的管理模块（德育积分、四项评比、德育风采、德育电台等）
 * @author wdj
 *
 */
@Table(name="school_purchase_project")
@Entity
public class PlatformSchoolPurchaseProjectEntity {

	private Integer id;
	
	private Integer schoolId;
	
	private Integer projectId;
	
	private Integer moduleId;
	
	private DataState state;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="schoolId")
	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	@Column(name="projectId")
	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@Column(name="moduleId")
	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	@Column(name="state")
	public DataState getState() {
		return state;
	}

	public void setState(DataState state) {
		this.state = state;
	}
	
	
}
