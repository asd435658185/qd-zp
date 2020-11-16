package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IExaminationPlanManageDao;
import com.zhiyu.baseplatform.bean.PageBean;
import com.zhiyu.baseplatform.entity.ExaminationPlanManageEntity;
import com.zhiyu.baseplatform.service.IExaminationPlanManageService;

/**
 *
 * @author wdj
 *
 */
@Service
public class ExaminationPlanManageServiceImpl implements IExaminationPlanManageService {

	@Autowired
	private IExaminationPlanManageDao dao;

	public PageBean<ExaminationPlanManageEntity> findPageByEntity(ExaminationPlanManageEntity entity,
			PageBean<ExaminationPlanManageEntity> page) throws Exception {
		return dao.findPageByEntity(entity, page);
	}

	public void saveOrUpdate(ExaminationPlanManageEntity entity) {
		dao.saveOrUpdate(entity);
	}

	public ExaminationPlanManageEntity findById(Integer id){
		ExaminationPlanManageEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public void deleteById(Integer id) {
		dao.deleteObjectByIds(id);
	}

	public List<ExaminationPlanManageEntity> findByEntity(ExaminationPlanManageEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ExaminationPlanManageEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}
}
