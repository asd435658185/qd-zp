package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.entity.StudentRfidRecordEntity;

public interface IStudentRfidRecordService {

	public StudentRfidRecordEntity findObjectById(Integer id);
	
	public List<StudentRfidRecordEntity> findByEntity(StudentRfidRecordEntity entity);
	
	public List<StudentRfidRecordEntity> findAll();
	
	public void update(StudentRfidRecordEntity entity);
	
	public void save(StudentRfidRecordEntity entity);
	
	public void del(Integer id);
	
	public List<StudentRfidRecordEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
}
