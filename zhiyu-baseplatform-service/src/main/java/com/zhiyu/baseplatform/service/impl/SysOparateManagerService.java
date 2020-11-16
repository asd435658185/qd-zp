package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.ISysOparateManagerDao;
import com.zhiyu.baseplatform.entity.SysOparateManager;
import com.zhiyu.baseplatform.service.ISysOparateManagerService;

/**
 *
 * @author wdj
 *
 */
@Service
public class SysOparateManagerService implements ISysOparateManagerService {

	@Autowired
	private ISysOparateManagerDao dao;

	public SysOparateManager findById(String id) {
		SysOparateManager entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<SysOparateManager> findByEntity(SysOparateManager entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<SysOparateManager> findAll() {
		return dao.findAll();
	}

	public void saveOrUpdate(SysOparateManager entity) {
		dao.save(entity);
	}

	public void del(Integer id) {
		dao.deleteObjectByIds(id);
	}

	public List<SysOparateManager> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

	public void deleteObjectByList(List<SysOparateManager> list) {
        dao.deleteObjectByList(list);
	}

}
