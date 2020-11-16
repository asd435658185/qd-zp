package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;
import com.zhiyu.baseplatform.entity.ClassLessionDetailEntity;

/**
 * 班级课程明细服务
 * @author csk
 *
 */
public interface IClassLessionDetailService {


	public ClassLessionDetailEntity findObjectById(Integer id);
	
	public List<ClassLessionDetailEntity> findByEntity(ClassLessionDetailEntity entity);
	
	public List<ClassLessionDetailEntity> findAll();
	
	public void update(ClassLessionDetailEntity entity);
	
	public void save(ClassLessionDetailEntity entity);
	
	public void del(Integer classLessionDetailId);
	
	public List<ClassLessionDetailEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
}
