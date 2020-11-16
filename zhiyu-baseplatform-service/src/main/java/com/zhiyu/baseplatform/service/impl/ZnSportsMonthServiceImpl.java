package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IZnSportsMonthDao;
import com.zhiyu.baseplatform.entity.ZnSportsMonthEntity;
import com.zhiyu.baseplatform.service.IZnSportsMonthService;

/**
 *
 * @author csk
 *
 */
@Service
public class ZnSportsMonthServiceImpl implements IZnSportsMonthService{

	@Autowired
	private IZnSportsMonthDao dao;

	public ZnSportsMonthEntity findObjectById(Integer id) {
		ZnSportsMonthEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<ZnSportsMonthEntity> findByEntity(ZnSportsMonthEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ZnSportsMonthEntity> findAll() {
		return dao.findAll();
	}

	public void update(ZnSportsMonthEntity entity) {
		dao.update(entity);
	}

	public void save(ZnSportsMonthEntity entity) {
		dao.save(entity);
	}

	public void del(Integer znSportsMonthId) {
		dao.deleteObjectByIds(znSportsMonthId);
	}

	public List<ZnSportsMonthEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

}
