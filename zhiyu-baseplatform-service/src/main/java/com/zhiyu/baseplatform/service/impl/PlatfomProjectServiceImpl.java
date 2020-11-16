package com.zhiyu.baseplatform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IPlatfomProjectDao;
import com.zhiyu.baseplatform.entity.PlatfomProjectEntity;
import com.zhiyu.baseplatform.service.IPlatformProjectService;

/**
 * 
 * @author wdj
 *
 */
@Service
public class PlatfomProjectServiceImpl implements IPlatformProjectService {

	@Autowired
	private IPlatfomProjectDao dao;
	
	/**
	 * 按实体查询列表
	 * @param entity
	 * @return
	 */
	public List<PlatfomProjectEntity> findByEntity(PlatfomProjectEntity entity){
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<PlatfomProjectEntity> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public PlatfomProjectEntity findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findObjectById(id);
	}

	public void save(PlatfomProjectEntity entity) {
		// TODO Auto-generated method stub
		dao.save(entity);
	}

	public void update(PlatfomProjectEntity entity) {
		// TODO Auto-generated method stub
		dao.update(entity);
	}

	public void del(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteObjectByIds(id);
	}

	public PlatfomProjectEntity merge(PlatfomProjectEntity entity) {
		// TODO Auto-generated method stub
		return dao.merge(entity);
	}
}
