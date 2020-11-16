package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.bean.PageBean;
import com.zhiyu.baseplatform.entity.HomeworkNoticeEntity;

/**
 * 作业通知服务
 * @author csk
 *
 */
public interface IHomeworkNoticeService {

	public HomeworkNoticeEntity findObjectById(Integer id);
	
	public List<HomeworkNoticeEntity> findByEntity(HomeworkNoticeEntity entity);
	
	public List<HomeworkNoticeEntity> findAll();
	
	public void update(HomeworkNoticeEntity entity);
	
	public void save(HomeworkNoticeEntity entity);
	
	public void del(Integer HomeworkNoticeId);
	
	public List<HomeworkNoticeEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);

	public PageBean<HomeworkNoticeEntity> findPage(String condition, Object[] params, PageBean<HomeworkNoticeEntity> page,Map<String, String> orderby);
	
	public PageBean<HomeworkNoticeEntity> findPageByEntity(HomeworkNoticeEntity entity,PageBean<HomeworkNoticeEntity> page) throws Exception;
	
	/**
	 * 根据分页条件获取信息
	 * @param entity
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public PageBean<HomeworkNoticeEntity> findPageByEntityWithSort(HomeworkNoticeEntity entity,PageBean<HomeworkNoticeEntity> page,Map<String, String> sortMap) throws Exception;
}
