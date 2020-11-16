package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;
import com.zhiyu.baseplatform.entity.GradeBaseInfoEntity;
/**
 * 
 * @author csk
 *
 */
public interface IGradeBaseInfoService {

	public GradeBaseInfoEntity findObjectById(Integer id);
	
	public List<GradeBaseInfoEntity> findByEntity(GradeBaseInfoEntity entity);
	
	public List<GradeBaseInfoEntity> findAll();
	
	public void update(GradeBaseInfoEntity entity);
	
	public void save(GradeBaseInfoEntity entity);
	
	public void del(Integer GradeBaseInfoId);
	
	public List<GradeBaseInfoEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
	
	public void saveOrUpdate(GradeBaseInfoEntity entity);
	
	public GradeBaseInfoEntity merge(GradeBaseInfoEntity entity);
	
	public List findBySql(String sql);
	
	public List<List<Map<String, Object>>> findBySQLs(String sql);
}