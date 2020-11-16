package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IProvinceDao;
import com.zhiyu.baseplatform.entity.ProvinceEntity;
import com.zhiyu.baseplatform.service.IProvinceService;
/**
 *
 * @author csk
 *
 */
@Service
public class ProvinceServiceImpl implements IProvinceService{

	@Autowired
	private IProvinceDao dao;

	public List<ProvinceEntity> findByEntity(ProvinceEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save(ProvinceEntity entity) {
		dao.save(entity);
	}

	public ProvinceEntity findObjectById(Integer id) {
		ProvinceEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<ProvinceEntity> findAll() {
		return dao.findAll();
	}

	public void update(ProvinceEntity entity) {
		dao.update(entity);
	}

	public void del(Integer ProvinceId) {
		dao.deleteObjectByIds(ProvinceId);
	}

	public List<ProvinceEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

}

