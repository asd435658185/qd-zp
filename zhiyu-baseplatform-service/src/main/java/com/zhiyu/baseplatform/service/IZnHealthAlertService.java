package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.entity.ZnHealthAlertEntity;

public interface IZnHealthAlertService {

	 public ZnHealthAlertEntity findObjectById(Integer id);

		public List<ZnHealthAlertEntity> findByEntity(ZnHealthAlertEntity entity);

		public List<ZnHealthAlertEntity> findAll();

		public void update(ZnHealthAlertEntity entity);

		public void save(ZnHealthAlertEntity entity);

		public void del(Integer ZnDeviceBaseInfoId);

		public List<ZnHealthAlertEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
}
