package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;
import com.zhiyu.baseplatform.entity.MenuAccessRelEntity;

/**
 * 
 * @author csk
 *
 */
public interface IMenuAccessRelService {

	public List<MenuAccessRelEntity> findByEntity(MenuAccessRelEntity entity);
	
	public void save(MenuAccessRelEntity entity);
	
	public List<MenuAccessRelEntity> findAll();
	
	public void update(MenuAccessRelEntity entity);
	
	public void del(Integer id);
	
	public List<MenuAccessRelEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);

	public MenuAccessRelEntity saveEntity(MenuAccessRelEntity entity);

	public MenuAccessRelEntity findObjectById(Integer relId);
}
