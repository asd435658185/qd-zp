package com.zhiyu.baseplatform.service;

import java.util.List;
import com.zhiyu.baseplatform.entity.PlatformSchoolPurchaseProjectEntity;

/**
 * 
 * @author wdj
 *
 */

public interface IPlatformSchoolPurchaseProjectService {
	public List<PlatformSchoolPurchaseProjectEntity> findByEntity(PlatformSchoolPurchaseProjectEntity entity);
	public void saveOrUpdate(PlatformSchoolPurchaseProjectEntity entity);
	public List<PlatformSchoolPurchaseProjectEntity> findAll();
	public PlatformSchoolPurchaseProjectEntity findById(Integer id);
	public void save(PlatformSchoolPurchaseProjectEntity entity);
	public void update(PlatformSchoolPurchaseProjectEntity entity);
	public void del(Integer id);
	public PlatformSchoolPurchaseProjectEntity merge(PlatformSchoolPurchaseProjectEntity entity);
}
