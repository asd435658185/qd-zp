package com.zhiyu.baseplatform.adapter;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.google.common.collect.Lists;
import com.zhiyu.baseplatform.dto.StudentBaseInfoDto;
import com.zhiyu.baseplatform.entity.ClassStudentRelEntity;
import com.zhiyu.baseplatform.entity.StudentBaseInfoEntity;
import com.zhiyu.baseplatform.enumcode.UploadFileType;
import com.zhiyu.baseplatform.processor.PictureInfoBeanFactory;
import com.zhiyu.baseplatform.processor.PictureSaveAndDisplayProcessor;
import com.zhiyu.baseplatform.service.IClassBaseInfoService;
import com.zhiyu.baseplatform.service.IClassStudentRelService;
import com.zhiyu.baseplatform.service.IGradeBaseInfoService;
import com.zhiyu.baseplatform.service.ISchoolBaseInfoService;
import com.zhiyu.baseplatform.service.ITermBaseInfoService;
/**
 *
 * @author csk
 *
 */
@Component
public class StudentBaseInfoAdapter {
	@Autowired
	private IClassStudentRelService classStudentRelService;

	@Autowired
	private ITermBaseInfoService termBaseInfoService;

	@Autowired
	private IClassBaseInfoService classBaseInfoService;

	@Autowired
	private IGradeBaseInfoService gradeBaseInfoService;

	@Autowired
	private ISchoolBaseInfoService schoolBaseInfoService;

	public StudentBaseInfoDto getResponseDtoFromEntity(StudentBaseInfoEntity entity){
		PictureSaveAndDisplayProcessor studentAvatarProcessor = new PictureSaveAndDisplayProcessor(PictureInfoBeanFactory.newInstance(UploadFileType.STUDENT_AVATAR));
		StudentBaseInfoDto dto = new StudentBaseInfoDto();
		dto.setId(entity.getId());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		if(entity.getBirthDate()!=null){
			dto.setBirthDate(formatter.format(entity.getBirthDate()));
		}else{
			dto.setBirthDate("");
		}
		if(entity.getEntranceDate()!=null){
			dto.setEntranceDate(formatter.format(entity.getEntranceDate()));
		}else{
			dto.setEntranceDate("");
		}
		dto.setClassName("");
		dto.setGradeName("");
		ClassStudentRelEntity cs=new ClassStudentRelEntity();
		cs.setStudentId(entity.getId());
		List<ClassStudentRelEntity> csList=classStudentRelService.findByEntity(cs);
		for(ClassStudentRelEntity e:csList){
			if(termBaseInfoService.findObjectById(e.getTermId()).getState()==1){
				cs=e;
				dto.setClassId(cs.getClassId());
		        dto.setClassName(classBaseInfoService.findObjectById(cs.getClassId()).getName());
		        dto.setGradeId(classBaseInfoService.findObjectById(classStudentRelService.findByEntity(cs).get(0).getClassId()).getGradeId());
		        dto.setGradeName(gradeBaseInfoService.findObjectById(classBaseInfoService.findObjectById(classStudentRelService.findByEntity(cs).get(0).getClassId()).getGradeId()).getName());
			}
		}
        
        dto.setCode(entity.getCode());
        dto.setConstellation(entity.getConstellation());
       
        dto.setHeading(studentAvatarProcessor.getFileService().getFileWebPathBySegment(entity.getHeading()));
        if( StringUtils.isNotBlank(entity.getHeight()) && !"cm".contains(entity.getHeight()) ){
        	String height = entity.getHeight() + " cm";
        	entity.setHeight(height);
        }
        if(entity.getHeight()!=null){
			dto.setHeight(entity.getHeight());
		}else{
			dto.setHeight("未设置");
		}
        if(entity.getHomeAddress()!=null){
			dto.setHomeAddress(entity.getHomeAddress());
		}else{
			dto.setHomeAddress("未设置");
		}
        dto.setName(entity.getName());
        if(entity.getNativePlace()!=null){
			dto.setNativePlace(entity.getNativePlace());
		}else{
			dto.setNativePlace("未设置");
		}
        if(entity.getNumber()!=null){
			dto.setNumber(entity.getNumber());
		}else{
			dto.setNumber("未设置");
		}
        dto.setSex(entity.getSex());
        if(entity.getTel()!=null){
			dto.setTel(entity.getTel());
		}else{
			dto.setTel("未设置");
		}
        if(StringUtils.isNotBlank(entity.getWeight()) && !"kg".contains(entity.getWeight())){
        	String weight = entity.getWeight() + " kg";
        	entity.setWeight(weight);
        }
        dto.setWeight(entity.getWeight());
        dto.setSchoolId(entity.getSchoolId());
        dto.setSchoolName(schoolBaseInfoService.findObjectById(entity.getSchoolId()).getSchoolName());
		return dto;
	}

	public List<StudentBaseInfoDto> getResponseDtosFromEntityList(List<StudentBaseInfoEntity> entityList){
		List<StudentBaseInfoDto> dtos = Lists.newArrayList();
		for(StudentBaseInfoEntity e:entityList){
			StudentBaseInfoDto dto = getResponseDtoFromEntity(e);
			dtos.add(dto);
		}
		return dtos;
	}
}
