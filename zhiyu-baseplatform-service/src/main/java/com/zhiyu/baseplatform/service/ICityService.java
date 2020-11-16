package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;
import com.zhiyu.baseplatform.entity.CityEntity;

/**
 * 
 * @author csk
 *
 */
public interface ICityService {

public CityEntity findObjectById(Integer id);
	
	public List<CityEntity> findByEntity(CityEntity entity);
	
	public List<CityEntity> findAll();
	
	public void update(CityEntity entity);
	
	public void save(CityEntity entity);
	
	public void del(Integer CityId);
	
	public List<CityEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
}
