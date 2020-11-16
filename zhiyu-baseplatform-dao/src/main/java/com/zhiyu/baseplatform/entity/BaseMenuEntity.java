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
 * @Description 菜单实体类
 */

@Table(name="base_menu")
@Entity
public class BaseMenuEntity {
	/**
	 * 菜单id
	 * */
    private Integer id;
    /**
	 * 菜单父级id
	 * */
    private Integer parentId;
    /**
	 * 菜单编号
	 * */
    private String code;
    /**
   	 * 菜单路径
   	 * */
    private String path;
    /**
   	 * 菜单名称
   	 * */
    private String name;
    /**
   	 * 菜单类型
   	 * */
    private Integer menuType;
    
    private String icon;
    
    private Integer projectType;
    
    private Integer projectChildSys;
    
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="parent_id")
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	@Column(name="code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name="path")
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="menu_type")
	public Integer getMenuType() {
		return menuType;
	}
	public void setMenuType(Integer menuType) {
		this.menuType = menuType;
	}
	
	@Column(name="icon")
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	@Column(name="project_type")
	public Integer getProjectType() {
		return projectType;
	}
	public void setProjectType(Integer projectType) {
		this.projectType = projectType;
	}
	
	@Column(name="project_child_sys")
	public Integer getProjectChildSys() {
		return projectChildSys;
	}
	public void setProjectChildSys(Integer projectChildSys) {
		this.projectChildSys = projectChildSys;
	}
    
	
    
}
