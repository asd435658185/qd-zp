package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.bean.PageBean;
import com.zhiyu.baseplatform.entity.StudentBaseInfoEntity;
/**
 *学生基础信息服务
 * @author csk
 *
 */
public interface IStudentBaseInfoService {

	public List<StudentBaseInfoEntity> findByEntity(StudentBaseInfoEntity entity);

	public void save(StudentBaseInfoEntity entity);
	
	public void update(StudentBaseInfoEntity entity);
	
	public StudentBaseInfoEntity merge(StudentBaseInfoEntity entity);

	public StudentBaseInfoEntity findById(Integer id);

	public void saveOrUpdate(StudentBaseInfoEntity entity);

	public void deleteById(Integer id);

	public PageBean<StudentBaseInfoEntity> findPage(String condition, Object[] params, PageBean<StudentBaseInfoEntity> page,Map<String, String> orderby);

	public PageBean<StudentBaseInfoEntity> findPageByEntity(StudentBaseInfoEntity entity,PageBean<StudentBaseInfoEntity> page) throws Exception;

	public List<StudentBaseInfoEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);

	public List<StudentBaseInfoEntity> findAll();
}
