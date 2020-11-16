package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhiyu.baseplatform.dao.IAccessBaseInfoDao;
import com.zhiyu.baseplatform.entity.AccessBaseInfoEntity;
import com.zhiyu.baseplatform.service.IAccessBaseInfoService;

/**
 *
 * @author csk
 *
 */
@Service
public class AccessBaseInfoServiceImpl implements IAccessBaseInfoService{

	@Autowired
	private IAccessBaseInfoDao dao;

	public List<AccessBaseInfoEntity> findByEntity(AccessBaseInfoEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save(AccessBaseInfoEntity entity) {
		dao.save(entity);
	}

	public AccessBaseInfoEntity findObjectById(Integer id) {
		AccessBaseInfoEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<AccessBaseInfoEntity> findAll() {
		return dao.findAll();
	}

	public void update(AccessBaseInfoEntity entity) {
		dao.update(entity);
	}

	public void del(Integer accessBaseInfoId) {
		dao.deleteObjectByIds(accessBaseInfoId);
	}

	public List<AccessBaseInfoEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

	public AccessBaseInfoEntity saveEntity(AccessBaseInfoEntity entity) {
		return dao.merge(entity);
	}

}
