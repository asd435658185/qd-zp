package com.zhiyu.baseplatform.service;

import java.util.List;

import com.zhiyu.baseplatform.entity.DayBaseInfoEntity;
/**
 * 
 * @author csk
 *
 */
public interface IDayBaseInfoService {

	public List<DayBaseInfoEntity> findByEntity(DayBaseInfoEntity entity);
	
	public void save(DayBaseInfoEntity entity);
}
