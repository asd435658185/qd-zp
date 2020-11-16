package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IStudentPraiseInfoDao;
import com.zhiyu.baseplatform.entity.StudentPraiseInfoEntity;
import com.zhiyu.baseplatform.service.IStudentPraiseInfoService;

/**
 *
 * @author wdj
 *
 */
@Service
public class StudentPraiseInfoServiceImpl implements IStudentPraiseInfoService {

	@Autowired
	private IStudentPraiseInfoDao dao;

	public StudentPraiseInfoEntity findObjectById(Integer id) {
		StudentPraiseInfoEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<StudentPraiseInfoEntity> findByEntity(StudentPraiseInfoEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<StudentPraiseInfoEntity> findAll() {
		return dao.findAll();
	}

	public void update(StudentPraiseInfoEntity entity) {
		dao.update(entity);
	}

	public void save(StudentPraiseInfoEntity entity) {
		dao.save(entity);
	}

	public void del(Integer id) {
		dao.deleteObjectByIds(id);
	}

	public List<StudentPraiseInfoEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

}
