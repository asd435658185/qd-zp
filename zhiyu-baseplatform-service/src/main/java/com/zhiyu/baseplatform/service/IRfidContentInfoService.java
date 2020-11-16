package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.entity.RfidContentInfoEntity;

public interface IRfidContentInfoService {

	public RfidContentInfoEntity findObjectById(Integer id);

	public List<RfidContentInfoEntity> findByEntity(RfidContentInfoEntity entity);

	public List<RfidContentInfoEntity> findAll();

	public void update(RfidContentInfoEntity entity);

	public void save(RfidContentInfoEntity entity);

	public void del(Integer id);

	public List<RfidContentInfoEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
}
