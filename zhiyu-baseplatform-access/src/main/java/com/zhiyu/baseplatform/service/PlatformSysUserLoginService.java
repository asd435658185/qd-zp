package com.zhiyu.baseplatform.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zhiyu.baseplatform.bean.BaseMenuBean;
import com.zhiyu.baseplatform.bean.UserInfoBean;
import com.zhiyu.baseplatform.entity.BaseMenuEntity;
import com.zhiyu.baseplatform.entity.MenuAccessRelEntity;
import com.zhiyu.baseplatform.entity.SysOparateManager;
import com.zhiyu.baseplatform.entity.TeacherBaseInfoEntity;
import com.zhiyu.baseplatform.entity.UserAccessEntity;
import com.zhiyu.baseplatform.entity.UserAuthenticationEntity;
import com.zhiyu.baseplatform.processor.BaseMenuProcessor;

/**
 * 平台系统用户登录服务
 * @author wdj
 *
 */
                     
@Service
public class PlatformSysUserLoginService {

	@Autowired
	private IUserAuthenticationService userAuthenticationService;//用户身份认证服务
	
	@Autowired
	private IUserAccessService userAccessService;//用户访问权限服务
	
	@Autowired
	private IMenuAccessRelService menuAccessRelService;//权限菜单关联服务
	
	@Autowired
	private IBaseMenuService baseMenuService;//基础菜单服务
	
	@Autowired
	private ISysOparateManagerService sysOperateManagerService;//系统操作人员服务类
	
	@Autowired
	private ITeacherBaseInfoService teacherBaseInfoService; 
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 获取登录用户Id
	 * @param loginAccount
	 * @param principal
	 * @return
	 */
	public String getUserId(String loginAccount,String principal){
		UserAuthenticationEntity entity = new UserAuthenticationEntity();
		entity.setLoginAccount(loginAccount);
		entity.setLoginPassword(principal);
		List<UserAuthenticationEntity> userList = userAuthenticationService.findByEntity(entity);
		if(userList!=null && !userList.isEmpty()){    
			return userList.get(0).getUserId();
		}
		return null;
	}
	
	/**
	 * 通过用户id获取该用户所能够拥有的菜单列表
	 * @param userId
	 * @return
	 */
	private List<BaseMenuBean> getMenuListByUserId(String userId){
		UserAccessEntity entity = new UserAccessEntity();
		entity.setUserId(userId);
		List<UserAccessEntity> userAccessList = userAccessService.findByEntity(entity);//获取用户的权限列表
		Map<Integer, BaseMenuEntity> menuMap = Maps.newConcurrentMap();
		List<MenuAccessRelEntity> accessMenuList = Lists.newArrayList();//菜单权限关联列表 才
		for(UserAccessEntity access:userAccessList){
			MenuAccessRelEntity rel = new MenuAccessRelEntity();
			rel.setAccessId(access.getAuthorityId());
			List<MenuAccessRelEntity> relList = Lists.newArrayList();
			relList = menuAccessRelService.findByEntity(rel);
			if(relList!=null && !relList.isEmpty()){
				accessMenuList.addAll(relList);
			}
		}
		//遍历关联列表，获取菜单列表
		for(MenuAccessRelEntity rel:accessMenuList){
			if(rel.getMenuId()!=null){
				if(!menuMap.containsKey(rel.getMenuId())){
					BaseMenuEntity menu = baseMenuService.findById(rel.getMenuId());
					if(menu!=null){
						menuMap.put(rel.getMenuId(),menu);
					}else{
						logger.info("菜单没配置好,对应菜单id为"+rel.getMenuId()+"的数据不存在");
					}
				}
			}
		}
		BaseMenuProcessor processor = new BaseMenuProcessor(Lists.newArrayList(menuMap.values()));
		return processor.getMenuList();
	}
	
	/**
	 * 获取用户信息
	 * @param userId    
	 * @return
	 */
	public UserInfoBean getUserInfo(String userId){
		UserInfoBean bean = new UserInfoBean();
		bean.setUserId(userId);
		bean.setMenuList(getMenuListByUserId(userId));
		SysOparateManager sysOperator = sysOperateManagerService.findById(userId); 
		if(sysOperator!=null){ //如果是操作人员
			bean.setUserName(sysOperator.getName());
			if(sysOperator.getSchoolId()!=null){
				bean.setSchoolId(sysOperator.getSchoolId());
			}
			bean.setLoginAccount(sysOperator.getId());
		}else{//如果不是操作人员，这里就是教师等相关人员了
			Integer teacherId = Integer.valueOf(userId);
			TeacherBaseInfoEntity teacher = teacherBaseInfoService.findObjectById(teacherId);
			bean.setUserName(teacher.getName());
			bean.setSex(teacher.getSex());
			bean.setSchoolId(teacher.getSchoolId());
			bean.setLoginAccount(teacher.getTel());
		}
		return bean;
	}
	
}
