package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IWeekBaseInfoDao;
import com.zhiyu.baseplatform.entity.WeekBaseInfoEntity;
import com.zhiyu.baseplatform.service.IWeekBaseInfoService;
/**
 *
 * @author csk
 *
 */
@Service
public class WeekBaseInfoServiceImpl implements IWeekBaseInfoService{

	@Autowired
	private IWeekBaseInfoDao dao;

	public List<WeekBaseInfoEntity> findByEntity(WeekBaseInfoEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save(WeekBaseInfoEntity entity) {
		dao.save(entity);
	}

	public WeekBaseInfoEntity findObjectById(Integer id) {
		WeekBaseInfoEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<WeekBaseInfoEntity> findAll() {
		return dao.findAll();
	}

	public void update(WeekBaseInfoEntity entity) {
		dao.update(entity);
	}

	public void del(Integer weekBaseInfoId) {
		dao.deleteObjectByIds(weekBaseInfoId);
	}

	public List<WeekBaseInfoEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

}

