package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IAcademicTitleDao;
import com.zhiyu.baseplatform.entity.AcademicTitleEntity;
import com.zhiyu.baseplatform.service.IAcademicTitleService;

/**
 *
 * @author wdj
 *
 */
@Service
public class AcademicTitleServiceImpl implements IAcademicTitleService {

	@Autowired
	private IAcademicTitleDao dao;

	public List<AcademicTitleEntity> findByEntity(AcademicTitleEntity entity){
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save(AcademicTitleEntity entity){
		dao.save(entity);
	}

	public AcademicTitleEntity findObjectById(Integer id) {
		AcademicTitleEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<AcademicTitleEntity> findAll() {
		return dao.findAll();
	}

	public void update(AcademicTitleEntity entity) {
		dao.update(entity);
	}

	public void del(Integer AcademicTitleId) {
		dao.deleteObjectByIds(AcademicTitleId);
	}

	public List<AcademicTitleEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

	public void saveOrUpdate(AcademicTitleEntity entity) {
		dao.saveOrUpdate(entity);
	}
}
