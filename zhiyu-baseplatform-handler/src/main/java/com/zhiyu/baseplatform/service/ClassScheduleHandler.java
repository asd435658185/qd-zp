package com.zhiyu.baseplatform.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zhiyu.baseplatform.adapter.ClassScheduleDetailAdapter;
import com.zhiyu.baseplatform.bean.ClassLessonDetailComparatorBean;
import com.zhiyu.baseplatform.dto.ClassScheduleDetailDto;
import com.zhiyu.baseplatform.entity.ClassBaseInfoEntity;
import com.zhiyu.baseplatform.entity.ClassLessionDetailEntity;
import com.zhiyu.baseplatform.entity.ClassScheduleDetailEntity;
import com.zhiyu.baseplatform.entity.ClassScheduleEntity;
import com.zhiyu.baseplatform.entity.TeacherBaseInfoEntity;
import com.zhiyu.baseplatform.entity.TermBaseInfoEntity;
import com.zhiyu.baseplatform.util.DateUtil;

/**
 * 
 * @author wdj
 *
 */
@Service
public class ClassScheduleHandler {

	@Autowired
	private SchoolTermHandler termService;
	
	@Autowired
	private IClassScheduleService classScheduleService;

	@Autowired
	private IClassScheduleDetailService classScheduleDetailService;
	
	@Autowired
	private IClassLessionDetailService classLessionDetailService;

	@Autowired
	private IClassBaseInfoService classService;
	
	@Autowired
	private ITeacherBaseInfoService teacherBaseInfoService;
	
	@Autowired
	private ICourseBaseInfoService courseBaseInfoService;
	
	@Autowired
	private ClassScheduleDetailAdapter classScheduleDetailAdapter;
	
	private String[] day_fields = new String[]{"day1","day2","day3","day4","day5"};

