package com.zhiyu.baseplatform.service.impl;

import java.util.Date;
import java.util.UUID;
import java.util.*;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.ITestAccountLogInfoDao;
import com.zhiyu.baseplatform.entity.TestAccountLogInfoEntity;
import com.zhiyu.baseplatform.service.ITestAccountLogInfoService;

/**
 *
 * @author wdj
 *
 */
@Service
public class TestAccountLogInfoService implements ITestAccountLogInfoService {

	@Autowired
	private ITestAccountLogInfoDao dao;

	@Transactional
	public void saveRecord(Integer schoolId,Integer rid,String oid,String tableName) {
		TestAccountLogInfoEntity entity = new TestAccountLogInfoEntity();
		entity.setCreateTime(new Date());
		entity.setOid(oid);
		entity.setRid(rid);
		entity.setTableName(tableName);
		entity.setSchoolId(schoolId);
		entity.setId(UUID.randomUUID().toString());
		dao.save(entity);
	}

	public List<TestAccountLogInfoEntity> findBySchoolId(Integer schoolId) {
		TestAccountLogInfoEntity entity = new TestAccountLogInfoEntity();
		entity.setSchoolId(schoolId);
		List<TestAccountLogInfoEntity> list=null;
		try {
			list = dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	public void deleteById(String id){
		dao.deleteObjectByIds(id);
	}

}
