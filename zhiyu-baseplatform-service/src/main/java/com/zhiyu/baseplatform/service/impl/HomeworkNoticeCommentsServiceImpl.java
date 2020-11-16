package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhiyu.baseplatform.dao.IHomeworkNoticeCommentsDao;
import com.zhiyu.baseplatform.entity.HomeworkNoticeCommentsEntity;
import com.zhiyu.baseplatform.service.IHomeworkNoticeCommentsService;

/**
 *
 * @author csk
 *
 */
@Service
public class HomeworkNoticeCommentsServiceImpl implements IHomeworkNoticeCommentsService{

	@Autowired
	private IHomeworkNoticeCommentsDao dao;

	public HomeworkNoticeCommentsEntity findObjectById(Integer id) {
		HomeworkNoticeCommentsEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<HomeworkNoticeCommentsEntity> findByEntity(HomeworkNoticeCommentsEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<HomeworkNoticeCommentsEntity> findAll() {
		return dao.findAll();
	}

	public void update(HomeworkNoticeCommentsEntity entity) {
		dao.update(entity);
	}

	public void save(HomeworkNoticeCommentsEntity entity) {
		dao.save(entity);
	}

	public void del(Integer homeworkNoticeCommentsId) {
		dao.deleteObjectByIds(homeworkNoticeCommentsId);
	}

	public List<HomeworkNoticeCommentsEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}
}
