package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.entity.StudentPraiseInfoEntity;

public interface IStudentPraiseInfoService {
	  
	    public StudentPraiseInfoEntity findObjectById(Integer id);
		
		public List<StudentPraiseInfoEntity> findByEntity(StudentPraiseInfoEntity entity);
		
		public List<StudentPraiseInfoEntity> findAll();
		
		public void update(StudentPraiseInfoEntity entity);
		
		public void save(StudentPraiseInfoEntity entity);
		
		public void del(Integer id);
		
		public List<StudentPraiseInfoEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
	}

