package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IZnStudentParentDeviceRelDao;
import com.zhiyu.baseplatform.entity.ZnStudentParentDeviceRelEntity;
import com.zhiyu.baseplatform.service.IZnStudentParentDeviceRelService;

/**
 *
 * @author csk
 *
 */
@Service
public class ZnStudentParentDeviceRelServiceImpl implements IZnStudentParentDeviceRelService{

	@Autowired
	private IZnStudentParentDeviceRelDao dao;

	public ZnStudentParentDeviceRelEntity findObjectById(Integer id) {
		ZnStudentParentDeviceRelEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<ZnStudentParentDeviceRelEntity> findByEntity(ZnStudentParentDeviceRelEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ZnStudentParentDeviceRelEntity> findAll() {
		return dao.findAll();
	}

	public void update(ZnStudentParentDeviceRelEntity entity) {
		dao.update(entity);
	}

	public void save(ZnStudentParentDeviceRelEntity entity) {
		dao.save(entity);
	}

	public void del(Integer znStudentParentDeviceRelId) {
		dao.deleteObjectByIds(znStudentParentDeviceRelId);
	}

	public List<ZnStudentParentDeviceRelEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

}
