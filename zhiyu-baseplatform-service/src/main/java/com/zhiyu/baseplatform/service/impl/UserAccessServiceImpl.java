package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IUserAccessDao;
import com.zhiyu.baseplatform.entity.UserAccessEntity;
import com.zhiyu.baseplatform.service.IUserAccessService;
/**
 *
 * @author csk
 *
 */
@Service
public class UserAccessServiceImpl implements IUserAccessService{

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IUserAccessDao dao;

	public List<UserAccessEntity> findByEntity(UserAccessEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			logger.info("查询用户权限列表出异常，异常信息为:{}", e);
		}
		return null;
	}

	public void save(UserAccessEntity entity) {
		dao.save(entity);
	}

	public UserAccessEntity findObjectById(Integer id) {
		UserAccessEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<UserAccessEntity> findAll() {
		return dao.findAll();
	}

	public void update(UserAccessEntity entity) {
		dao.update(entity);
	}

	public void del(Integer userAccessId) {
		dao.deleteObjectByIds(userAccessId);
	}

	public List<UserAccessEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

	public UserAccessEntity saveEntity(UserAccessEntity entity) {
		return dao.merge(entity);
	}

}