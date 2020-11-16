package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.entity.ClassStudentRelEntity;

/**
 * 班级学生关系服务
 * @author csk
 *
 */
public interface IClassStudentRelService {

	public List<ClassStudentRelEntity> findByEntity(ClassStudentRelEntity entity);
	
	public void saveOrUpdate(ClassStudentRelEntity entity);
	
	public List<ClassStudentRelEntity> findByCondition(String condition, Object[] params, Map<String, String> orderby);
	
	public ClassStudentRelEntity findById(Integer id);
	
	public void deleteById(Integer id);
	
	public void save(ClassStudentRelEntity entity);
	
	public void update(ClassStudentRelEntity entity);
	
	public ClassStudentRelEntity merge(ClassStudentRelEntity entity);
	
	public List  findBySQL(String sql);
}
