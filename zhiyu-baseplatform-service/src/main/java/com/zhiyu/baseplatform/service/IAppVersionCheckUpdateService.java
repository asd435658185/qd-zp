package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.entity.AppVersionCheckUpdateEntity;

/**
 * 
 * @author csk
 *
 */
public interface IAppVersionCheckUpdateService {

   public AppVersionCheckUpdateEntity findObjectById(Integer id);
	
	public List<AppVersionCheckUpdateEntity> findByEntity(AppVersionCheckUpdateEntity entity);
	
	public List<AppVersionCheckUpdateEntity> findAll();
	
	public void update(AppVersionCheckUpdateEntity entity);
	
	public void save(AppVersionCheckUpdateEntity entity);
	
	public void del(Integer id);
	
	public List<AppVersionCheckUpdateEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
}