package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IGradeBaseInfoDao;
import com.zhiyu.baseplatform.entity.GradeBaseInfoEntity;
import com.zhiyu.baseplatform.service.IGradeBaseInfoService;

/**
 *
 * @author csk
 *
 */
@Service
public class GradeBaseInfoService implements IGradeBaseInfoService{

	@Autowired
	private IGradeBaseInfoDao dao;

	public List<GradeBaseInfoEntity> findByEntity(GradeBaseInfoEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save(GradeBaseInfoEntity entity) {
		dao.save(entity);
	}

	public GradeBaseInfoEntity findObjectById(Integer id) {
		GradeBaseInfoEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<GradeBaseInfoEntity> findAll() {
		return dao.findAll();
	}

	public void update(GradeBaseInfoEntity entity) {
		dao.update(entity);
	}

	public void del(Integer GradeBaseInfoId) {
		dao.deleteObjectByIds(GradeBaseInfoId);
	}

	public List<GradeBaseInfoEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

	public void saveOrUpdate(GradeBaseInfoEntity entity) {
		dao.saveOrUpdate(entity);
	}

	public GradeBaseInfoEntity merge(GradeBaseInfoEntity entity){
		return dao.merge(entity);
	}

	public List findBySql(String sql) {
		// TODO Auto-generated method stub
		return dao.findBySQL(sql);
	}
	public List<List<Map<String, Object>>> findBySQLs(String sql) {
		// TODO Auto-generated method stub
		return dao.findBySQLs(sql);
	}
}
