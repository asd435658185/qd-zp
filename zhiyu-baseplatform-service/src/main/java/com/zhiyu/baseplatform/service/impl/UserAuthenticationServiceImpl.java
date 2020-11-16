package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IUserAuthenticationDao;
import com.zhiyu.baseplatform.entity.UserAuthenticationEntity;
import com.zhiyu.baseplatform.service.IUserAuthenticationService;

/**
 *
 * @author csk
 *
 */
@Service
public class UserAuthenticationServiceImpl implements IUserAuthenticationService{

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IUserAuthenticationDao dao;

	/**
	 * 按实体条件查询
	 * @throws Exception
	 */
	public List<UserAuthenticationEntity> findByEntity(UserAuthenticationEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return null;
	}

	public void save(UserAuthenticationEntity entity) {
		dao.save(entity);
	}

	public UserAuthenticationEntity saveEntity(UserAuthenticationEntity entity) {
		return dao.merge(entity);
	}

	public UserAuthenticationEntity findObjectById(String id) {
		UserAuthenticationEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<UserAuthenticationEntity> findAll() {
		return dao.findAll();
	}

	public void update(UserAuthenticationEntity entity) {
		dao.update(entity);
	}

	public void del(String userAuthenticationId) {
		dao.deleteObjectByIds(userAuthenticationId);
	}

	public List<UserAuthenticationEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

	public void saveOrUpdate(UserAuthenticationEntity entity) {
		dao.saveOrUpdate(entity);
	}


}