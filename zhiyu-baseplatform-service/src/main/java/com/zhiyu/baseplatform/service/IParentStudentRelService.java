package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.entity.ParentStudentRelEntity;

/**
 * 
 * @author csk
 *
 */
public interface IParentStudentRelService {

	 public ParentStudentRelEntity findObjectById(Integer id);
		
		public List<ParentStudentRelEntity> findByEntity(ParentStudentRelEntity entity);
		
		public List<ParentStudentRelEntity> findAll();
		
		public void update(ParentStudentRelEntity entity);
		
		public void save(ParentStudentRelEntity entity);
		
		public void del(Integer ParentStudentRelId);
		
		public List<ParentStudentRelEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
	}

