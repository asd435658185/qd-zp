package com.zhiyu.baseplatform.service.identifycode;

import com.zhiyu.baseplatform.entity.SysIdentifyCodeGenerateEntity;

/**
 * 识别码生成方式
 * @author wdj
 *
 */

public interface ISysIdentifyCodeGenerateService {

	public void saveOrUpdate(SysIdentifyCodeGenerateEntity entity);
}
