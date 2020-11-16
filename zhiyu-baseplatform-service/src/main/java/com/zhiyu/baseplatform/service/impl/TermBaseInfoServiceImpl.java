package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.ITermBaseInfoDao;
import com.zhiyu.baseplatform.bean.PageBean;
import com.zhiyu.baseplatform.entity.TermBaseInfoEntity;
import com.zhiyu.baseplatform.service.ITermBaseInfoService;
/**
 *
 * @author csk
 *
 */
@Service
public class TermBaseInfoServiceImpl implements ITermBaseInfoService{

	@Autowired
	private ITermBaseInfoDao dao;

	public List<TermBaseInfoEntity> findByEntity(TermBaseInfoEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save(TermBaseInfoEntity entity) {
		dao.save(entity);
	}

	public TermBaseInfoEntity findObjectById(Integer id) {
		TermBaseInfoEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<TermBaseInfoEntity> findAll() {
		return dao.findAll();
	}

	public void update(TermBaseInfoEntity entity) {
		dao.update(entity);
	}

	public void del(Integer TermBaseInfoId) {
		dao.deleteObjectByIds(TermBaseInfoId);
	}

	public List<TermBaseInfoEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

	public PageBean<TermBaseInfoEntity> findPageByEntityWithSort(TermBaseInfoEntity entity,
			PageBean<TermBaseInfoEntity> page, Map<String, String> sortMap) throws Exception {
		return dao.findPageByEntityWithSort(entity, page, sortMap);
	}

	public void saveOrUpdate(TermBaseInfoEntity entity) {
		dao.saveOrUpdate(entity);
	}

	public TermBaseInfoEntity merge(TermBaseInfoEntity entity) {
		// TODO Auto-generated method stub
		return dao.merge(entity);
	}

}
