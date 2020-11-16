package com.zhiyu.baseplatform.service;

import java.util.List;

import com.zhiyu.baseplatform.entity.SmileAngelEntity;

/**
 * 
 * @author wdj
 *
 */

public interface ISmileAngelService {

	/**
	 * 获取随机列表
	 * @param schoolId
	 * @param size
	 * @return
	 */
	public List<SmileAngelEntity> findRandomList(Integer schoolId,Integer size);
	/**
	 * 根据条件获取列表
	 * @return
	 */
	public List<SmileAngelEntity> findByEntity(SmileAngelEntity entity);
	
	public void save(SmileAngelEntity entity);
}
