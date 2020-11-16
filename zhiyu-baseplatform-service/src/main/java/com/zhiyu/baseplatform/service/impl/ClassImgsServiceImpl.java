package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IClassImgsDao;
import com.zhiyu.baseplatform.entity.ClassImgsEntity;
import com.zhiyu.baseplatform.service.IClassImgsService;


/**
 *
 * @author csk
 *
 */
@Service
public class ClassImgsServiceImpl implements IClassImgsService{

	@Autowired
    private IClassImgsDao dao;

	public ClassImgsEntity findObjectById(Integer id) {
		ClassImgsEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<ClassImgsEntity> findByEntity(ClassImgsEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ClassImgsEntity> findAll() {
		return dao.findAll();
	}

	public void update(ClassImgsEntity entity) {
		dao.update(entity);
	}

	public void save(ClassImgsEntity entity) {
		dao.save(entity);
	}

	public void del(Integer classImgsId) {
		dao.deleteObjectByIds(classImgsId);
	}

	public List<ClassImgsEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

}
