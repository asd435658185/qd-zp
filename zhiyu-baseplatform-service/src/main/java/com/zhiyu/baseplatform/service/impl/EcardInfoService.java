package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IEcardInfoDao;
import com.zhiyu.baseplatform.entity.EcardInfoEntity;
import com.zhiyu.baseplatform.service.IEcardInfoService;

/**
 *
 * @author wdj
 *
 */
@Service
public class EcardInfoService implements IEcardInfoService {

	@Autowired
	private IEcardInfoDao dao;

	public EcardInfoEntity findObjectById(Integer id) {
		EcardInfoEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<EcardInfoEntity> findByEntity(EcardInfoEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<EcardInfoEntity> findAll() {
		return dao.findAll();
	}

	public void update(EcardInfoEntity entity) {
		dao.update(entity);
	}

	public void save(EcardInfoEntity entity) {
		dao.save(entity);
	}

	public void del(Integer ecardInfoId) {
		dao.deleteObjectByIds(ecardInfoId);
	}

	public List<EcardInfoEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

}
