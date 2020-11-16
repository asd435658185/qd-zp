package com.zhiyu.baseplatform.dto;


/**
 * 老师信息响应数据
 * 
 * @author wdj
 *
 */
public class TeacherBaseInfoDto {
	private Integer id;// 老师id
	private String code;// 老师编号
	private String name;// 老师名称
	private String tel;// 老师电话
	private Integer sex;// 老师性别
	private String entryDate;// 入职时间
	private String birthDate;// 出生日期
	private String avatar;// 老师头像
	private String academicTitleId;// 老师职称id
	private Integer schoolId;// 所属学校id
	private String academicTitleName;
	private String schoolName;
	private String positionName;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getAcademicTitleId() {
		return academicTitleId;
	}

	public void setAcademicTitleId(String academicTitleId) {
		this.academicTitleId = academicTitleId;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public String getAcademicTitleName() {
		return academicTitleName;
	}

	public void setAcademicTitleName(String academicTitleName) {
		this.academicTitleName = academicTitleName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
}
