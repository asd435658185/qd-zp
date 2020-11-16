package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.entity.ZnStudentParentDeviceRelEntity;
/**
 * 
 * @author csk
 *
 */
public interface IZnStudentParentDeviceRelService {

	 public ZnStudentParentDeviceRelEntity findObjectById(Integer id);
		
		public List<ZnStudentParentDeviceRelEntity> findByEntity(ZnStudentParentDeviceRelEntity entity);
		
		public List<ZnStudentParentDeviceRelEntity> findAll();
		
		public void update(ZnStudentParentDeviceRelEntity entity);
		
		public void save(ZnStudentParentDeviceRelEntity entity);
		
		public void del(Integer ZnStudentParentDeviceRelId);
		
		public List<ZnStudentParentDeviceRelEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
	}
