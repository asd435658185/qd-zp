package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.INoticeLogDao;
import com.zhiyu.baseplatform.entity.NoticeLogEntity;
import com.zhiyu.baseplatform.service.INoticeLogService;

/**
*
* @author csk
*
*/
@Service
public class NoticeLogServiceImpl implements INoticeLogService{

	@Autowired
	private INoticeLogDao dao;

	public NoticeLogEntity findObjectById(Integer id) {
		NoticeLogEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<NoticeLogEntity> findByEntity(NoticeLogEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<NoticeLogEntity> findAll() {
		return dao.findAll();
	}

	public void update(NoticeLogEntity entity) {
		dao.update(entity);
	}

	public void save(NoticeLogEntity entity) {
		dao.save(entity);
	}

	public void del(Integer noticeLogId) {
		dao.deleteObjectByIds(noticeLogId);
	}

	public List<NoticeLogEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

}
