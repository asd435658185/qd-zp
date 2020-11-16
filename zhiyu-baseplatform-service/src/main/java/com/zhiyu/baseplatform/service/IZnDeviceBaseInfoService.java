package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.entity.ZnDeviceBaseInfoEntity;

/**
 * 
 * @author csk
 *
 */
public interface IZnDeviceBaseInfoService {

	 public ZnDeviceBaseInfoEntity findObjectById(Integer id);
		
		public List<ZnDeviceBaseInfoEntity> findByEntity(ZnDeviceBaseInfoEntity entity);
		
		public List<ZnDeviceBaseInfoEntity> findAll();
		
		public void update(ZnDeviceBaseInfoEntity entity);
		
		public void save(ZnDeviceBaseInfoEntity entity);
		
		public void del(Integer ZnDeviceBaseInfoId);
		
		public List<ZnDeviceBaseInfoEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
	}
