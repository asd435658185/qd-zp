package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhiyu.baseplatform.dao.IAppVersionCheckUpdateDao;
import com.zhiyu.baseplatform.entity.AppVersionCheckUpdateEntity;
import com.zhiyu.baseplatform.service.IAppVersionCheckUpdateService;

/**
 *
 * @author csk
 *
 */
@Service
public class AppVersionCheckUpdateServiceImpl implements IAppVersionCheckUpdateService{

	@Autowired
	private IAppVersionCheckUpdateDao dao;

	public List<AppVersionCheckUpdateEntity> findByEntity(AppVersionCheckUpdateEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void save(AppVersionCheckUpdateEntity entity) {
		dao.save(entity);
	}

	public AppVersionCheckUpdateEntity findObjectById(Integer id) {
		AppVersionCheckUpdateEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<AppVersionCheckUpdateEntity> findAll() {
		return dao.findAll();
	}

	public void update(AppVersionCheckUpdateEntity entity) {
		dao.update(entity);
	}

	public void del(Integer id) {
		dao.deleteObjectByIds(id);
	}

	public List<AppVersionCheckUpdateEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

}
