package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;
import com.zhiyu.baseplatform.entity.ClassScheduleEntity;

/**
 * 
 * @author csk
 *
 */
public interface IClassScheduleService {

	public ClassScheduleEntity findObjectById(Integer id);
	
	public List<ClassScheduleEntity> findByEntity(ClassScheduleEntity entity);
	
	public List<ClassScheduleEntity> findAll();
	
	public void update(ClassScheduleEntity entity);
	
	public void save(ClassScheduleEntity entity);
	
	public void del(Integer classScheduleId);
	
	public List<ClassScheduleEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
}
