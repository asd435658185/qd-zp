package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.ISchoolTypeDao;
import com.zhiyu.baseplatform.entity.SchoolTypeEntity;
import com.zhiyu.baseplatform.service.ISchoolTypeService;

/**
 *
 * @author csk
 *
 */
@Service
public class SchoolTypeServiceImpl implements ISchoolTypeService{

	@Autowired
	private ISchoolTypeDao dao;

	public List<SchoolTypeEntity> findByEntity(SchoolTypeEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
		}
		return null;
	}

	public List<SchoolTypeEntity> findAll() {
		return dao.findAll();
	}

	public void del(Integer schoolTypeId) {
		dao.deleteObjectByIds(schoolTypeId);
	}

	public SchoolTypeEntity findObjectById(Integer id) {
		SchoolTypeEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<SchoolTypeEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

	public void saveOrUpdate(SchoolTypeEntity entity) {
		dao.saveOrUpdate(entity);
	}
}
