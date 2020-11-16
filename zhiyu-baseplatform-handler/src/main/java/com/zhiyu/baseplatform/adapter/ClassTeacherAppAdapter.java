package com.zhiyu.baseplatform.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.zhiyu.baseplatform.dto.ClassTeacherAppDto;
import com.zhiyu.baseplatform.entity.ClassBaseInfoEntity;
import com.zhiyu.baseplatform.entity.ClassTeacherRelEntity;
import com.zhiyu.baseplatform.service.IClassBaseInfoService;
import com.zhiyu.baseplatform.service.IGradeBaseInfoService;
import com.zhiyu.baseplatform.service.ITeacherBaseInfoService;
/**
 * APP端
 * @author wdj
 *
 */
@Component
public class ClassTeacherAppAdapter {
	
	@Autowired
	private IClassBaseInfoService classBaseInfoService;
	
	@Autowired
	private ITeacherBaseInfoService teacherBaseInfoService;
	
	@Autowired
	private IGradeBaseInfoService gradeBaseInfoService;
	
	public ClassTeacherAppDto getResponseDtoFromEntity(ClassTeacherRelEntity entity){
		ClassTeacherAppDto dto = new ClassTeacherAppDto();
		dto.setRelId(entity.getRelId());
		dto.setTermId(entity.getTermId());
		dto.setCurfocus(entity.getCurfocus());
		dto.setClassId(entity.getClassId());
		dto.setTeacherId(entity.getTeacherId());
		dto.setClassCode(classBaseInfoService.findObjectById(entity.getClassId()).getCode());
		dto.setClassName(gradeBaseInfoService.findObjectById(classBaseInfoService.findObjectById(entity.getClassId()).getGradeId()).getName()+classBaseInfoService.findObjectById(entity.getClassId()).getName());
		dto.setTeacherName(teacherBaseInfoService.findObjectById(entity.getTeacherId()).getName());
		ClassBaseInfoEntity classBaseInfo = new ClassBaseInfoEntity();
		classBaseInfo.setMasterTeacherId(entity.getTeacherId());
		classBaseInfo.setId(entity.getClassId());
		List<ClassBaseInfoEntity> classList = classBaseInfoService.findByEntity(classBaseInfo);
		if (classList.size() > 0) {
			dto.setIsClassManage(true);
		} else {
			dto.setIsClassManage(false);
		}
		return dto;
	}
	
	public List<ClassTeacherAppDto> getResponseDtosFromEntityList(List<ClassTeacherRelEntity> entityList){
		List<ClassTeacherAppDto> dtos = Lists.newArrayList();
		for(ClassTeacherRelEntity e:entityList){
			ClassTeacherAppDto dto = getResponseDtoFromEntity(e);
			dtos.add(dto);
		}
		return dtos;
	}
}
