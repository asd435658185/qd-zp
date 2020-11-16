package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IParentStudentRelDao;
import com.zhiyu.baseplatform.entity.ParentStudentRelEntity;
import com.zhiyu.baseplatform.service.IParentStudentRelService;

/**
 *
 * @author csk
 *
 */
@Service
public class ParentStudentRelServiceImpl implements IParentStudentRelService{

	@Autowired
	private IParentStudentRelDao dao;

	public ParentStudentRelEntity findObjectById(Integer id) {
		ParentStudentRelEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<ParentStudentRelEntity> findByEntity(ParentStudentRelEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ParentStudentRelEntity> findAll() {
		return dao.findAll();
	}

	public void update(ParentStudentRelEntity entity) {
		dao.update(entity);
	}

	public void save(ParentStudentRelEntity entity) {
		dao.save(entity);
	}

	public void del(Integer parentStudentRelId) {
		dao.deleteObjectByIds(parentStudentRelId);
	}

	public List<ParentStudentRelEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

}
