package com.zhiyu.baseplatform.service;

import java.util.List;

import com.zhiyu.baseplatform.entity.PlatfomProjectEntity;

/**
 * 
 * @author wdj
 *
 */

public interface IPlatformProjectService {
	public List<PlatfomProjectEntity> findByEntity(PlatfomProjectEntity entity);
	public List<PlatfomProjectEntity> findAll();
	public PlatfomProjectEntity findById(Integer id);
	public void save(PlatfomProjectEntity entity);
	public void update(PlatfomProjectEntity entity);
	public void del(Integer id);
	public PlatfomProjectEntity merge(PlatfomProjectEntity entity);
}
