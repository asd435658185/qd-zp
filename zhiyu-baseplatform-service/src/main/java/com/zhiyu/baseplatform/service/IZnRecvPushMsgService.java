package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.entity.ZnRecvPushMsgEntity;

/**
 *
 * @author csk
 *
 */
public interface IZnRecvPushMsgService {

	 public ZnRecvPushMsgEntity findObjectById(Integer id);

		public List<ZnRecvPushMsgEntity> findByEntity(ZnRecvPushMsgEntity entity);

		public List<ZnRecvPushMsgEntity> findAll();

		public void update(ZnRecvPushMsgEntity entity);

		public void save(ZnRecvPushMsgEntity entity);

		public void del(Integer ZnSportsMonthId);

		public List<ZnRecvPushMsgEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
	}
