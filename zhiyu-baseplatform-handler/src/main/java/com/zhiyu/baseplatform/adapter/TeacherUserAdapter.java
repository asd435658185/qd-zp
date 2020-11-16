package com.zhiyu.baseplatform.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhiyu.baseplatform.dto.TeacherUserDto;
import com.zhiyu.baseplatform.entity.ClassBaseInfoEntity;
import com.zhiyu.baseplatform.entity.GradeBaseInfoEntity;
import com.zhiyu.baseplatform.entity.TeacherBaseInfoEntity;
import com.zhiyu.baseplatform.entity.UserAccessEntity;
import com.zhiyu.baseplatform.entity.UserAuthenticationEntity;
import com.zhiyu.baseplatform.service.IAccessBaseInfoService;
import com.zhiyu.baseplatform.service.IClassBaseInfoService;
import com.zhiyu.baseplatform.service.IGradeBaseInfoService;
import com.zhiyu.baseplatform.service.IUserAccessService;
import com.zhiyu.baseplatform.service.IUserAuthenticationService;
/**
 * 
 * @author csk
 *
 */
@Component
public class TeacherUserAdapter {
	
	@Autowired
	private IUserAuthenticationService userAuthenticationService;
	
	@Autowired
	private IAccessBaseInfoService accessBaseInfoService;
	
	@Autowired
	private IUserAccessService userAccessService;
	
	@Autowired
	private IGradeBaseInfoService gradeBaseInfoService;
	
	@Autowired
	private IClassBaseInfoService classBaseInfoService;
	
	public TeacherUserDto getData(TeacherBaseInfoEntity e){
		UserAuthenticationEntity user=userAuthenticationService.findObjectById(String.valueOf(e.getId()));
		TeacherUserDto dto=new TeacherUserDto();
		dto.setLoginAccount(user.getLoginAccount());
		dto.setLoginPassword(user.getLoginPassword());
		dto.setName(e.getName());
		dto.setUserId(user.getUserId());
		dto.setSchoolId(e.getSchoolId());
		UserAccessEntity userAccess=new UserAccessEntity();
		userAccess.setUserId(user.getUserId());
		List<UserAccessEntity> userAccessList=userAccessService.findByEntity(userAccess);
		if(userAccessList.size()>0){
			dto.setUserAccessId(userAccessList.get(0).getAuthorityId());
			dto.setUserAccessName(accessBaseInfoService.findObjectById(userAccessList.get(0).getAuthorityId()).getName());
		}else{
			dto.setUserAccessId(-1);
			dto.setUserAccessName("未设置");
		}
		GradeBaseInfoEntity grade=new GradeBaseInfoEntity();
		grade.setSchoolId(e.getSchoolId());
		grade.setMasterTeacherId(e.getId());
        List<GradeBaseInfoEntity> grades = gradeBaseInfoService.findByEntity(grade);
		if(grades.size()>0){
			dto.setGrade(true);
		}else{
			dto.setGrade(false);
		}
		ClassBaseInfoEntity classBaseInfo=new ClassBaseInfoEntity();
		classBaseInfo.setMasterTeacherId(e.getId());
		List<ClassBaseInfoEntity> classList=classBaseInfoService.findByEntity(classBaseInfo);
		if(classList.size()>0){
			dto.setClass(true);
		}else{
			dto.setClass(false);
		}
		return dto;
		
	}
	
	public List<TeacherUserDto> getDataList(List<TeacherBaseInfoEntity> teachers){
		
		List<TeacherUserDto> teacherUserList=new ArrayList<TeacherUserDto>();
		for(TeacherBaseInfoEntity e:teachers){
			TeacherUserDto dto=getData(e);
			teacherUserList.add(dto);
		}
		return teacherUserList;
		
	}
}
