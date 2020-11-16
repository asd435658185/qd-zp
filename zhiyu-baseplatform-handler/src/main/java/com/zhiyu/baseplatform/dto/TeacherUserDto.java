package com.zhiyu.baseplatform.dto;
/**
 * 教师用户
 * @author wdj
 *
 */
public class TeacherUserDto {
	private String userId;// 用户id
	private String loginAccount;// 用户名
	private String loginPassword;// 用户密码
	private String name;
	private Integer schoolId;
	private Integer userAccessId;
	private String userAccessName;
	private boolean isGrade;// 是否为年段长
	private boolean isClass;// 是否为班主任
	private Integer id;
	private String openId;
	private String scanCode;//二维码

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public Integer getUserAccessId() {
		return userAccessId;
	}

	public void setUserAccessId(Integer userAccessId) {
		this.userAccessId = userAccessId;
	}

	public String getUserAccessName() {
		return userAccessName;
	}

	public void setUserAccessName(String userAccessName) {
		this.userAccessName = userAccessName;
	}

	public boolean isGrade() {
		return isGrade;
	}

	public void setGrade(boolean isGrade) {
		this.isGrade = isGrade;
	}

	public boolean isClass() {
		return isClass;
	}

	public void setClass(boolean isClass) {
		this.isClass = isClass;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getScanCode() {
		return scanCode;
	}

	public void setScanCode(String scanCode) {
		this.scanCode = scanCode;
	}
}
