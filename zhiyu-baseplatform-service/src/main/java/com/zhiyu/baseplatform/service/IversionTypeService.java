package com.zhiyu.baseplatform.service;

import java.util.List;

import com.zhiyu.baseplatform.entity.VersionTypeEntity;
/**
 * 
 * @author csk
 *
 */
public interface IversionTypeService {

	public List<VersionTypeEntity> findByEntity(VersionTypeEntity entity);
	
	public void save(VersionTypeEntity entity);
}
