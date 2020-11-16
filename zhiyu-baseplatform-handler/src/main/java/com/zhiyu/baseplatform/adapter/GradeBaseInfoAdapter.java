package com.zhiyu.baseplatform.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.zhiyu.baseplatform.dto.GradeBaseInfoDto;
import com.zhiyu.baseplatform.entity.GradeBaseInfoEntity;
import com.zhiyu.baseplatform.entity.TeacherBaseInfoEntity;
import com.zhiyu.baseplatform.service.ITeacherBaseInfoService;

/**
 * 
 * @author csk
 *
 */
@Component
public class GradeBaseInfoAdapter {
	@Autowired
	private ITeacherBaseInfoService teacherBaseInfoService;
	
	public GradeBaseInfoDto getResponseDtoFromEntity(GradeBaseInfoEntity entity){
		GradeBaseInfoDto dto = new GradeBaseInfoDto();
		dto.setCode(entity.getCode());
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setSchoolId(entity.getSchoolId());
		dto.setMasterTeacherId(entity.getMasterTeacherId());
		if(entity.getMasterTeacherId()!=null){
			TeacherBaseInfoEntity master = teacherBaseInfoService.findObjectById(entity.getMasterTeacherId());
			if(master!=null){
				dto.setMasterTeacherName(master.getName());
			}
		}
		return dto;
	}
	
	public List<GradeBaseInfoDto> getResponseDtosFromEntityList(List<GradeBaseInfoEntity> entityList){
		List<GradeBaseInfoDto> dtos = Lists.newArrayList();
		for(GradeBaseInfoEntity e:entityList){
			GradeBaseInfoDto dto = getResponseDtoFromEntity(e);
			dtos.add(dto);
		}
		return dtos;
	}
}
