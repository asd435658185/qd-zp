package com.zhiyu.baseplatform.service;

import java.util.List;

import com.zhiyu.baseplatform.entity.StudentCardEntity;


public interface StudentCardService {
	/**
	    * 通过ID查询
	    * @param id
	    * @return
	   */
	public StudentCardEntity findObjectById(Integer id);
	    
	public void saveOrUpdate(StudentCardEntity entity);
	
	public List<StudentCardEntity> findByEntity(StudentCardEntity entity);
	
	/**
	 * 获取所有记录
	 * @return
	 */
	public List<StudentCardEntity> findAll();
}
