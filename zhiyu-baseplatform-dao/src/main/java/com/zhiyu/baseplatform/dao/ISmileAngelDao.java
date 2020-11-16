package com.zhiyu.baseplatform.dao;

import com.zhiyu.baseplatform.dao.base.ICommonDao;
import com.zhiyu.baseplatform.entity.SmileAngelEntity;

/**
 * 
 * @author wdj
 *
 */

public interface ISmileAngelDao extends ICommonDao<SmileAngelEntity>{

	public Integer getCount(final String primaryKeyName,final String condition, final Object[] params);
}
