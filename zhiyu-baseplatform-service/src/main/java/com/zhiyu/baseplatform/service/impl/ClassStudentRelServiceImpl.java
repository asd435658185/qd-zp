package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhiyu.baseplatform.dao.IClassStudentRelDao;
import com.zhiyu.baseplatform.entity.ClassStudentRelEntity;
import com.zhiyu.baseplatform.service.IClassStudentRelService;

/**
 *
 * @author csk
 *
 */
@Service
public class ClassStudentRelServiceImpl implements IClassStudentRelService{

	@Autowired
	private IClassStudentRelDao dao;

	public List<ClassStudentRelEntity> findByEntity(ClassStudentRelEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void saveOrUpdate(ClassStudentRelEntity entity) {
		dao.save(entity);
	}

	public List<ClassStudentRelEntity> findByCondition(String condition, Object[] params, Map<String, String> orderby){
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

	public ClassStudentRelEntity findById(Integer id){
		ClassStudentRelEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}
	
	public void deleteById(Integer id){
		dao.deleteObjectByIds(id);
	}
	
	public void save(ClassStudentRelEntity entity){
		dao.save(entity);
	}
	
	public void update(ClassStudentRelEntity entity){
		dao.update(entity);
	}
	
	public ClassStudentRelEntity merge(ClassStudentRelEntity entity){
		return dao.merge(entity);
	}

	public List findBySQL(String sql) {
		// TODO Auto-generated method stub
		return dao.findBySQL(sql);
	}
}

