package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;
import com.zhiyu.baseplatform.entity.ClassBaseInfoEntity;

/**
 * 班级基础信息服务
 * @author csk
 *
 */
public interface IClassBaseInfoService {

	public ClassBaseInfoEntity findObjectById(Integer id);
	
	public List<ClassBaseInfoEntity> findByEntity(ClassBaseInfoEntity entity);
	
	public List<ClassBaseInfoEntity> findAll();
	
	public void update(ClassBaseInfoEntity entity);
	
	public void save(ClassBaseInfoEntity entity);
	
	public void del(Integer ClassBaseInfoId);
	
	public List<ClassBaseInfoEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
	
	public ClassBaseInfoEntity merge(ClassBaseInfoEntity entity);
	
	public List findBySql(String sql);
}