	/**
	 * 获取班级课程表整体数据
	 * @param termId
	 * @param classId
	 * @return
	 */
	public List<Map<String, Object>> getScheduleTableData(Integer termId,Integer classId){
		List<Map<String, Object>> result = Lists.newArrayList();
		// 获取主表下的班级和学期
		ClassScheduleEntity classSchedule = new ClassScheduleEntity();
		classSchedule.setTermId(termId);
		classSchedule.setClassId(classId);

		// 获取课程数据明细
		Map<String, List<ClassScheduleDetailEntity>> classScheduleDetails = getClassScheduleDetailByLesson(classId);

		for (String lessonCode : classScheduleDetails.keySet()) {
			List<ClassScheduleDetailEntity> sub = classScheduleDetails.get(lessonCode);
			if (sub == null || sub.isEmpty()) {
				continue;
			}
			ClassLessionDetailEntity classLesson = classLessionDetailService
					.findObjectById(sub.get(0).getLessionId());
			//// 设置属性参数,默认数据
			Map<String, Object> map = Maps.newConcurrentMap();
			map.put("weekIndex", DateUtil.getTodayWeekIndex());
			map.put("lessonId", classLesson.getId());
			map.put("lessonName", classLesson.getName());
			map.put("courseBegin", classLesson.getBeginTime());
			map.put("courseEnd", classLesson.getEndTime());
			// 默认每天的课程
			map.put("courseMonday", "");
			map.put("courseMondayId", 0);
			map.put("teacherMondayId", 0);
			map.put("teacherMondayName", "");
			map.put("teacherMondayTel", "");
			map.put("scheduleDetailMondayId", 0);// 课表明细id
			map.put("courseTuesday", "");
			map.put("courseTuesdayId", 0);
			map.put("teacherTuesdayId", 0);
			map.put("teacherTuesdayName", "");
			map.put("teacherTuesdayTel", "");
			map.put("scheduleDetailTuesdayId", 0);// 课表明细id
			map.put("courseWednesday", "");
			map.put("courseWednesdayId", 0);
			map.put("teacherWednesdayId", 0);
			map.put("teacherWednesdayName", "");
			map.put("teacherWednesdayTel", "");
			map.put("scheduleDetailWednesdayId", 0);// 课表明细id
			map.put("courseThursday", "");
			map.put("courseThursdayId", 0);
			map.put("teacherThursdayId", 0);
			map.put("teacherThursdayName", "");
			map.put("teacherThursdayTel", "");
			map.put("scheduleDetailThursdayId", 0);// 课表明细id
			map.put("courseFriday", "");
			map.put("courseFridayId", 0);
			map.put("teacherFridayId", 0);
			map.put("teacherFridayName", "");
			map.put("teacherFridayTel", "");
			map.put("scheduleDetailFridayId", 0);// 课表明细id

			List<ClassScheduleDetailDto> subDtos = classScheduleDetailAdapter
					.getResponseDtosFromEntityList(sub);
			for (ClassScheduleDetailDto csd : subDtos) {
				if (csd.getDayIndex() == 1) {// 第几节周一
					// 周一
					map.put("courseMonday", csd.getCourseName());
					map.put("courseMondayId", csd.getCourseId());
					map.put("teacherMondayId", csd.getTeacherId());
					map.put("teacherMondayName", csd.getTeacherName());
					map.put("teacherMondayTel", csd.getTeacherTel());
					map.put("scheduleDetailMondayId", csd.getId());// 课表明细id
				}
				if (csd.getDayIndex() == 2) {// 第几节周二
					// 周二
					map.put("courseTuesday", csd.getCourseName());
					map.put("courseTuesdayId", csd.getCourseId());
					map.put("teacherTuesdayId", csd.getTeacherId());
					map.put("teacherTuesdayName", csd.getTeacherName());
					map.put("teacherTuesdayTel", csd.getTeacherTel());
					map.put("scheduleDetailTuesdayId", csd.getId());// 课表明细id
				}
				if (csd.getDayIndex() == 3) {// 第几节周三
					// 周三
					map.put("courseWednesday", csd.getCourseName());
					map.put("courseWednesdayId", csd.getCourseId());
					map.put("teacherWednesdayId", csd.getTeacherId());
					map.put("teacherWednesdayName", csd.getTeacherName());
					map.put("teacherWednesdayTel", csd.getTeacherTel());
					map.put("scheduleDetailWednesdayId", csd.getId());// 课表明细id
				}
				if (csd.getDayIndex() == 4) {// 第几节周四
					// 周四
					map.put("courseThursday", csd.getCourseName());
					map.put("courseThursdayId", csd.getCourseId());
					map.put("teacherThursdayId", csd.getTeacherId());
					map.put("teacherThursdayName", csd.getTeacherName());
					map.put("teacherThursdayTel", csd.getTeacherTel());
					map.put("scheduleDetailThursdayId", csd.getId());// 课表明细id
				}
				if (csd.getDayIndex() == 5) {// 第几节周五
					// 周五
					map.put("courseFriday", csd.getCourseName());
					map.put("courseFridayId", csd.getCourseId());
					map.put("teacherFridayId", csd.getTeacherId());
					map.put("teacherFridayName", csd.getTeacherName());
					map.put("teacherFridayTel", csd.getTeacherTel());
					map.put("scheduleDetailFridayId", csd.getId());// 课表明细id
				}
			}
			result.add(map);
		}
		return result;
	}

	/**
	 * 生成课程表展示数据
	 * @param classId
	 * @param currentDayIndex
	 * @return
	 */
	public List<Map<String, String>> generateScheduleTableData(Integer classId,Integer currentDayIndex){
		Map<String, List<ClassScheduleDetailEntity> > sortedMapByCode = groupSortedByLessonCode(getClassScheduleDetails(classId, currentDayIndex));
		List<Map<String, String>> list = Lists.newArrayList();
		for(String key:sortedMapByCode.keySet()){
			List<ClassScheduleDetailEntity> valueList = sortedMapByCode.get(key);
			Map<String, String> rowMap = Maps.newTreeMap();
			//预设定课程为空
			for(String s:day_fields){
				rowMap.put(s, "");
			}
			//具体课程安排
			for(ClassScheduleDetailEntity e:valueList){
				if(e.getDayIndex()>5||e.getDayIndex()<1){
					throw new RuntimeException("课程表数据有误！");
				}
				String courseName = courseBaseInfoService.findObjectById(e.getCourseId()).getName();
				int dayindex = e.getDayIndex();
				rowMap.put(day_fields[dayindex-1], courseName);
			}
			list.add(rowMap);
		}
		return list;
	}
	
