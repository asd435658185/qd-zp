package com.zhiyu.baseplatform.adapter;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.zhiyu.baseplatform.dto.ClassBaseInfoDto;
import com.zhiyu.baseplatform.entity.ClassBaseInfoEntity;
import com.zhiyu.baseplatform.enumcode.UploadFileType;
import com.zhiyu.baseplatform.processor.PictureInfoBeanFactory;
import com.zhiyu.baseplatform.processor.PictureSaveAndDisplayProcessor;
import com.zhiyu.baseplatform.service.IGradeBaseInfoService;
import com.zhiyu.baseplatform.service.ITeacherBaseInfoService;
import com.zhiyu.baseplatform.service.ITermBaseInfoService;

/**
 * 
 * @author wdj
 *
 */
@Component
public class ClassBaseInfoAdapter {

	@Autowired
	private ITeacherBaseInfoService teacherBaseInfoService;

	@Autowired
	private IGradeBaseInfoService gradeBaseInfoService;
	
	@Autowired
	private ITermBaseInfoService  termBaseInfoService;

	public ClassBaseInfoDto getResponseDtoFromEntity(ClassBaseInfoEntity entity) {
		ClassBaseInfoDto dto = new ClassBaseInfoDto();
		dto.setCode(entity.getCode());
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setGradeId(entity.getGradeId());
		dto.setGradeName(gradeBaseInfoService.findObjectById(entity.getGradeId()).getName());
		dto.setMasterTeacherId(entity.getMasterTeacherId());
		if (entity.getMasterTeacherId() != null) {
			try {
				dto.setMasterTeacherName(teacherBaseInfoService.findObjectById(entity.getMasterTeacherId()).getName());
				dto.setSchoolId(teacherBaseInfoService.findObjectById(entity.getMasterTeacherId()).getSchoolId());
			} catch (Exception e) {
				dto.setMasterTeacherName("指定班主任不存在");
			}

		}
		dto.setClassAddress(entity.getClassAddress());
		PictureSaveAndDisplayProcessor noticeProcessor = new PictureSaveAndDisplayProcessor(
				PictureInfoBeanFactory.newInstance(UploadFileType.NOTIFICATION));
		if(StringUtils.isNotBlank(entity.getLogoImg())){
			if(noticeProcessor.getFileService().getFileWebPathBySegment(entity.getLogoImg()).contains("default")){
				dto.setLogoImg("");
			}else{
				dto.setLogoImg(noticeProcessor.getFileService().getFileWebPathBySegment(entity.getLogoImg()));
			}
		}else{
			dto.setLogoImg("");
		}
		
		if(entity.getTermId()!=null){
			dto.setTermId(entity.getTermId());
			dto.setTermName(termBaseInfoService.findObjectById(entity.getTermId()).getName());
		}else{
			dto.setTermId(-1);
			dto.setTermName("未设置学期");
		}
		return dto;
	}

	public List<ClassBaseInfoDto> getResponseDtosFromEntityList(List<ClassBaseInfoEntity> entityList) {
		List<ClassBaseInfoDto> dtos = Lists.newArrayList();
		for (ClassBaseInfoEntity e : entityList) {
			ClassBaseInfoDto dto = getResponseDtoFromEntity(e);
			dtos.add(dto);
		}
		return dtos;
	}
	
}
