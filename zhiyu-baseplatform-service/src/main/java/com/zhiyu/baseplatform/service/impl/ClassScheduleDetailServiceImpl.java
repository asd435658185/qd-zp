package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhiyu.baseplatform.dao.IClassScheduleDetailDao;
import com.zhiyu.baseplatform.entity.ClassScheduleDetailEntity;
import com.zhiyu.baseplatform.service.IClassScheduleDetailService;

/**
 *
 * @author csk
 *
 */
@Service
public class ClassScheduleDetailServiceImpl implements IClassScheduleDetailService{

	@Autowired
	private IClassScheduleDetailDao dao;

	public List<ClassScheduleDetailEntity> findByEntity(ClassScheduleDetailEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save(ClassScheduleDetailEntity entity) {
		dao.save(entity);
	}

	public ClassScheduleDetailEntity findObjectById(Integer id) {
		ClassScheduleDetailEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<ClassScheduleDetailEntity> findAll() {
		return dao.findAll();
	}

	public void update(ClassScheduleDetailEntity entity) {
		dao.update(entity);
	}

	public void del(Integer classScheduleDetailId) {
		dao.deleteObjectByIds(classScheduleDetailId);
	}

	public List<ClassScheduleDetailEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

}
