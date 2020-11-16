package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.ICityDao;
import com.zhiyu.baseplatform.entity.CityEntity;
import com.zhiyu.baseplatform.service.ICityService;

/**
 *
 * @author csk
 *
 */
@Service
public class CityServiceImpl implements ICityService{

	@Autowired
	private ICityDao dao;

	public List<CityEntity> findByEntity(CityEntity entity) {
		return dao.findAll();
	}

	public void save(CityEntity entity) {
		dao.save(entity);
	}

	public CityEntity findObjectById(Integer id) {
		CityEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<CityEntity> findAll() {
		return dao.findAll();
	}

	public void update(CityEntity entity) {
		dao.update(entity);
	}

	public void del(Integer CityId) {
		dao.deleteObjectByIds(CityId);
	}

	public List<CityEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

}
