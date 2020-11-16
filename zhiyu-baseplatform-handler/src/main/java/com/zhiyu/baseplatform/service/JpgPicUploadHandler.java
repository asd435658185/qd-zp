package com.zhiyu.baseplatform.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.zhiyu.baseplatform.bean.UploadInfoBean;
import com.zhiyu.baseplatform.util.Base64Image;


/**
 * 图片上传处理
 * @author wdj
 *
 */

public class JpgPicUploadHandler {

	private UploadInfoBean bean;
	
	private String defaultSuffix = ".jpg";
	
	private String directoryName = "picDirectory";
	
	public JpgPicUploadHandler(UploadInfoBean bean) {
		super();
		this.bean = bean;
	}

	public JpgPicUploadHandler(UploadInfoBean bean, String defaultSuffix, String directoryName) {
		super();
		this.bean = bean;
		this.defaultSuffix = defaultSuffix;
		this.directoryName = directoryName;
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


	/**
	 * 上传图片，返回片段地址
	 * @param schoolId
	 * @param imgStr
	 * @return
	 * @throws IOException 
	 */
	public String uploadPicByApp(Integer schoolId,String imgStr) throws IOException{
		String segment = "";
		if(StringUtils.isNotBlank(imgStr)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			// 转成uuid命名
			String savePath = bean.getUploadFileRoot();
			if(StringUtils.isBlank(savePath)){
				throw new RuntimeException("文件上传地址配置获取有误");
			}
			String uuid = UUID.randomUUID().toString();
			String segmentPath = schoolId + "/" + directoryName + "/" + sdf.format(new Date());
			String saveFilePath = savePath + segmentPath;
			String newFileName = uuid +  defaultSuffix;
			String fileName = saveFilePath+"/"+newFileName;
			File file = new File(saveFilePath+"/");
			if(!file.exists()){
				file.mkdirs();
			}
			Base64Image.GenerateImage(imgStr, fileName);
			// 返回相关数据
			segment = segmentPath + "/" + newFileName;
		}
		return segment;
	}
	
	/**
	 * 上传图片，返回片段地址
	 * @param schoolId
	 * @param imgStr
	 * @return
	 * @throws IOException 
	 */
	public String uploadPicByWeb(Integer schoolId,InputStream inputStream) throws Exception{
		String segment = "";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			// 转成uuid命名
			String savePath = bean.getUploadFileRoot();
			if(StringUtils.isBlank(savePath)){
				throw new RuntimeException("文件上传地址配置获取有误");
			}
			String uuid = UUID.randomUUID().toString();
			String segmentPath = schoolId + "/" + directoryName + "/" + sdf.format(new Date());
			String saveFilePath = savePath + segmentPath;
			String newFileName = uuid +  defaultSuffix;
			File file = new File(saveFilePath+"/");
			if(!file.exists()){
				file.mkdirs();
			}
			FileUtils.copyInputStreamToFile(inputStream, new File(saveFilePath, newFileName));
			// 返回相关数据
			segment = segmentPath + "/" + newFileName;
		return segment;
	}
	/**
	 * 上传并压缩图片，返回片段地址
	 * @param schoolId
	 * @param imgStr
	 * @return
	 * @throws IOException 
	 */
	public List<String> uploadPicByWebZip(Integer schoolId,InputStream inputStream,int width, int hight) throws Exception{
		List<String> strList=Lists.newArrayList();
		String segment = "";
		String segment1 = "";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			// 转成uuid命名
			String savePath = bean.getUploadFileRoot();
			if(StringUtils.isBlank(savePath)){
				throw new RuntimeException("文件上传地址配置获取有误");
			}
			String uuid = UUID.randomUUID().toString();
			String segmentPath = schoolId + "/" + directoryName + "/" + sdf.format(new Date());
			String saveFilePath = savePath + segmentPath;
			String newFileName = uuid +  defaultSuffix;
			File file = new File(saveFilePath+"/");
			if(!file.exists()){
				file.mkdirs();
			}
			//上传文件
			FileUtils.copyInputStreamToFile(inputStream, new File(saveFilePath, newFileName));
		    // 缩放后需要保存的路径  
			String saveFileName = uuid +"_0"+defaultSuffix;
		    File saveFile = new File(saveFilePath+"/"+saveFileName);
            File oldFile = new File(saveFilePath+"/"+newFileName);
            ImageHelper.zipImageFile(oldFile, saveFile, width, hight, 0.7f);
			// 返回相关数据
			segment = segmentPath + "/" + newFileName;
			segment1 = segmentPath + "/" + saveFileName;
			strList.add(segment);
			strList.add(segment1);
			strList.add(String.valueOf(saveFile.length()));
		return strList;
	}
	/**
	 * 上传图片，返回片段地址
	 * @param schoolId
	 * @param isUseDateDirectory
	 * @param childDirectory
	 * @param imgStr
	 * @return
	 * @throws IOException 
	 */
	public String uploadPicByApp(Integer schoolId,boolean isUseDateDirectory,String childDirectory,String imgStr,String suffix) throws IOException{
		String segment = "";
		if(StringUtils.isNotBlank(imgStr)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			// 转成uuid命名
			String savePath = bean.getUploadFileRoot();
			if(StringUtils.isBlank(savePath)){
				throw new RuntimeException("文件上传地址配置获取有误");
			}
			String uuid = UUID.randomUUID().toString();
			String segmentPath = schoolId + "/" ;
			if(StringUtils.isNotBlank(childDirectory)){
				segmentPath = segmentPath + childDirectory + "/";
			}
			if(isUseDateDirectory){
				segmentPath = segmentPath + sdf.format(new Date()) + "/";
			}
			String saveFilePath = savePath + segmentPath;
			String newFileName = uuid +  suffix;
			String fileName = saveFilePath+newFileName;
			File file = new File(saveFilePath+"/");
			if(!file.exists()){
				file.mkdirs();
			}
			Base64Image.GenerateImage(imgStr, fileName);
			// 返回相关数据
			segment = segmentPath + newFileName;
		}
		return segment;
	}
	/**  
	 * @从制定URL下载文件并保存到指定目录
	 * @param filePath 文件将要保存的目录  
	 * @param method 请求方法，包括POST和GET  
	 * @param url 请求的路径  
	 * @return  
	 */  
	  
	public  String saveUrlAs(String fileName1,String fileName2,String urlPath)throws Exception{  
		String savePath = bean.getUploadFileRoot();
		if(StringUtils.isBlank(savePath)){
			throw new RuntimeException("文件上传地址配置获取有误");
		}
		String saveFilePath = savePath + fileName1 + "/" + fileName2;
		String newFileName = defaultSuffix;
		File file = new File(saveFilePath+"/");
		if(!file.exists()){
			file.mkdirs();
		}
		URL url = new URL(urlPath);
		FileUtils.copyURLToFile(url, new File(saveFilePath, newFileName));
		return savePath;  
	 }
}
