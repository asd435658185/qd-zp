package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;
import com.zhiyu.baseplatform.entity.AcademicTitleEntity;

/**
 * 
 * @author wdj
 *
 */

public interface IAcademicTitleService {


	public AcademicTitleEntity findObjectById(Integer id);
	
	public List<AcademicTitleEntity> findByEntity(AcademicTitleEntity entity);
	
	public List<AcademicTitleEntity> findAll();
	
	public void update(AcademicTitleEntity entity);
	
	public void save(AcademicTitleEntity entity);
	
	public void del(Integer AcademicTitleId);
	
	public List<AcademicTitleEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
	
	public void saveOrUpdate(AcademicTitleEntity entity);
}
