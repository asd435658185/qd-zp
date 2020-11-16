package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;
import com.zhiyu.baseplatform.entity.UserAccessEntity;

/**
 * 
 * @author csk
 *
 */
public interface IUserAccessService {

public UserAccessEntity findObjectById(Integer id);
	
	public List<UserAccessEntity> findByEntity(UserAccessEntity entity);
	
	public List<UserAccessEntity> findAll();
	
	public void update(UserAccessEntity entity);
	
	public void save(UserAccessEntity entity);
	
	public void del(Integer UserAccessId);
	
	public List<UserAccessEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);

	public UserAccessEntity saveEntity(UserAccessEntity entity);
}
