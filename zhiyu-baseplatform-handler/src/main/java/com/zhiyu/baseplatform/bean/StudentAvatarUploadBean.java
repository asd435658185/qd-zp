package com.zhiyu.baseplatform.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 学生头像上传bean
 * @author Administrator
 *
 */
@Component("studentAvatarUploadBean")
public class StudentAvatarUploadBean implements UploadInfoBean {

	@Value("#{configProperties['resource.manage.student.avatar.file.fileroot']}")
	private String directory;
	
	@Value("#{configProperties['resource.manage.student.avatar.file.webroot']}")
	private String webRoot;
	
	public String getUploadFileRoot() {
		return directory;
	}

	public String getUploadFileWebRoot() {
		return webRoot;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public String getWebRoot() {
		return webRoot;
	}

	public void setWebRoot(String webRoot) {
		this.webRoot = webRoot;
	}

}
