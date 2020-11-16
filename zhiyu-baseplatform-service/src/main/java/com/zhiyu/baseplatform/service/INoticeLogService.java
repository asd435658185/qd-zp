package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.entity.NoticeLogEntity;

/**
 * 
 * @author csk
 *
 */
public interface INoticeLogService {
	
	public NoticeLogEntity findObjectById(Integer id);
	
	public List<NoticeLogEntity> findByEntity(NoticeLogEntity entity);
	
	public List<NoticeLogEntity> findAll();
	
	public void update(NoticeLogEntity entity);
	
	public void save(NoticeLogEntity entity);
	
	public void del(Integer noticeLogId);
	
	public List<NoticeLogEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
}
