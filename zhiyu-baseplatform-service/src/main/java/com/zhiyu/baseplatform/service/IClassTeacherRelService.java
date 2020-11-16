package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;
import com.zhiyu.baseplatform.entity.ClassTeacherRelEntity;

/**
 * 
 * @author csk
 *
 */
public interface IClassTeacherRelService {

	public List<ClassTeacherRelEntity> findByEntity(ClassTeacherRelEntity entity);

	public void save(ClassTeacherRelEntity entity);

	public void saveOrUpdate(ClassTeacherRelEntity entity);

	public ClassTeacherRelEntity findObjectById(Integer id);

	public List<ClassTeacherRelEntity> findAll();

	public void update(ClassTeacherRelEntity entity);

	public void del(Integer id);

	public List<ClassTeacherRelEntity> findListByConditionWithNoPage(String condition, final Object[] params,
			Map<String, String> orderby);

	public void deleteById(Integer id);

	public ClassTeacherRelEntity merge(ClassTeacherRelEntity entity);

}
