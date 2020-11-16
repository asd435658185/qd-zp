package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.zhiyu.baseplatform.dao.ISmileAlbumDao;
import com.zhiyu.baseplatform.entity.SmileAlbumEntity;
import com.zhiyu.baseplatform.service.ISmileAlbumService;

/**
 * 
 * @author wdj
 *
 */
@Service
public class SmileAlbumService implements ISmileAlbumService {

	@Autowired
	private ISmileAlbumDao dao;
	
	/**
	 * 获取学生最新笑脸照片
	 * @param studentId
	 * @return
	 */
	public SmileAlbumEntity getLastestByStudentId(Integer studentId){
		Map<String, Object> fieldAndValueMap = Maps.newConcurrentMap();
		fieldAndValueMap.put("studentId", studentId);
		Map<String, String> sortMap = Maps.newConcurrentMap();
		sortMap.put("uploadTime", "desc");
		List<SmileAlbumEntity> albums = dao.findListByConditionMap(fieldAndValueMap, sortMap);
		if(albums==null || albums.isEmpty()){
			return null;
		}
		return albums.get(0);
	}
	/**
	 * 获取学生笑脸照片列表
	 * @param studentId
	 * @return
	 */
	public List<SmileAlbumEntity> getByStudentId(Integer studentId){
		Map<String, Object> fieldAndValueMap = Maps.newConcurrentMap();
		fieldAndValueMap.put("studentId", studentId);
		Map<String, String> sortMap = Maps.newConcurrentMap();
		sortMap.put("uploadTime", "desc");
		List<SmileAlbumEntity> albums = dao.findListByConditionMap(fieldAndValueMap, sortMap);
		return albums;
	}
	
	/**
	 * 删除学生笑脸照片
	 * @param id
	 * @return
	 */
	public void del(Long id) {
		dao.deleteObjectByIds(id);
	}
	
	public void save(SmileAlbumEntity entity){
		dao.saveOrUpdate(entity);
	}
}
