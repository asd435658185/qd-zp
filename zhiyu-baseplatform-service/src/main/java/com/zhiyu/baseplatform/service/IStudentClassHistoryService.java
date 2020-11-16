package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;
import com.zhiyu.baseplatform.entity.StudentClassHistoryEntity;

/**
 * 
 * @author wdj
 *
 */

public interface IStudentClassHistoryService {

	/**
	 * 更新
	 * @param entity
	 */
	public void saveOrUpdate(StudentClassHistoryEntity entity);
	
	public List<StudentClassHistoryEntity> findByCondition(String condition, Object[] params, Map<String, String> orderby);

	public List<StudentClassHistoryEntity> findByEntity(StudentClassHistoryEntity entity);
	
}
