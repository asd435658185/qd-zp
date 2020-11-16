package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.entity.GradeLessonPeriodEntity;

public interface IGradeLessonPeriodService {

	public GradeLessonPeriodEntity findObjectById(Integer id);
	
	public List<GradeLessonPeriodEntity> findByEntity(GradeLessonPeriodEntity entity);
	
	public List<GradeLessonPeriodEntity> findAll();
	
	public void update(GradeLessonPeriodEntity entity);
	
	public void save(GradeLessonPeriodEntity entity);
	
	public void del(Integer GradeLessonPeriodId);
	
	public List<GradeLessonPeriodEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
	
	public void saveOrUpdate(GradeLessonPeriodEntity entity);
}
