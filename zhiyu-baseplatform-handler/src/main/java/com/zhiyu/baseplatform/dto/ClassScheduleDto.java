package com.zhiyu.baseplatform.dto;

public class ClassScheduleDto {
	/**
	  * 班级课程id
	  * */
     private Integer id;
     /**
	  * 班级id
	  * */
     private Integer classId;
     /**
 	  * 学期id
 	  * */
     private Integer termId;
     
     private String className;
     
     private String termName;
     
     private Integer gradeId;
     
     private String gradeName;
     
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getTermName() {
		return termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
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
     
}
