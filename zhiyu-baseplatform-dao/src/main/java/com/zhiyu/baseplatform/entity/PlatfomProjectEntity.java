package com.zhiyu.baseplatform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="platform_project_main")
@Entity
public class PlatfomProjectEntity {

	private Integer projectId;//平台下项目id
	
	private String name;//项目名称
	
	private Integer value;//项目对应的数值
	
	private DataState state;//数据状态

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="value")
	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Column(name="state")
	public DataState getState() {
		return state;
	}

	public void setState(DataState state) {
		this.state = state;
	}
	
	
}
