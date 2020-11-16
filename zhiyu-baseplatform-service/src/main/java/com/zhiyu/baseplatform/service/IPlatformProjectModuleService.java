package com.zhiyu.baseplatform.service;

import java.util.List;
import com.zhiyu.baseplatform.entity.PlatformProjectModuleEntity;

/**
 * 
 * @author wdj
 *
 */

public interface IPlatformProjectModuleService {
	public List<PlatformProjectModuleEntity> findByEntity(PlatformProjectModuleEntity entity);
	public PlatformProjectModuleEntity findById(Integer id);
	public List<PlatformProjectModuleEntity> findAll();
	public void save(PlatformProjectModuleEntity entity);
	public void update(PlatformProjectModuleEntity entity);
	public void del(Integer id);
	public PlatformProjectModuleEntity merge(PlatformProjectModuleEntity entity);
}
