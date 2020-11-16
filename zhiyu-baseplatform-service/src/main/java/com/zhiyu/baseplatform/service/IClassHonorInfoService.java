package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.entity.ClassHonorInfoEntity;

public interface IClassHonorInfoService {

	public ClassHonorInfoEntity findObjectById(Integer id);
	
	public List<ClassHonorInfoEntity> findByEntity(ClassHonorInfoEntity entity);
	
	public List<ClassHonorInfoEntity> findAll();
	
	public void update(ClassHonorInfoEntity entity);
	
	public void save(ClassHonorInfoEntity entity);
	
	public void del(Integer classHonorInfoId);
	
	public List<ClassHonorInfoEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
}
