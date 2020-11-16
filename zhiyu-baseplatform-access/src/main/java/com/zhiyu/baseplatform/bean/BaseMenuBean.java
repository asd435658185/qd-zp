package com.zhiyu.baseplatform.bean;

import java.util.List;

import com.google.common.collect.Lists;
import com.zhiyu.baseplatform.entity.BaseMenuEntity;

/**
 * 父菜单
 * @author wdj
 *
 */

public class BaseMenuBean {

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
    
    private String icon;
    
    /**
   	 * 菜单类型
   	 * */
    private Integer menuType;
    
    private Integer projectType;
    
    private Integer projectChildSys;
    
    private List<BaseMenuEntity> childs = Lists.newArrayList();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMenuType() {
		return menuType;
	}

	public void setMenuType(Integer menuType) {
		this.menuType = menuType;
	}

	public List<BaseMenuEntity> getChilds() {
		return childs;
	}

	public void setChilds(List<BaseMenuEntity> childs) {
		this.childs = childs;
	}

	public void addChildMenu(BaseMenuEntity menu){
		childs.add(menu);
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getProjectType() {
		return projectType;
	}

	public void setProjectType(Integer projectType) {
		this.projectType = projectType;
	}

	public Integer getProjectChildSys() {
		return projectChildSys;
	}

	public void setProjectChildSys(Integer projectChildSys) {
		this.projectChildSys = projectChildSys;
	}
	
	
}
