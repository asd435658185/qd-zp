package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zhiyu.baseplatform.entity.ClassBaseInfoEntity;
import com.zhiyu.baseplatform.entity.ClassStudentRelEntity;
import com.zhiyu.baseplatform.entity.StudentBaseInfoEntity;
import com.zhiyu.baseplatform.entity.StudentClassHistoryEntity;
import com.zhiyu.baseplatform.entity.TermBaseInfoEntity;

/**
 * 班级学生关系处理
 * @author wdj
 *
 */
@Service
public class ClassStudentRelationHandler {

	@Autowired
	private SchoolTermHandler schoolTermHandler;
	
	@Autowired
	private IClassStudentRelService classStudentRelService;
	
	@Autowired
	private IStudentClassHistoryService studentClassHistoryService;
	
	@Autowired
	private IStudentBaseInfoService studentBaseInfoService;
	
	@Autowired
	private IClassBaseInfoService classBaseInfoService;
	
	/**
	 * 根据学校id和班级id查询当前班级当前学期的学生班级关联列表
	 * @param schoolId
	 * @param classId
	 * @return
	 */
	public List<ClassStudentRelEntity> findClassStudents(Integer schoolId,Integer classId){
		TermBaseInfoEntity term = schoolTermHandler.getCurrentTermInfoBySchoolId(schoolId);
		ClassStudentRelEntity classStudentEntity = new ClassStudentRelEntity();
		classStudentEntity.setClassId(classId);
		classStudentEntity.setTermId(term.getId());
		List<ClassStudentRelEntity> studentRelList = classStudentRelService.findByEntity(classStudentEntity);
		return studentRelList;
	}
	/**
	 * 获取当前班级下学生列表
	 * @param schoolId
	 * @param classId
	 * @return
	 */
	public ClassBaseInfoEntity findStudentClassById(Integer studentId){
		ClassBaseInfoEntity cb=new ClassBaseInfoEntity();
		ClassStudentRelEntity rel=new ClassStudentRelEntity();
		rel.setStudentId(studentId);
		List<ClassStudentRelEntity> rels = classStudentRelService.findByEntity(rel);
		if(rels!=null&&!rels.isEmpty()){
			cb=classBaseInfoService.findObjectById(rels.get(0).getClassId());
		}
		return cb;
	}
	/**
	 * 获取当前班级下学生列表
	 * @param schoolId
	 * @param classId
	 * @return
	 */
	public List<StudentBaseInfoEntity> findStudentsByClass(Integer schoolId,Integer classId){
		List<ClassStudentRelEntity> rels = findClassStudents(schoolId, classId);
		List<StudentBaseInfoEntity> students = Lists.newArrayList();
		for(ClassStudentRelEntity rel:rels){
			StudentBaseInfoEntity classRelStudent = studentBaseInfoService.findById(rel.getStudentId());
			if(classRelStudent!=null){
				students.add(classRelStudent);
			}
		}
		return students;
	}
	
