package com.zhiyu.baseplatform.adapter;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.zhiyu.baseplatform.bean.PageBean;
import com.zhiyu.baseplatform.dto.NoticeAppRequestDto;
import com.zhiyu.baseplatform.dto.NoticeAppRequestDto.CommentsDto;
import com.zhiyu.baseplatform.dto.NoticeAppRequestDto.NoticeLogDto;
import com.zhiyu.baseplatform.entity.HomeworkNoticeCommentsEntity;
import com.zhiyu.baseplatform.entity.HomeworkNoticeEntity;
import com.zhiyu.baseplatform.entity.NoticeLogEntity;
import com.zhiyu.baseplatform.entity.ParentBaseInfoEntity;
import com.zhiyu.baseplatform.entity.ParentStudentRelEntity;
import com.zhiyu.baseplatform.entity.SchoolNoticeCommentsEntity;
import com.zhiyu.baseplatform.entity.SchoolNoticeEntity;
import com.zhiyu.baseplatform.entity.TeacherBaseInfoEntity;
import com.zhiyu.baseplatform.enumcode.UploadFileType;
import com.zhiyu.baseplatform.processor.PictureInfoBeanFactory;
import com.zhiyu.baseplatform.processor.PictureSaveAndDisplayProcessor;
import com.zhiyu.baseplatform.service.IHomeworkNoticeCommentsService;
import com.zhiyu.baseplatform.service.INoticeLogService;
import com.zhiyu.baseplatform.service.IParentBaseInfoService;
import com.zhiyu.baseplatform.service.IParentStudentRelService;
import com.zhiyu.baseplatform.service.ISchoolBaseInfoService;
import com.zhiyu.baseplatform.service.ISchoolNoticeCommentsService;
import com.zhiyu.baseplatform.service.IStudentBaseInfoService;
import com.zhiyu.baseplatform.service.ITeacherBaseInfoService;

/**
 * 
 * @author wdj
 *
 */
@Component
public class NoticeAppRequestAdapter {
	@Autowired
	private ITeacherBaseInfoService teacherBaseInfoService;

	@Autowired
	private ISchoolBaseInfoService schoolBaseInfoService;

	@Autowired
	private IHomeworkNoticeCommentsService homeworkNoticeCommentsService;

	@Autowired
	private ISchoolNoticeCommentsService schoolNoticeCommentsService;

	@Autowired
	private IParentStudentRelService parentStudentRelService;

	@Autowired
	private IParentBaseInfoService parentBaseInfoService;

	@Autowired
	private IStudentBaseInfoService studentBaseInfoService;

	@Autowired
	private INoticeLogService noticeLogService;
	
