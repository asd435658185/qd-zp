package com.zhiyu.baseplatform.service;


import java.util.List;

import com.zhiyu.baseplatform.entity.TestAccountLogInfoEntity;

/**
 *
 * @author wdj
 *
 */

public interface ITestAccountLogInfoService {

	public void saveRecord(Integer schoolId,Integer rid,String oid,String tableName);

	public List<TestAccountLogInfoEntity> findBySchoolId(Integer schoolId);

	public void deleteById(String id);
}
