package com.zhiyu.baseplatform.service.identifycode;

import com.zhiyu.baseplatform.entity.SysIdentifyCodeGenerateEntity;
import com.zhiyu.baseplatform.enumcode.IdentifyCodeGenerateType;

/**
 * 默认识别码生成方式-相当于值由外部传入的
 * @author wdj
 *
 */
public class DefaultIdentifyCodeGenerator extends AbsSysIdentifyCodeGenerator{
	
	@Override
	protected String createIdentifyCode(SysIdentifyCodeGenerateEntity entity) {
		entity.setType(IdentifyCodeGenerateType.DEFAULT);
		return entity.getId();
	}
	
}
