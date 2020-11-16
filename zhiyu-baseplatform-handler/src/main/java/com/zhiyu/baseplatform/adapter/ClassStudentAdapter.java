package com.zhiyu.baseplatform.adapter;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.zhiyu.baseplatform.dto.ClassStudentDto;
import com.zhiyu.baseplatform.entity.ClassBaseInfoEntity;
import com.zhiyu.baseplatform.entity.ClassStudentRelEntity;
import com.zhiyu.baseplatform.entity.GradeBaseInfoEntity;
import com.zhiyu.baseplatform.entity.StudentBaseInfoEntity;
import com.zhiyu.baseplatform.entity.StudentClassHistoryEntity;
import com.zhiyu.baseplatform.entity.TermBaseInfoEntity;
import com.zhiyu.baseplatform.service.IClassBaseInfoService;
import com.zhiyu.baseplatform.service.IGradeBaseInfoService;
import com.zhiyu.baseplatform.service.IStudentBaseInfoService;
import com.zhiyu.baseplatform.service.ITermBaseInfoService;
/**
 * 
 * @author wdj
 *
 */
@Component
public class ClassStudentAdapter {
	
	@Autowired
	private IGradeBaseInfoService gradeBaseInfoService;
	
	@Autowired
	private IClassBaseInfoService classBaseInfoService;
	
	@Autowired
	private IStudentBaseInfoService studentBaseInfoService;
	
	@Autowired
	private ITermBaseInfoService termBaseInfoService;
	/**
	 * @param entity
	 * @return
	 */
	public ClassStudentDto getResponseDtoFromEntity(ClassStudentRelEntity entity){
		ClassStudentDto dto = new ClassStudentDto();
		StudentBaseInfoEntity student=studentBaseInfoService.findById(entity.getStudentId());
		dto.setStudentId(student.getId());
		dto.setStudentName(student.getName());
		dto.setStudentNumber(student.getNumber());
		ClassBaseInfoEntity c=classBaseInfoService.findObjectById(entity.getClassId());
		dto.setClassId(c.getId());
		dto.setClassName(c.getName());
		GradeBaseInfoEntity g=gradeBaseInfoService.findObjectById(c.getGradeId());
		dto.setGradeName(g.getName());
		TermBaseInfoEntity t=termBaseInfoService.findObjectById(entity.getTermId());
		dto.setTermName(t.getName());
		return dto;
	}
	
	public List<ClassStudentDto> getResponseDtosFromEntityList(List<ClassStudentRelEntity> entityList){
		List<ClassStudentDto> dtos = Lists.newArrayList();
		for(ClassStudentRelEntity e:entityList){
			ClassStudentDto dto = getResponseDtoFromEntity(e);
			dtos.add(dto);
		}
		return dtos;
	}
	/**
	 * @param entity
	 * @return
	 */
	public ClassStudentDto getResponseDtoFrom(StudentClassHistoryEntity entity){
		ClassStudentDto dto = new ClassStudentDto();
		StudentBaseInfoEntity student=studentBaseInfoService.findById(entity.getStudentId());
		dto.setStudentName(student.getName());
		dto.setStudentNumber(student.getNumber());
		ClassBaseInfoEntity c=classBaseInfoService.findObjectById(entity.getClassId());
		dto.setClassName(c.getName());
		GradeBaseInfoEntity g=gradeBaseInfoService.findObjectById(c.getGradeId());
		dto.setGradeName(g.getName());
		TermBaseInfoEntity t=termBaseInfoService.findObjectById(entity.getTermId());
		dto.setTermName(t.getName());
		return dto;
	}
	
	public List<ClassStudentDto> getResponseDtosFromList(List<StudentClassHistoryEntity> entityList){
		List<ClassStudentDto> dtos = Lists.newArrayList();
		for(StudentClassHistoryEntity e:entityList){
			ClassStudentDto dto = getResponseDtoFrom(e);
			dtos.add(dto);
		}
		return dtos;
	}
}
