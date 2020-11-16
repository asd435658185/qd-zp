package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;
import com.zhiyu.baseplatform.entity.WeekBaseInfoEntity;

/**
 * 
 * @author csk
 *
 */
public interface IWeekBaseInfoService {


	public WeekBaseInfoEntity findObjectById(Integer id);
	
	public List<WeekBaseInfoEntity> findByEntity(WeekBaseInfoEntity entity);
	
	public List<WeekBaseInfoEntity> findAll();
	
	public void update(WeekBaseInfoEntity entity);
	
	public void save(WeekBaseInfoEntity entity);
	
	public void del(Integer WeekBaseInfoId);
	
	public List<WeekBaseInfoEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
}