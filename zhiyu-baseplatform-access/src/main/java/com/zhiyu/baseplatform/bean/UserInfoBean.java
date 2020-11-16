package com.zhiyu.baseplatform.bean;

import java.util.List;

import com.google.common.collect.Lists;
import com.zhiyu.baseplatform.entity.AccessBaseInfoEntity;
import com.zhiyu.baseplatform.entity.PlatformProjectModuleEntity;
import com.zhiyu.baseplatform.enumcode.DataState;

/**
 * 登录用户bean
 * @author wdj
 *
 */

public class UserInfoBean {

	private Integer schoolId;//null表示是超级管理员
	
	private String userId;//用户id
	
	private String userName;//用户名称
	
	private String loginAccount;//登录账号
	
	private String avatar;//头像
	
	private Integer sex;//性别
	
	private List<BaseMenuBean> menuList = Lists.newArrayList();//拥有的菜单

	private List<UserAccessDto> userAccessDtos;
	public static class UserAccessDto{
		private Integer id;// 用户权限记录id
		private Integer authorityId;// 权限id
		private String userId;// 用户id
		private String remark;
		private AccessBaseInfoEntity accessBaseInfo;
		private List<UserAppDto> userAppDtos;
		public static class UserAppDto{
			private Integer projectId;//平台下项目id
			private String name;//项目名称
			private Integer value;//项目对应的数值
			private DataState state;//数据状态
			private List<AppDto> appDtos;
			public static class AppDto{
				private Integer id;
				private Integer schoolId;
				private Integer projectId;
				private Integer moduleId;
				private DataState state;
				private PlatformProjectModuleEntity pmEntity;
				private List<BaseMenuBean> menuList;
				public Integer getId() {
					return id;
				}
				public void setId(Integer id) {
					this.id = id;
				}
				public Integer getSchoolId() {
					return schoolId;
				}
				public void setSchoolId(Integer schoolId) {
					this.schoolId = schoolId;
				}
				public Integer getProjectId() {
					return projectId;
				}
				public void setProjectId(Integer projectId) {
					this.projectId = projectId;
				}
				public Integer getModuleId() {
					return moduleId;
				}
				public void setModuleId(Integer moduleId) {
					this.moduleId = moduleId;
				}
				public DataState getState() {
					return state;
				}
				public void setState(DataState state) {
					this.state = state;
				}
				public PlatformProjectModuleEntity getPmEntity() {
					return pmEntity;
				}
				public void setPmEntity(PlatformProjectModuleEntity pmEntity) {
					this.pmEntity = pmEntity;
				}
				public List<BaseMenuBean> getMenuList() {
					return menuList;
				}
				public void setMenuList(List<BaseMenuBean> menuList) {
					this.menuList = menuList;
				}
			}
			public Integer getProjectId() {
				return projectId;
			}
			public void setProjectId(Integer projectId) {
				this.projectId = projectId;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public Integer getValue() {
				return value;
			}
			public void setValue(Integer value) {
				this.value = value;
			}
			public DataState getState() {
				return state;
			}
			public void setState(DataState state) {
				this.state = state;
			}
			public List<AppDto> getAppDtos() {
				return appDtos;
			}
			public void setAppDtos(List<AppDto> appDtos) {
				this.appDtos = appDtos;
			}
		}
		public List<UserAppDto> getUserAppDtos() {
			return userAppDtos;
		}
		public void setUserAppDtos(List<UserAppDto> userAppDtos) {
			this.userAppDtos = userAppDtos;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getAuthorityId() {
			return authorityId;
		}
		public void setAuthorityId(Integer authorityId) {
			this.authorityId = authorityId;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		public AccessBaseInfoEntity getAccessBaseInfo() {
			return accessBaseInfo;
		}
		public void setAccessBaseInfo(AccessBaseInfoEntity accessBaseInfo) {
			this.accessBaseInfo = accessBaseInfo;
		}
		
	}
	public List<UserAccessDto> getUserAccessDtos() {
		return userAccessDtos;
	}

	public void setUserAccessDtos(List<UserAccessDto> userAccessDtos) {
		this.userAccessDtos = userAccessDtos;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<BaseMenuBean> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<BaseMenuBean> menuList) {
		this.menuList = menuList;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}
	
	
	
}
