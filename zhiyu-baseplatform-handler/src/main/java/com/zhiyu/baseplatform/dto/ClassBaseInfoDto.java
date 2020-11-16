package com.zhiyu.baseplatform.dto;

/**
 * 班级基础信息dto对象
 * 
 * @author wdj
 *
 */
public class ClassBaseInfoDto {
	
	/**
	 * 班级id
	 */
	private Integer id;
	
	/**
	 * 班级编号
	 */
	private String code;
	
	/**
	 * 班级名称
	 */
	private String name;
	
	/**
	 * 班级班主任老师id
	 */
	private Integer masterTeacherId;
	
	/**
	 * 所在年级id
	 */
	private Integer gradeId;

	private String gradeName;

	private String masterTeacherName;
	
	private Integer schoolId;
	
    private String logoImg;
	
	private String classAddress;
	
	private Integer termId;
	
	private String termName;

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

	public Integer getMasterTeacherId() {
		return masterTeacherId;
	}

	public void setMasterTeacherId(Integer masterTeacherId) {
		this.masterTeacherId = masterTeacherId;
	}

	public Integer getGradeId() {
		return gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getMasterTeacherName() {
		return masterTeacherName;
	}

	public void setMasterTeacherName(String masterTeacherName) {
		this.masterTeacherName = masterTeacherName;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public String getLogoImg() {
		return logoImg;
	}

	public void setLogoImg(String logoImg) {
		this.logoImg = logoImg;
	}

	public String getClassAddress() {
		return classAddress;
	}

	public void setClassAddress(String classAddress) {
		this.classAddress = classAddress;
	}

	public Integer getTermId() {
		return termId;
	}

	public void setTermId(Integer termId) {
		this.termId = termId;
	}

	public String getTermName() {
		return termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}

}
