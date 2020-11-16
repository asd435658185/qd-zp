package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;
import com.zhiyu.baseplatform.entity.SchoolLevelEntity;

/**
 * 
 * @author csk
 *
 */
public interface ISchoolLevelService {

	public SchoolLevelEntity findObjectById(Integer id);
	
	public List<SchoolLevelEntity> findByEntity(SchoolLevelEntity entity);
	
	public List<SchoolLevelEntity> findAll();
	
	public void update(SchoolLevelEntity entity);
	
	public void save(SchoolLevelEntity entity);
	
	public void del(Integer schoolLevelId);
	
	public List<SchoolLevelEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
}
