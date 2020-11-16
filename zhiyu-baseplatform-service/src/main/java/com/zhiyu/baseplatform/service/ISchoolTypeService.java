package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.entity.SchoolTypeEntity;
/**
 * 
 * @author csk
 *
 */
public interface ISchoolTypeService {

	public SchoolTypeEntity findObjectById(Integer id);
	
	public List<SchoolTypeEntity> findByEntity(SchoolTypeEntity entity);
	
	public List<SchoolTypeEntity> findAll();
	
	public void saveOrUpdate(SchoolTypeEntity entity);
	
	public void del(Integer schoolTypeId);
	
	public List<SchoolTypeEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
}
