package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.entity.StudentLeaveEntity;

public interface IStudentLeaveService {

	public StudentLeaveEntity findObjectById(Integer id);
	
	public List<StudentLeaveEntity> findByEntity(StudentLeaveEntity entity);
	
	public List<StudentLeaveEntity> findAll();
	
	public void update(StudentLeaveEntity entity);
	
	public void save(StudentLeaveEntity entity);
	
	public void del(Integer id);
	
	public List<StudentLeaveEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
}