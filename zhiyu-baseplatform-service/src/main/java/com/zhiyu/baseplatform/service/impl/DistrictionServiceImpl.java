package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.IDistrictionDao;
import com.zhiyu.baseplatform.entity.DistrictionEntity;
import com.zhiyu.baseplatform.service.IDistrictionService;
/**
 *
 * @author csk
 *
 */
@Service
public class DistrictionServiceImpl implements IDistrictionService{

	@Autowired
	private IDistrictionDao dao;

	public List<DistrictionEntity> findByEntity(DistrictionEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void save(DistrictionEntity entity) {
		dao.save(entity);
	}

	public List<DistrictionEntity> findAll() {
		return dao.findAll();
	}

	public void update(DistrictionEntity entity) {
		dao.update(entity);
	}

	public void del(Integer DistrictionId) {
		dao.deleteObjectByIds(DistrictionId);
	}

	public List<DistrictionEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

	public DistrictionEntity findObjectById(Integer id) {
		DistrictionEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

}
