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
 * @Description app版本更新实体类
 */

@Table(name="app_version_check_update")
@Entity
public class AppVersionCheckUpdateEntity {
	/**
	 * 版本id
	 * */
    private Integer id;
    /**
	 * 版本类型id
	 * */
    private Integer typeId;
    /**
	 * 版本号
	 * */
    private String versionNo;
    /**
	 * 版本更新时间
	 * */
    private Date updateTime;
    /**
	 * 版本路径
	 * */
    private String path;
    /**
	 * 版本大小
	 * */
    private Integer size;
    /**
	 * 版本描述
	 * */
    private String descrs;
    /**
	 * 版本是否强制更新
	 * */
    private Integer isForceUpdateFlag;
    
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="type_id")
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	
	@Column(name="version_no")
	public String getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}
	
	@Column(name="update_time")
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	@Column(name="path")
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	@Column(name="size")
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	
	@Column(name="descrs")
	public String getDescrs() {
		return descrs;
	}
	public void setDescrs(String descrs) {
		this.descrs = descrs;
	}
	
	@Column(name="is_force_update_flag")
	public Integer getIsForceUpdateFlag() {
		return isForceUpdateFlag;
	}
	public void setIsForceUpdateFlag(Integer isForceUpdateFlag) {
		this.isForceUpdateFlag = isForceUpdateFlag;
	}
    
    
}
