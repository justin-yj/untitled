/**
 * Copyright &copy; 2015-2020 <a href="http://www.atzhixiao.com/">atzhixiao</a> All rights reserved.
 */
package com.lw.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 * 
 * @author atzhixiao
 * @version 2014-4-15
 */
public class DateUtil extends org.apache.commons.lang3.time.DateUtils {

	private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
			"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss",
			"yyyy.MM.dd HH:mm", "yyyy.MM" };

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}

	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}
	
	public static String formatDate(Date date, String pattern) {
		if(StringUtils.isBlank(pattern)){
			pattern="yyyy-MM-dd HH:mm:ss";
		}
		if(date==null){
			date=new Date();
		}
		String formatDate = new SimpleDateFormat(pattern).format(date);
		return formatDate;
	}

	public static Date formatDateByDate(Date date, String pattern) {
		if (pattern != null && StringUtils.isNotBlank(pattern.toString())) {
			try {
				return new SimpleDateFormat(pattern).parse(new SimpleDateFormat(pattern).format(date));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			try {
				return new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(date));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return date;
	}

	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}
	
	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static int getMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH) + 1;  
		return month;
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	public static Date getDayTime(){
		return formatDateByDate(new Date(),"yyyy-MM-dd");
	}
	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}

	/**
	 * 日期型字符串转化为日期 格式 { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
	 * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy.MM.dd",
	 * "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
	 */
	public static Date parseDate(Object str) {
		if (str == null) {
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 获取过去的天数
	 * 
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (24 * 60 * 60 * 1000);
	}

	/**
	 * 获取过去的小时
	 * 
	 * @param date
	 * @return
	 */
	public static long pastHour(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (60 * 60 * 1000);
	}

	/**
	 * 获取过去的分钟
	 * 
	 * @param date
	 * @return
	 */
	public static long pastMinutes(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (60 * 1000);
	}

	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 * 
	 * @param timeMillis
	 * @return
	 */
	public static String formatDateTime(long timeMillis) {
		long day = timeMillis / (24 * 60 * 60 * 1000);
		long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
		long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
		return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
	}

	/**
	 * 获取两个日期之间的天数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
	}

	/**
	 * 时间戳转Date
	 * 
	 * @param timestamp
	 * @return
	 */
	public static Date timeStampToDate(String timestamp) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long time = Long.parseLong(timestamp) * 1000;
		String d = format.format(time);
		try {
			return format.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static List<String> dateToWeek(Date mdate) {
		List<String> list = new ArrayList<String>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(mdate);
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);

		for (int a = 0; a < 7; a++) {
			list.add(a, formatDate(addDays(cal.getTime(), a)));
		}
		return list;
	}

	public static String dateAmPm(Date mdate) {
		GregorianCalendar ca = new GregorianCalendar();
		ca.setTime(mdate);
		int type = ca.get(GregorianCalendar.AM_PM);
		if (type == 0) {
			return "上午";
		} else {
			return "下午";
		}
	}

	/**
	 * 根据用户生日计算年龄
	 */
	public static int getAgeByBirthday(Date birthday) {

		Calendar cal = Calendar.getInstance();
		if (cal.before(birthday)) {
			return 0;
		}
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(birthday);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
		int age = yearNow - yearBirth;
		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				// monthNow==monthBirth
				if (dayOfMonthNow < dayOfMonthBirth) {
					age--;
				}
			} else {
				// monthNow>monthBirth
				age--;
			}
		}
		return age;
	}

	/**
	 * 根据一个日期，返回是星期几的字符串
	 * 
	 * @param
	 * @return
	 */
	public static int getWeek(String date) {
		Calendar c = Calendar.getInstance();
		c.setTime(parseDate(date));
		int hour = c.get(Calendar.DAY_OF_WEEK);
		switch (hour) {
		case 1:
			return 7;
		case 2:
			return 1;
		case 3:
			return 2;
		case 4:
			return 3;
		case 5:
			return 4;
		case 6:
			return 5;
		case 7:
			return 6;
		}
		return 0;
	}
	
	public static int getWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int hour = c.get(Calendar.DAY_OF_WEEK);
		switch (hour) {
		case 1:
			return 7;
		case 2:
			return 1;
		case 3:
			return 2;
		case 4:
			return 3;
		case 5:
			return 4;
		case 6:
			return 5;
		case 7:
			return 6;
		}
		return 0;
	}

	public static List<Map<String, String>> getWeekDate(Date mdate) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(mdate);
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);

		for (int a = 0; a < 7; a++) {
			Map<String, String> map = new HashMap<String, String>();
			String date = formatDate(addDays(cal.getTime(), a));
			String weekDay = getWeekDayName(getWeek(date));
			map.put("date", date);
			map.put("weekDay", weekDay);
			list.add(a, map);
		}
		return list;
	}

	/**
	 * 获取星期几的名称
	 * 
	 * @param weekDay
	 * @return
	 */
	public static String getWeekDayName(int weekDay) {
		switch (weekDay) {
		case 1:
			return "星期一";
		case 2:
			return "星期二";
		case 3:
			return "星期三";
		case 4:
			return "星期四";
		case 5:
			return "星期五";
		case 6:
			return "星期六";
		case 7:
			return "星期日";

		default:
			return "";
		}
	}

	public static long intervalSecond(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / 1000;
	}

	/**
	 * 比较两个时间大小 d1>d2:1 d1<d2:-1 d1==d2:0
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int compareTime(Date d1, Date d2) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date t1 = new Date();
		Date t2 = new Date();
		try {
			t1 = fmt.parse(fmt.format(d1 == null ? new Date() : d1));
			t2 = fmt.parse(fmt.format(d2 == null ? new Date() : d2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (t1.getTime() > t2.getTime()) {
			return 1;
		} else if (t1.getTime() < t2.getTime()) {
			return -1;
		} else {
			return 0;
		}
	}

	/**
	 * 比较两个日期大小 d1>d2:1 d1<d2:-1 d1==d2:0
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int compareDate(Date d1, Date d2) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date t1 = new Date();
		Date t2 = new Date();
		try {
			t1 = fmt.parse(fmt.format(d1 == null ? new Date() : d1));
			t2 = fmt.parse(fmt.format(d2 == null ? new Date() : d2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (t1.getTime() > t2.getTime()) {
			return 1;
		} else if (t1.getTime() < t2.getTime()) {
			return -1;
		} else {
			return 0;
		}
	}

	/**
	 * 在指定时间加几分钟
	 * 
	 * @param date
	 * @param minute
	 * @return
	 */
	public static Date plusMinute(Date date, Integer minute) {
		Calendar afterTime = Calendar.getInstance();
		afterTime.setTime(date);
		afterTime.add(Calendar.MINUTE, minute);
		Date afterDate = (Date) afterTime.getTime();
		return afterDate;
	}

	/**
	 * 在指定时间加几天
	 * 
	 * @param date
	 * @param
	 * @return
	 */
	public static Date plusDay(Date date, Integer day) {
		Calendar afterTime = Calendar.getInstance();
		afterTime.setTime(date);
		afterTime.add(Calendar.DATE, day);
		Date afterDate = (Date) afterTime.getTime();
		return afterDate;
	}

	// 获取当前时间所在周的开始日期
	public static Date getFirstDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
		return c.getTime();
	}

	// 获取当前时间所在周的结束日期
	public static Date getLastDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
		return c.getTime();
	}

	// 获取某年的第几周的开始日期
	public static Date getFirstDayOfWeek(int year, int week) {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DATE, 1);

		Calendar cal = (GregorianCalendar) c.clone();
		cal.add(Calendar.DATE, week * 7);

		return getFirstDayOfWeek(cal.getTime());
	}

	// 获取某年的第几周的结束日期
	public static Date getLastDayOfWeek(int year, int week) {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DATE, 1);

		Calendar cal = (GregorianCalendar) c.clone();
		cal.add(Calendar.DATE, week * 7);

		return getLastDayOfWeek(cal.getTime());
	}

	// 获取当前时间所在年的周数
	public static int getWeekOfYear(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setMinimalDaysInFirstWeek(7);
		c.setTime(date);

		return c.get(Calendar.WEEK_OF_YEAR);
	}

	// 获取当前时间所在年的最大周数
	public static int getMaxWeekNumOfYear(int year) {
		Calendar c = new GregorianCalendar();
		c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);

		return getWeekOfYear(c.getTime());
	}

	public static Date getMonthfirst() {
		// 获取当前月第一天：
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		return c.getTime();
	}
	
	public static Date getMonthfirst(Date date) {
		// 获取当前月第一天：
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		return c.getTime();
	}

	public static Date getMonthlast() {
		// 获取当前月最后一天
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		return ca.getTime();
	}
	
	public static Date getMonthlast(Date date) {
		// 获取当前月最后一天
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		return ca.getTime();
	}

	// 更具年月获取月的第一天 如：2017-07 得到2017-07-01
	public static String getFirstDayOfMonth(String date) {
		return date + "-01";
	}

	// 根据年月获取月的最后一天
	public static String getLastDayOfMonth(Date dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = DateUtil.parseDate(sdf.format(dateStr));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		Date lastDayOfMonth = calendar.getTime();
		String str = sdf.format(lastDayOfMonth);
		return str;
	}

	// 获取当前月的天数
	public static int getDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1); // 把时间调整为当月的第一天；
		calendar.add(Calendar.MONTH, 1); // 月份调至下个月；
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		int days = calendar.get(Calendar.DAY_OF_MONTH);
		return days;
	}

	// 获取当前月的第N天
	public static Date getDayOfIndex(Date date, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, n); // 把时间调整为当月的第n天;
		return calendar.getTime();
	}

	// 获取当天开始时间
	public static Date getTimeOfStart(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	// 获取当前天结束时间
	public static Date getTimeOfEnd(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) {
		System.out.println(formatDateTime(plusMinute(new Date(),-30)) );
	}

}
