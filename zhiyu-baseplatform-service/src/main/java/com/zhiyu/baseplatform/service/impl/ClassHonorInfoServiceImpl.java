package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IClassHonorInfoDao;
import com.zhiyu.baseplatform.entity.ClassHonorInfoEntity;
import com.zhiyu.baseplatform.service.IClassHonorInfoService;

/**
 *
 * @author csk
 *
 */
@Service
public class ClassHonorInfoServiceImpl implements IClassHonorInfoService{

	@Autowired
	private IClassHonorInfoDao dao;

	public ClassHonorInfoEntity findObjectById(Integer id) {
		ClassHonorInfoEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<ClassHonorInfoEntity> findByEntity(ClassHonorInfoEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ClassHonorInfoEntity> findAll() {
		return dao.findAll();
	}

	public void update(ClassHonorInfoEntity entity) {
		dao.update(entity);
	}

	public void save(ClassHonorInfoEntity entity) {
		dao.save(entity);
	}

	public void del(Integer classHonorInfoId) {
		dao.deleteObjectByIds(classHonorInfoId);
	}

	public List<ClassHonorInfoEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

}
