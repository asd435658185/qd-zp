package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IClassBaseInfoDao;
import com.zhiyu.baseplatform.entity.ClassBaseInfoEntity;
import com.zhiyu.baseplatform.service.IClassBaseInfoService;

/**
 *
 * @author csk
 *
 */
@Service
public class ClassBaseInfoServiceImpl implements IClassBaseInfoService{

	@Autowired
	private IClassBaseInfoDao dao;

	public List<ClassBaseInfoEntity> findByEntity(ClassBaseInfoEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save(ClassBaseInfoEntity entity) {
		dao.save(entity);
	}

	public ClassBaseInfoEntity findObjectById(Integer id) {
		ClassBaseInfoEntity entity = dao.findObjectById(id);
		if(entity!=null){
//			dao.evict(entity);
		}
		return entity;
	}

	public List<ClassBaseInfoEntity> findAll() {
		return dao.findAll();
	}

	public void update(ClassBaseInfoEntity entity) {
		dao.update(entity);
	}

	public void del(Integer classBaseInfoId) {
		dao.deleteObjectByIds(classBaseInfoId);
	}

	public List<ClassBaseInfoEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

	public ClassBaseInfoEntity merge(ClassBaseInfoEntity entity){
		return dao.merge(entity);
	}
	
	public List findBySql(String sql) {
		// TODO Auto-generated method stub
		return dao.findBySQL(sql);
	}
}
