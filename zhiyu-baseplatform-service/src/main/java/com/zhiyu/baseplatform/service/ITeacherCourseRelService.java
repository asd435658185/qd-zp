package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;
import com.zhiyu.baseplatform.entity.TeacherCourseRelEntity;
/**
 * 
 * @author csk
 *
 */
public interface ITeacherCourseRelService {


	public List<TeacherCourseRelEntity> findByEntity(TeacherCourseRelEntity entity);
	
	public void save(TeacherCourseRelEntity entity);
	
	public TeacherCourseRelEntity saveEntity(TeacherCourseRelEntity entity);
	
    public TeacherCourseRelEntity findObjectById(Integer id);
	
	public List<TeacherCourseRelEntity> findAll();
	
	public void update(TeacherCourseRelEntity entity);
	
	
	public void del(Integer TeacherCourseRelId);
	
	public List<TeacherCourseRelEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);

}