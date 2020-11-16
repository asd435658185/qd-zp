package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.entity.ZnSportsDayEntity;
/**
 * 
 * @author csk
 *
 */
public interface IZnSportsDayService {

	 public ZnSportsDayEntity findObjectById(Integer id);
		
		public List<ZnSportsDayEntity> findByEntity(ZnSportsDayEntity entity);
		
		public List<ZnSportsDayEntity> findAll();
		
		public void update(ZnSportsDayEntity entity);
		
		public void save(ZnSportsDayEntity entity);
		
		public void del(Integer ZnSportsDayId);
		
		public List<ZnSportsDayEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
	}
