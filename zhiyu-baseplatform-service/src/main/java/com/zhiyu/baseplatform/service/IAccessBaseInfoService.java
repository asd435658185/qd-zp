package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;
import com.zhiyu.baseplatform.entity.AccessBaseInfoEntity;

/**
 * 
 * @author csk
 *
 */
public interface IAccessBaseInfoService {
	
public AccessBaseInfoEntity findObjectById(Integer id);
	
	public List<AccessBaseInfoEntity> findByEntity(AccessBaseInfoEntity entity);
	
	public List<AccessBaseInfoEntity> findAll();
	
	public void update(AccessBaseInfoEntity entity);
	
	public void save(AccessBaseInfoEntity entity);
	
	public void del(Integer AccessBaseInfoId);
	
	public List<AccessBaseInfoEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);

	public AccessBaseInfoEntity saveEntity(AccessBaseInfoEntity entity);
}
