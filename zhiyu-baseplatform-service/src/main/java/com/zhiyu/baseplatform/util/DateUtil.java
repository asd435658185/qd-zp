package com.zhiyu.baseplatform.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class DateUtil {
	public final static String detailFmt = "yyyy-MM-dd HH:mm:ss";
	public final static String detailFmt1 = "yyyy-MM-dd HH:mm";

	public final static String simpleFmt = "yyyy-MM-dd";

	public final static String wxFmt = "yyyyMMddHHmmss";
	public final static String wxFmt1 = "yyyyMMddHH";

	/**
	 * 指定月的当前时间
	 *
	 * @param month
	 * @return
	 */
	public static Date getTimeByMonth(Integer month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.MONTH, month - 1);
		return cal.getTime();
	}

	/**
	 * 一个月的开始第一天
	 *
	 * @param date
	 * @return
	 */
	public static Date getMonthBegin(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1, 0, 0, 0);
		return cal.getTime();
	}

	/**
	 * 一个月的结束第一天
	 *
	 * @param date
	 * @return
	 */
	public static Date getMonthEnd(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, 1, 0, 0, 0);
		cal.set(Calendar.SECOND, cal.get(Calendar.SECOND) - 1);

		return cal.getTime();
	}

	/**
	 * 格式化指定时间
	 *
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String format(Date date, String pattern) {
		if (date == null)
			return "";
		try {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			return df.format(date);
		} catch (Exception e) {
		}
		return "";

	}

	/**
	 * 以yyyy/MM/dd方式格式化指定时间
	 *
	 * @param date
	 * @return
	 */
	public static String formatSimplyDate(Date date) {
		return format(date, simpleFmt);
	}

	/**
	 * 以yyyy/MM/dd方式格式化指定时间
	 *
	 * @param date
	 * @return
	 */
	public static String formatDetailDate(Date date) {
		return format(date, detailFmt);
	}

	public static String formatDetailDate1(Date date) {
		return format(date, detailFmt1);
	}

	/**
	 * 解释日期
	 *
	 * @param str
	 * @param pattern
	 * @return
	 * @throws Exception
	 */
	public static Date parse(String str, String pattern) {
		Date myDate = null;
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try {
			myDate = df.parse(str);
		} catch (Exception e) {
		}
		return myDate;
	}

	/**
	 * 解析日期
	 *
	 * @param str
	 * @return
	 */
	public static Date parse(String str) {
		return parse(str, simpleFmt);
	}

	/**
	 * 得到一天的开始时间，返回String
	 *
	 * @return
	 */
	public static String formatCurrentDayStart() {
		SimpleDateFormat df = new SimpleDateFormat(simpleFmt);
		return df.format(new Date());
	}

	/**
	 * 得到一天的结束时间，返回String
	 *
	 * @return
	 */
	public static String formatCurrentDayEnd() {
		StringBuffer str = new StringBuffer();
		str.append(formatCurrentDayStart());
		str.append(" 23:59:59");
		return str.toString();
	}

	public static String formatDateDayEnd(Date date) {
		StringBuffer str = new StringBuffer();
		str.append(formatSimplyDate(date));
		str.append(" 23:59:59");
		return str.toString();
	}

	public static String formatDateDayEnd(String date) {
		StringBuffer str = new StringBuffer();
		str.append(date);
		str.append(" 23:59:59");
		return str.toString();
	}

	/**
	 * 得到当天开始日期 ，不带小时分秒
	 *
	 * @return
	 * @throws Exception
	 */
	public static Date getCurrentDayStart() {
		return parse(formatCurrentDayStart());
	}

	public static Date getToday() {
		return parse(formatCurrentDayStart());
	}

	/**
	 * 得到当天结束日期 ，不带小时分秒
	 *
	 * @return
	 * @throws Exception
	 */
	public static Date getCurrentDayend() {
		return parse(formatCurrentDayEnd(), detailFmt);
	}

	/**
	 * 得到现在的时间
	 *
	 * @return
	 */
	public static Date getNow() {
		return new Timestamp(Calendar.getInstance().getTime().getTime());
	}

	/**
	 * 判断日期是否是当天时间
	 *
	 * @param date
	 * @return
	 */
	public static boolean judgeDateIsCurrentDay(Date date) {

		try {
			long time = date.getTime();
			long Daystart = getCurrentDayStart().getTime();
			long Dayend = getCurrentDayend().getTime();
			return Daystart <= time && time <= Dayend;
		} catch (Exception e) {
		}
		return false;
	}

	/**
	 * 比较日期字符串返回天数
	 *
	 * @param strBegin
	 *            格式：yyyy-MM-dd
	 * @param strEnd
	 *            格式：yyyy-MM-dd
	 * @return
	 * @throws Exception
	 */
	public static int getDifferDays(String strBegin, String strEnd)
			throws Exception {

		java.util.Calendar calst = java.util.Calendar.getInstance();
		java.util.Calendar caled = java.util.Calendar.getInstance();

		calst.setTime(parse(strBegin.concat(" 00:00:00"), detailFmt));
		caled.setTime(parse(strEnd.concat(" 00:00:00"), detailFmt));

		// 得到两个日期相差的天数
		int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst
				.getTime().getTime() / 1000)) / 3600 / 24;

		return days;

	}

	/**
	 * 比较日期返回天数
	 *
	 * @param strBegin
	 * @param strEnd
	 * @return
	 */
	public static final int getDifferDays(Date strBegin, Date strEnd) {
		java.util.Calendar calst = java.util.Calendar.getInstance();
		java.util.Calendar caled = java.util.Calendar.getInstance();
		calst.setTime(strBegin);
		caled.setTime(strEnd);
		// 设置时间为0时
		calst.set(java.util.Calendar.HOUR_OF_DAY, 0);
		calst.set(java.util.Calendar.MINUTE, 0);
		calst.set(java.util.Calendar.SECOND, 0);
		caled.set(java.util.Calendar.HOUR_OF_DAY, 0);
		caled.set(java.util.Calendar.MINUTE, 0);
		caled.set(java.util.Calendar.SECOND, 0);
		// 得到两个日期相差的天数
		int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst
				.getTime().getTime() / 1000)) / 3600 / 24;

		return days;
	}

	/**
	 * 在指定的日期增加天数
	 *
	 * @param initDate
	 * @param diff
	 * @return
	 */
	public static Date addDay(Date initDate, int diff) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(initDate);
		cal.add(Calendar.DATE, diff);
		return new Date(cal.getTimeInMillis());
	}

	public static Date addMonth(Date initDate, int diff) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(initDate);
		cal.add(Calendar.MONTH, diff);
		return new Date(cal.getTimeInMillis());
	}

	public static Date addMinute(Date initDate, int diff) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(initDate);
		cal.add(Calendar.MINUTE, diff);
		return new Date(cal.getTimeInMillis());
	}

	public static Date addHour(Date initDate, int diff) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(initDate);
		cal.add(Calendar.HOUR, diff);
		return new Date(cal.getTimeInMillis());
	}

	public static String formatYyyymmdd(Date date) {
		if (date == null)
			return "";
		String myDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			myDate = sdf.format(date);
		} catch (Exception e) {
		}
		return myDate;
	}

	public static String formatYyyyMMddHHmmss(Date date) {
		if (date == null)
			return "";
		String myDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			myDate = sdf.format(date);
		} catch (Exception e) {
		}
		return myDate;
	}

	public static long getDiffMinute(Date begin, Date end) {
		long nm = 1000 * 60;
		long diff = end.getTime() - begin.getTime();
		long min = diff / nm;
		return min;

	}

	public static Integer getTodayWeekIndex() {
		Calendar now = Calendar.getInstance();
		// 一周第一天是否为星期天
		boolean isFirstSunday = (now.getFirstDayOfWeek() == Calendar.SUNDAY);
		// 获取周几
		int weekDay = now.get(Calendar.DAY_OF_WEEK);
		// 若一周第一天为星期天，则-1
		if (isFirstSunday) {
			weekDay = weekDay - 1;
			if (weekDay == 0) {
				weekDay = 7;
			}
		}
		return weekDay;
	}

	/**
	 * 判断日期第几周
	 *
	 * @return
	 * @throws Exception
	 */
	public static int getWeek(Date fromDate,Date date) throws Exception {
		Calendar dateCalendar = Calendar.getInstance();
		dateCalendar.setTime(date);
		// 一周第一天是否为星期天
		boolean isFirstSunday = (dateCalendar.getFirstDayOfWeek() == Calendar.SUNDAY);
		//开学日期
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fromDate);
		int result = 0;
		int nowWeek = dateCalendar.get(Calendar.WEEK_OF_YEAR);
		int week = calendar.get(Calendar.WEEK_OF_YEAR);
		if (nowWeek >=week) {
			result = nowWeek - week+1;
		} else {
			int yearWeek = calendar.getActualMaximum(Calendar.WEEK_OF_YEAR);
			result = yearWeek - week + nowWeek;
		}
		if (isFirstSunday) {
			//result = result + 1;
		}
		return result;
	}

	/**
	 * 判断日期星期几
	 *
	 * @return
	 * @throws Exception
	 */
	public static int getWeekIndex(Date date) throws ParseException {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		// 一周第一天是否为星期天
		boolean isFirstSunday = (calendar.getFirstDayOfWeek() == Calendar.SUNDAY);
		// 获取周几
		int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
		// 若一周第一天为星期天，则-1
		if (isFirstSunday) {
			weekDay = weekDay - 1;
			if (weekDay == 0) {
				weekDay = 7;
			}
		}
		return weekDay;
	}



	/**
	 * 判断年份
	 *
	 * @return
	 * @throws Exception
	 */
	public static int getYear(String str) throws Exception {

		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		int year = c.get(Calendar.YEAR);
		return year;
	}

    /**
     * 日期比较
     *
     * @param s1 日期
     * @param s2 日期
     * @return s1＞s2 正数<br>
     *         s1＝s2 0<br>
     *         s1＜s2 负数<br>
     */
    public static long compareDateTime(java.util.Date s1, java.util.Date s2) {
        return s1.getTime() - s2.getTime();
    }

	/**
	 * 通过周和星期获取日期
	 * weekNo 第几周
	 * weekIndex 星期几
	 * @return
	 * @throws ParseException
	 * @throws Exception
	 */
	public static String getDate(Date begindate,int weekNo, int weekIndex) throws ParseException {
		int beginWeekIndex=getWeekIndex(begindate);

		int days=(weekNo-1)*7+weekIndex-beginWeekIndex;
		Date date=addDay(begindate,days);
		return DateUtil.formatSimplyDate(date);
	}

	public static Date TimeStamp2Date(Long ts){
		  Long timestamp = ts*1000;
		  Date date=new java.util.Date(timestamp);
		  return date;
		}
	public static String getHHMMSS(Date date){
		 DateFormat df = DateFormat.getTimeInstance();//只显示出时分秒
	     return  df.format(date);
	}
	public static void main(String[] args) throws Exception {
	}
}
