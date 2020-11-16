package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.entity.StudentRfidRelEntity;

public interface IStudentRfidRelService {
	public StudentRfidRelEntity findObjectById(Integer id);
	
	public List<StudentRfidRelEntity> findByEntity(StudentRfidRelEntity entity);
	
	public List<StudentRfidRelEntity> findAll();
	
	public void update(StudentRfidRelEntity entity);
	
	public void save(StudentRfidRelEntity entity);
	
	public void del(Integer id);
	
	public List<StudentRfidRelEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
}
