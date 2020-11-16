package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;
import com.zhiyu.baseplatform.entity.SysOparateManager;

/**
 * 
 * @author wdj
 *
 */

public interface ISysOparateManagerService {

	/**
	 * 根据用户Id查询数据
	 * @param userId
	 * @return
	 */
	public SysOparateManager findById(String id);
	
    public List<SysOparateManager> findByEntity(SysOparateManager entity);
	
	public List<SysOparateManager> findAll();
	
	public void saveOrUpdate(SysOparateManager entity);
	
	public void del(Integer id);
	
	public void deleteObjectByList(List<SysOparateManager> list);
	
	public List<SysOparateManager> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
}
