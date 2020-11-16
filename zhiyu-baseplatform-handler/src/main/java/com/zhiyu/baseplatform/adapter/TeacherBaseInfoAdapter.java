package com.zhiyu.baseplatform.adapter;

import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.google.common.collect.Lists;
import com.zhiyu.baseplatform.dto.TeacherBaseInfoDto;
import com.zhiyu.baseplatform.entity.AcademicTitleEntity;
import com.zhiyu.baseplatform.entity.TeacherBaseInfoEntity;
import com.zhiyu.baseplatform.service.IAcademicTitleService;
import com.zhiyu.baseplatform.service.ISchoolBaseInfoService;

/**
 * 
 * @author wdj
 *
 */
@Component
public class TeacherBaseInfoAdapter {
	
	@Autowired
	private IAcademicTitleService academicTitleService;
	
	@Autowired
	private ISchoolBaseInfoService schoolBaseInfoService;
	
	public TeacherBaseInfoDto getResponseDtoFromEntity(TeacherBaseInfoEntity entity){
		TeacherBaseInfoDto dto = new TeacherBaseInfoDto();
		if(entity.getAcademicTitleId()!=null){
			dto.setAcademicTitleId(entity.getAcademicTitleId());
			String[] arr = entity.getAcademicTitleId().split(",");
			String acName="";
			for (String id : arr) {
				if (!id.equals("")) {
					AcademicTitleEntity ac=academicTitleService.findObjectById(Integer.valueOf(id));
		            if(acName.equals("")){
		            	acName=acName+ac.getName();
		            }else{
		            	acName=acName+","+ac.getName();
		            }
				}
			}
			dto.setAcademicTitleName(acName);
		}
		dto.setPositionName(entity.getPositionName());
		dto.setAvatar(entity.getAvatar());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		if(entity.getBirthDate()!=null){
			dto.setBirthDate(formatter.format(entity.getBirthDate()));
		}else{
			dto.setBirthDate("");
		}
		if(entity.getEntryDate()!=null){
			dto.setEntryDate(formatter.format(entity.getEntryDate()));
		}else{
			dto.setEntryDate("");
		}
		dto.setCode(entity.getCode());
		dto.setId(entity.getId());
		if(entity.getName()!=null){
		  dto.setName(entity.getName());
		}else{
			dto.setName("");
		}
		dto.setSchoolId(entity.getSchoolId());
		String schoolName=schoolBaseInfoService.findObjectById(entity.getSchoolId()).getSchoolName();
		if(schoolName!=null){
			  dto.setSchoolName(schoolName);
			}else{
				dto.setSchoolName("");
			}
		if(entity.getTel()!=null){
			  dto.setTel(entity.getTel());
			}else{
				dto.setTel("");
			}
		dto.setSex(entity.getSex());
		return dto;
	}
	
	public List<TeacherBaseInfoDto> getResponseDtosFromEntityList(List<TeacherBaseInfoEntity> entityList){
		List<TeacherBaseInfoDto> dtos = Lists.newArrayList();
		for(TeacherBaseInfoEntity e:entityList){
			TeacherBaseInfoDto dto = getResponseDtoFromEntity(e);
			dtos.add(dto);
		}
		return dtos;
	}
}
