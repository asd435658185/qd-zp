package com.zhiyu.baseplatform.service.identifycode;

import com.zhiyu.baseplatform.entity.SysIdentifyCodeGenerateEntity;

/**
 * 识别码生成器
 * @author wdj
 *
 */

public abstract class AbsSysIdentifyCodeGenerator{
	
	protected abstract String createIdentifyCode(SysIdentifyCodeGenerateEntity entity);
	
	public SysIdentifyCodeGenerateEntity processIdentitfyCodeId(SysIdentifyCodeGenerateEntity entity){
		String code = createIdentifyCode(entity);
		entity.setId(code);
		return entity;
	}

}
