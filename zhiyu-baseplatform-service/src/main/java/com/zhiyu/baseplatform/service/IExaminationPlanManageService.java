package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.bean.PageBean;
import com.zhiyu.baseplatform.entity.ExaminationPlanManageEntity;

/**
 * 
 * @author wdj
 *
 */

public interface IExaminationPlanManageService {

	public PageBean<ExaminationPlanManageEntity> findPageByEntity(ExaminationPlanManageEntity entity,PageBean<ExaminationPlanManageEntity> page) throws Exception;
	
	public void saveOrUpdate(ExaminationPlanManageEntity entity);
	
	public ExaminationPlanManageEntity findById(Integer id);
	
	public void deleteById(Integer id);
	
	public List<ExaminationPlanManageEntity> findByEntity(ExaminationPlanManageEntity entity);

	public List<ExaminationPlanManageEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
}
