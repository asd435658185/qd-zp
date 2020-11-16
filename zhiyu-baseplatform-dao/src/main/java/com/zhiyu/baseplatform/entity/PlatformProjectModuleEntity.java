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
@Table(name="project_module_rel")
@Entity
public class PlatformProjectModuleEntity {

	private Integer moduleId;//平台下项目id
	
	private Integer projectId;//模块所属项目id
	
	private String name;//模块名称
	
	private Integer value;//模块对应的数值
	
	private DataState state;//数据状态

	private String path;
	
	private String icon;
	 
	private String color;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	
	@Column(name="pid")
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
	
	@Column(name="path")
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Column(name="icon")
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Column(name="color")
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
