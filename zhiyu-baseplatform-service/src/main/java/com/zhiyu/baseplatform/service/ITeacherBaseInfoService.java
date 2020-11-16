package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.bean.PageBean;
import com.zhiyu.baseplatform.entity.TeacherBaseInfoEntity;

/**
 * 教师基础信息服务
 * @author csk
 *
 */
public interface ITeacherBaseInfoService {


	public TeacherBaseInfoEntity findObjectById(Integer id);

	public List<TeacherBaseInfoEntity> findByEntity(TeacherBaseInfoEntity entity);

	public List<TeacherBaseInfoEntity> findAll();

	public void update(TeacherBaseInfoEntity entity);

	public void save(TeacherBaseInfoEntity entity);

	public void del(Integer TeacherBaseInfoId);

	public List<TeacherBaseInfoEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);

	public TeacherBaseInfoEntity saveEntity(TeacherBaseInfoEntity entity);

	public PageBean<TeacherBaseInfoEntity> findPageByEntity(TeacherBaseInfoEntity entity,PageBean<TeacherBaseInfoEntity> page) throws Exception;

	public PageBean<TeacherBaseInfoEntity> findPage(String condition,  Object[] params, PageBean<TeacherBaseInfoEntity> page,Map<String, String> orderby);

	public void saveOrUpdate(TeacherBaseInfoEntity entity);
	
	public List  findBySQL(String sql);

}

