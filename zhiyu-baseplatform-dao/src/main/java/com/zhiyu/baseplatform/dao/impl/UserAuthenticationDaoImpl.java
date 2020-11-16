package com.zhiyu.baseplatform.dao.impl;

import org.springframework.stereotype.Repository;

import com.zhiyu.baseplatform.dao.IUserAuthenticationDao;
import com.zhiyu.baseplatform.dao.base.impl.CommonDaoImpl;
import com.zhiyu.baseplatform.entity.UserAuthenticationEntity;

/**
 * 
 * @author csk
 *
 */
@Repository
public class UserAuthenticationDaoImpl extends CommonDaoImpl<UserAuthenticationEntity> implements IUserAuthenticationDao{

}
