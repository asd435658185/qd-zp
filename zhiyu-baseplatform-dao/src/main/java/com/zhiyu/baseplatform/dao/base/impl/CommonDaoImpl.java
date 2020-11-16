package com.zhiyu.baseplatform.dao.base.impl;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zhiyu.baseplatform.bean.PageBean;
import com.zhiyu.baseplatform.bean.SqlQueryHelperBean;
import com.zhiyu.baseplatform.dao.base.ICommonDao;
import com.zhiyu.baseplatform.util.TUtil;
import com.zhiyu.baseplatform.util.TransformUtil;

public class CommonDaoImpl<T> extends HibernateDaoSupport implements ICommonDao<T> {

	private Logger logger = LoggerFactory.getLogger(getClass());

	protected Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public CommonDaoImpl() {
		/** T型转换 */
		this.entityClass = TUtil.getActualType(getClass());
	}

	@Resource(name = "sessionFactory")
	public void setSuperHibernateTemplate(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public void save(T entity) {
		try {
			getHibernateTemplate().save(entity);
			getHibernateTemplate().flush();
			logger.debug("save成功");
		} catch (Exception e) {
			logger.debug("save失败,异常为:{}", e);
		}
	}

	public void evict(Object entity){
		getHibernateTemplate().evict(entity);
	}

	public void update(T entity) {
		try {
			getHibernateTemplate().clear();
			getHibernateTemplate().update(entity);
			getHibernateTemplate().flush();
			logger.debug("update成功");
		} catch (Exception e) {
			logger.debug("update失败,异常为:{}", e);
		}
	}

	public T merge(T entity) {
		try {
			entity = getHibernateTemplate().merge(entity);
			getHibernateTemplate().flush();
			return entity;
		} catch (RuntimeException e) {
			logger.debug("saveOrUpdate方法执行失败，异常信息为:{}", e);
			throw e;
		}
	}

	public T findObjectById(Serializable id) {
		return (T) this.getHibernateTemplate().get(entityClass, id);
	}

	public void deleteObjectByIds(Serializable... ids) {
		if (ids != null && ids.length > 0) {
			for (Serializable id : ids) {
				// 先查询
				Object entity = this.findObjectById(id);
				logger.debug("准备删除");
				// 再删除
				try {
					this.getHibernateTemplate().delete(entity);
					getHibernateTemplate().flush();
					logger.debug("成功删除");
				} catch (Exception e) {
					logger.debug("删除失败,原因;{}", e.getMessage());
				}

			}
		}
	}

	public void deleteObjectByList(List<T> list) {
		this.getHibernateTemplate().deleteAll(list);
	}

	/**
	 * 指定查询条件，查询列表 condition: name=? and age=? params: "testName" 20 orderby:
	 * key=表字段field, value=asc/desc
	 **/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby) {
		// hql语句
		String hql = "from " + entityClass.getSimpleName() + " o where 1=1  ";
		// 将Map集合中存放的字段排序，组织成ORDER BY o.textDate ASC,o.textName DESC
		// ，如果单表的，可以去掉o
		String orderbyCondition = this.orderbyHql(orderby);
		// 添加查询条件
		if (StringUtils.isNotBlank(condition)) {
			hql += condition;
		}
		if (StringUtils.isNotBlank(orderbyCondition)) {
			hql += orderbyCondition;
		}
		final String finalHql = hql;
		List<T> list = (List<T>) this.getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(finalHql);
				if (params != null && params.length > 0) {
					for (int i = 0; i < params.length; i++) {
						query.setParameter(i, params[i]);
					}
				}
				return query.list();
			}
		});
		return list;
	}

	/**
	 * 将Map集合中存放的字段排序，组织成 ORDER BY o.textDate ASC,o.textName DESC key是o.textDate
	 * value是升序或者降序
	 **/
	private String orderbyHql(Map<String, String> orderby) {
		StringBuffer buffer = new StringBuffer("");
		if (orderby != null && orderby.size() > 0) {
			buffer.append(" ORDER BY ");
			for (Map.Entry<String, String> map : orderby.entrySet()) {
				buffer.append(map.getKey() + " " + map.getValue() + ",");
			}
			// 在循环后，删除最后一个逗号
			buffer.deleteCharAt(buffer.length() - 1);
		}
		return buffer.toString();
	}

	public void saveOrUpdate(T entity) {
		try {
			getHibernateTemplate().saveOrUpdate(entity);
			getHibernateTemplate().flush();
			logger.debug("saveOrUpdate方法执行成功");
		} catch (RuntimeException e) {
			logger.error("saveOrUpdate方法执行失败，异常信息为:{}", e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		List<T> list;
		try {
			list = (List<T>) getHibernateTemplate().find(" from " + entityClass.getName());
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取编码序列
	 *
	 * @return
	 */
	public Integer generateSequenceValueByName(String sequenceName) {
		final String getNextSeqSql = "select NEXTVAL('" + sequenceName + "')";
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session) throws HibernateException {
				return (Integer) session.createSQLQuery(getNextSeqSql).uniqueResult();
			}
		});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List findBySQL(final String sql){
		return  (List) getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
				List<T> list = query.list();
				getHibernateTemplate().flush();
				return list;
			}
		});
	}

	public List<T> findListByConditionMap(Map<String, Object> fieldAndValueMap, Map<String, String> sortMap) {
		SqlQueryHelperBean bean = new SqlQueryHelperBean(fieldAndValueMap);
		return findListByConditionWithNoPage(bean.getConditionStr().toString(), bean.getParams().toArray(), sortMap);
	}

	public List<T> findByEntity(T entity) throws Exception {
		Map<String, Object> map = Maps.newConcurrentMap();
		map = TransformUtil.objectToMap(entity);
		Set<String> keys = map.keySet();
		List<String> deletsKeys = Lists.newArrayList();
		for (String key : keys) {
			if (map.get(key) == null) {
				deletsKeys.add(key);
			}
		}
		for (String key : deletsKeys) {
			map.remove(key);
		}
		return this.findListByConditionMap(map, null);
	}

	/**
	 * 根据分页条件获取信息
	 * @param entity
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public PageBean<T> findPageByEntity(T entity,PageBean<T> page) throws Exception {
		Map<String, Object> map = Maps.newConcurrentMap();
		map = TransformUtil.objectToMap(entity);
		Set<String> keys = map.keySet();
		List<String> deletsKeys = Lists.newArrayList();
		for (String key : keys) {
			if (map.get(key) == null) {
				deletsKeys.add(key);
			}
		}
		for (String key : deletsKeys) {
			map.remove(key);
		}
		page.setItems(findPageByConditionMap(map, page, null));
		SqlQueryHelperBean bean = new SqlQueryHelperBean(map);
		page.setTotalNum(getCount(page.getTypePrimaryKeyName(),bean.getConditionStr().toString(),bean.getParams().toArray()));
		return page;
	}

	/**
	 * 根据分页条件获取信息
	 * @param entity
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public PageBean<T> findPageByEntityWithSort(T entity,PageBean<T> page,Map<String, String> sortMap) throws Exception {
		Map<String, Object> map = Maps.newConcurrentMap();
		map = TransformUtil.objectToMap(entity);
		Set<String> keys = map.keySet();
		List<String> deletsKeys = Lists.newArrayList();
		for (String key : keys) {
			if (map.get(key) == null) {
				deletsKeys.add(key);
			}
		}
		for (String key : deletsKeys) {
			map.remove(key);
		}
		page.setItems(findPageByConditionMap(map, page, sortMap));
		SqlQueryHelperBean bean = new SqlQueryHelperBean(map);
		page.setTotalNum(getCount(page.getTypePrimaryKeyName(),bean.getConditionStr().toString(),bean.getParams().toArray()));
		return page;
	}

	/**
	 * 根据map，分页条件获取列表
	 * @param fieldAndValueMap
	 * @param page
	 * @param sortMap
	 * @return
	 */
	private List<T> findPageByConditionMap(Map<String, Object> fieldAndValueMap, PageBean<T> page,Map<String, String> sortMap) {
		SqlQueryHelperBean bean = new SqlQueryHelperBean(fieldAndValueMap);
		return findListByConditionWithByPage(bean.getConditionStr().toString(), bean.getParams().toArray(), page,sortMap);
	}

	/**
	 * 统计数据数
	 *
	 * @param primaryKeyName
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Integer getCount(final String primaryKeyName,final String condition, final Object[] params) {
		Integer count = 0;
		List<T> list = (List<T>) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				String fromTableHql = "from " + entityClass.getSimpleName() + " o where 1=1  ";
				String hql = "SELECT COUNT(o." + primaryKeyName + ") " + fromTableHql;
				// 添加查询条件
				if (StringUtils.isNotBlank(condition)) {
					hql += condition;
				}
				Query query = session.createQuery(hql);
				if (params != null && params.length > 0) {
					for (int i = 0; i < params.length; i++) {
						query.setParameter(i, params[i]);
					}
				}
				List<T> list = query.list();
				return list;
			}
		});

		if (list.size() > 0) {
			count = Integer.valueOf(list.get(0).toString());
		}
		return count;

	}

	/**
	 * 分页查询
	 *
	 * @param condition
	 * @param params
	 * @param page
	 * @param orderby
	 * @return
	 */
	public PageBean<T> findPage(String condition, final Object[] params, final PageBean<T> page,
			Map<String, String> orderby) {
		page.setItems(findListByConditionWithByPage(condition, params, page, orderby));
		page.setTotalNum(getCount(page.getTypePrimaryKeyName(),condition,params));
		return page;
	}

	/**
	 * 指定查询条件，查询列表 condition: name=? and age=? params: "testName" 20 orderby:
	 * key=表字段field, value=asc/desc
	 **/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findListByConditionWithByPage(String condition, final Object[] params, final PageBean<T> page,
			Map<String, String> orderby) {
		String hql = "from " + entityClass.getSimpleName() + " o where 1=1  ";
		String orderbyCondition = this.orderbyHql(orderby);
		// 添加查询条件
		if (StringUtils.isNotBlank(condition)) {
			hql += condition;
		}
		if (StringUtils.isNotBlank(orderbyCondition)) {
			hql += orderbyCondition;
		}
		final String finalHql = hql;
		List<T> list = (List<T>) this.getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(finalHql);
				if (params != null && params.length > 0) {
					for (int i = 0; i < params.length; i++) {
						query.setParameter(i, params[i]);
					}
				}
				query.setFirstResult(page.getStart());
				query.setMaxResults(page.getPageSize());
				return query.list();
			}
		});
		return list;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<List<Map<String, Object>>> findBySQLs(final String sql){
		return  (List<List<Map<String, Object>>>) getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException {
				final List<List<Map<String, Object>>> result = new ArrayList<List<Map<String, Object>>>();
				session.doWork(new Work() {
	                public void execute(Connection conn) throws SQLException {
	                    CallableStatement cs = null;
	                    ResultSet rs = null;
	                    cs = conn.prepareCall(sql);
	                    boolean hadResults = cs.execute();
	                    ResultSetMetaData metaData = null;
	                    while (hadResults) {// 遍历结果集
	                        List<Map<String, Object>> rsList = new ArrayList<Map<String, Object>>();// 用于装该结果集的内容
	                        rs = cs.getResultSet();// 获取当前结果集
	                        metaData = rs.getMetaData();
	                        int colCount = metaData.getColumnCount();// 获取当前结果集的列数
	                        while (rs.next()) {
	                            Map<String, Object> map = new HashMap<String, Object>();
	                            for (int i = 1; i <= colCount; i++) {
	                                String colName = metaData.getColumnName(i);
	                                map.put(colName, rs.getObject(colName));
	                            }
	                            rsList.add(map);
	                        }
	                        result.add(rsList);
	                        close(null, rs);// 遍历完一个结果集，将其关闭
	                        hadResults = cs.getMoreResults();// 移到下一个结果集
	                    }
	                    close(cs, rs);
	                }
	            });
	            return result;
			}
		});
	}
	private void close(CallableStatement cs, ResultSet rs) {
        try {
            if (cs != null) {
                cs.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
