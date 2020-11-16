package com.zhiyu.baseplatform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author csk
 * @Description 班级课程明细实体类
 */

@Table(name="class_schedule_detail")
@Entity
public class ClassScheduleDetailEntity {
   /**
   * 课程明细id
   * */
   private Integer id;
   /**
    * 任科老师id
    * */
   private Integer teacherId;
   /**
    * 科目id
    * */
   private Integer courseId;
   /**
    * 周几
    * */
   private Integer dayIndex;
   /**
    * 课节id
    * */
   private Integer lessionId;
   /**
    * 课程主表id
    * */
   private Integer scheduleId;
   
    @Id
 	@GeneratedValue(strategy=GenerationType.AUTO)
 	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="teacher_id")
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	
	@Column(name="course_id")
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	
	@Column(name="day_index")
	public Integer getDayIndex() {
		return dayIndex;
	}
	public void setDayIndex(Integer dayIndex) {
		this.dayIndex = dayIndex;
	}
	
	@Column(name="lession_id")
	public Integer getLessionId() {
		return lessionId;
	}
	public void setLessionId(Integer lessionId) {
		this.lessionId = lessionId;
	}
	
	@Column(name="schedule_id")
	public Integer getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}
   
   
}
