package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;
import com.zhiyu.baseplatform.entity.ClassScheduleDetailEntity;

/**
 * 
 * @author csk
 *
 */
public interface IClassScheduleDetailService {

	public ClassScheduleDetailEntity findObjectById(Integer id);
	
	public List<ClassScheduleDetailEntity> findByEntity(ClassScheduleDetailEntity entity);
	
	public List<ClassScheduleDetailEntity> findAll();
	
	public void update(ClassScheduleDetailEntity entity);
	
	public void save(ClassScheduleDetailEntity entity);
	
	public void del(Integer ClassScheduleDetailId);
	
	public List<ClassScheduleDetailEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
}