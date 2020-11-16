package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IExaminationMarkManageDao;
import com.zhiyu.baseplatform.bean.PageBean;
import com.zhiyu.baseplatform.entity.ExaminationMarkManageEntity;
import com.zhiyu.baseplatform.service.IExaminationMarkManageService;

/**
 *
 * @author wdj
 *
 */
@Service
public class ExaminationMarkManageServiceImpl implements IExaminationMarkManageService {

	@Autowired
	private IExaminationMarkManageDao dao;

	public PageBean<ExaminationMarkManageEntity> findPageByEntity(ExaminationMarkManageEntity entity,
			PageBean<ExaminationMarkManageEntity> page,Map<String, String> sortMap) throws Exception {
		return dao.findPageByEntity(entity, page);
	}

	public void saveOrUpdate(ExaminationMarkManageEntity entity) {
		dao.saveOrUpdate(entity);
	}

	public ExaminationMarkManageEntity findById(Integer id){
		ExaminationMarkManageEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public void deleteById(Integer id) {
		dao.deleteObjectByIds(id);
	}

	public List<ExaminationMarkManageEntity> findByEntity(ExaminationMarkManageEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ExaminationMarkManageEntity> findAll() {
		return dao.findAll();
	}

}
