package com.zhiyu.baseplatform.service;

import java.util.List;

import com.zhiyu.baseplatform.entity.StudentAuthenticationEntity;

/**
 * 
 * @author csk
 *
 */
public interface IStudentAuthenticationService {

	public List<StudentAuthenticationEntity> findByEntity(StudentAuthenticationEntity entity);
	
	public void save(StudentAuthenticationEntity entity);
	
	public List<StudentAuthenticationEntity> findAll();
	/**
	    * 通过ID查询
	    * @param id
	    * @return
	   */
	public StudentAuthenticationEntity findObjectById(Integer id);
	    
	public StudentAuthenticationEntity saveOrUpdate(StudentAuthenticationEntity entity);
	
	public void delete(Integer id);
	
	/**
	 * 通过md5加密的学号，扫码登录
	 * @param md5
	 * @param schoolId
	 * @return
	 */
	public StudentAuthenticationEntity findEntityByMd5LoginAccount(String md5,Integer schoolId);
}
