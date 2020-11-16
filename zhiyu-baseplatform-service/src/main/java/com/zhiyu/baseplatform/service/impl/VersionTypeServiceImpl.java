package com.zhiyu.baseplatform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IVersionTypeDao;
import com.zhiyu.baseplatform.entity.VersionTypeEntity;
import com.zhiyu.baseplatform.service.IversionTypeService;

/**
 * 
 * @author csk
 *
 */
@Service
public class VersionTypeServiceImpl implements IversionTypeService{
	
	@Autowired
	private IVersionTypeDao dao;
	
	public List<VersionTypeEntity> findByEntity(VersionTypeEntity entity) {
		return dao.findAll();
	}

	public void save(VersionTypeEntity entity) {
		dao.save(entity);
	}

}

