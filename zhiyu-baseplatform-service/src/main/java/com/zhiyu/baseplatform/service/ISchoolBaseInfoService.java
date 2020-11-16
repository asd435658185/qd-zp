package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;
import com.zhiyu.baseplatform.entity.SchoolBaseInfoEntity;
/**
 * 
 * @author csk
 *
 */
public interface ISchoolBaseInfoService {

    public SchoolBaseInfoEntity findObjectById(Integer id);
	
	public List<SchoolBaseInfoEntity> findByEntity(SchoolBaseInfoEntity entity);
	
	public List<SchoolBaseInfoEntity> findAll();
	
	public void update(SchoolBaseInfoEntity entity);
	
	public void save(SchoolBaseInfoEntity entity);
	
	public void del(Integer SchoolBaseInfoId);
	
	public SchoolBaseInfoEntity merge(SchoolBaseInfoEntity entity);
	
	public List<SchoolBaseInfoEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);

    public List findBySql(String sql);
}
