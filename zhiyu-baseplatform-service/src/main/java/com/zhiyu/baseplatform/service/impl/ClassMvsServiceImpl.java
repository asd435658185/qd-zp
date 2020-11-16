package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhiyu.baseplatform.dao.IClassMvsDao;
import com.zhiyu.baseplatform.entity.ClassMvsEntity;
import com.zhiyu.baseplatform.service.IClassMvsService;

/**
*
* @author csk
*
*/
@Service
public class ClassMvsServiceImpl implements IClassMvsService{
	
	@Autowired
    private IClassMvsDao dao;
	
	public ClassMvsEntity findObjectById(Integer id) {
		ClassMvsEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<ClassMvsEntity> findByEntity(ClassMvsEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ClassMvsEntity> findAll() {
		return dao.findAll();
	}

	public void update(ClassMvsEntity entity) {
		dao.update(entity);
	}

	public void save(ClassMvsEntity entity) {
		dao.save(entity);
	}

	public void del(Integer classImgsId) {
		dao.deleteObjectByIds(classImgsId);
	}

	public List<ClassMvsEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

}
