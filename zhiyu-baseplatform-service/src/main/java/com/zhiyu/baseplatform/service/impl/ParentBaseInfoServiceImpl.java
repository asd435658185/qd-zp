package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IParentBaseInfoDao;
import com.zhiyu.baseplatform.entity.ParentBaseInfoEntity;
import com.zhiyu.baseplatform.service.IParentBaseInfoService;

/**
 *
 * @author csk
 *
 */
@Service
public class ParentBaseInfoServiceImpl implements IParentBaseInfoService{

	@Autowired
    private IParentBaseInfoDao dao;

	public ParentBaseInfoEntity findObjectById(Integer id) {
		ParentBaseInfoEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<ParentBaseInfoEntity> findByEntity(ParentBaseInfoEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ParentBaseInfoEntity> findAll() {
		return dao.findAll();
	}

	public void update(ParentBaseInfoEntity entity) {
		dao.update(entity);
	}

	public void save(ParentBaseInfoEntity entity) {
		dao.save(entity);
	}
	
	public ParentBaseInfoEntity merge(ParentBaseInfoEntity entity){
		return dao.merge(entity);
	}

	public void del(Integer parentBaseInfoId) {
		dao.deleteObjectByIds(parentBaseInfoId);
	}

	public List<ParentBaseInfoEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

}
