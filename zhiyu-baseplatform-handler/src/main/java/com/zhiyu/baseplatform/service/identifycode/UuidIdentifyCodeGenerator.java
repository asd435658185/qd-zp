package com.zhiyu.baseplatform.service.identifycode;

import java.util.UUID;

import com.zhiyu.baseplatform.entity.SysIdentifyCodeGenerateEntity;
import com.zhiyu.baseplatform.enumcode.IdentifyCodeGenerateType;

/**
 * UUID识别码生成方式
 * @author wdj
 *
 */
public class UuidIdentifyCodeGenerator extends AbsSysIdentifyCodeGenerator{
	
	
	@Override
	protected String createIdentifyCode(SysIdentifyCodeGenerateEntity entity) {
		entity.setType(IdentifyCodeGenerateType.UUID);
		return getUUID();
	}
	
	/**  
     * 自动生成32位的UUid，对应数据库的主键id进行插入用。  
     * @return  
     */  
    public static String getUUID() {  
        return UUID.randomUUID().toString().replace("-", "");  
    }  
}
