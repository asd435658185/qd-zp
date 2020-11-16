package com.zhiyu.baseplatform.processor;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zhiyu.baseplatform.bean.BaseMenuBean;
import com.zhiyu.baseplatform.entity.BaseMenuEntity;
import com.zhiyu.baseplatform.enumcode.MenuType;

/**
 * 基础菜单处理器
 * @author wdj
 *
 */
public class BaseMenuProcessor {

	private List<BaseMenuEntity> entityList;
	
	private List<BaseMenuBean> menuList;
	
	public BaseMenuProcessor(List<BaseMenuEntity> entityList) {
		super();
		clearDeplicateMenu(entityList);
		getParentMenus();
		addChildMenu();
	}

	/**
	 * 去除重复菜单项
	 * @param entityList
	 * @return
	 */
	private void clearDeplicateMenu(List<BaseMenuEntity> entityList){
		
		Map<Integer, BaseMenuEntity> map = Maps.newConcurrentMap();
		for(BaseMenuEntity entity:entityList){
			if(!map.containsKey(entity.getId())){
				map.put(entity.getId(), entity);
			}
		}
		this.entityList = Lists.newArrayList(map.values());
	}
	
	/**
	 * 获取父级菜单
	 * @return
	 */
	private void getParentMenus(){
		menuList = Lists.newArrayList();
		for(BaseMenuEntity menu:entityList){
			if(menu.getMenuType()==MenuType.PARENT.getValue())
			{
				BaseMenuBean bean = new BaseMenuBean();
				BeanUtils.copyProperties(menu, bean);
				menuList.add(bean);
			}
		}
	}

	

	/**
	 * 增加父级下的子菜单
	 */
	private void addChildMenu(){
		for(BaseMenuBean bean:menuList){
			for(BaseMenuEntity menu:entityList){
				if(menu.getMenuType()==MenuType.LEAF.getValue()){
					if(menu.getParentId()==bean.getId()){
						bean.addChildMenu(menu);
					}
				}
			}
		}
	
	}

	public List<BaseMenuBean> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<BaseMenuBean> menuList) {
		this.menuList = menuList;
	}
	
	
}
