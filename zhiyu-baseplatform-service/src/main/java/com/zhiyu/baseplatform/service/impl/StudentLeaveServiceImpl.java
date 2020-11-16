package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IStudentLeaveDao;
import com.zhiyu.baseplatform.entity.StudentLeaveEntity;
import com.zhiyu.baseplatform.service.IStudentLeaveService;


@Service
public class StudentLeaveServiceImpl implements IStudentLeaveService{

	@Autowired
	private IStudentLeaveDao dao;

	public StudentLeaveEntity findObjectById(Integer id) {
		StudentLeaveEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<StudentLeaveEntity> findByEntity(StudentLeaveEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<StudentLeaveEntity> findAll() {
		return dao.findAll();
	}

	public void update(StudentLeaveEntity entity) {
		dao.update(entity);
	}

	public void save(StudentLeaveEntity entity) {
		dao.save(entity);
	}

	public void del(Integer id) {
		dao.deleteObjectByIds(id);
	}

	public List<StudentLeaveEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

}
