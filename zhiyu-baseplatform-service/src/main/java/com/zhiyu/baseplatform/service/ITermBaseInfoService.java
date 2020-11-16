package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.bean.PageBean;
import com.zhiyu.baseplatform.entity.TermBaseInfoEntity;

/**
 * 
 * @author csk
 *
 */
public interface ITermBaseInfoService {


	public TermBaseInfoEntity findObjectById(Integer id);
	
	public List<TermBaseInfoEntity> findByEntity(TermBaseInfoEntity entity);
	
	public List<TermBaseInfoEntity> findAll();
	
	public void update(TermBaseInfoEntity entity);
	
	public void save(TermBaseInfoEntity entity);
	
	public void del(Integer TermBaseInfoId);
	
	public List<TermBaseInfoEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
	
	/**
	 * 根据分页条件获取信息
	 * @param entity
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public PageBean<TermBaseInfoEntity> findPageByEntityWithSort(TermBaseInfoEntity entity,PageBean<TermBaseInfoEntity> page,Map<String, String> sortMap) throws Exception;
	
	public void saveOrUpdate(TermBaseInfoEntity entity);
	
	public TermBaseInfoEntity merge(TermBaseInfoEntity entity);
}
