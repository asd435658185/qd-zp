package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;
import com.zhiyu.baseplatform.entity.ProvinceEntity;

/**
 * 
 * @author csk
 *
 */
public interface IProvinceService {

	 public ProvinceEntity findObjectById(Integer id);
		
		public List<ProvinceEntity> findByEntity(ProvinceEntity entity);
		
		public List<ProvinceEntity> findAll();
		
		public void update(ProvinceEntity entity);
		
		public void save(ProvinceEntity entity);
		
		public void del(Integer ProvinceId);
		
		public List<ProvinceEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
	}
