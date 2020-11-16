package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.entity.DutySudentInfoEntity;

public interface IDutySudentInfoService {

	public DutySudentInfoEntity findObjectById(Integer id);
	
	public List<DutySudentInfoEntity> findByEntity(DutySudentInfoEntity entity);
	
	public List<DutySudentInfoEntity> findAll();
	
	public void update(DutySudentInfoEntity entity);
	
	public void save(DutySudentInfoEntity entity);
	
	public void del(Integer id);
	
	public List<DutySudentInfoEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
}
