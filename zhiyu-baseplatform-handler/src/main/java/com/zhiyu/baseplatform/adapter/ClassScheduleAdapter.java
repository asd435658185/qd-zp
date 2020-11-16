package com.zhiyu.baseplatform.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.google.common.collect.Lists;
import com.zhiyu.baseplatform.dto.ClassScheduleDto;
import com.zhiyu.baseplatform.entity.ClassScheduleEntity;
import com.zhiyu.baseplatform.service.IClassBaseInfoService;
import com.zhiyu.baseplatform.service.IGradeBaseInfoService;
import com.zhiyu.baseplatform.service.ITermBaseInfoService;

/**
 * 
 * @author wdj
 *
 */
@Component
public class ClassScheduleAdapter {

	@Autowired
	private ITermBaseInfoService termBaseInfoService;

	@Autowired
	private IClassBaseInfoService classBaseInfoService;

	@Autowired
	private IGradeBaseInfoService gradeBaseInfoService;

	public ClassScheduleDto getResponseDtoFromEntity(ClassScheduleEntity entity) {
		ClassScheduleDto dto = new ClassScheduleDto();
		dto.setId(entity.getId());
		dto.setClassId(entity.getClassId());
		dto.setTermId(entity.getTermId());
		dto.setClassName(classBaseInfoService.findObjectById(entity.getClassId()).getName());
		dto.setTermName(termBaseInfoService.findObjectById(entity.getTermId()).getName());
		dto.setGradeId(classBaseInfoService.findObjectById(entity.getClassId()).getGradeId());
		dto.setGradeName(gradeBaseInfoService
				.findObjectById(classBaseInfoService.findObjectById(entity.getClassId()).getGradeId()).getName());
		return dto;
	}

	public List<ClassScheduleDto> getResponseDtosFromEntityList(List<ClassScheduleEntity> entityList) {
		List<ClassScheduleDto> dtos = Lists.newArrayList();
		for (ClassScheduleEntity e : entityList) {
			ClassScheduleDto dto = getResponseDtoFromEntity(e);
			dtos.add(dto);
		}
		return dtos;
	}
}
