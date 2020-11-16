package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IGradeLessonPeriodDao;
import com.zhiyu.baseplatform.entity.GradeLessonPeriodEntity;
import com.zhiyu.baseplatform.service.IGradeLessonPeriodService;

/**
 *
 * @author csk
 *
 */
@Service
public class GradeLessonPeriodServiceImpl implements IGradeLessonPeriodService{

	@Autowired
	private IGradeLessonPeriodDao dao;

	public GradeLessonPeriodEntity findObjectById(Integer id) {
		GradeLessonPeriodEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<GradeLessonPeriodEntity> findByEntity(GradeLessonPeriodEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<GradeLessonPeriodEntity> findAll() {
		return dao.findAll();
	}

	public void update(GradeLessonPeriodEntity entity) {
		dao.update(entity);
	}

	public void save(GradeLessonPeriodEntity entity) {
		dao.save(entity);
	}

	public void del(Integer gradeLessonPeriodId) {
		dao.deleteObjectByIds(gradeLessonPeriodId);
	}

	public List<GradeLessonPeriodEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

	public void saveOrUpdate(GradeLessonPeriodEntity entity) {
		dao.saveOrUpdate(entity);
	}

}
