package com.ducetech.framework.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 身份证工具类
 *
 * @ClassName: IDCardUtil
 * @Date 17-10-9 下午5:06
 */
public class IDCardUtils {
	private final static int[] wi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10,
			5, 8, 4, 2, 1};
	private final static int[] vi = {1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2};
	private static int[] ai = new int[18];

	/**
	 * 验证身份证号码的正确性
	 *
	 * @param idcard 身份证号码
	 * @return boolean 符合身份证规则为 true 否则为 false
	 * @throws
	 * @Title: verifyIDCard
	 * @Date: 17-10-9 下午5:08
	 */
	public static boolean verifyIDCard(String idcard) {
		if (idcard.length() == 15) {
			idcard = uptoeighteen(idcard);
		}
		if (idcard.length() != 18) {
			return false;
		}
		String verify = idcard.substring(17, 18);
		if (verify.equals(getVerify(idcard))) {
			return true;
		}
		return false;
	}

	/**
	 * 验证18位身份证号码的正确性
	 *
	 * @param eighteencardid 18位身份证
	 * @return java.lang.String
	 * @throws
	 * @Title: getVerify
	 * @Date: 17-10-9 下午5:10
	 */
	private static String getVerify(String eighteencardid) {
		int remaining = 0;
		if (eighteencardid.length() == 18) {
			eighteencardid = eighteencardid.substring(0, 17);
		}
		if (eighteencardid.length() == 17) {
			int sum = 0;
			for (int i = 0; i < 17; i++) {
				String k = eighteencardid.substring(i, i + 1);
				ai[i] = Integer.parseInt(k);
			}
			for (int i = 0; i < 17; i++) {
				sum = sum + wi[i]*ai[i];
			}
			remaining = sum%11;
		}
		return remaining == 2 ? "X" : String.valueOf(vi[remaining]);
	}

	/**
	 * 将15位身份证号码转换为18位身份证号码
	 *
	 * @param fifteencardid 15位身份证
	 * @return java.lang.String 18位身份证
	 * @throws
	 * @Title: uptoeighteen
	 * @Date: 17-10-9 下午5:12
	 */
	private static String uptoeighteen(String fifteencardid) {
		String eightcardid = fifteencardid.substring(0, 6);
		eightcardid = eightcardid + "19";
		eightcardid = eightcardid + fifteencardid.substring(6, 15);
		eightcardid = eightcardid + getVerify(eightcardid);
		return eightcardid;
	}

	/**
	 * 根据身份证号码获取性别
	 *
	 * @param idcard 身份证
	 * @return java.lang.String
	 * @throws
	 * @Title: getSex
	 * @Date: 17-10-9 下午5:14
	 */
	public static String getSex(String idcard) {
		String inputStr = idcard.toString();
		int sex;
		if (inputStr.length() == 18) {
			sex = inputStr.charAt(16);
			if (sex%2 == 0) {
				return "女";
			} else {
				return "男";
			}
		} else {
			sex = inputStr.charAt(14);
			if (sex%2 == 0) {
				return "女";
			} else {
				return "男";
			}
		}
	}

	/**
	 * 根据身份证号码获取出生日期
	 *
	 * @param idcard 身份证号码
	 * @return java.util.Date 出生日期
	 * @throws ParseException 解析异常
	 * @Title: getBirthDate
	 * @Date: 17-10-9 下午5:15
	 */
	public static Date getBirthDate(String idcard) throws ParseException {
		String year;
		String month;
		String day;
		if (idcard.length() == 18) {
			// 处理18位身份证
			year = idcard.substring(6, 10);
			month = idcard.substring(10, 12);
			day = idcard.substring(12, 14);
		} else {
			// 处理非18位身份证
			year = idcard.substring(6, 8);
			month = idcard.substring(8, 10);
			day = idcard.substring(10, 12);
			year = "19" + year;
		}
		return new SimpleDateFormat("yyyy-MM-dd").parse(year + "-" + month
				+ "-" + day);
	}

	/**
	 * 根据身份证号码计算周岁
	 *
	 * @param idcard 身份证号码
	 * @return int 年龄
	 * @throws
	 * @Title: getAge
	 * @Date: 17-10-9 下午5:17
	 */
	public static int getAge(String idcard) throws ParseException {
		Calendar calBirth = Calendar.getInstance();
		Calendar today = Calendar.getInstance();
		Date birthDate = getBirthDate(idcard);
		calBirth.setTime(birthDate);
		return getYearDiff(today, calBirth);
	}

	/**
	 * 根据日期计算差值
	 *
	 * @param cal  日期（大）
	 * @param cal1 日期（小）
	 * @return int 差值（年）
	 * @throws
	 * @Title: getYearDiff
	 * @Date: 17-10-9 下午5:21
	 */
	private static int getYearDiff(Calendar cal, Calendar cal1) {
		int m = (cal.get(cal.MONTH)) - (cal1.get(cal1.MONTH));
		int y = (cal.get(cal.YEAR)) - (cal1.get(cal1.YEAR));
		return (y*12 + m)/12;
	}
}