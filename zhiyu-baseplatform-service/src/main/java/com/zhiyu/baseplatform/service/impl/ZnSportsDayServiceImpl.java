package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IZnSportsDayDao;
import com.zhiyu.baseplatform.entity.ZnSportsDayEntity;
import com.zhiyu.baseplatform.service.IZnSportsDayService;

/**
 *
 * @author csk
 *
 */
@Service
public class ZnSportsDayServiceImpl implements IZnSportsDayService{

	@Autowired
	private IZnSportsDayDao dao;

	public ZnSportsDayEntity findObjectById(Integer id) {
		ZnSportsDayEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<ZnSportsDayEntity> findByEntity(ZnSportsDayEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ZnSportsDayEntity> findAll() {
		return dao.findAll();
	}

	public void update(ZnSportsDayEntity entity) {
		dao.update(entity);
	}

	public void save(ZnSportsDayEntity entity) {
		dao.save(entity);
	}

	public void del(Integer znSportsDayId) {
		dao.deleteObjectByIds(znSportsDayId);
	}

	public List<ZnSportsDayEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

}