	public NoticeAppRequestDto getHomeworkResponseDtoFromEntity(HomeworkNoticeEntity entity, Integer userId,
			Integer isParent, Integer studentId) {
		NoticeAppRequestDto dto = new NoticeAppRequestDto();
		dto.setId(entity.getId());
		dto.setNoticeTitle(entity.getHomeworkNoticeTitle());
		dto.setNoticeContent(entity.getHomeworkNoticeContent());
		PictureSaveAndDisplayProcessor noticeProcessor = new PictureSaveAndDisplayProcessor(
				PictureInfoBeanFactory.newInstance(UploadFileType.NOTIFICATION));
		if (StringUtils.isNotBlank(entity.getHomeworkNoticeImg1())) {
			dto.setNoticeImg1(noticeProcessor.getFileService().getFileWebPathBySegment(entity.getHomeworkNoticeImg1()));
		} else {
			dto.setNoticeImg1("");
		}
		if (StringUtils.isNotBlank(entity.getHomeworkNoticeImg2())) {
			dto.setNoticeImg2(noticeProcessor.getFileService().getFileWebPathBySegment(entity.getHomeworkNoticeImg2()));
		} else {
			dto.setNoticeImg2("");
		}
		if (StringUtils.isNotBlank(entity.getHomeworkNoticeImg3())) {
			dto.setNoticeImg3(noticeProcessor.getFileService().getFileWebPathBySegment(entity.getHomeworkNoticeImg3()));
		} else {
			dto.setNoticeImg3("");
		}
		dto.setNoticeTime(entity.getHomeworkNoticeTime());
		dto.setUserId(entity.getHomeworkNoticeTeacherId());
		TeacherBaseInfoEntity teacher = teacherBaseInfoService.findObjectById(entity.getHomeworkNoticeTeacherId());
		if(teacher!=null){
			dto.setUserName(teacher.getName());
		}
		dto.setType(0);// 0作业通知 1学校通知
		HomeworkNoticeCommentsEntity comment = new HomeworkNoticeCommentsEntity();
		comment.setHomeworkNoticeId(entity.getId());
		List<HomeworkNoticeCommentsEntity> comments = homeworkNoticeCommentsService.findByEntity(comment);
		List<CommentsDto> commentsDtoList = Lists.newArrayList();
		for (HomeworkNoticeCommentsEntity e : comments) {
			CommentsDto commentsDto = new CommentsDto();
			commentsDto.setCommentsContent(e.getCommentsContent());
			commentsDto.setCommentsTime(e.getCommentsTime());
			commentsDto.setCommentsUserId(e.getParentId());// 家长
			commentsDto.setId(e.getId());
			commentsDto.setNoticeId(e.getHomeworkNoticeId());
			commentsDto.setCommentsUserType(0);
			ParentBaseInfoEntity parent = parentBaseInfoService.findObjectById(e.getParentId());
			ParentStudentRelEntity parentStudent = new ParentStudentRelEntity();
			parentStudent.setParentId(parent.getId());
			List<ParentStudentRelEntity> parentStudentList = parentStudentRelService.findByEntity(parentStudent);
			if (parentStudentList.size() > 0) {
				commentsDto.setCommentsUserName(
						studentBaseInfoService.findById(parentStudentList.get(0).getStudentId()).getName()
								+ parentStudentList.get(0).getRelation());
			}
			commentsDtoList.add(commentsDto);
		}
		dto.setCommentsDtoList(commentsDtoList);
		// 通知日志
		List<NoticeLogDto> noticeLogDtoList = Lists.newArrayList();
		NoticeLogEntity noticelog = new NoticeLogEntity();
		noticelog.setNoticeId(entity.getId());
		noticelog.setNoticeType(1);
		if (isParent == 0) {// 家长端
			noticelog.setParentId(userId);
			noticelog.setStudentId(studentId);
		} else if (isParent == 1) {
			noticelog.setTeacherId(userId);
		}
		List<NoticeLogEntity> noticeLogs = noticeLogService.findByEntity(noticelog);
		for (NoticeLogEntity n : noticeLogs) {
			NoticeLogDto noticeLogDto = new NoticeLogDto();
			noticeLogDto.setId(n.getId());
			noticeLogDto.setNoticeId(n.getNoticeId());
			noticeLogDto.setNoticeType(n.getNoticeType());
			noticeLogDto.setTeacherId(n.getTeacherId());
			noticeLogDto.setParentId(n.getParentId());
			noticeLogDto.setStudentId(n.getStudentId());
			noticeLogDto.setStatus(n.getStatus());
			noticeLogDtoList.add(noticeLogDto);
		}
		dto.setNoticeLogDtoList(noticeLogDtoList);
		return dto;
	}

	public List<NoticeAppRequestDto> getHomeworkResponseDtosFromEntityList(PageBean<HomeworkNoticeEntity> entityList,
			Integer userId, Integer isParent, Integer studentId) {
		List<NoticeAppRequestDto> dtos = Lists.newArrayList();
		for (HomeworkNoticeEntity e : entityList.getItems()) {
			NoticeAppRequestDto dto = getHomeworkResponseDtoFromEntity(e, userId, isParent, studentId);
			dto.setPageNumber(entityList.getPageNo());
			dto.setPageLimit(entityList.getPageSize());
			dtos.add(dto);
		}
		return dtos;
	}

