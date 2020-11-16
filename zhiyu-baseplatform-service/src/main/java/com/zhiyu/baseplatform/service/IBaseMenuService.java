package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;
import com.zhiyu.baseplatform.entity.BaseMenuEntity;

/**
 * 
 * @author csk
 *
 */
public interface IBaseMenuService {
	public List<BaseMenuEntity> findListByConditionMap(Map<String, Object> fieldAndValueMap, Map<String, String> sortMap);
	public void save(BaseMenuEntity entity);
	public BaseMenuEntity findById(Integer id);
	public List<BaseMenuEntity> findByEntity(BaseMenuEntity entity);
	public List<BaseMenuEntity> findAll();
	public void update(BaseMenuEntity entity);
	public void del(Integer id);
	public BaseMenuEntity merge(BaseMenuEntity entity);
}
