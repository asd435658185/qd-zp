package com.zhiyu.baseplatform.dto;

/**
 * APP端班級教室dto對象
 * @author wdj
 *
 */

public class ClassTeacherAppDto {
	/**
	 * 关联id
	 */
	private Integer relId;
	/**
	 * 老师id
	 */
	private Integer teacherId;

	private String teacherName;
	/**
	 * 班级id
	 */
	private Integer classId;

	private Integer termId;

	private Integer curfocus;

	private String classCode;

	private String className;
	
	private Boolean isClassManage;//是否为班主任

	public Integer getRelId() {
		return relId;
	}

	public void setRelId(Integer relId) {
		this.relId = relId;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getTermId() {
		return termId;
	}

	public void setTermId(Integer termId) {
		this.termId = termId;
	}

	public Integer getCurfocus() {
		return curfocus;
	}

	public void setCurfocus(Integer curfocus) {
		this.curfocus = curfocus;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Boolean getIsClassManage() {
		return isClassManage;
	}

	public void setIsClassManage(Boolean isClassManage) {
		this.isClassManage = isClassManage;
	}

}
