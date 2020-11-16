package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;
import com.zhiyu.baseplatform.entity.DistrictionEntity;

/**
 * 
 * @author csk
 *
 */
public interface IDistrictionService {
	
	 public DistrictionEntity findObjectById(Integer id);

	public List<DistrictionEntity> findByEntity(DistrictionEntity entity);
	
	public List<DistrictionEntity> findAll();
	
	public void update(DistrictionEntity entity);
	
	public void save(DistrictionEntity entity);
	
	public void del(Integer DistrictionId);
	
	public List<DistrictionEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
}
