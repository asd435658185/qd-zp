package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IStudentAttendDao;
import com.zhiyu.baseplatform.entity.StudentAttendEntity;
import com.zhiyu.baseplatform.service.IStudentAttendService;

@Service
public class StudentAttendServiceImpl implements IStudentAttendService{

	@Autowired
	private IStudentAttendDao dao;

	public StudentAttendEntity findObjectById(Integer id) {
		StudentAttendEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<StudentAttendEntity> findByEntity(StudentAttendEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<StudentAttendEntity> findAll() {
		return dao.findAll();
	}

	public void saveOrUpdate(StudentAttendEntity entity) {
		dao.saveOrUpdate(entity);
	}

	public void del(Integer studentAttendId) {
		dao.deleteObjectByIds(studentAttendId);
	}

	public List<StudentAttendEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

	/**
	 * 获取班级中所有学生所在期间的考勤信息
	 */
	public List<StudentAttendEntity> findListByClassId(int termId, int classId,  String fromYmd, String endYmd) {
		return dao.findListByClassId(termId, classId, fromYmd, endYmd);
	}

}
