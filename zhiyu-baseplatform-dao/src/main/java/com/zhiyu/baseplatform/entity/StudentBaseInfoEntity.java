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
 * @Description 学生信息实体类
 */

@Table(name = "student_base_info")
@Entity
public class StudentBaseInfoEntity {
	private Integer id;// 学生id
	private String code;// 学生编号
	private String name;// 学生姓名
	private String tel;// 学生电话
	private Integer sex;// 学生性别
	private Date entranceDate;// 入学时间
	private Date birthDate;// 出生日期
	private String nativePlace;// 学生籍贯
	private String number;// 学生学号
	private String homeAddress;// 学生地址
	private String height;// 学生身高
	private String weight;// 学生体重
	private String constellation;// 学生星座
	private String heading;// 学生头像
	private Integer schoolId;
	private String oursideAvatar;// 外部头像地址

	private Integer updateType;//更新状态：1、新增；2、更改，3、删除
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "tel")
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "sex")
	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "entrance_date")
	public Date getEntranceDate() {
		return entranceDate;
	}

	public void setEntranceDate(Date entranceDate) {
		this.entranceDate = entranceDate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "birth_date")
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "native_place")
	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String native_place) {
		this.nativePlace = native_place;
	}

	@Column(name = "number")
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Column(name = "home_address")
	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	@Column(name = "height")
	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	@Column(name = "weight")
	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	@Column(name = "constellation")
	public String getConstellation() {
		return constellation;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}

	@Column(name = "heading")
	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	@Column(name = "school_id")
	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	@Column(name = "outside_avatar")
	public String getOursideAvatar() {
		return oursideAvatar;
	}

	public void setOursideAvatar(String oursideAvatar) {
		this.oursideAvatar = oursideAvatar;
	}

	@Column(name="update_type")
	public Integer getUpdateType() {
		return updateType;
	}
	public void setUpdateType(Integer updateType) {
		this.updateType = updateType;
	}
   
}
