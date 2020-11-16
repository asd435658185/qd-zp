package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IStudentBaseInfoDao;
import com.zhiyu.baseplatform.bean.PageBean;
import com.zhiyu.baseplatform.entity.StudentBaseInfoEntity;
import com.zhiyu.baseplatform.service.IStudentBaseInfoService;

/**
 *
 * @author csk
 *
 */
@Service
public class StudentBaseInfoServiceImpl implements IStudentBaseInfoService{

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IStudentBaseInfoDao dao;

	public List<StudentBaseInfoEntity> findByEntity(StudentBaseInfoEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			logger.info("查询学生基础信息出异常，异常信息为:", e);
		}
		return null;
	}

	public PageBean<StudentBaseInfoEntity> findPage(String condition,  Object[] params, PageBean<StudentBaseInfoEntity> page,Map<String, String> orderby){
		return dao.findPage(condition, params, page, orderby);
	}

	public PageBean<StudentBaseInfoEntity> findPageByEntity(StudentBaseInfoEntity entity,PageBean<StudentBaseInfoEntity> page) throws Exception{
		return dao.findPageByEntity(entity, page);
	}

	public void save(StudentBaseInfoEntity entity) {
		dao.save(entity);
	}
	public void update(StudentBaseInfoEntity entity) {
		dao.update(entity);
	}
	public StudentBaseInfoEntity findById(Integer id) {
		StudentBaseInfoEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public void saveOrUpdate(StudentBaseInfoEntity entity){
		try {
			dao.saveOrUpdate(entity);
		} catch (Exception e) {
			logger.error("更新出现异常，异常信息为{}",e.getMessage());
		}
	}

	public void deleteById(Integer id){
		dao.deleteObjectByIds(id);
	}

	public List<StudentBaseInfoEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

	public List<StudentBaseInfoEntity> findAll() {
		return dao.findAll();
	}

	public StudentBaseInfoEntity merge(StudentBaseInfoEntity entity) {
		// TODO Auto-generated method stub
		return dao.merge(entity);
	}
}