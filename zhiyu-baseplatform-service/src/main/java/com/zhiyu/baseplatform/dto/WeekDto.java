package com.zhiyu.baseplatform.dto;

/**
 *
 * @author wdj
 *
 */

public class WeekDto {

	private Integer weekIndex; // 周的索引

	private String weekName; // 周的名称

	private String startYmd; // 周的开始日期（yyyyMMdd格式）

	private String endYmd;	// 周的结束日期（yyyyMMdd格式）

	public WeekDto(Integer weekIndex, String weekName) {
		super();
		this.weekIndex = weekIndex;
		this.weekName = weekName;
	}

	public Integer getWeekIndex() {
		return weekIndex;
	}

	public void setWeekIndex(Integer weekIndex) {
		this.weekIndex = weekIndex;
	}

	public String getWeekName() {
		return weekName;
	}

	public void setWeekName(String weekName) {
		this.weekName = weekName;
	}

	public String getStartYmd() {
		return startYmd;
	}

	public void setStartYmd(String startYmd) {
		this.startYmd = startYmd;
	}

	public String getEndYmd() {
		return endYmd;
	}

	public void setEndYmd(String endYmd) {
		this.endYmd = endYmd;
	}
}
