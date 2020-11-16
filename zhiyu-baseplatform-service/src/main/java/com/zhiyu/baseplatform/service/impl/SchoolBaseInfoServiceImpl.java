package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.ISchoolBaseInfoDao;
import com.zhiyu.baseplatform.entity.SchoolBaseInfoEntity;
import com.zhiyu.baseplatform.service.ISchoolBaseInfoService;

/**
 *
 * @author csk
 *
 */
@Service
public class SchoolBaseInfoServiceImpl implements ISchoolBaseInfoService{

	@Autowired
	private ISchoolBaseInfoDao dao;

	public List<SchoolBaseInfoEntity> findByEntity(SchoolBaseInfoEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save(SchoolBaseInfoEntity entity) {
		dao.save(entity);
	}

	public SchoolBaseInfoEntity findObjectById(Integer id) {
		SchoolBaseInfoEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<SchoolBaseInfoEntity> findAll() {
		return dao.findAll();
	}

	public void update(SchoolBaseInfoEntity entity) {
		dao.update(entity);
	}

	public SchoolBaseInfoEntity merge(SchoolBaseInfoEntity entity){
		return dao.merge(entity);
	}
	
	public void del(Integer SchoolBaseInfoId) {
		dao.deleteObjectByIds(SchoolBaseInfoId);
	}

	public List<SchoolBaseInfoEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

	public List findBySql(String sql) {
		// TODO Auto-generated method stub
		return dao.findBySQL(sql);
	}

}
