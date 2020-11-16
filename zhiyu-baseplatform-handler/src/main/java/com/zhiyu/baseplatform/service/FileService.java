package com.zhiyu.baseplatform.service;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.zhiyu.baseplatform.bean.UploadInfoBean;

/**
 * 文件查询服务
 * @author wdj
 *
 */

public class FileService {

	private UploadInfoBean infoBean;
	
	public final static List<String> UPLOAD_IMAGE_TYPES = Lists.newArrayList(".jpeg",".jpg");

	public final static List<String> UPLOAD_IMAGE_MIMETYPES = Lists.newArrayList("image/jpeg","image/jpg");

	public final static List<String> UPLOAD_MOVIE_TYPES = Lists.newArrayList(".mp4",".flv",".avi");

	public final static List<String> UPLOAD_MOVIE_MIMETYPES = Lists.newArrayList("video/mp4","video/flv","video/avi");
	
	public final static List<String> UPLOAD_EXCEL_TYPES = Lists.newArrayList(".xls");
	
	public final static List<String> UPLOAD_EXCEL_MIMETYPES = Lists.newArrayList("application/vnd.ms-excel");

	public final static String RESOURCE_SHOW_PARAM = "path";
	
	public FileService(UploadInfoBean infoBean) {
		super();
		this.infoBean = infoBean;
	}

	/**
	 * 获取文件片段路径  物理地址路径---片段路径
	 * @return
	 */
	public String getFileSegmentPathByFullPath(String fileFullPath) {
		fileFullPath = fileFullPath.replace(infoBean.getUploadFileRoot(), "");
		return fileFullPath;
	}

	/**
	 * 获取文件片段路径 网站访问地址路径---片段路径
	 * @return
	 */
	public String getFileSegmentPathByWebPath(String fileWebPath) {
		fileWebPath = fileWebPath.replace(infoBean.getUploadFileWebRoot(), "");
		int space = 1 + RESOURCE_SHOW_PARAM.length()+1;
		return fileWebPath.substring(space);
	}

	/**
	 * 获取文件全路径  片段路径---物理全路径
	 * @param segment
	 * @return
	 */
	public String getFileFullPathBySegment(String segment) {
		if(StringUtils.isBlank(segment)){
			segment = "/default.jpg";
		}
		return infoBean.getUploadFileRoot()+segment;
	}

	/**
	 * 获取文件网站访问路径 片段路径---网站访问全路径
	 * @param segment
	 * @return
	 */
	public String getFileWebPathBySegment(String segment) {
		if(StringUtils.isNotBlank(segment)){
			return infoBean.getUploadFileWebRoot()+"&"+RESOURCE_SHOW_PARAM+"="+segment;
		}
		return infoBean.getUploadFileWebRoot()+"&"+RESOURCE_SHOW_PARAM+"=default.jpg";
	}

	/**
	 * 通过片段获取文件内容类型
	 * @param segment
	 * @return
	 */
	public String getContentTypeBySegment(String segment){
		
		String suffix = segment.substring(segment.lastIndexOf(".")).substring(1);
		String type = "";
		int index=  0;
		for(String imageType:UPLOAD_IMAGE_TYPES){
			index++;
			if(imageType.contains(suffix)){
				type = UPLOAD_IMAGE_MIMETYPES.get(index-1);
				break;
			}
		}
		index=  0;
		for(String movieType:UPLOAD_MOVIE_TYPES){
			index++;
			if(movieType.contains(suffix)){
				type = UPLOAD_MOVIE_MIMETYPES.get(index-1);
				break;
			}
		}
		index=0;
		for(String movieType:UPLOAD_EXCEL_TYPES){
			index++;
			if(movieType.contains(suffix)){
				type = UPLOAD_EXCEL_MIMETYPES.get(index-1);
				break;
			}
		}
		return type;
	}
	
	/**
	 * 删除文件
	 * @param fileFullPath
	 */
	public void deleteFile(String segment){
		File file = new File(getFileFullPathBySegment(segment));
		if(file.exists()){
			file.delete();
		}
	}
	//删除文件夹  
	public void delFile(String folderPath) {  
		  String segment=infoBean.getUploadFileRoot()+folderPath;
		  delFolder(segment); //删除完里面所有内容  
	}
	//删除文件夹  
	public void delFolder(String segment) {  
	     try {  
	        delAllFile(segment); //删除完里面所有内容  
	        String filePath = segment;  
	        filePath = filePath.toString();  
	        java.io.File myFilePath = new java.io.File(filePath);  
	        myFilePath.delete(); //删除空文件夹  
	     } catch (Exception e) {  
	       e.printStackTrace();   
	     }  
	}  
//	删除指定文件夹下的所有文件
	public boolean delAllFile(String path) {  
	       boolean flag = false;  
	       File file = new File(path);  
	       if (!file.exists()) {  
	         return flag;  
	       }  
	       if (!file.isDirectory()) {  
	         return flag;  
	       }  
	       String[] tempList = file.list();  
	       File temp = null;  
	       for (int i = 0; i < tempList.length; i++) {  
	          if (path.endsWith(File.separator)) {  
	             temp = new File(path + tempList[i]);  
	          } else {  
	              temp = new File(path + File.separator + tempList[i]);  
	          }  
	          if (temp.isFile()) {  
	             temp.delete();  
	          }  
	          if (temp.isDirectory()) {  
	             delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件  
	             delFolder(path + "/" + tempList[i]);//再删除空文件夹  
	             flag = true;  
	          }  
	       }  
	       return flag;  
	 }  
}
