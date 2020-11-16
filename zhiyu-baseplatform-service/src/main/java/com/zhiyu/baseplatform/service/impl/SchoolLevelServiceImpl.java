package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.zhiyu.baseplatform.dao.ISchoolLevelDao;
import com.zhiyu.baseplatform.entity.SchoolLevelEntity;
import com.zhiyu.baseplatform.service.ISchoolLevelService;
/**
 *
 * @author csk
 *
 */
@Service
public class SchoolLevelServiceImpl implements ISchoolLevelService{

	@Autowired
	private ISchoolLevelDao dao;

	public List<SchoolLevelEntity> findByEntity(SchoolLevelEntity entity) {
		Map<String, Object> fieldAndValueMap = Maps.newConcurrentMap();
		if(StringUtils.isNotBlank(entity.getSchoolLevelName())){
			fieldAndValueMap.put("schoolLevelName", entity.getSchoolLevelName());
		}
		return dao.findListByConditionMap(fieldAndValueMap, null);
	}

	public List<SchoolLevelEntity> findAll() {
		return dao.findAll();
	}

	public void save(SchoolLevelEntity entity) {
		dao.save(entity);
	}

	public void update(SchoolLevelEntity entity) {
		dao.update(entity);
	}

	public void del(Integer schoolLevelId) {
		dao.deleteObjectByIds(schoolLevelId);
	}

	public SchoolLevelEntity findObjectById(Integer id) {
		SchoolLevelEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<SchoolLevelEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}
}

