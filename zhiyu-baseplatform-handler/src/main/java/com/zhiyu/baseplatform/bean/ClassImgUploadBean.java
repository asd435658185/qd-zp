package com.zhiyu.baseplatform.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.zhiyu.baseplatform.bean.UploadInfoBean;

@Component("classImgUploadBean")
public class ClassImgUploadBean implements UploadInfoBean {

	@Value("#{configProperties['resource.manage.class.img.file.fileroot']}")
	private String directory;
	
	@Value("#{configProperties['resource.manage.class.img.file.webroot']}")
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

