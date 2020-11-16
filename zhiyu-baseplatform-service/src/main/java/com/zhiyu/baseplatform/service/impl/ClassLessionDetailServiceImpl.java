package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IClassLessionDetailDao;
import com.zhiyu.baseplatform.entity.ClassLessionDetailEntity;
import com.zhiyu.baseplatform.service.IClassLessionDetailService;

/**
 *
 * @author csk
 *
 */
@Service
public class ClassLessionDetailServiceImpl implements IClassLessionDetailService{
	@Autowired
	private IClassLessionDetailDao dao;

	public List<ClassLessionDetailEntity> findByEntity(ClassLessionDetailEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save(ClassLessionDetailEntity entity) {
		dao.save(entity);
	}

	public ClassLessionDetailEntity findObjectById(Integer id) {
		ClassLessionDetailEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<ClassLessionDetailEntity> findAll() {
		return dao.findAll();
	}

	public void update(ClassLessionDetailEntity entity) {
		dao.update(entity);
	}

	public void del(Integer classLessionDetailId) {
		dao.deleteObjectByIds(classLessionDetailId);
	}

	public List<ClassLessionDetailEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}


}
