package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.entity.SchoolNoticeCommentsEntity;

/**
 * 
 * @author csk
 *
 */
public interface ISchoolNoticeCommentsService {

	public SchoolNoticeCommentsEntity findObjectById(Integer id);
	
	public List<SchoolNoticeCommentsEntity> findByEntity(SchoolNoticeCommentsEntity entity);
	
	public List<SchoolNoticeCommentsEntity> findAll();
	
	public void update(SchoolNoticeCommentsEntity entity);
	
	public void save(SchoolNoticeCommentsEntity entity);
	
	public void del(Integer SchoolNoticeCommentsId);
	
	public List<SchoolNoticeCommentsEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
}