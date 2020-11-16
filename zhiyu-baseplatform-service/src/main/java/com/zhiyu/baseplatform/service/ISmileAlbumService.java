package com.zhiyu.baseplatform.service;

import java.util.List;

import com.zhiyu.baseplatform.entity.SmileAlbumEntity;

/**
 * 
 * @author wdj
 *
 */

public interface ISmileAlbumService {

	/**
	 * 获取学生最新笑脸照片
	 * @param studentId
	 * @return
	 */
	public SmileAlbumEntity getLastestByStudentId(Integer studentId);
	
	/**
	 * 获取学生笑脸照片列表
	 * @param studentId
	 * @return
	 */
	public List<SmileAlbumEntity> getByStudentId(Integer studentId);
	
	public void del(Long id);
	
	public void save(SmileAlbumEntity entity);
}
