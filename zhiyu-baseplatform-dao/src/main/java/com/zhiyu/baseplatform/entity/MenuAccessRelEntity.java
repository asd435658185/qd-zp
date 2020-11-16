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
 * @Description 菜单权限关联实体类
 */

@Table(name="menu_access_rel")
@Entity
public class MenuAccessRelEntity {
	/**
	  * 关联id
	  * */
	private Integer relId;
	/**
	  * 菜单id
	  * */
	private Integer menuId;
	/**
	  * 权限id
	  * */
	private Integer accessId;
	
	@Id
 	@GeneratedValue(strategy=GenerationType.AUTO)
 	@Column(name="rel_id")
	public Integer getRelId() {
		return relId;
	}
	public void setRelId(Integer relId) {
		this.relId = relId;
	}
	
	@Column(name="menu_id")
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	
	@Column(name="access_id")
	public Integer getAccessId() {
		return accessId;
	}
	public void setAccessId(Integer accessId) {
		this.accessId = accessId;
	}
	
	
	
}
