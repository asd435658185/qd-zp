package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.ISchoolKindDao;
import com.zhiyu.baseplatform.entity.SchoolKindEntity;
import com.zhiyu.baseplatform.service.ISchoolKindService;
/**
 *
 * @author csk
 *
 */
@Service
public class SchoolKindServiceImpl implements ISchoolKindService{

	@Autowired
	private ISchoolKindDao dao;

	public List<SchoolKindEntity> findByEntity(SchoolKindEntity entity) {
		return dao.findAll();
	}

	public void save(SchoolKindEntity entity) {
		dao.save(entity);
	}

	public SchoolKindEntity findObjectById(Integer id) {
		SchoolKindEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<SchoolKindEntity> findAll() {
		return dao.findAll();
	}

	public void update(SchoolKindEntity entity) {
		dao.update(entity);
	}

	public void del(Integer schoolKindId) {
		dao.deleteObjectByIds(schoolKindId);
	}

	public List<SchoolKindEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

}