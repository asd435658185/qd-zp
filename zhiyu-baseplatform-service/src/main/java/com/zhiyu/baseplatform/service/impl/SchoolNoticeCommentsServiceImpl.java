package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhiyu.baseplatform.dao.ISchoolNoticeCommentsDao;
import com.zhiyu.baseplatform.entity.SchoolNoticeCommentsEntity;
import com.zhiyu.baseplatform.service.ISchoolNoticeCommentsService;

/**
 *
 * @author csk
 *
 */
@Service
public class SchoolNoticeCommentsServiceImpl implements ISchoolNoticeCommentsService{

	@Autowired
	private ISchoolNoticeCommentsDao dao;

	public SchoolNoticeCommentsEntity findObjectById(Integer id) {
		SchoolNoticeCommentsEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<SchoolNoticeCommentsEntity> findByEntity(SchoolNoticeCommentsEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<SchoolNoticeCommentsEntity> findAll() {
		return dao.findAll();
	}

	public void update(SchoolNoticeCommentsEntity entity) {
		dao.update(entity);
	}

	public void save(SchoolNoticeCommentsEntity entity) {
		dao.save(entity);
	}

	public void del(Integer schoolNoticeCommentsId) {
		dao.deleteObjectByIds(schoolNoticeCommentsId);
	}

	public List<SchoolNoticeCommentsEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}
}
