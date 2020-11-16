package com.zhiyu.baseplatform.processor;

import com.zhiyu.baseplatform.bean.UploadInfoBean;
import com.zhiyu.baseplatform.enumcode.UploadFileType;
import com.zhiyu.baseplatform.service.SpringContextHolder;

/**
 * PictureInfoBean工厂
 *
 * @author wdj
 *
 */
public class PictureInfoBeanFactory {

	/**
	 * 根据文件类型来获取对应的实例
	 *
	 * @param fileType
	 * @return
	 */
	public static UploadInfoBean newInstance(UploadFileType fileType) {
		if (fileType.getValue().intValue() == UploadFileType.NOTIFICATION.getValue()) {
			return SpringContextHolder.getBean("notificationPicUploadBean");
		}
		if (fileType.getValue().intValue() == UploadFileType.STUDENT_AVATAR.getValue()) {
			return SpringContextHolder.getBean("studentAvatarUploadBean");
		}
		if (fileType.getValue().intValue() == UploadFileType.TEACHER_AVATAR.getValue()) {
			return SpringContextHolder.getBean("teacherAvatarUploadBean");
		}
		if (fileType.getValue().intValue() == UploadFileType.CLASS_IMG.getValue()) {
			return SpringContextHolder.getBean("classImgUploadBean");
		}
		if (fileType.getValue().intValue() == UploadFileType.GIFT_IMG.getValue()) {
			return SpringContextHolder.getBean("giftImgUploadBean");
		}
		if (fileType.getValue().intValue() == UploadFileType.PROJECT_IMG.getValue()) {
			return SpringContextHolder.getBean("projectImgUploadBean");
		}
		if (fileType.getValue().intValue() == UploadFileType.ANDRIOD_APP.getValue()) {
			return SpringContextHolder.getBean("andriodAppUploadBean");
		}
		if (fileType.getValue().intValue() == UploadFileType.MORAL_IMG.getValue()) {
			return SpringContextHolder.getBean("moralImgUploadBean");
		}
		if (fileType.getValue().intValue() == UploadFileType.MORAL_CLASS.getValue()) {
			return SpringContextHolder.getBean("moralClassUploadBean");
		}
		if(fileType.getValue().intValue()==UploadFileType.MORAL_TV.getValue()){
			return SpringContextHolder.getBean("moralTvUploadBean");
		}
		if(fileType.getValue().intValue()==UploadFileType.CLOUD_BASE_IMPORT_TEMPLATE_STUDENT.getValue()){
			return SpringContextHolder.getBean("templateUploadAndDownloadBean");
		}
		if(fileType.getValue().intValue()==UploadFileType.CLASS_ACTIVITY_SPACE.getValue()){
			return SpringContextHolder.getBean("csActivitySpaceUploadBean");
		}
		if(fileType.getValue().intValue()==UploadFileType.LINKTOP_RECORD.getValue()){
			return SpringContextHolder.getBean("linktopRecordUploadBean");
		}
		return null;
	}
}
