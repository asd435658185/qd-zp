package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.entity.ClassImgsEntity;

/**
 * 
 * @author csk
 *
 */
public interface IClassImgsService {

	public ClassImgsEntity findObjectById(Integer id);
	
	public List<ClassImgsEntity> findByEntity(ClassImgsEntity entity);
	
	public List<ClassImgsEntity> findAll();
	
	public void update(ClassImgsEntity entity);
	
	public void save(ClassImgsEntity entity);
	
	public void del(Integer ClassImgsId);
	
	public List<ClassImgsEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
}