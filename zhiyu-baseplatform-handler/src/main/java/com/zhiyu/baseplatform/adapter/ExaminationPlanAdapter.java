package com.zhiyu.baseplatform.adapter;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.zhiyu.baseplatform.dto.ExaminationPlanDto;
import com.zhiyu.baseplatform.entity.ExaminationPlanManageEntity;
import com.zhiyu.baseplatform.service.IGradeBaseInfoService;
import com.zhiyu.baseplatform.service.ISchoolBaseInfoService;
import com.zhiyu.baseplatform.service.ITermBaseInfoService;

/**
 * 考試計劃
 * @author wdj
 *
 */
@Component
public class ExaminationPlanAdapter {

	@Autowired
	private IGradeBaseInfoService gradeService;
	
	@Autowired
	private ISchoolBaseInfoService schoolService;
	
	@Autowired
	private ITermBaseInfoService termService;
	
	/**
	 * 将实体转成dto
	 * @param entity
	 * @return
	 */
	public ExaminationPlanDto getDto(ExaminationPlanManageEntity entity){
		ExaminationPlanDto dto = new ExaminationPlanDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setGradeName(gradeService.findObjectById(entity.getGradeId()).getName());
		dto.setSchoolName(schoolService.findObjectById(entity.getSchoolId()).getSchoolName());
		dto.setTermName(termService.findObjectById(entity.getTermId()).getName());
		return dto;
	}
	
	/**
	 * 转换列表
	 * @param entityList
	 * @return
	 */
	public List<ExaminationPlanDto> getDtos(List<ExaminationPlanManageEntity> entityList){
		List<ExaminationPlanDto> dtos = Lists.newArrayList();
		for(ExaminationPlanManageEntity entity:entityList){
			dtos.add(getDto(entity));
		}
		return dtos;
	}
}
