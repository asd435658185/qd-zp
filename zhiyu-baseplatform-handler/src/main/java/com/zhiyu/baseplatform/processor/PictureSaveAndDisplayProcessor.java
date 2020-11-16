package com.zhiyu.baseplatform.processor;

import com.zhiyu.baseplatform.bean.UploadInfoBean;
import com.zhiyu.baseplatform.service.FileService;
import com.zhiyu.baseplatform.service.JpgPicUploadHandler;

/**
 * 图片存储展示处理器
 * @author wdj
 *
 */

public class PictureSaveAndDisplayProcessor {

	private FileService fileService;
	
	private JpgPicUploadHandler picUploadHandler;
	
	private String defaultSuffix = ".jpg";
	
	private String directoryName = "picDirectory";

	public PictureSaveAndDisplayProcessor(UploadInfoBean uploadInfoBean,String defaultSuffix, String directoryName) {
		super();
		this.defaultSuffix = defaultSuffix;
		this.directoryName = directoryName;
		this.fileService = new FileService(uploadInfoBean);
		this.picUploadHandler = new JpgPicUploadHandler(uploadInfoBean,defaultSuffix,directoryName);
	}

	public PictureSaveAndDisplayProcessor(UploadInfoBean uploadInfoBean){
		this.fileService = new FileService(uploadInfoBean);
		this.picUploadHandler = new JpgPicUploadHandler(uploadInfoBean,defaultSuffix,directoryName);
	}
	
	public FileService getFileService() {
		return fileService;
	}

	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

	public JpgPicUploadHandler getPicUploadHandler() {
		return picUploadHandler;
	}

	public void setPicUploadHandler(JpgPicUploadHandler picUploadHandler) {
		this.picUploadHandler = picUploadHandler;
	}

	public String getDefaultSuffix() {
		return defaultSuffix;
	}

	public void setDefaultSuffix(String defaultSuffix) {
		this.defaultSuffix = defaultSuffix;
	}

	public String getDirectoryName() {
		return directoryName;
	}

	public void setDirectoryName(String directoryName) {
		this.directoryName = directoryName;
	}
	
}
