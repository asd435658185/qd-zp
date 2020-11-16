package com.zhiyu.baseplatform.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 年级上线放学时间
 * @author wdj
 *
 */
@Table(name = "grade_lesson_period")
@Entity
public class GradeLessonPeriodEntity {
	private Integer id;
	private Integer gradeId;//	年段ID
	private String inTime1;//	上午上学时间（格式：HHMM）
	private String outTime1;//	上午放学时间（格式：HHMM）
	private String inTime2;//	下午上学时间（格式：HHMM）
	private String outTime2;//	下午放学时间（格式：HHMM）
	private Integer termId;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "grade_id")
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	@Column(name = "in_time_1")
	public String getInTime1() {
		return inTime1;
	}
	public void setInTime1(String inTime1) {
		this.inTime1 = inTime1;
	}
	@Column(name = "out_time_1")
	public String getOutTime1() {
		return outTime1;
	}
	public void setOutTime1(String outTime1) {
		this.outTime1 = outTime1;
	}
	@Column(name = "in_time_2")
	public String getInTime2() {
		return inTime2;
	}
	public void setInTime2(String inTime2) {
		this.inTime2 = inTime2;
	}
	@Column(name = "out_time_2")
	public String getOutTime2() {
		return outTime2;
	}
	public void setOutTime2(String outTime2) {
		this.outTime2 = outTime2;
	}
	@Column(name = "term_id")
	public Integer getTermId() {
		return termId;
	}
	public void setTermId(Integer termId) {
		this.termId = termId;
	}

}