	/**
	 * 将课程明细按照课程的id对应的code值进行排序处理
	 * @param classScheduleDetailList
	 * @return
	 */
	private Map<String, List<ClassScheduleDetailEntity>> groupSortedByLessonCode(List<ClassScheduleDetailEntity> classScheduleDetailList){
		Map<String, List<ClassScheduleDetailEntity>> map = Maps.newTreeMap();
		for(ClassScheduleDetailEntity entity:classScheduleDetailList){
			String code = classLessionDetailService.findObjectById(entity.getLessionId()).getCode().toString();
			if(!map.containsKey(code)){
				List<ClassScheduleDetailEntity> list = Lists.newArrayList();
				list.add(entity);
				map.put(code, list);
			}else{
				map.get(code).add(entity);
			}
		}
		return map;
	}
	
	/**
	 * 获取根据课节分布的班级课程明细
	 * @param classId
	 * @return <lessonCode,List>
	 */
	public Map<String, List<ClassScheduleDetailEntity>> getClassScheduleDetailByLesson(Integer classId){
		Map<String, List<ClassScheduleDetailEntity> > sortedMapByCode = groupSortedByLessonCode(getClassScheduleDetails(classId, null));
		return sortedMapByCode;
	}
	
	/**
	 * 获取班级课节对应课程的明细
	 * @param classId
	 * @param currentDayIndex   
	 * @return
	 */
	public List<ClassScheduleDetailEntity> getClassScheduleDetails(Integer classId,Integer currentDayIndex){
		List<ClassScheduleDetailEntity> classScheduleDetailList = Lists.newArrayList();
		//获取年级共同课节信息
		List<ClassLessionDetailEntity> gradeLessonDetails = getGradeLessonSchedules(classId); 
		ClassLessionDetailEntity oneLessonInfo = null;
		if(gradeLessonDetails!=null && !gradeLessonDetails.isEmpty()){
			oneLessonInfo = gradeLessonDetails.get(0);
		}else{
			return null;
		}
		//获取班级课程主表信息
		ClassScheduleEntity classScheduleInfo = getClassSchedule(oneLessonInfo.getTermId(), classId);
		if(classScheduleInfo==null){
			return null;
		}
		//获取班级课程信息明细
		ClassScheduleDetailEntity classScheduleDetailCondition = new ClassScheduleDetailEntity();
		classScheduleDetailCondition.setScheduleId(classScheduleInfo.getId());
		if(currentDayIndex!=null){
			classScheduleDetailCondition.setDayIndex(currentDayIndex);
		}
		for (ClassLessionDetailEntity clzLessonDetail : gradeLessonDetails) {
			classScheduleDetailCondition.setLessionId(clzLessonDetail.getId());
			if (classScheduleDetailService.findByEntity(classScheduleDetailCondition) != null) {
				classScheduleDetailList
						.addAll(classScheduleDetailService.findByEntity(classScheduleDetailCondition));
			}
		}
		return classScheduleDetailList;
	}
	
	/**
	 * 根据学期id和班级id获取班级课程主表信息
	 * @param termId
	 * @param classId
	 * @return
	 */
	private ClassScheduleEntity getClassSchedule(Integer termId,Integer classId){
		ClassScheduleEntity classSchedule = new ClassScheduleEntity();
		classSchedule.setTermId(termId);
		classSchedule.setClassId(classId);
		List<ClassScheduleEntity> classScheduleList = classScheduleService.findByEntity(classSchedule);
		if(classScheduleList!=null && !classScheduleList.isEmpty()){
			return classScheduleList.get(0);
		}
		return null;
	}
	
	/**
	 * 获取年级下主课程表的课节明细信息列表
	 * @param classId
	 * @return
	 */
	private List<ClassLessionDetailEntity> getGradeLessonSchedules(Integer classId){
		// 获取该年级下的所有课节(同一年级下课节数、时间等是一致的)
		ClassLessionDetailEntity lessionDetailCondition = new ClassLessionDetailEntity();
		ClassBaseInfoEntity classInfo = classService.findObjectById(classId);
		TeacherBaseInfoEntity teacher = teacherBaseInfoService.findObjectById(classInfo.getMasterTeacherId());
		TermBaseInfoEntity currentTerm = termService.getCurrentTermInfoBySchoolId(teacher.getSchoolId());
		lessionDetailCondition.setTermId(currentTerm.getId());
		lessionDetailCondition.setGradeId(classInfo.getGradeId());
		List<ClassLessionDetailEntity> gradeLessonDetails = classLessionDetailService.findByEntity(lessionDetailCondition);
		if(gradeLessonDetails==null){
			return null;
		}
		Collections.sort(gradeLessonDetails, new ClassLessonDetailComparatorBean()); 
		return gradeLessonDetails;
	}
	
}
