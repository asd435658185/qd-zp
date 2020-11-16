package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IBaseMenuDao;
import com.zhiyu.baseplatform.entity.BaseMenuEntity;
import com.zhiyu.baseplatform.service.IBaseMenuService;

/**
 *
 * @author csk
 *
 */
@Service
public class BaseMenuServiceImpl implements IBaseMenuService{

	@Autowired
	private IBaseMenuDao dao;

	public List<BaseMenuEntity> findListByConditionMap(Map<String, Object> fieldAndValueMap, Map<String, String> sortMap) {
		return dao.findListByConditionMap(fieldAndValueMap, sortMap);
	}

	public void save(BaseMenuEntity entity) {
		dao.save(entity);
	}

	public BaseMenuEntity findById(Integer id) {
		BaseMenuEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<BaseMenuEntity> findByEntity(BaseMenuEntity entity) {
		// TODO Auto-generated method stub
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<BaseMenuEntity> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public void update(BaseMenuEntity entity) {
		// TODO Auto-generated method stub
		dao.update(entity);
	}

	public void del(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteObjectByIds(id);
	}

	public BaseMenuEntity merge(BaseMenuEntity entity) {
		// TODO Auto-generated method stub
		return dao.merge(entity);
	}

}
