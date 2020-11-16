package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IZnHealthAlertDao;
import com.zhiyu.baseplatform.entity.ZnHealthAlertEntity;
import com.zhiyu.baseplatform.service.IZnHealthAlertService;

/**
 *
 * @author wdj
 *
 */
@Service
public class ZnHealthAlertServiceImpl implements IZnHealthAlertService {

	@Autowired
	private IZnHealthAlertDao dao;

	public List<ZnHealthAlertEntity> findByEntity(ZnHealthAlertEntity entity){
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save(ZnHealthAlertEntity entity){
		dao.save(entity);
	}

	public ZnHealthAlertEntity findObjectById(Integer id) {
		ZnHealthAlertEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<ZnHealthAlertEntity> findAll() {
		return dao.findAll();
	}

	public void update(ZnHealthAlertEntity entity) {
		dao.update(entity);
	}

	public void del(Integer AcademicTitleId) {
		dao.deleteObjectByIds(AcademicTitleId);
	}

	public List<ZnHealthAlertEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

	public void saveOrUpdate(ZnHealthAlertEntity entity) {
		dao.saveOrUpdate(entity);
	}
}
