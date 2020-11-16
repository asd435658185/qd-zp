package com.zhiyu.baseplatform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IPlatformSchoolPurchaseProjectDao;
import com.zhiyu.baseplatform.entity.PlatformSchoolPurchaseProjectEntity;
import com.zhiyu.baseplatform.service.IPlatformSchoolPurchaseProjectService;

/**
 * 
 * @author wdj
 *
 */
@Service
public class PlatformSchoolPurchaseProjectServiceImpl implements IPlatformSchoolPurchaseProjectService {

	@Autowired
	private IPlatformSchoolPurchaseProjectDao dao;
	
	/**
	 * 按实体查询列表
	 * @param entity
	 * @return
	 */
	public List<PlatformSchoolPurchaseProjectEntity> findByEntity(PlatformSchoolPurchaseProjectEntity entity){
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void saveOrUpdate(PlatformSchoolPurchaseProjectEntity entity) {
		dao.save(entity);
	}

	public List<PlatformSchoolPurchaseProjectEntity> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public PlatformSchoolPurchaseProjectEntity findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findObjectById(id);
	}

	public void save(PlatformSchoolPurchaseProjectEntity entity) {
		// TODO Auto-generated method stub
		dao.save(entity);
	}

	public void update(PlatformSchoolPurchaseProjectEntity entity) {
		// TODO Auto-generated method stub
		dao.update(entity);
	}

	public void del(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteObjectByIds(id);
	}

	public PlatformSchoolPurchaseProjectEntity merge(PlatformSchoolPurchaseProjectEntity entity) {
		// TODO Auto-generated method stub
		return dao.merge(entity);
	}
}
