package com.zhiyu.baseplatform.adapter;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.zhiyu.baseplatform.dto.ExaminationMarkDto;
import com.zhiyu.baseplatform.entity.ExaminationMarkManageEntity;
import com.zhiyu.baseplatform.service.ICourseBaseInfoService;
import com.zhiyu.baseplatform.service.IExaminationPlanManageService;
import com.zhiyu.baseplatform.service.ISchoolBaseInfoService;
import com.zhiyu.baseplatform.service.IStudentBaseInfoService;

/**
 * 考試成績
 * @author wdj
 *
 */
@Service
public class ExaminationMarkAdapter {

	@Autowired
	private ISchoolBaseInfoService schoolBaseInfoService;
	
	@Autowired
	private IStudentBaseInfoService studentBaseInfoService;
	
	@Autowired
	private ICourseBaseInfoService courseBaseInfoService;
	
	@Autowired
	private IExaminationPlanManageService examinationPlanManageService;
	
	public ExaminationMarkDto getDto(ExaminationMarkManageEntity entity){
		ExaminationMarkDto dto = new ExaminationMarkDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setPlanName(examinationPlanManageService.findById(entity.getPlanId()).getName());
		dto.setSchoolName(schoolBaseInfoService.findObjectById(entity.getSchoolId()).getSchoolName());
		dto.setStudentName(studentBaseInfoService.findById(entity.getStudentId()).getName());
		dto.setStudentNo(studentBaseInfoService.findById(entity.getStudentId()).getNumber());
		dto.setSubjectName(courseBaseInfoService.findObjectById(entity.getSubjectId()).getName());
		dto.setGradeId(examinationPlanManageService.findById(entity.getPlanId()).getGradeId());
		return dto;
	}
	public ExaminationMarkDto getExaminationMarkDto(ExaminationMarkManageEntity entity){
		ExaminationMarkDto dto = new ExaminationMarkDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setStudentName(studentBaseInfoService.findById(entity.getStudentId()).getName());
		return dto;
	}
	/**
	 * 转换列表
	 * @param entityList
	 * @return
	 */
	public List<ExaminationMarkDto> getDtos(List<ExaminationMarkManageEntity> entityList){
		List<ExaminationMarkDto> dtos = Lists.newArrayList();
		for(ExaminationMarkManageEntity entity:entityList){
			dtos.add(getExaminationMarkDto(entity));
		}
		return dtos;
	}
}
