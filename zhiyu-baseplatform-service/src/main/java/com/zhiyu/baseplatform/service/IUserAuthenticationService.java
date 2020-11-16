package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;
import com.zhiyu.baseplatform.entity.UserAuthenticationEntity;
/**
 * 
 * @author csk
 *
 */
public interface IUserAuthenticationService {

	public List<UserAuthenticationEntity> findByEntity(UserAuthenticationEntity entity);
	
	public void save(UserAuthenticationEntity entity);
	
	public UserAuthenticationEntity saveEntity(UserAuthenticationEntity entity);
	
    public UserAuthenticationEntity findObjectById(String id);
	
	public List<UserAuthenticationEntity> findAll();
	
	public void update(UserAuthenticationEntity entity);
	
	
	public void del(String userAuthenticationId);
	
	public List<UserAuthenticationEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
	
	public void saveOrUpdate(UserAuthenticationEntity entity);

}
