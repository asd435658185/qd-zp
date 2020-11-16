package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.zhiyu.baseplatform.entity.ClassTeacherRelEntity;
import com.zhiyu.baseplatform.entity.TeacherBaseInfoEntity;
import com.zhiyu.baseplatform.entity.TermBaseInfoEntity;
import com.zhiyu.baseplatform.enumcode.FocusState;

/**
 * 班级教师关系处理
 * @author wdj
 *
 */
@Service
public class ClassTeacherRelationHandler {

	@Autowired
	private SchoolTermHandler schoolTermHandler;
	
	@Autowired
	private IClassTeacherRelService classTeacherRelService;
	
	@Autowired
	private ITeacherBaseInfoService teacherBaseInfoService;
	
	/**
	 * 根据学校id和班级id查询当前班级当前学期的教师班级关联列表
	 * @param schoolId
	 * @param classId
	 * @return
	 */
	public List<ClassTeacherRelEntity> findClassTeachers(Integer schoolId,Integer classId,Integer termId){
		ClassTeacherRelEntity classTeacherEntity = new ClassTeacherRelEntity();
		classTeacherEntity.setClassId(classId);
		if(termId==null){
			TermBaseInfoEntity term = schoolTermHandler.getCurrentTermInfoBySchoolId(schoolId);
			classTeacherEntity.setTermId(term.getId());
		}else{
			classTeacherEntity.setTermId(termId);
		}
		List<ClassTeacherRelEntity> teacherRelList = classTeacherRelService.findByEntity(classTeacherEntity);
		return teacherRelList;
	}
	
	/**
	 * 将教师添加到当前学期的班级内
	 * @param schoolId
	 * @param teacherIds
	 * @param classId
	 */
	public Map<String, Object> addTeachersToCurrentTermClass(Integer schoolId,List<Integer> teacherIds,Integer classId,Integer newTermId){
		Map<String, Object> result = Maps.newConcurrentMap();
		for(Integer id:teacherIds){
			ClassTeacherRelEntity classTeacherEntity = new ClassTeacherRelEntity();
			classTeacherEntity.setTeacherId(id);
			classTeacherEntity.setTermId(newTermId);
			classTeacherEntity.setClassId(classId);
			List<ClassTeacherRelEntity> entityList = classTeacherRelService.findByEntity(classTeacherEntity);
			if(entityList==null || entityList.isEmpty()){
				//将其他关注班级都设置成非当前关注班级
				ClassTeacherRelEntity classTeacher = new ClassTeacherRelEntity();
				classTeacher.setTeacherId(id);
				List<ClassTeacherRelEntity> entitys = classTeacherRelService.findByEntity(classTeacher);
				if(entitys!=null && !entitys.isEmpty()){
					for(ClassTeacherRelEntity c:entitys){
						c.setCurfocus(0);
						classTeacherRelService.saveOrUpdate(c);
					}
				}
				//默认新增为当前关注班级
				classTeacherEntity.setCurfocus(1);
				classTeacherRelService.saveOrUpdate(classTeacherEntity);
			}else{
				result.put("code", 1);
				result.put("msg", "添加失败，老师:"+teacherBaseInfoService.findObjectById(id).getName()+"已升学到该班级！");
				return result;
			}
		}
		result.put("code", 0);
		result.put("msg", "添加成功！");
		return result;
	}
	/**
	 * 批量升学班级老师
	 * @param schoolId
	 * @param teacherIds
	 * @param classId
	 */
	public Map<String, Object> addTeachersToTermClass(Integer schoolId,List<Integer> teacherIds,
			Integer classId,Integer oldClassId,Integer newTermId,Integer oldTermId){
		Map<String, Object> result = Maps.newConcurrentMap();
		for(Integer id:teacherIds){
			ClassTeacherRelEntity classTeacherEntity = new ClassTeacherRelEntity();
			classTeacherEntity.setTeacherId(id);
			classTeacherEntity.setTermId(newTermId);
			classTeacherEntity.setClassId(classId);
			List<ClassTeacherRelEntity> entityList = classTeacherRelService.findByEntity(classTeacherEntity);
			if(entityList==null || entityList.isEmpty()){
				//将其他关注班级都设置成非当前关注班级
				ClassTeacherRelEntity classTeacher = new ClassTeacherRelEntity();
				classTeacher.setTeacherId(id);
				List<ClassTeacherRelEntity> entitys = classTeacherRelService.findByEntity(classTeacher);
				if(entitys!=null && !entitys.isEmpty()){
					for(ClassTeacherRelEntity c:entitys){
						c.setCurfocus(0);
						classTeacherRelService.saveOrUpdate(c);
					}
				}
				//默认新增为当前关注班级
				classTeacherEntity.setCurfocus(1);
				classTeacherRelService.saveOrUpdate(classTeacherEntity);
			}else{
				result.put("code", 1);
				result.put("msg", "升学失败，老师:"+teacherBaseInfoService.findObjectById(id).getName()+"已升学到该班级！");
				return result;
			}
		}
		result.put("code", 0);
		result.put("msg", "升学成功！");
		return result;
	}
	/**
	 * 获取当前学期内教师当前关注的班级关联数据
	 * @param teacherId
	 * @return
	 */
	public ClassTeacherRelEntity findCurrentFocusClassTeacherRel(Integer teacherId){
		ClassTeacherRelEntity t = new ClassTeacherRelEntity();
		t.setTeacherId(teacherId);
		TeacherBaseInfoEntity teacher = teacherBaseInfoService.findObjectById(teacherId);
		TermBaseInfoEntity term = schoolTermHandler.getCurrentTermInfoBySchoolId(teacher.getSchoolId());
		t.setTermId(term.getId());
		t.setCurfocus(FocusState.FOCUSED.getValue());
		List<ClassTeacherRelEntity> classTeacherList=classTeacherRelService.findByEntity(t);
		if(classTeacherList!=null&&!classTeacherList.isEmpty()){
			return classTeacherList.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 获取某个学期下班级教师关联的列表(注意这里只是教师及班级关联，这有记录就说明教师对某一个班级有关注，默认的当前关注状态为未关注)
	 * @param teacherId
	 * @param termId
	 * @return
	 */
	public List<ClassTeacherRelEntity> findTermClassTeacherRelList(Integer teacherId,Integer termId){
		ClassTeacherRelEntity entity = new ClassTeacherRelEntity();
		entity.setTeacherId(teacherId);
		entity.setTermId(termId);
		List<ClassTeacherRelEntity> classRelList = classTeacherRelService.findByEntity(entity);
		return classRelList;
	}
}
