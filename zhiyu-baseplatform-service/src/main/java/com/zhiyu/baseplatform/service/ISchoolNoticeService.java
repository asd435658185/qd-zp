package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.bean.PageBean;
import com.zhiyu.baseplatform.entity.SchoolNoticeEntity;

/**
 * 学校通知服务
 * @author csk
 *
 */
public interface ISchoolNoticeService {

	public SchoolNoticeEntity findObjectById(Integer id);
	
	public List<SchoolNoticeEntity> findByEntity(SchoolNoticeEntity entity);
	
	public List<SchoolNoticeEntity> findAll();
	
	public void update(SchoolNoticeEntity entity);
	
	public void save(SchoolNoticeEntity entity);
	
	public void del(Integer SchoolNoticeId);
	
	public List<SchoolNoticeEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);

    public PageBean<SchoolNoticeEntity> findPage(String condition, Object[] params, PageBean<SchoolNoticeEntity> page,Map<String, String> orderby);
	
	public PageBean<SchoolNoticeEntity> findPageByEntity(SchoolNoticeEntity entity,PageBean<SchoolNoticeEntity> page) throws Exception;
	
	/**
	 * 根据分页条件获取信息
	 * @param entity
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public PageBean<SchoolNoticeEntity> findPageByEntityWithSort(SchoolNoticeEntity entity,PageBean<SchoolNoticeEntity> page,Map<String, String> sortMap) throws Exception;
}
