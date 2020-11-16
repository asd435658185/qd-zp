package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.entity.StudentAttendEntity;

public interface IStudentAttendService {

	public StudentAttendEntity findObjectById(Integer id);

	public List<StudentAttendEntity> findByEntity(StudentAttendEntity entity);

	public List<StudentAttendEntity> findAll();

	public void saveOrUpdate(StudentAttendEntity entity);

	public void del(Integer studentAttendId);

	public List<StudentAttendEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);

	public List<StudentAttendEntity> findListByClassId(int termId, int classId, String fromYmd, String endYmd);
}

