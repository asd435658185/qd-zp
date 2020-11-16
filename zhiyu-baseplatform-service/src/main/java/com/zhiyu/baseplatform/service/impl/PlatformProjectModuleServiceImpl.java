package com.zhiyu.baseplatform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IPlatformProjectModuleDao;
import com.zhiyu.baseplatform.entity.PlatformProjectModuleEntity;
import com.zhiyu.baseplatform.service.IPlatformProjectModuleService;

/**
 *
 * @author wdj
 *
 */
@Service
public class PlatformProjectModuleServiceImpl implements IPlatformProjectModuleService {

	@Autowired
	private IPlatformProjectModuleDao dao;

	/**
	 * 按实体查询列表
	 * @param entity
	 * @return
	 */
	public List<PlatformProjectModuleEntity> findByEntity(PlatformProjectModuleEntity entity){
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public PlatformProjectModuleEntity findById(Integer id) {
		PlatformProjectModuleEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<PlatformProjectModuleEntity> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public void save(PlatformProjectModuleEntity entity) {
		// TODO Auto-generated method stub
		dao.save(entity);
	}

	public void update(PlatformProjectModuleEntity entity) {
		// TODO Auto-generated method stub
		dao.update(entity);
	}

	public void del(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteObjectByIds(id);
	}

	public PlatformProjectModuleEntity merge(PlatformProjectModuleEntity entity) {
		// TODO Auto-generated method stub
		return dao.merge(entity);
	}
}
