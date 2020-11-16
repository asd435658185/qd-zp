package com.zhiyu.baseplatform.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("notificationPicUploadBean")
public class NotificationPicUploadBean implements UploadInfoBean {

	@Value("#{configProperties['resource.manage.notification.file.fileroot']}")
	private String directory;
	
	@Value("#{configProperties['resource.manage.notification.file.webroot']}")
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
