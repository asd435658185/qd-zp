package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.ICourseBaseInfoDao;
import com.zhiyu.baseplatform.entity.CourseBaseInfoEntity;
import com.zhiyu.baseplatform.service.ICourseBaseInfoService;
/**
 *
 * @author csk
 *
 */
@Service
public class CourseBaseInfoServiceImpl implements ICourseBaseInfoService{

	@Autowired
	private ICourseBaseInfoDao dao;

	public List<CourseBaseInfoEntity> findByEntity(CourseBaseInfoEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save(CourseBaseInfoEntity entity) {
		dao.save(entity);
	}

	public CourseBaseInfoEntity saveEntity(CourseBaseInfoEntity entity) {
		return dao.merge(entity);
	}

	public CourseBaseInfoEntity findObjectById(Integer id) {
		CourseBaseInfoEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<CourseBaseInfoEntity> findAll() {
		return dao.findAll();
	}

	public void update(CourseBaseInfoEntity entity) {
		dao.update(entity);
	}

	public void del(Integer courseBaseInfoId) {
		dao.deleteObjectByIds(courseBaseInfoId);
	}

	public List<CourseBaseInfoEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

}
