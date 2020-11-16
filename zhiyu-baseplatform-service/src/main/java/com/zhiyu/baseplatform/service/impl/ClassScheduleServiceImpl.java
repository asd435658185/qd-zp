package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IClassScheduleDao;
import com.zhiyu.baseplatform.entity.ClassScheduleEntity;
import com.zhiyu.baseplatform.service.IClassScheduleService;

/**
 *
 * @author csk
 *
 */
@Service
public class ClassScheduleServiceImpl implements IClassScheduleService{

	@Autowired
	private IClassScheduleDao dao;

	public List<ClassScheduleEntity> findByEntity(ClassScheduleEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save(ClassScheduleEntity entity) {
		dao.save(entity);
	}

	public ClassScheduleEntity findObjectById(Integer id) {
		ClassScheduleEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<ClassScheduleEntity> findAll() {
		return dao.findAll();
	}

	public void update(ClassScheduleEntity entity) {
		dao.update(entity);
	}

	public void del(Integer classScheduleId) {
		dao.deleteObjectByIds(classScheduleId);
	}

	public List<ClassScheduleEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

}
