package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;
import com.zhiyu.baseplatform.entity.ParentBaseInfoEntity;

/**
 * 
 * @author csk
 *
 */
public interface IParentBaseInfoService {

		public ParentBaseInfoEntity findObjectById(Integer id);
		
		public List<ParentBaseInfoEntity> findByEntity(ParentBaseInfoEntity entity);
		
		public List<ParentBaseInfoEntity> findAll();
		
		public void update(ParentBaseInfoEntity entity);
		
		public void save(ParentBaseInfoEntity entity);
		
		public void del(Integer ParentBaseInfoId);
		
		public List<ParentBaseInfoEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
		
		public ParentBaseInfoEntity merge(ParentBaseInfoEntity entity);
	}
