package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.ITeacherCourseRelDao;
import com.zhiyu.baseplatform.entity.TeacherCourseRelEntity;
import com.zhiyu.baseplatform.service.ITeacherCourseRelService;

/**
 *
 * @author csk
 *
 */
@Service
public class TeacherCourseRelServiceImpl implements ITeacherCourseRelService{

	@Autowired
	private ITeacherCourseRelDao dao;

	public List<TeacherCourseRelEntity> findByEntity(TeacherCourseRelEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save(TeacherCourseRelEntity entity) {
		dao.save(entity);
	}

	public TeacherCourseRelEntity saveEntity(TeacherCourseRelEntity entity) {
		return dao.merge(entity);
	}

	public TeacherCourseRelEntity findObjectById(Integer id) {
		TeacherCourseRelEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<TeacherCourseRelEntity> findAll() {
		return dao.findAll();
	}

	public void update(TeacherCourseRelEntity entity) {
		dao.update(entity);
	}

	public void del(Integer teacherCourseRelId) {
		dao.deleteObjectByIds(teacherCourseRelId);
	}

	public List<TeacherCourseRelEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

}