package com.zhiyu.baseplatform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhiyu.baseplatform.dao.IDayBaseInfoDao;
import com.zhiyu.baseplatform.entity.DayBaseInfoEntity;
import com.zhiyu.baseplatform.service.IDayBaseInfoService;

/**
 * 
 * @author csk
 *
 */
@Service
public class DayBaseInfoServiceImpl implements IDayBaseInfoService{
	
	@Autowired
	private IDayBaseInfoDao dao;
	
	public List<DayBaseInfoEntity> findByEntity(DayBaseInfoEntity entity) {
		return dao.findAll();
	}

	public void save(DayBaseInfoEntity entity) {
		dao.save(entity);
	}

}
