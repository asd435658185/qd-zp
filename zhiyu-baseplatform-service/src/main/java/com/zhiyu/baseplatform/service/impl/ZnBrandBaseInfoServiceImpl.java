package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IZnBrandBaseInfoDao;
import com.zhiyu.baseplatform.entity.ZnBrandBaseInfoEntity;
import com.zhiyu.baseplatform.service.IZnBrandBaseInfoService;
/**
 *
 * @author csk
 *
 */
@Service
public class ZnBrandBaseInfoServiceImpl implements IZnBrandBaseInfoService{

	@Autowired
	private IZnBrandBaseInfoDao dao;

	public ZnBrandBaseInfoEntity findObjectById(Integer id) {
		ZnBrandBaseInfoEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<ZnBrandBaseInfoEntity> findByEntity(ZnBrandBaseInfoEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ZnBrandBaseInfoEntity> findAll() {
		return dao.findAll();
	}

	public void update(ZnBrandBaseInfoEntity entity) {
		dao.update(entity);
	}

	public void save(ZnBrandBaseInfoEntity entity) {
		dao.save(entity);
	}

	public void del(Integer znBrandBaseInfoId) {
		dao.deleteObjectByIds(znBrandBaseInfoId);
	}

	public List<ZnBrandBaseInfoEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

}
