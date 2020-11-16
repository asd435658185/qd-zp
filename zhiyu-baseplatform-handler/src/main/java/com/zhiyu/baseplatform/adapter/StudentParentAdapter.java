package com.zhiyu.baseplatform.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.zhiyu.baseplatform.dto.StudentParentDto;
import com.zhiyu.baseplatform.entity.ParentStudentRelEntity;
import com.zhiyu.baseplatform.service.IParentBaseInfoService;
import com.zhiyu.baseplatform.service.IStudentBaseInfoService;

/**
 * 
 * @author wdj
 *
 */
@Component
public class StudentParentAdapter {
	
	@Autowired
	private IParentBaseInfoService parentBaseInfoService;
	
	@Autowired
	private IStudentBaseInfoService studentBaseInfoService;
	
	public StudentParentDto getResponseDtoFromEntity(ParentStudentRelEntity entity){
		StudentParentDto dto = new StudentParentDto();
		dto.setId(entity.getId());
		dto.setParentId(entity.getParentId());
		if(parentBaseInfoService.findObjectById(entity.getParentId())!=null){
			dto.setParentName(parentBaseInfoService.findObjectById(entity.getParentId()).getParentName());
		}
		dto.setRelation(entity.getRelation());
		dto.setStudentId(entity.getStudentId());
		dto.setStudentCode(studentBaseInfoService.findById(entity.getStudentId()).getCode());
		dto.setStudentName(studentBaseInfoService.findById(entity.getStudentId()).getName());
		return dto;
	}
	
	public List<StudentParentDto> getResponseDtosFromEntityList(List<ParentStudentRelEntity> entityList){
		List<StudentParentDto> dtos = Lists.newArrayList();
		for(ParentStudentRelEntity e:entityList){
			System.out.println(e.getId());
			if(e.getId().equals(519)){
				System.out.println("1");
			}
			StudentParentDto dto = getResponseDtoFromEntity(e);
			dtos.add(dto);
		}
		return dtos;
	}
}
