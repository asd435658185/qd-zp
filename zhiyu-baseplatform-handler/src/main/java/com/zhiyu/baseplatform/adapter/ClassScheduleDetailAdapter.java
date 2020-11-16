package com.zhiyu.baseplatform.adapter;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.google.common.collect.Lists;
import com.zhiyu.baseplatform.dto.ClassScheduleDetailDto;
import com.zhiyu.baseplatform.entity.ClassLessionDetailEntity;
import com.zhiyu.baseplatform.entity.ClassScheduleDetailEntity;
import com.zhiyu.baseplatform.entity.TeacherBaseInfoEntity;
import com.zhiyu.baseplatform.service.IClassLessionDetailService;
import com.zhiyu.baseplatform.service.ICourseBaseInfoService;
import com.zhiyu.baseplatform.service.ITeacherBaseInfoService;

/**
 * 
 * @author wdj
 *
 */
@Component
public class ClassScheduleDetailAdapter {

	@Autowired
	private ICourseBaseInfoService courseBaseInfoService;

	@Autowired
	private IClassLessionDetailService classLessionDetailService;

	@Autowired
	private ITeacherBaseInfoService teacherBaseInfoService;

	public ClassScheduleDetailDto getResponseDtoFromEntity(ClassScheduleDetailEntity entity) {
		ClassScheduleDetailDto dto = new ClassScheduleDetailDto();
		dto.setId(entity.getId());
		dto.setCourseId(entity.getCourseId());
		dto.setCourseName(courseBaseInfoService.findObjectById(entity.getCourseId()).getName());
		dto.setDayIndex(entity.getDayIndex());
		if (entity.getDayIndex() == 1) {
			dto.setDayName("周一");
		} else if (entity.getDayIndex() == 2) {
			dto.setDayName("周二");
		} else if (entity.getDayIndex() == 3) {
			dto.setDayName("周三");
		} else if (entity.getDayIndex() == 4) {
			dto.setDayName("周四");
		} else if (entity.getDayIndex() == 5) {
			dto.setDayName("周五");
		}
		ClassLessionDetailEntity detail = classLessionDetailService.findObjectById(entity.getLessionId());
		dto.setScheduleId(entity.getScheduleId());
		dto.setLessionId(entity.getLessionId());
		dto.setLessionName(detail.getName());
		dto.setCourseId(entity.getCourseId());
		dto.setBeginTime(detail.getBeginTime());
		dto.setEndTime(detail.getEndTime());
		dto.setTeacherId(entity.getTeacherId());
		TeacherBaseInfoEntity teacher = teacherBaseInfoService.findObjectById(entity.getTeacherId());
		dto.setTeacherName(teacher.getName());
		dto.setTeacherTel(teacher.getTel());
		return dto;
	}

	public List<ClassScheduleDetailDto> getResponseDtosFromEntityList(List<ClassScheduleDetailEntity> entityList) {
		List<ClassScheduleDetailDto> dtos = Lists.newArrayList();
		for (ClassScheduleDetailEntity e : entityList) {
			ClassScheduleDetailDto dto = getResponseDtoFromEntity(e);
			dtos.add(dto);
		}
		return dtos;
	}
}
