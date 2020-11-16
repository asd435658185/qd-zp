package com.zhiyu.baseplatform.dao;

import java.util.List;

import com.zhiyu.baseplatform.dao.base.ICommonDao;
import com.zhiyu.baseplatform.entity.StudentAttendEntity;

public interface IStudentAttendDao extends ICommonDao<StudentAttendEntity>{

	public List<StudentAttendEntity> findListByClassId(int termId, int classId, String fromYmd, String endYmd);
}
