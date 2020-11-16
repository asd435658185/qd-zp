package com.zhiyu.baseplatform.service.identifycode.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.ISysIdentifyCodeGenerateDao;
import com.zhiyu.baseplatform.entity.SysIdentifyCodeGenerateEntity;
import com.zhiyu.baseplatform.service.identifycode.ISysIdentifyCodeGenerateService;

/**
 * 
 * @author wdj
 *
 */
@Service
public class SysIdentifyCodeGenerateService implements ISysIdentifyCodeGenerateService {

	@Autowired
	private ISysIdentifyCodeGenerateDao dao;
	
	public void saveOrUpdate(SysIdentifyCodeGenerateEntity entity) {
		dao.saveOrUpdate(entity);
	}

}
