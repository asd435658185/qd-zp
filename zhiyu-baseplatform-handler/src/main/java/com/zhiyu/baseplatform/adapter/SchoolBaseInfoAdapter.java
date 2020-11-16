package com.zhiyu.baseplatform.adapter;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.google.common.collect.Lists;
import com.zhiyu.baseplatform.dto.SchoolBaseInfoDto;
import com.zhiyu.baseplatform.entity.SchoolBaseInfoEntity;
import com.zhiyu.baseplatform.enumcode.UploadFileType;
import com.zhiyu.baseplatform.processor.PictureInfoBeanFactory;
import com.zhiyu.baseplatform.processor.PictureSaveAndDisplayProcessor;
import com.zhiyu.baseplatform.service.ICityService;
import com.zhiyu.baseplatform.service.IDistrictionService;
import com.zhiyu.baseplatform.service.IProvinceService;
import com.zhiyu.baseplatform.service.ISchoolKindService;
import com.zhiyu.baseplatform.service.ISchoolLevelService;
import com.zhiyu.baseplatform.service.ISchoolTypeService;

/**
 * 
 * @author wdj
 *
 */
@Component
public class SchoolBaseInfoAdapter {

	@Autowired
	private IProvinceService provinceService;

	@Autowired
	private ICityService cityService;

	@Autowired
	private IDistrictionService districtionService;

	@Autowired
	private ISchoolKindService schoolKindService;

	@Autowired
	private ISchoolTypeService schoolTypeService;

	@Autowired
	private ISchoolLevelService schoolLevelService;

	public SchoolBaseInfoDto getResponseDtoFromEntity(SchoolBaseInfoEntity entity) {
		SchoolBaseInfoDto dto = new SchoolBaseInfoDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setSchoolKindName(schoolKindService.findObjectById(entity.getSchoolKindId()).getSchoolKindName());
		dto.setSchoolLevelName(schoolLevelService.findObjectById(entity.getSchoolLevelId()).getSchoolLevelName());
		dto.setSchoolTypeName(schoolTypeService.findObjectById(entity.getSchoolTypeId()).getSchoolTypeName());
		dto.setSchoolProvinceName(provinceService.findObjectById(entity.getSchoolProvinceId()).getProvinceName());
		dto.setSchoolCityName(cityService.findObjectById(entity.getSchoolCityId()).getCityName());
		dto.setSchoolDistrictName(districtionService.findObjectById(entity.getSchoolDistrictId()).getDistrictName());
		PictureSaveAndDisplayProcessor noticeProcessor = new PictureSaveAndDisplayProcessor(
				PictureInfoBeanFactory.newInstance(UploadFileType.NOTIFICATION));
		if (StringUtils.isNotBlank(entity.getSchoolImg())) {
			dto.setSchoolImg(noticeProcessor.getFileService().getFileWebPathBySegment(entity.getSchoolImg()));
		} else {
			dto.setSchoolImg("");
		}
		return dto;
	}

	public List<SchoolBaseInfoDto> getResponseDtosFromEntityList(List<SchoolBaseInfoEntity> entityList) {
		List<SchoolBaseInfoDto> dtos = Lists.newArrayList();
		for (SchoolBaseInfoEntity e : entityList) {
			SchoolBaseInfoDto dto = getResponseDtoFromEntity(e);
			dtos.add(dto);
		}
		return dtos;
	}
}
