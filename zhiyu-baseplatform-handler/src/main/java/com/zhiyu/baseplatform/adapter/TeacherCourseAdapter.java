package com.zhiyu.baseplatform.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.google.common.collect.Lists;
import com.zhiyu.baseplatform.dto.TeacherCourseDto;
import com.zhiyu.baseplatform.entity.TeacherCourseRelEntity;
import com.zhiyu.baseplatform.service.IClassBaseInfoService;
import com.zhiyu.baseplatform.service.ICourseBaseInfoService;
import com.zhiyu.baseplatform.service.IGradeBaseInfoService;
import com.zhiyu.baseplatform.service.ITeacherBaseInfoService;

/**
 * 
 * @author wdj
 *
 */
@Component
public class TeacherCourseAdapter {
	
	@Autowired
	private IClassBaseInfoService classBaseInfoService;
	
	@Autowired
	private ITeacherBaseInfoService teacherBaseInfoService;
	
	@Autowired
	private ICourseBaseInfoService courseBaseInfoService;
	
	@Autowired
	private IGradeBaseInfoService gradeBaseInfoService;
	
	public TeacherCourseDto getResponseDtoFromEntity(TeacherCourseRelEntity entity){
		TeacherCourseDto dto = new TeacherCourseDto();
		dto.setRelId(entity.getRelId());
		dto.setClassId(entity.getClassId());
		dto.setCourseId(entity.getCourseId());
		dto.setTeacherId(entity.getTeacherId());
		dto.setClassName(classBaseInfoService.findObjectById(entity.getClassId()).getName());
		dto.setCourseName(courseBaseInfoService.findObjectById(entity.getCourseId()).getName());
		dto.setTeacherName(teacherBaseInfoService.findObjectById(entity.getTeacherId()).getName());
		dto.setGradeId(classBaseInfoService.findObjectById(entity.getClassId()).getGradeId());
		dto.setGradeName(gradeBaseInfoService.findObjectById(classBaseInfoService.findObjectById(entity.getClassId()).getGradeId()).getName());
		return dto;
	}
	
	public List<TeacherCourseDto> getResponseDtosFromEntityList(List<TeacherCourseRelEntity> entityList){
		List<TeacherCourseDto> dtos = Lists.newArrayList();
		for(TeacherCourseRelEntity e:entityList){
			TeacherCourseDto dto = getResponseDtoFromEntity(e);
			dtos.add(dto);
		}
		return dtos;
	}
}
