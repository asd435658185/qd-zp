package com.zhiyu.baseplatform.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.zhiyu.baseplatform.dto.SchoolAuthenticationDto;
import com.zhiyu.baseplatform.entity.SysOparateManager;
import com.zhiyu.baseplatform.entity.UserAccessEntity;
import com.zhiyu.baseplatform.entity.UserAuthenticationEntity;
import com.zhiyu.baseplatform.service.IAccessBaseInfoService;
import com.zhiyu.baseplatform.service.ISchoolBaseInfoService;
import com.zhiyu.baseplatform.service.IUserAccessService;
import com.zhiyu.baseplatform.service.IUserAuthenticationService;
/**
 * 
 * @author wdj
 *
 */
@Component
public class SchoolAuthenticationAdapter {
	
	@Autowired
	private ISchoolBaseInfoService schoolBaseInfoService;
	
	@Autowired
	private IUserAuthenticationService userAuthenticationService;
	
	@Autowired
	private IUserAccessService userAccessService;
	
	@Autowired
	private IAccessBaseInfoService accessBaseInfoService;
	
	public SchoolAuthenticationDto getResponseDtoFromEntity(SysOparateManager entity){
		SchoolAuthenticationDto dto = new SchoolAuthenticationDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setRemark(entity.getRemark());
		dto.setSchoolId(entity.getSchoolId());
		dto.setSchoolName(schoolBaseInfoService.findObjectById(entity.getSchoolId()).getSchoolName());
		UserAuthenticationEntity user=new UserAuthenticationEntity();
		user.setUserId(entity.getId());
		dto.setLoginAccount(userAuthenticationService.findByEntity(user).get(0).getLoginAccount());
		dto.setLoginPassword(userAuthenticationService.findByEntity(user).get(0).getLoginPassword());
		UserAccessEntity userAs=new UserAccessEntity();
		userAs.setUserId(entity.getId());
		dto.setAuthorityId(accessBaseInfoService.findObjectById(userAccessService.findByEntity(userAs).get(0).getAuthorityId()).getId());
		dto.setAuthorityName(accessBaseInfoService.findObjectById(userAccessService.findByEntity(userAs).get(0).getAuthorityId()).getName());
		return dto;
	}
	
	public List<SchoolAuthenticationDto> getResponseDtosFromEntityList(List<SysOparateManager> entityList){
		List<SchoolAuthenticationDto> dtos = Lists.newArrayList();
		for(SysOparateManager e:entityList){
			SchoolAuthenticationDto dto = getResponseDtoFromEntity(e);
			dtos.add(dto);
		}
		return dtos;
	}
}
