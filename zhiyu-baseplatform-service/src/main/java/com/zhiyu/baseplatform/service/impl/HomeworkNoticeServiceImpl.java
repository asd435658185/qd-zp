package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IHomeworkNoticeDao;
import com.zhiyu.baseplatform.bean.PageBean;
import com.zhiyu.baseplatform.entity.HomeworkNoticeEntity;
import com.zhiyu.baseplatform.service.IHomeworkNoticeService;
/**
 *
 * @author csk
 *
 */
@Service
public class HomeworkNoticeServiceImpl implements IHomeworkNoticeService{

	@Autowired
	private IHomeworkNoticeDao dao;

	public HomeworkNoticeEntity findObjectById(Integer id) {
		HomeworkNoticeEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<HomeworkNoticeEntity> findByEntity(HomeworkNoticeEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<HomeworkNoticeEntity> findAll() {
		return dao.findAll();
	}

	public void update(HomeworkNoticeEntity entity) {
		dao.update(entity);
	}

	public void save(HomeworkNoticeEntity entity) {
		dao.save(entity);
	}

	public void del(Integer homeworkNoticeId) {
		dao.deleteObjectByIds(homeworkNoticeId);
	}

	public List<HomeworkNoticeEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

	public PageBean<HomeworkNoticeEntity> findPage(String condition, Object[] params,
			PageBean<HomeworkNoticeEntity> page, Map<String, String> orderby) {
		return dao.findPage(condition, params, page, orderby);
	}

	public PageBean<HomeworkNoticeEntity> findPageByEntity(HomeworkNoticeEntity entity,
			PageBean<HomeworkNoticeEntity> page) throws Exception {
		return dao.findPageByEntity(entity, page);
	}

	/**
	 * 根据分页条件获取信息
	 * @param entity
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public PageBean<HomeworkNoticeEntity> findPageByEntityWithSort(HomeworkNoticeEntity entity,PageBean<HomeworkNoticeEntity> page,Map<String, String> sortMap) throws Exception{
		return dao.findPageByEntityWithSort(entity, page, sortMap);
	}
}
