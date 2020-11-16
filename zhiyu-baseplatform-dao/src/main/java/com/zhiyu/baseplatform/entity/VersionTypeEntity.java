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
 * @Description 版本类型实体类
 */

@Table(name="version_type")
@Entity
public class VersionTypeEntity {
	private Integer typeId;//	版本类型id
	private String typeCode;//	版本类型编号
	private String typeName;//	版本类型名称
	
	@Id
 	@GeneratedValue(strategy=GenerationType.AUTO)
 	@Column(name="type_id")
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	
	@Column(name="type_code")
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	
	@Column(name="type_name")
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}
