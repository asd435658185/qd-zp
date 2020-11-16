package com.zhiyu.baseplatform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhiyu.baseplatform.dao.StudentCardDao;
import com.zhiyu.baseplatform.entity.StudentCardEntity;
import com.zhiyu.baseplatform.service.StudentCardService;

@Component
public class StudentCardServiceImpl implements StudentCardService {
	
	@Autowired
	private StudentCardDao dao;

	public StudentCardEntity findObjectById(Integer id) {
		StudentCardEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public void saveOrUpdate(StudentCardEntity entity) {
		dao.save(entity);
	}

	public List<StudentCardEntity> findByEntity(StudentCardEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<StudentCardEntity> findAll() {
		return dao.findAll();
	}

}
