package com.zhiyu.baseplatform.util;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;
import com.zhiyu.baseplatform.dto.WeekDto;

/**
 *
 * @author wdj
 *
 */

public class WeekDataProcessor {

	private Date startDate;

	private Date endDate;

	private List<WeekDto> weekList =Lists.newArrayList();

//	private static String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

	public WeekDataProcessor(Date startDate, Date endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		achiveWeekListBetweenDates();
	}

	private void achiveWeekListBetweenDates() {
		int currentWeek = 1;
		int index = getWeekDay(startDate);
		if (index == 0 || index == 5 || index == 6) {// 如果当天是周天、周五、周六，则由下一周开始为第一周
			int space = getSpaceBetweenNextMonday(index);// 获取当前天到下周一的间隔天数
			Calendar cal = Calendar.getInstance();
			cal.setTime(startDate);
			cal.add(Calendar.DAY_OF_YEAR, space);
			startDate = cal.getTime();
			currentWeek = 0;
		} else {
			// 获取本周的周一作为开始日期
			startDate = DateUtil.addDay(startDate, (index - 1) * -1);
		}

		int days = daysOfTwo(startDate,endDate)+currentWeek;
		int mod = days%7==0? days/7:(days/7+1);//计算周数
		for(int i=1;i<=mod;i++){
			WeekDto week = new WeekDto(i, "第"+i+"周");
			week.setStartYmd(DateUtil.formatYyyymmdd(DateUtil.addDay(startDate, (i-1)*7)));
			week.setEndYmd(DateUtil.formatYyyymmdd(DateUtil.addDay(startDate, ((i-1)*7 + 6))));
			weekList.add(week);
		}
	}

	private  static int getWeekDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return w;
	}

	private static Integer getSpaceBetweenNextMonday(int currentDayIndex) {
		int minus = 1;// 计算距离下周周一的天数差
		if (currentDayIndex == 0) {
			minus = 1;
		}
		if (currentDayIndex == 5) {
			minus = 3;
		}
		if (currentDayIndex == 6) {
			minus = 2;
		}
		return minus;
	}

	public static int daysOfTwo(Date startDate, Date endDate) {
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(startDate);
		int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
		int year1 = aCalendar.get(Calendar.YEAR);
		aCalendar.setTime(endDate);
		int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
		int year2 = aCalendar.get(Calendar.YEAR);
		int space = day2 - day1;;
		if(year2>year1){
			space = space+365;
		}
		return space;

	}

	public List<WeekDto> getWeekList() {
		return weekList;
	}

	public void setWeekList(List<WeekDto> weekList) {
		this.weekList = weekList;
	}
}
