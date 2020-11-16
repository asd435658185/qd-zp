package com.zhiyu.baseplatform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author wdj
 * @Description 职称实体类
 */

@Table(name="academic_title")
@Entity
public class AcademicTitleEntity {
	
	/**
	 * 职称id
	 * */
	private Integer id;
	/**
	 * 职称编号
	 * */
	private String code;
	/**
	 * 职称名称
	 * */
	private String name;
	/**
	 * 所属学校id
	 * */
	private Integer schoolId;
	/**
	 * 父级职称id
	 * */
	private Integer parentId;
	
	private String parentCode;
	
	private Integer updateType;//更新状态：1、新增；2、更改，3、删除

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

	@Column(name="school_id")
	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	@Column(name="parent_id")
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name="parent_code")
	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	
	@Column(name="update_type")
	public Integer getUpdateType() {
		return updateType;
	}
	public void setUpdateType(Integer updateType) {
		this.updateType = updateType;
	}
}
