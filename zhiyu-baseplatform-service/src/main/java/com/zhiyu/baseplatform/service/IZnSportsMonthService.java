package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.entity.ZnSportsMonthEntity;

/**
 * 
 * @author csk
 *
 */
public interface IZnSportsMonthService {

	 public ZnSportsMonthEntity findObjectById(Integer id);
		
		public List<ZnSportsMonthEntity> findByEntity(ZnSportsMonthEntity entity);
		
		public List<ZnSportsMonthEntity> findAll();
		
		public void update(ZnSportsMonthEntity entity);
		
		public void save(ZnSportsMonthEntity entity);
		
		public void del(Integer ZnSportsMonthId);
		
		public List<ZnSportsMonthEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
	}
