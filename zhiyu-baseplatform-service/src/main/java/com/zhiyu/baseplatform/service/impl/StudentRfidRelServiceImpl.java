package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IStudentRfidRelDao;
import com.zhiyu.baseplatform.entity.StudentRfidRelEntity;
import com.zhiyu.baseplatform.service.IStudentRfidRelService;

/**
 *
 * @author wdj
 *
 */
@Service
public class StudentRfidRelServiceImpl implements IStudentRfidRelService {

	@Autowired private IStudentRfidRelDao dao;

	public StudentRfidRelEntity findObjectById(Integer id) {
		StudentRfidRelEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<StudentRfidRelEntity> findByEntity(StudentRfidRelEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<StudentRfidRelEntity> findAll() {
		return dao.findAll();
	}

	public void update(StudentRfidRelEntity entity) {
		dao.update(entity);
	}

	public void save(StudentRfidRelEntity entity) {
		dao.save(entity);
	}

	public void del(Integer id) {
		dao.deleteObjectByIds(id);
	}

	public List<StudentRfidRelEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

}
