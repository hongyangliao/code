package com.ducetech.framework.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 日期工具类
 *
 * @ClassName: DateUtils
 * @Date 17-9-29 下午4:30
 */
public class DateUtils {
	/**
	 * 默认时区 GMT+8
	 */
	public final static String DEFAULT_TIMEZONE = "GMT+8";

	/**
	 * 日期格式 yyyy-MM-dd'T'HH:mm:ss.SSS
	 */
	public final static String ISO_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";

	/**
	 * 日期格式 yyyy-MM-dd'T'HH:mm:ss
	 */
	public final static String ISO_SHORT_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	/**
	 * 日期格式 yyyy-MM-dd HH:mm:ss
	 */
	public final static String DEFAULT_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 日期格式 yyyy-MM-dd
	 */
	public final static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

	/**
	 * 日期格式 yyyy-MM-dd HH:mm
	 */
	public final static String SHORT_TIME_FORMAT = "yyyy-MM-dd HH:mm";

	/**
	 * 日期格式 yyyyMMddHHmmssSSS
	 */
	public final static String FULL_SEQ_FORMAT = "yyyyMMddHHmmssSSS";

	/**
	 * 混合日期格式
	 * yyyy-MM-dd
	 * yyyy-MM-dd HH:mm:ss
	 * yyyy-MM-dd'T'HH:mm:ss.SSS
	 * yyyy-MM-dd'T'HH:mm:ss
	 * yyyy-MM-dd HH:mm
	 * yyyy-MM
	 */
	public final static String[] MULTI_FORMAT = {DEFAULT_DATE_FORMAT, DEFAULT_TIME_FORMAT, ISO_DATE_TIME_FORMAT, ISO_SHORT_DATE_TIME_FORMAT,
			SHORT_TIME_FORMAT, "yyyy-MM"};

	/**
	 * 日期格式 yyyy
	 */
	public final static String FORMAT_YYYY = "yyyy";

	/**
	 * 日期格式 yyyyMM
	 */
	public final static String FORMAT_YYYYMM = "yyyyMM";

	/**
	 * 日期格式 yyyyMMdd
	 */
	public final static String FORMAT_YYYYMMDD = "yyyyMMdd";

	/**
	 * 日期格式 yyyyMMddHH
	 */
	public final static String FORMAT_YYYYMMDDHH = "yyyyMMddHH";


	/**
	 * 格式化日期为字符串 格式为 yyyy-MM-dd
	 *
	 * @param date 日期类型
	 * @return java.lang.String yyyy-MM-dd格式字符串
	 * @throws
	 * @Title: formatDefaultDate
	 * @Date: 17-9-29 下午4:31
	 */
	public static String formatDefaultDate(Date date) {
		if (date == null) {
			return "";
		}
		return new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(date);
	}

	/**
	 * 根据指定类型格式化日期为字符串
	 *
	 * @param date   日期类型
	 * @param format 格式
	 * @return java.lang.String
	 * @throws
	 * @Title: formatDate
	 * @Date: 17-9-29 下午4:34
	 */
	public static String formatDate(Date date, String format) {
		if (date == null) {
			return null;
		}
		return new SimpleDateFormat(format).format(date);
	}

	/**
	 * 根据格式将日期转换为Integer类型
	 *
	 * @param date   日期类型
	 * @param format 格式
	 * @return java.lang.Integer
	 * @throws
	 * @Title: formatDateToInt
	 * @Date: 17-9-29 下午4:50
	 */
	public static Integer formatDateToInt(Date date, String format) {
		if (date == null) {
			return null;
		}
		return Integer.valueOf(new SimpleDateFormat(format).format(date));
	}

	/**
	 * 根据格式将日期转换为Long类型
	 *
	 * @param date   日期类型
	 * @param format 格式
	 * @return java.lang.Long
	 * @throws
	 * @Title: formatDateToLong
	 * @Date: 17-9-29 下午4:50
	 */
	public static Long formatDateToLong(Date date, String format) {
		if (date == null) {
			return null;
		}
		return Long.valueOf(new SimpleDateFormat(format).format(date));
	}

