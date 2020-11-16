package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.entity.ZnBrandBaseInfoEntity;
/**
 * 
 * @author csk
 *
 */
public interface IZnBrandBaseInfoService {

	 public ZnBrandBaseInfoEntity findObjectById(Integer id);
		
		public List<ZnBrandBaseInfoEntity> findByEntity(ZnBrandBaseInfoEntity entity);
		
		public List<ZnBrandBaseInfoEntity> findAll();
		
		public void update(ZnBrandBaseInfoEntity entity);
		
		public void save(ZnBrandBaseInfoEntity entity);
		
		public void del(Integer ZnBrandBaseInfoId);
		
		public List<ZnBrandBaseInfoEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
	}
