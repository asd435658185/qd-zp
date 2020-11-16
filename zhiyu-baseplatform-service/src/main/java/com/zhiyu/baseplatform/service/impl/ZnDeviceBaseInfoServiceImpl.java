package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IZnDeviceBaseInfoDao;
import com.zhiyu.baseplatform.entity.ZnDeviceBaseInfoEntity;
import com.zhiyu.baseplatform.service.IZnDeviceBaseInfoService;

/**
 *
 * @author csk
 *
 */
@Service
public class ZnDeviceBaseInfoServiceImpl implements IZnDeviceBaseInfoService{

	@Autowired
	private IZnDeviceBaseInfoDao dao;

	public ZnDeviceBaseInfoEntity findObjectById(Integer id) {
		ZnDeviceBaseInfoEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<ZnDeviceBaseInfoEntity> findByEntity(ZnDeviceBaseInfoEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ZnDeviceBaseInfoEntity> findAll() {
		return dao.findAll();
	}

	public void update(ZnDeviceBaseInfoEntity entity) {
		dao.update(entity);
	}

	public void save(ZnDeviceBaseInfoEntity entity) {
		dao.save(entity);
	}

	public void del(Integer znDeviceBaseInfoId) {
		dao.deleteObjectByIds(znDeviceBaseInfoId);
	}

	public List<ZnDeviceBaseInfoEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

}
