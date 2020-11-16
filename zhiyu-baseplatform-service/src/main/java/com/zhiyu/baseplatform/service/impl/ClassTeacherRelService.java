package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IClassTeacherRelDao;
import com.zhiyu.baseplatform.entity.ClassTeacherRelEntity;
import com.zhiyu.baseplatform.service.IClassTeacherRelService;

/**
 *
 * @author csk
 *
 */
@Service
public class ClassTeacherRelService implements IClassTeacherRelService{

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IClassTeacherRelDao dao;

	public List<ClassTeacherRelEntity> findByEntity(ClassTeacherRelEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return null;
	}

	public void save(ClassTeacherRelEntity entity) {
		dao.save(entity);
	}

	public void saveOrUpdate(ClassTeacherRelEntity entity) {
		dao.saveOrUpdate(entity);
	}

	public ClassTeacherRelEntity findObjectById(Integer id) {
		ClassTeacherRelEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<ClassTeacherRelEntity> findAll() {
		return dao.findAll();
	}

	public void update(ClassTeacherRelEntity entity) {
		dao.update(entity);
	}

	public void del(Integer id) {
		dao.deleteObjectByIds(id);
	}

	public List<ClassTeacherRelEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

	public void deleteById(Integer id){
		dao.deleteObjectByIds(id);
	}
	
	public ClassTeacherRelEntity merge(ClassTeacherRelEntity entity){
		return dao.merge(entity);
	}
}
