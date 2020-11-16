package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.ITeacherBaseInfoDao;
import com.zhiyu.baseplatform.bean.PageBean;
import com.zhiyu.baseplatform.entity.TeacherBaseInfoEntity;
import com.zhiyu.baseplatform.service.ITeacherBaseInfoService;
/**
 *
 * @author csk
 *
 */
@Service
public class TeacherBaseInfoServiceImpl implements ITeacherBaseInfoService{

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ITeacherBaseInfoDao dao;

	public List<TeacherBaseInfoEntity> findByEntity(TeacherBaseInfoEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			logger.info("查询教师实体时出现异常，异常信息为:{}", e);
		}
		return null;
	}

	public void save(TeacherBaseInfoEntity entity) {
		dao.save(entity);
	}


	public TeacherBaseInfoEntity findObjectById(Integer id) {
		TeacherBaseInfoEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<TeacherBaseInfoEntity> findAll() {
		return dao.findAll();
	}

	public void update(TeacherBaseInfoEntity entity) {
		dao.update(entity);
	}

	public void del(Integer TeacherBaseInfoId) {
		dao.deleteObjectByIds(TeacherBaseInfoId);
	}

	public List<TeacherBaseInfoEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

	@Transactional
	public TeacherBaseInfoEntity saveEntity(TeacherBaseInfoEntity entity) {
		return dao.merge(entity);
	}

	public PageBean<TeacherBaseInfoEntity> findPageByEntity(TeacherBaseInfoEntity entity,
			PageBean<TeacherBaseInfoEntity> page) throws Exception {
		return dao.findPageByEntity(entity, page);
	}

	public void saveOrUpdate(TeacherBaseInfoEntity entity) {
		dao.saveOrUpdate(entity);
	}

	public PageBean<TeacherBaseInfoEntity> findPage(String condition, Object[] params,
			PageBean<TeacherBaseInfoEntity> page, Map<String, String> orderby) {
		return	dao.findPage(condition, params, page, orderby);
	}

	public List findBySQL(String sql) {
		// TODO Auto-generated method stub
		return dao.findBySQL(sql);
	}

}
