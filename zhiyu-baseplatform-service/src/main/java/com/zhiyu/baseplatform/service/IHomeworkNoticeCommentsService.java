package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;
import com.zhiyu.baseplatform.entity.HomeworkNoticeCommentsEntity;
/**
 * 
 * @author csk
 *
 */
public interface IHomeworkNoticeCommentsService {

	public HomeworkNoticeCommentsEntity findObjectById(Integer id);
	
	public List<HomeworkNoticeCommentsEntity> findByEntity(HomeworkNoticeCommentsEntity entity);
	
	public List<HomeworkNoticeCommentsEntity> findAll();
	
	public void update(HomeworkNoticeCommentsEntity entity);
	
	public void save(HomeworkNoticeCommentsEntity entity);
	
	public void del(Integer HomeworkNoticeCommentsId);
	
	public List<HomeworkNoticeCommentsEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
}
