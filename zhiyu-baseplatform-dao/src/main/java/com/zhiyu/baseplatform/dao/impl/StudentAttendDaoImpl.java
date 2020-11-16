package com.zhiyu.baseplatform.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.zhiyu.baseplatform.dao.IStudentAttendDao;
import com.zhiyu.baseplatform.dao.base.impl.CommonDaoImpl;
import com.zhiyu.baseplatform.entity.StudentAttendEntity;

@Repository
public class StudentAttendDaoImpl  extends CommonDaoImpl<StudentAttendEntity> implements IStudentAttendDao{

	/**
	 * 获取班级中所有学生所在期间的考勤信息
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<StudentAttendEntity> findListByClassId(int termId, int classId, String fromYmd, String endYmd) {

		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT b                            ");
		sb.append("   FROM ClassStudentRelEntity as a   ");
		sb.append("       ,StudentAttendEntity as b     ");
		sb.append("  WHERE a.studentId = b.studentId    ");
		sb.append("    AND a.classId = ?                ");
		sb.append("    AND a.termId  = ?                ");
		sb.append("    AND b.attendYmd BETWEEN ? AND ?  ");
		sb.append("  ORDER BY b.attendYmd               ");

		final String finalHql = sb.toString();
		final Object[] params = new Object[] {classId, termId, fromYmd, endYmd};
		List<StudentAttendEntity> list = (List<StudentAttendEntity>) this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(finalHql);
				if (params != null && params.length > 0) {
					for (int i = 0; i < params.length; i++) {
						query.setParameter(i, params[i]);
					}
				}
				return query.list();
			}
		});

		return list;
	}
}
