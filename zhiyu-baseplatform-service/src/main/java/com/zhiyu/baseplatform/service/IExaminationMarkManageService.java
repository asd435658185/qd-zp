package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.bean.PageBean;
import com.zhiyu.baseplatform.entity.ExaminationMarkManageEntity;

/**
 * 
 * @author wdj
 *
 */

public interface IExaminationMarkManageService {

	public PageBean<ExaminationMarkManageEntity> findPageByEntity(ExaminationMarkManageEntity entity,PageBean<ExaminationMarkManageEntity> page,Map<String, String> sortMap) throws Exception;
	
	public void saveOrUpdate(ExaminationMarkManageEntity entity);
	
	public ExaminationMarkManageEntity findById(Integer id);
	
	public void deleteById(Integer id);

	public List<ExaminationMarkManageEntity> findByEntity(ExaminationMarkManageEntity entity);
	
	public List<ExaminationMarkManageEntity> findAll();
}
