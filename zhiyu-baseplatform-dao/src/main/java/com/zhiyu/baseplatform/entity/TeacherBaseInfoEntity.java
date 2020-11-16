package com.zhiyu.baseplatform.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author csk
 * @Description 老师信息实体类
 */

@Table(name="teacher_base_info")
@Entity
public class TeacherBaseInfoEntity {
	private Integer id;//	老师id
	private String code;//	老师编号
	private String name;//	老师名称
	private String tel;//	老师电话
	private Integer sex;//	老师性别
	private Date entryDate;//	入职时间
	private Date birthDate;//	出生日期
	private String avatar;//	老师头像
	private String academicTitleId;//	老师职称id
	private Integer schoolId;// 所属学校id
	private String positionName;//	老师职位名称
	private Integer updateType;//更新状态：1、新增；2、更改，3、删除
	@Id
 	@GeneratedValue(strategy=GenerationType.AUTO)
 	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="tel")
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Column(name="sex")
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="entry_date")
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="birth_date")
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Column(name="avatar")
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	@Column(name="academic_title_id")
	public String getAcademicTitleId() {
		return academicTitleId;
	}
	public void setAcademicTitleId(String academicTitleId) {
		this.academicTitleId = academicTitleId;
	}
	
	@Column(name="school_id")
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	
	@Column(name="position_name")
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	
	@Column(name="update_type")
	public Integer getUpdateType() {
		return updateType;
	}
	public void setUpdateType(Integer updateType) {
		this.updateType = updateType;
	}
}
