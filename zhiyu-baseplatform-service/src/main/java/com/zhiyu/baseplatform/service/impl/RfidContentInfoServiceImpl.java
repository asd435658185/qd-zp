package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IRfidContentInfoDao;
import com.zhiyu.baseplatform.entity.RfidContentInfoEntity;
import com.zhiyu.baseplatform.service.IRfidContentInfoService;

@Service
public class RfidContentInfoServiceImpl implements IRfidContentInfoService{

	@Autowired
	private IRfidContentInfoDao dao;

	public RfidContentInfoEntity findObjectById(Integer id) {
		RfidContentInfoEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<RfidContentInfoEntity> findByEntity(RfidContentInfoEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<RfidContentInfoEntity> findAll() {
		return dao.findAll();
	}

	public void update(RfidContentInfoEntity entity) {
		dao.update(entity);
	}

	public void save(RfidContentInfoEntity entity) {
		dao.save(entity);
	}

	public void del(Integer id) {
		dao.deleteObjectByIds(id);
	}

	public List<RfidContentInfoEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

}
