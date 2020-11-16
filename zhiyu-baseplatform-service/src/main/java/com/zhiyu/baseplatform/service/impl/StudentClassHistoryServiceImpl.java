package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IStudentClassHistoryDao;
import com.zhiyu.baseplatform.entity.StudentClassHistoryEntity;
import com.zhiyu.baseplatform.service.IStudentClassHistoryService;

/**
 * 
 * @author wdj
 *
 */
@Service
public class StudentClassHistoryServiceImpl implements IStudentClassHistoryService {

	@Autowired
	private IStudentClassHistoryDao dao;
	
	/**
	 * 更新
	 * @param entity
	 */
	public void saveOrUpdate(StudentClassHistoryEntity entity){
		dao.saveOrUpdate(entity);
	}
	
	public List<StudentClassHistoryEntity> findByCondition(String condition, Object[] params, Map<String, String> orderby){
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

	public List<StudentClassHistoryEntity> findByEntity(StudentClassHistoryEntity entity) {
		// TODO Auto-generated method stub
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
