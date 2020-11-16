package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import com.zhiyu.baseplatform.entity.EcardInfoEntity;

/**
 * 电子班牌信息服务
 * @author wdj
 *
 */

public interface IEcardInfoService {
	
    public EcardInfoEntity findObjectById(Integer id);
	
	public List<EcardInfoEntity> findByEntity(EcardInfoEntity entity);
	
	public List<EcardInfoEntity> findAll();
	
	public void update(EcardInfoEntity entity);
	
	public void save(EcardInfoEntity entity);
	
	public void del(Integer EcardInfoId);
	
	public List<EcardInfoEntity> findListByConditionWithNoPage(String condition, final Object[] params, Map<String, String> orderby);
}
