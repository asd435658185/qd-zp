package com.zhiyu.baseplatform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.zhiyu.baseplatform.enumcode.IdentifyCodeGenerateType;

/**
 * 系统识别码生成实体
 * @author wdj
 *
 */

@Table(name="sys_identify_code_generator")
@Entity
public class SysIdentifyCodeGenerateEntity {

	private String com;
	
	private String project;
	
	private String funName;
	
	private String id;
	
	private String helpId;
	
	private IdentifyCodeGenerateType type;

	@Column(name="com_sign")
	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}

	@Column(name="project_sign")
	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	@Column(name="fun_name")
	public String getFunName() {
		return funName;
	}

	public void setFunName(String funName) {
		this.funName = funName;
	}

	@Id
	@Column(name="id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name="help_id")
	public String getHelpId() {
		return helpId;
	}

	public void setHelpId(String helpId) {
		this.helpId = helpId;
	}

	@Enumerated
	@Column(name="type")
	public IdentifyCodeGenerateType getType() {
		return type;
	}

	public void setType(IdentifyCodeGenerateType type) {
		this.type = type;
	}
	
	
}
