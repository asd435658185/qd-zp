package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.entity.ClassMvsEntity;

/**
 * 
 * @author csk
 *
 */
public interface IClassMvsService {

	public ClassMvsEntity findObjectById(Integer id);
	
	public List<ClassMvsEntity> findByEntity(ClassMvsEntity entity);
	
	public List<ClassMvsEntity> findAll();
	
	public void update(ClassMvsEntity entity);
	
	public void save(ClassMvsEntity entity);
	
	public void del(Integer ClassImgsId);
	
	public List<ClassMvsEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
}
