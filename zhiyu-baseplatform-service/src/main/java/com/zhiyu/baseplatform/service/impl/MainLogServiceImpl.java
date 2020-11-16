package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IMainLogDao;
import com.zhiyu.baseplatform.entity.MainLogEntity;
import com.zhiyu.baseplatform.service.IMainLogService;

/**
 * 
 * @author wdj
 *
 */
@Service
public class MainLogServiceImpl implements IMainLogService{

	@Autowired
	private IMainLogDao dao;

	public List<MainLogEntity> findByEntity(MainLogEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save(MainLogEntity entity) {
		dao.save(entity);
	}

	public MainLogEntity findObjectById(Integer id) {
		MainLogEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<MainLogEntity> findAll() {
		return dao.findAll();
	}

	public void update(MainLogEntity entity) {
		dao.update(entity);
	}

	public void del(Integer MainLogId) {
		dao.deleteObjectByIds(MainLogId);
	}

	public List<MainLogEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

	public void saveOrUpdate(MainLogEntity entity) {
		dao.saveOrUpdate(entity);
	}

	public MainLogEntity merge(MainLogEntity entity){
		return dao.merge(entity);
	}

	public List findBySql(String sql) {
		// TODO Auto-generated method stub
		return dao.findBySQL(sql);
	}
}
