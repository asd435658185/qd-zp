package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;
import com.zhiyu.baseplatform.entity.SchoolKindEntity;

/**
 * 
 * @author csk
 *
 */
public interface ISchoolKindService {

    public SchoolKindEntity findObjectById(Integer id);
	
	public List<SchoolKindEntity> findByEntity(SchoolKindEntity entity);
	
	public List<SchoolKindEntity> findAll();
	
	public void update(SchoolKindEntity entity);
	
	public void save(SchoolKindEntity entity);
	
	public void del(Integer schoolKindId);
	
	public List<SchoolKindEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
}