	/**
	 * 将学生添加到当前学期的班级内
	 * @param studentIds
	 * @param classId
	 */
	public Map<String, Object> addStudentsToCurrenttermClass(Integer schoolId,List<Integer> studentIds,Integer classId,Integer termId){
		Map<String, Object> result = Maps.newConcurrentMap();
		for(Integer id:studentIds){
			ClassStudentRelEntity classStudentEntity = new ClassStudentRelEntity();
			classStudentEntity.setStudentId(id);
			classStudentEntity.setTermId(termId);
			//按学生id查询，判断是否已存在
			if(classStudentRelService.findByEntity(classStudentEntity)!=null 
					&& !classStudentRelService.findByEntity(classStudentEntity).isEmpty()){
				result.put("code", 1);
				result.put("msg", "添加失败，学生:"+studentBaseInfoService.findById(id).getName()+"已有班级！");
				return result;
			}
			ClassStudentRelEntity cs = new ClassStudentRelEntity();
			cs.setStudentId(id);
			cs.setTermId(termId);
			cs.setClassId(classId);
			classStudentRelService.saveOrUpdate(cs);
		}
		result.put("code", 0);
		result.put("msg", "添加成功！");
		return result;
	}
	/**
	 * 班级学生升学处理
	 * @param studentIds
	 * @param classId
	 */
	public Map<String, Object> addStudentsToTermClass(Integer schoolId,List<Integer> studentIds,Integer classId,Integer oldClassId,Integer newTermId,Integer oldTermId){
		Map<String, Object> result = Maps.newConcurrentMap();
		for(Integer id:studentIds){
			ClassStudentRelEntity classStudentEntity = new ClassStudentRelEntity();
			classStudentEntity.setStudentId(id);
			classStudentEntity.setTermId(newTermId);
			List<ClassStudentRelEntity> cs=classStudentRelService.findByEntity(classStudentEntity);
			//按学生id查询，判断是否已存在
			if(cs!=null && !cs.isEmpty()){
				result.put("code", 1);
				result.put("msg", "升学失败，学生:"+studentBaseInfoService.findById(id).getName()+"已有班级！");
				return result;
			}
			ClassStudentRelEntity ce = new ClassStudentRelEntity();
			ce.setStudentId(id);
			ce.setTermId(newTermId);
			ce.setClassId(classId);
			classStudentRelService.saveOrUpdate(ce);
		}
		result.put("code", 0);
		result.put("msg", "升学成功！");
		return result;
	}
	/**
	 * 根据学校id和班级id查询当前班级上个学期的学生班级关联列表(升学操纵)
	 * @param schoolId
	 * @param classId
	 * @return
	 */
	public List<ClassStudentRelEntity> findClassStudentsLastTerms(Integer schoolId,Integer classId){
		TermBaseInfoEntity term = schoolTermHandler.getCurrentTermInfoBySchoolId(schoolId);
		String condition = " and classId=? and termId<? ";
//		Object[] params = new Object[]{classId,term.getId()};
		Map<String, String> sortMap = Maps.newConcurrentMap();
		sortMap.put("termId", "desc");
//		List<StudentClassHistoryEntity> studentRelList = studentClassHistoryService.findByCondition(condition, params, sortMap);
//		return findTermClassStudents(studentRelList.get(0).getTermId().longValue(), schoolId.longValue(), classId.longValue());
		return classStudentRelService.findByCondition(condition, new Object[]{classId.intValue(),term.getId().intValue()}, null);
	}
	
	/**
	 * 查询学期下班级的学生
	 * @param qryTermId
	 * @param schoolId
	 * @param classId
	 * @return
	 */
	public List<ClassStudentRelEntity> findTermClassStudents(Long qryTermId,Long schoolId,Long classId){
		Long currentTermId = schoolTermHandler.getCurrentTermInfoBySchoolId(schoolId.intValue()).getId().longValue();
		if(currentTermId.longValue()==qryTermId.longValue()){
			return classStudentRelService.findByCondition(" and classId=? and termId=? ", new Object[]{classId.intValue(),qryTermId.intValue()}, null);
		}else{
			List<StudentClassHistoryEntity> students = studentClassHistoryService.findByCondition(" and classId=? and termId=? and schoolId=? ", new Object[]{classId.intValue(),qryTermId.intValue(),schoolId.intValue()}, null);
			List<ClassStudentRelEntity> rels = Lists.newArrayList();
			for(StudentClassHistoryEntity e:students){
				ClassStudentRelEntity rel = new ClassStudentRelEntity();
				rel.setRelId(e.getId().intValue());
				rel.setClassId(e.getClassId());
				rel.setStudentId(e.getStudentId());
				rel.setTermId(e.getTermId());
				rels.add(rel);
			}
			if(!rels.isEmpty()){
				return rels;
			}else{
				return classStudentRelService.findByCondition(" and classId=? and termId=? ", new Object[]{classId.intValue(),qryTermId.intValue()}, null);
			}
		}
	}
	
	/**
	 * 查询学期学生对应的班级关联信息
	 * @param qryTermId
	 * @param schoolId
	 * @param classId
	 * @return
	 */
	public List<ClassStudentRelEntity> findTermStudentClass(Long qryTermId,Long schoolId,Long studentId){
		Long currentTermId = schoolTermHandler.getCurrentTermInfoBySchoolId(schoolId.intValue()).getId().longValue();
		if(currentTermId.longValue()==qryTermId.longValue()){
			return classStudentRelService.findByCondition(" and studentId=? and termId=? ", new Object[]{studentId.intValue(),qryTermId.intValue()}, null);
		}else{
			List<StudentClassHistoryEntity> students = studentClassHistoryService.findByCondition(" and studentId=? and termId=? and schoolId=? ", new Object[]{studentId.intValue(),qryTermId.intValue(),schoolId.intValue()}, null);
			List<ClassStudentRelEntity> rels = Lists.newArrayList();
			for(StudentClassHistoryEntity e:students){
				ClassStudentRelEntity rel = new ClassStudentRelEntity();
				rel.setClassId(e.getClassId());
				rel.setStudentId(e.getStudentId());
				rel.setTermId(e.getTermId());
				rels.add(rel);
			}
			return rels;
		}
	}
}
