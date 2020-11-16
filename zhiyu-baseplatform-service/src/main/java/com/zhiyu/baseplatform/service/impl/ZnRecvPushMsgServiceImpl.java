package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IZnRecvPushMsgDao;
import com.zhiyu.baseplatform.entity.ZnRecvPushMsgEntity;
import com.zhiyu.baseplatform.service.IZnRecvPushMsgService;

/**
 *
 * @author csk
 *
 */
@Service
public class ZnRecvPushMsgServiceImpl implements IZnRecvPushMsgService{

	@Autowired
	private IZnRecvPushMsgDao dao;

	public ZnRecvPushMsgEntity findObjectById(Integer id) {
		ZnRecvPushMsgEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<ZnRecvPushMsgEntity> findByEntity(ZnRecvPushMsgEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ZnRecvPushMsgEntity> findAll() {
		return dao.findAll();
	}

	public void update(ZnRecvPushMsgEntity entity) {
		dao.update(entity);
	}

	public void save(ZnRecvPushMsgEntity entity) {
		dao.save(entity);
	}

	public void del(Integer znSportsMonthId) {
		dao.deleteObjectByIds(znSportsMonthId);
	}

	public List<ZnRecvPushMsgEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

}
