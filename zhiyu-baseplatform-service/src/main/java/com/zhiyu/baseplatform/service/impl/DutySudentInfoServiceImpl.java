package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhiyu.baseplatform.dao.IDutySudentInfoDao;
import com.zhiyu.baseplatform.entity.DutySudentInfoEntity;
import com.zhiyu.baseplatform.service.IDutySudentInfoService;

@Service
public class DutySudentInfoServiceImpl implements IDutySudentInfoService{

	@Autowired
	private IDutySudentInfoDao dao;

	public DutySudentInfoEntity findObjectById(Integer id) {
		DutySudentInfoEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<DutySudentInfoEntity> findByEntity(DutySudentInfoEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<DutySudentInfoEntity> findAll() {
		return dao.findAll();
	}

	public void update(DutySudentInfoEntity entity) {
		dao.update(entity);
	}

	public void save(DutySudentInfoEntity entity) {
		dao.save(entity);
	}

	public void del(Integer id) {
		dao.deleteObjectByIds(id);
	}

	public List<DutySudentInfoEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

}
