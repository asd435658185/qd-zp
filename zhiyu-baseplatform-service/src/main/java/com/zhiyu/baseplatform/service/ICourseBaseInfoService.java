package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;
import com.zhiyu.baseplatform.entity.CourseBaseInfoEntity;

/**
 * 
 * @author csk
 *
 */
public interface ICourseBaseInfoService {


	public List<CourseBaseInfoEntity> findByEntity(CourseBaseInfoEntity entity);
	
	public void save(CourseBaseInfoEntity entity);
	
	public CourseBaseInfoEntity saveEntity(CourseBaseInfoEntity entity);
	
    public CourseBaseInfoEntity findObjectById(Integer id);
	
	public List<CourseBaseInfoEntity> findAll();
	
	public void update(CourseBaseInfoEntity entity);
	
	
	public void del(Integer CourseBaseInfoId);
	
	public List<CourseBaseInfoEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);

}
