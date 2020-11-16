package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IStudentRfidRecordDao;
import com.zhiyu.baseplatform.entity.StudentRfidRecordEntity;
import com.zhiyu.baseplatform.service.IStudentRfidRecordService;

@Service
public class StudentRfidRecordServiceImpl implements IStudentRfidRecordService{

	@Autowired
	private IStudentRfidRecordDao dao;

	public StudentRfidRecordEntity findObjectById(Integer id) {
		StudentRfidRecordEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<StudentRfidRecordEntity> findByEntity(StudentRfidRecordEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<StudentRfidRecordEntity> findAll() {
		return dao.findAll();
	}

	public void update(StudentRfidRecordEntity entity) {
		dao.update(entity);
	}

	public void save(StudentRfidRecordEntity entity) {
		dao.save(entity);
	}

	public void del(Integer id) {
		dao.deleteObjectByIds(id);
	}

	public List<StudentRfidRecordEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

}
