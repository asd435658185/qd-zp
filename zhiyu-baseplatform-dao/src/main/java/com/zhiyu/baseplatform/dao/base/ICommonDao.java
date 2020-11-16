package com.zhiyu.baseplatform.dao.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.bean.PageBean;

/**
 * 公有接口的数据访问层
 * @author wdj
 *
 */
public interface ICommonDao<T> {

	public void save(T entity);
	
	public void update(T entity);
	
	public T findObjectById(Serializable id);
	
	public void deleteObjectByIds(Serializable...ids);
	
	public void deleteObjectByList(List<T> list);
	
	public List<T> findListByConditionWithNoPage(String condition,Object[] params, Map<String, String> orderby);
	
	public void saveOrUpdate(T entity);
	
	public List<T> findAll();
	
	/**
	 * 获取编码序列
	 * @return
	 */
	public Integer generateSequenceValueByName(String sequenceName);
	
	public List<T> findListByConditionMap(Map<String, Object> fieldAndValueMap,Map<String, String> sortMap);
	
	public List<T> findByEntity(T entity) throws Exception;
	
	public T merge(T entity);
	
	/**
	 * 分页查询
	 * @param condition
	 * @param params
	 * @param page
	 * @param orderby
	 * @return
	 */
	public PageBean<T> findPage(String condition, final Object[] params, final PageBean<T> page,Map<String, String> orderby);
	
	/**
	 * 根据分页条件获取信息
	 * @param entity
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public PageBean<T> findPageByEntity(T entity,PageBean<T> page) throws Exception;
	

	/**
	 * 根据分页条件获取信息
	 * @param entity
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public PageBean<T> findPageByEntityWithSort(T entity,PageBean<T> page,Map<String, String> sortMap) throws Exception;
	
	@SuppressWarnings("rawtypes")
	public List findBySQL(String sql);
	
	@SuppressWarnings("rawtypes")
	public List<List<Map<String, Object>>> findBySQLs(String sql);
	
	public void evict(Object entity);
}
