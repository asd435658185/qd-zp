package com.zhiyu.baseplatform.adapter;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.google.common.collect.Lists;
import com.zhiyu.baseplatform.dto.HomeworkNoticeDto;
import com.zhiyu.baseplatform.entity.HomeworkNoticeEntity;
import com.zhiyu.baseplatform.service.IClassBaseInfoService;
import com.zhiyu.baseplatform.service.ITeacherBaseInfoService;
/**
 * 
 * @author wdj
 *
 */
@Component
public class HomeworkNoticeAdater {
	
	@Autowired
	private ITeacherBaseInfoService teacherBaseInfoService;
	
	@Autowired
	private IClassBaseInfoService classBaseInfoService;
	
	public HomeworkNoticeDto getResponseDtoFromEntity(HomeworkNoticeEntity entity){
		HomeworkNoticeDto dto = new HomeworkNoticeDto();
		dto.setId(entity.getId());
		dto.setHomeworkNoticeClassId(entity.getHomeworkNoticeClassId());
		dto.setHomeworkNoticeClassName(classBaseInfoService.findObjectById(entity.getHomeworkNoticeClassId()).getName());
		dto.setHomeworkNoticeTitle(entity.getHomeworkNoticeTitle());
		dto.setHomeworkNoticeContent(entity.getHomeworkNoticeContent());
		dto.setHomeworkNoticeImg1(entity.getHomeworkNoticeImg1());
		dto.setHomeworkNoticeImg2(entity.getHomeworkNoticeImg2());
		dto.setHomeworkNoticeImg3(entity.getHomeworkNoticeImg3());
		dto.setHomeworkNoticeTime(entity.getHomeworkNoticeTime());
		dto.setHomeworkNoticeTeacherId(entity.getHomeworkNoticeTeacherId());
		dto.setHomeworkNoticeTeacherName(teacherBaseInfoService.findObjectById(entity.getHomeworkNoticeTeacherId()).getName());
		return dto;
	}
	
	public List<HomeworkNoticeDto> getResponseDtosFromEntityList(List<HomeworkNoticeEntity> entityList){
		List<HomeworkNoticeDto> dtos = Lists.newArrayList();
		for(HomeworkNoticeEntity e:entityList){
			HomeworkNoticeDto dto = getResponseDtoFromEntity(e);
			dtos.add(dto);
		}
		return dtos;
	}
}
