package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IMenuAccessRelDao;
import com.zhiyu.baseplatform.entity.MenuAccessRelEntity;
import com.zhiyu.baseplatform.service.IMenuAccessRelService;

/**
 * 
 * @author csk
 *
 */
@Service
public class MenuAccessRelServiceImpl implements IMenuAccessRelService{
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IMenuAccessRelDao dao;
	
	public List<MenuAccessRelEntity> findByEntity(MenuAccessRelEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			logger.info("查询关联的菜单出异常，异常信息为:{}",e);
		}
		return null;
	}

	public void save(MenuAccessRelEntity entity) {
		dao.save(entity);
	}

	public List<MenuAccessRelEntity> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public void update(MenuAccessRelEntity entity) {
		// TODO Auto-generated method stub
		dao.update(entity);
	}

	public void del(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteObjectByIds(id);
	}

	public List<MenuAccessRelEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		// TODO Auto-generated method stub
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

	public MenuAccessRelEntity saveEntity(MenuAccessRelEntity entity) {
		// TODO Auto-generated method stub
		return dao.merge(entity);
	}

	public MenuAccessRelEntity findObjectById(Integer relId) {
		// TODO Auto-generated method stub
		return dao.findObjectById(relId);
	}

}