	public NoticeAppRequestDto getSchoolResponseDtoFromEntity(SchoolNoticeEntity entity, Integer userId,
			Integer isParent, Integer studentId) {
		NoticeAppRequestDto dto = new NoticeAppRequestDto();
		dto.setId(entity.getId());
		dto.setNoticeTitle(entity.getSchoolNoticeTitle());
		dto.setNoticeContent(entity.getSchoolNoticeContent());
		PictureSaveAndDisplayProcessor noticeProcessor = new PictureSaveAndDisplayProcessor(
				PictureInfoBeanFactory.newInstance(UploadFileType.NOTIFICATION));
		dto.setNoticeImg1(noticeProcessor.getFileService().getFileWebPathBySegment(entity.getSchoolNoticeImg1()));
		dto.setNoticeImg2(noticeProcessor.getFileService().getFileWebPathBySegment(entity.getSchoolNoticeImg2()));
		dto.setNoticeImg3(noticeProcessor.getFileService().getFileWebPathBySegment(entity.getSchoolNoticeImg3()));
		dto.setNoticeTime(entity.getSchoolNoticeTime());
		dto.setUserId(entity.getSchoolId());
		dto.setUserName(schoolBaseInfoService.findObjectById(entity.getSchoolId()).getSchoolName());
		dto.setType(1);// 0作业通知 1学校通知
		SchoolNoticeCommentsEntity comment = new SchoolNoticeCommentsEntity();
		comment.setSchoolNoticeId(entity.getId());
		List<SchoolNoticeCommentsEntity> comments = schoolNoticeCommentsService.findByEntity(comment);
		List<CommentsDto> commentsDtoList = Lists.newArrayList();
		for (SchoolNoticeCommentsEntity e : comments) {
			CommentsDto commentsDto = new CommentsDto();
			commentsDto.setCommentsContent(e.getCommentsContent());
			commentsDto.setCommentsTime(e.getCommentsTime());
			commentsDto.setCommentsUserId(e.getUserId());
			commentsDto.setId(e.getId());
			commentsDto.setNoticeId(e.getSchoolNoticeId());
			commentsDto.setCommentsUserType(e.getType());// 0家长 1老师
			if (e.getType() == 0) {
				ParentBaseInfoEntity parent = parentBaseInfoService.findObjectById(e.getUserId());
				ParentStudentRelEntity parentStudent = new ParentStudentRelEntity();
				parentStudent.setParentId(parent.getId());
				List<ParentStudentRelEntity> parentStudentList = parentStudentRelService.findByEntity(parentStudent);
				if (parentStudentList.size() > 0) {
					commentsDto.setCommentsUserName(
							studentBaseInfoService.findById(parentStudentList.get(0).getStudentId()).getName()
									+ parentStudentList.get(0).getRelation());
				}
			} else if (e.getType() == 1) {
				TeacherBaseInfoEntity teacher = teacherBaseInfoService.findObjectById(e.getUserId());
				if(teacher!=null){
					commentsDto.setCommentsUserName(teacher.getName());
				}
			}

			commentsDtoList.add(commentsDto);
		}
		dto.setCommentsDtoList(commentsDtoList);
		// 通知日志
		List<NoticeLogDto> noticeLogDtoList = Lists.newArrayList();
		NoticeLogEntity noticelog = new NoticeLogEntity();
		noticelog.setNoticeId(entity.getId());
		noticelog.setNoticeType(0);
		if (isParent == 0) {// 家长端
			noticelog.setParentId(userId);
			noticelog.setStudentId(studentId);
		} else if (isParent == 1) {
			noticelog.setTeacherId(userId);
		}

		List<NoticeLogEntity> noticeLogs = noticeLogService.findByEntity(noticelog);
		for (NoticeLogEntity n : noticeLogs) {
			NoticeLogDto noticeLogDto = new NoticeLogDto();
			noticeLogDto.setId(n.getId());
			noticeLogDto.setNoticeId(n.getNoticeId());
			noticeLogDto.setNoticeType(n.getNoticeType());
			noticeLogDto.setTeacherId(n.getTeacherId());
			noticeLogDto.setParentId(n.getParentId());
			noticeLogDto.setStudentId(n.getStudentId());
			noticeLogDto.setStatus(n.getStatus());
			noticeLogDtoList.add(noticeLogDto);
		}
		dto.setNoticeLogDtoList(noticeLogDtoList);
		return dto;
	}

	public List<NoticeAppRequestDto> getSchoolResponseDtosFromEntityList(PageBean<SchoolNoticeEntity> entityList,
			Integer userId, Integer isParent, Integer studentId) {
		List<NoticeAppRequestDto> dtos = Lists.newArrayList();
		for (SchoolNoticeEntity e : entityList.getItems()) {
			NoticeAppRequestDto dto = getSchoolResponseDtoFromEntity(e, userId, isParent, studentId);
			dto.setPageNumber(entityList.getPageNo());
			dto.setPageLimit(entityList.getPageSize());
			dtos.add(dto);
		}
		return dtos;
	}
}
