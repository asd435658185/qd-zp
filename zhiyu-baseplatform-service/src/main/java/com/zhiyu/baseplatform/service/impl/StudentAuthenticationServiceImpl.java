package com.zhiyu.baseplatform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IStudentAuthenticationDao;
import com.zhiyu.baseplatform.entity.StudentAuthenticationEntity;
import com.zhiyu.baseplatform.service.IStudentAuthenticationService;
/**
 *
 * @author csk
 *
 */
@Service
public class StudentAuthenticationServiceImpl implements IStudentAuthenticationService{

	@Autowired
	private IStudentAuthenticationDao dao;

	public List<StudentAuthenticationEntity> findByEntity(StudentAuthenticationEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 通过md5加密的学号，扫码登录
	 * @param md5
	 * @param schoolId
	 * @return
	 */
	public StudentAuthenticationEntity findEntityByMd5LoginAccount(String md5,Integer schoolId){
		String sql = " and md5(loginAccount)=? and  schoolId=? ";
		List<StudentAuthenticationEntity> list = dao.findListByConditionWithNoPage(sql, new Object[]{md5, schoolId},null);
		if(list!=null && !list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	public StudentAuthenticationEntity findObjectById(Integer id) {
		StudentAuthenticationEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public StudentAuthenticationEntity saveOrUpdate(StudentAuthenticationEntity entity) {
		dao.saveOrUpdate(entity);
		return entity;
	}

	public void delete(Integer id) {
		dao.deleteObjectByIds(id);
	}

	public List<StudentAuthenticationEntity> findAll() {
		return dao.findAll();
	}

	public void save(StudentAuthenticationEntity entity) {
		dao.save(entity);
	}


}

