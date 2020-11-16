package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.entity.MainLogEntity;

/**
 * 
 * @author wdj
 *
 */

public interface IMainLogService {

	public MainLogEntity findObjectById(Integer id);
	
	public List<MainLogEntity> findByEntity(MainLogEntity entity);
	
	public List<MainLogEntity> findAll();
	
	public void update(MainLogEntity entity);
	
	public void save(MainLogEntity entity);
	
	public void del(Integer MainLogId);
	
	public List<MainLogEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
	
	public void saveOrUpdate(MainLogEntity entity);
	
	public MainLogEntity merge(MainLogEntity entity);
	
	public List findBySql(String sql);
}