	/**
	 * 将日期转换为 yyyy-MM-dd HH:mm:ss 格式字符串
	 *
	 * @param date 日期类型
	 * @return java.lang.String
	 * @throws
	 * @Title: formatDefaultTime
	 * @Date: 17-9-29 下午4:55
	 */
	public static String formatDefaultTime(Date date) {
		if (date == null) {
			return null;
		}
		return new SimpleDateFormat(DEFAULT_TIME_FORMAT).format(date);
	}

	/**
	 * 将日期转换为 yyyy-MM-dd HH:mm 格式字符串
	 *
	 * @param date
	 * @return java.lang.String
	 * @throws
	 * @Title: formatShortTime
	 * @Date: 17-9-29 下午4:57
	 */
	public static String formatShortTime(Date date) {
		if (date == null) {
			return null;
		}
		return new SimpleDateFormat(SHORT_TIME_FORMAT).format(date);
	}

	//public static String formatDateNow() {
	//    return formatDate(DateUtils.currentDate());
	//}

	//public static String formatTimeNow() {
	//    return formatTime(DateUtils.currentDate());
	//}

	/**
	 * 根据格式解析字符串为日期类型
	 *
	 * @param date   日期字符串
	 * @param format 格式
	 * @return java.util.Date 日期类型
	 * @throws
	 * @Title: parseDate
	 * @Date: 17-9-29 下午4:58
	 */
	public static Date parseDate(String date, String format) {
		if (date == null) {
			return null;
		}
		try {
			return new SimpleDateFormat(format).parse(date);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据 yyyy-MM-dd 格式解析字符串为日期类型
	 *
	 * @param date 日期字符串
	 * @return java.util.Date 日期类型
	 * @throws
	 * @Title: parseDefaultDate
	 * @Date: 17-9-29 下午4:58
	 */
	public static Date parseDefaultDate(String date) {
		return parseDate(date, DEFAULT_DATE_FORMAT);
	}

	/**
	 * 根据 yyyy-MM-dd HH:mm:ss 格式解析字符串为日期类型
	 *
	 * @param date 日期字符串
	 * @return java.util.Date 日期类型
	 * @throws
	 * @Title: parseDefaultTime
	 * @Date: 17-9-29 下午4:58
	 */
	public static Date parseDefaultTime(String date) {
		return parseDate(date, DEFAULT_TIME_FORMAT);
	}

	/**
	 * 将日期字符串加一天返回 yyyy-MM-dd 格式字符串
	 *
	 * @param date 日期字符串
	 * @return java.lang.String
	 * @throws
	 * @Title: plusOneDay
	 * @Date: 17-9-29 下午5:11
	 */
	public static String plusOneDay(String date) {
		DateTime dateTime = new DateTime(parseDefaultDate(date).getTime());
		return formatDefaultDate(dateTime.plusDays(1).toDate());
	}

	/**
	 * 将日期加一天返回 yyyy-MM-dd 格式字符串
	 *
	 * @param date 日期
	 * @return java.lang.String
	 * @throws
	 * @Title: plusOneDay
	 * @Date: 17-9-29 下午5:11
	 */
	public static String plusOneDay(Date date) {
		DateTime dateTime = new DateTime(date.getTime());
		return formatDefaultDate(dateTime.plusDays(1).toDate());
	}

	/**
	 * 把类似2014-01-01 ~ 2014-01-30格式的单一字符串转换为两个元素数组
	 *
	 * @param date 字符串
	 * @return java.util.Date[]
	 * @throws
	 * @Title: parseBetweenDates
	 * @Date: 17-10-9 上午9:17
	 */
	public static Date[] parseBetweenDates(String date) {
		if (StringUtils.isBlank(date)) {
			return null;
		}
		date = date.replace("～", "~");
		Date[] dates = new Date[2];
		String[] values = date.split("~");
		dates[0] = parseMultiFormatDate(values[0].trim());
		dates[1] = parseMultiFormatDate(values[1].trim());
		return dates;
	}

	/**
	 * 将
	 * yyyy-MM-dd
	 * yyyy-MM-dd HH:mm:ss
	 * yyyy-MM-dd'T'HH:mm:ss.SSS
	 * yyyy-MM-dd'T'HH:mm:ss
	 * yyyy-MM-dd HH:mm
	 * yyyy-MM
	 * 格式转换为Date
	 *
	 * @param date
	 * @return java.util.Date
	 * @throws
	 * @Title: parseMultiFormatDate
	 * @Date: 17-10-9 上午9:20
	 */
	public static Date parseMultiFormatDate(String date) {
		try {
			return org.apache.commons.lang3.time.DateUtils.parseDate(date, MULTI_FORMAT);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @Title:getDiffDay
	 * @Description:获取日期相差天数
	 * @param:@param beginDate  字符串类型开始日期
	 * @param:@param endDate    字符串类型结束日期
	 * @param:@return
	 * @return:Long 日期相差天数
	 * @author:谢
	 * @thorws:
	 */
	public static Long getDiffDay(String beginDate, String endDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Long checkday = 0l;
		//开始结束相差天数
		try {
			checkday = (formatter.parse(endDate).getTime() - formatter.parse(beginDate).getTime())/(1000*24*60*60);
		} catch (ParseException e) {

			e.printStackTrace();
			checkday = null;
		}
		return checkday;
	}

	/**
	 * @Title:getDiffDay
	 * @Description:获取日期相差天数
	 * @param:@param beginDate Date类型开始日期
	 * @param:@param endDate   Date类型结束日期
	 * @param:@return
	 * @return:Long 相差天数
	 * @author: 谢
	 * @thorws:
	 */
	public static Long getDiffDay(Date beginDate, Date endDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strBeginDate = format.format(beginDate);

		String strEndDate = format.format(endDate);
		return getDiffDay(strBeginDate, strEndDate);
	}

	/**
	 * N天之后
	 *
	 * @param n    天数
	 * @param date 日期
	 * @return java.util.Date
	 * @throws
	 * @Title: nDaysAfter
	 * @Date: 17-10-9 上午9:22
	 */
	public static Date nDaysAfter(Integer n, Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + n);
		return cal.getTime();
	}

	/**
	 * N天之前
	 *
	 * @param n    天数
	 * @param date 日期
	 * @return java.util.Date
	 * @throws
	 * @Title: nDaysAgo
	 * @Date: 17-10-9 上午9:23
	 */
	public static Date nDaysAgo(Integer n, Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) - n);
		return cal.getTime();
	}

	private static Date currentDate;

	/**
	 * 某一年的星期个数
	 *
	 * @param date 格式为yyyy的日期
	 * @return java.lang.Integer 星期个数
	 * @throws
	 * @Title: getWeekOfYear
	 * @Date: 17-10-9 上午9:25
	 */
	public static Integer getWeekOfYear(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		String yearString = formatDate(date, FORMAT_YYYY);
		int weekNum = c.get(Calendar.WEEK_OF_YEAR);
		if (weekNum < 10) {
			yearString = StringUtils.rightPad(yearString, 5, "0");
		}
		return Integer.valueOf(yearString + weekNum);
	}


	/**
	 * 获取某年某月的最后一天 月份从0开始
	 *
	 * @param year  年
	 * @param month 月
	 * @return java.lang.String yyyy-MM-dd字符串
	 * @throws
	 * @Title: getLastDayOfMonth
	 * @Date: 17-10-9 上午9:30
	 */
	public static String getLastDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));
		return new SimpleDateFormat("yyyy-MM-dd ").format(cal.getTime());
	}

	/**
	 * 获取某年某月的第一天 月份从0开始
	 *
	 * @param year  年
	 * @param month 月
	 * @return java.lang.String yyyy-MM-dd字符串
	 * @throws
	 * @Title: getFirstDayOfMonth
	 * @Date: 17-10-9 上午9:32
	 */
	public static String getFirstDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));
		return new SimpleDateFormat("yyyy-MM-dd ").format(cal.getTime());
	}

	//实例
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);
		System.out.println(DateUtils.formatDate(c.getTime(), DateUtils.FORMAT_YYYYMMDD));

		DateUtils.formatDate(new Date(), DEFAULT_DATE_FORMAT);

		Pattern p = Pattern.compile("(\\d{4})-(\\d{1,2})-(\\d{1,2})");
		Matcher m = p.matcher(DateUtils.formatDate(new Date(), DEFAULT_DATE_FORMAT));

		if (m.find()) {
			System.out.println("日期:" + m.group());
			System.out.println("年:" + m.group(1));
			System.out.println("月:" + m.group(2));
			System.out.println("日:" + m.group(3));
		}

		String time = "2015/11/02 ";

		System.out.println(parseDate(time, "yyyy/MM/dd"));
	}

}
