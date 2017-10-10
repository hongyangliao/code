package com.ducetech.framework.util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数字工具类
 *
 * @ClassName: NumberUtils
 * @Date 17-10-10 上午9:46
 */
public class NumberUtils {

	private static final int DEF_DIV_SCALE = 10;

	private NumberUtils() {
	}

	/**
	 * BigDecimal的四舍五入
	 *
	 * @param decimal 输入的BigDecimal值
	 * @return java.math.BigDecimal 四舍五入后的BigDecimal值
	 * @throws
	 * @Title: round
	 * @Date: 17-10-10 上午9:50
	 */
	public static BigDecimal round(BigDecimal decimal) {
		return new BigDecimal(Math.round(decimal.doubleValue()));
	}

	/**
	 * 如果输入的BigDecimal类型变量值为null，返回值为0的BigDecimal类型
	 *
	 * @param num BigDecimal类型变量
	 * @return java.math.BigDecimal 如果BigDecimal类型变量值为null，返回值为0的BigDecimal类型，否则返回本身
	 * @throws
	 * @Title: nullToZero
	 * @Date: 17-10-10 上午9:52
	 */
	public static BigDecimal nullToZero(BigDecimal num) {
		if (num == null) {
			return new BigDecimal("0");
		}
		return num;
	}

	/**
	 * 如果输入的Long类型值为null,返回值为0的Long类型
	 *
	 * @param num Long类型
	 * @return java.lang.Long 如果输入的Long类型值为null,返回值为0的Long类型,否则返回本身
	 * @throws
	 * @Title: nullToZero
	 * @Date: 17-10-10 上午9:57
	 */
	public static Long nullToZero(Long num) {
		if (num == null) {
			return new Long("0");
		}
		return num;
	}

	/**
	 * 如果输入的字符串值为null,返回值为0的BigDecimal类型,否则返回字符串转换为的BigDecimal
	 *
	 * @param num 字符串
	 * @return java.math.BigDecimal BigDecimal类型
	 * @throws
	 * @Title: nullToZero
	 * @Date: 17-10-10 上午9:59
	 */
	public static BigDecimal nullToZero(String num) {
		if (num == null) {
			return new BigDecimal("0");
		}
		return new BigDecimal(num);
	}

	/**
	 * 如果输入的Integer类型值为null,返回值为0的Integer类型
	 *
	 * @param num Integer类型
	 * @return java.lang.Integer 如果输入的Integer类型值为null,返回值为0的Integer类型,否则返回本身
	 * @throws
	 * @Title: nullToZero
	 * @Date: 17-10-10 上午9:57
	 */
	public static Integer nullToZero(Integer num) {
		if (num == null) {
			return new Integer("0");
		}
		return num;
	}

	/**
	 * 判断字符串是否可转换为正整数
	 *
	 * @param num 字符串
	 * @return boolean 可转换为正整数，值为true,否则为false
	 * @throws
	 * @Title: isNumber
	 * @Date: 17-10-10 上午10:05
	 */
	public static boolean isNumber(String num) {
		if (num == null) {
			return false;
		}
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(num);
		return m.matches();
	}

	/**
	 * 判断输入的字符串是否可转换为小数位不为0小数
	 *
	 * @param num 字符串
	 * @return boolean 如果输入的字符串为小数位不为0小数返回true,否则返回false
	 * @throws
	 * @Title: isNumberForImport
	 * @Date: 17-10-10 上午10:15
	 */
	public static boolean isNumberForImport(String num) {
		Pattern p = Pattern.compile("(\\d+)|(\\d+.{1}\\d+)");
		Matcher m = p.matcher(num);
		if (m.matches()) {
			/** 是小数且小数位不为0 */
			Float fNum = Float.parseFloat(num);
			return !(fNum.floatValue() == fNum.longValue());
		}
		return false;
	}

	/**
	 * 判断输入的字符串是否可以转换为Float类型
	 *
	 * @param num 字符串
	 * @return boolean 如果输入的字符串可以转换为Float类型,则返回 true ,否则返回 false
	 * @throws
	 * @Title: isFloat
	 * @Date: 17-10-10 上午10:23
	 */
	public static boolean isFloat(String num) {
		Pattern p = Pattern.compile("(\\d+)|(\\d+.{1}\\d+)");
		Matcher m = p.matcher(num);
		return m.matches();
	}

	/**
	 * 判断输入的字符串是否可以转换为Integer类型
	 *
	 * @param num 字符串
	 * @return boolean 如果可以转换为Integer类型,则返回 true,否则返回 false
	 * @throws
	 * @Title: isInteger
	 * @Date: 17-10-10 上午10:25
	 */
	public static boolean isInteger(String num) {
		Pattern p = Pattern.compile("(\\d+)");
		Matcher m = p.matcher(num);
		return m.matches();
	}

	/**
	 * 判断输入的字符串是否可以转换为有指定长度的小数位的小数
	 *
	 * @param num      字符串
	 * @param floatnum 小数位的长度
	 * @return boolean 如果输入的字符串可以转换为有指定长度的小数位的小数,则返回 true,否则返回 false
	 * (如果指定小数位长度为0,则判断是否可以转换为Integer类型)
	 * @throws
	 * @Title: isFloat
	 * @Date: 17-10-10 上午10:27
	 */
	public static boolean isFloat(String num, int floatnum) {
		if (floatnum == 0) {
			return isInteger(num);
		}
		Pattern p = Pattern.compile("(\\d+)|(\\d+.{1}\\d{0," + floatnum + "})");
		Matcher m = p.matcher(num);
		return m.matches();
	}

	/**
	 * 提供精确的加法运算
	 *
	 * @param v1 被加数
	 * @param v2 加数
	 * @return java.math.BigDecimal 两个参数的和
	 * @throws
	 * @Title: add
	 * @Date: 17-10-10 上午10:34
	 */
	public static BigDecimal add(BigDecimal v1, BigDecimal v2) {
		BigDecimal sum = new BigDecimal(0);
		// 设一个不为0的值
		if (v1 == null || v2 == null) {
			if (v1 == null && v2 == null) {
				return sum;
			}
			return v1 == null ? v2 : v1;
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1.doubleValue()));
		BigDecimal b2 = new BigDecimal(Double.toString(v2.doubleValue()));
		return b1.add(b2);
	}

	/**
	 * 提供精确的减法运算
	 *
	 * @param v1 被减数
	 * @param v2 减数
	 * @return java.math.BigDecimal 两个参数的差
	 * @throws
	 * @Title: sub
	 * @Date: 17-10-10 上午10:35
	 */
	public static BigDecimal sub(BigDecimal v1, BigDecimal v2) {
		BigDecimal b1 = new BigDecimal("0");
		if (v1 != null) {
			b1 = new BigDecimal(Double.toString(v1.doubleValue()));
		}
		BigDecimal b2 = new BigDecimal("0");
		if (v2 != null) {
			b2 = new BigDecimal(Double.toString(v2.doubleValue()));
		}
		return b1.subtract(b2);
	}

	/**
	 * 比较两个数大小
	 *
	 * @param v1 第一个数字
	 * @param v2 第二个数字
	 * @return int 大于返回 1 等于返回 0 小于返回 -1
	 * @throws
	 * @Title: compare
	 * @Date: 17-10-10 上午10:37
	 */
	public static int compare(BigDecimal v1, BigDecimal v2) {
		int intValue = 0;
		Double d1 = v1.doubleValue();
		Double d2 = v2.doubleValue();
		if (d1 > d2) {
			intValue = 1;
		}
		if (d1 == d2) {
			intValue = 0;
		}
		if (d1 < d2) {
			intValue = -1;
		}
		return intValue;
	}

	/**
	 * 提供精确的乘法运算
	 *
	 * @param v1 被乘数
	 * @param v2 乘数
	 * @return java.math.BigDecimal 两个参数的积
	 * @throws
	 * @Title: mul
	 * @Date: 17-10-10 上午10:39
	 */
	public static BigDecimal mul(BigDecimal v1, BigDecimal v2) {
		if (v1 == null || v2 == null) {
			return new BigDecimal(0);
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1.doubleValue()));
		BigDecimal b2 = new BigDecimal(Double.toString(v2.doubleValue()));

		return b1.multiply(b2);
	}

	/**
	 * 提供精确的乘法运算
	 *
	 * @param v1 被乘数
	 * @param v2 乘数
	 * @return java.math.BigDecimal 两个参数的积
	 * @throws
	 * @Title: mul
	 * @Date: 17-10-10 上午10:40
	 */
	public static BigDecimal mul(Long v1, BigDecimal v2) {
		if (v1 == null || v2 == null) {
			return new BigDecimal(0);
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1.doubleValue()));
		BigDecimal b2 = new BigDecimal(Double.toString(v2.doubleValue()));
		return b1.multiply(b2);
	}

	/**
	 * 提供（相对）精确的除法运算,当发生除不尽的情况时,精确到 小数点以后10位,以后的数字四舍五入
	 *
	 * @param v1 被除数
	 * @param v2 除数
	 * @return java.math.BigDecimal 两个参数的商
	 * @throws
	 * @Title: div
	 * @Date: 17-10-10 上午10:42
	 */
	public static BigDecimal div(BigDecimal v1, BigDecimal v2) {
		return div(v1, v2, DEF_DIV_SCALE);
	}

	/**
	 * 提供（相对）精确的除法运算 当发生除不尽的情况时,由scale参数指 定精度,以后的数字四舍五入
	 *
	 * @param v1    被除数
	 * @param v2    除数
	 * @param scale 表示表示需要精确到小数点以后几位
	 * @return java.math.BigDecimal 两个参数的商
	 * @throws
	 * @Title: div
	 * @Date: 17-10-10 上午10:43
	 */
	public static BigDecimal div(BigDecimal v1, BigDecimal v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1.doubleValue()));
		BigDecimal b2 = new BigDecimal(Double.toString(v2.doubleValue()));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 提供精确的小数位四舍五入处理
	 *
	 * @param v     需要四舍五入的数字
	 * @param scale 小数点后保留几位
	 * @return java.math.BigDecimal  四舍五入后的结果
	 * @throws
	 * @Title: round
	 * @Date: 17-10-10 上午10:45
	 */
	public static BigDecimal round(BigDecimal v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v.doubleValue()));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 数字、货币格式化
	 *
	 * @param pattern 格式
	 * @param number  需要格式化的数据
	 * @return java.lang.String 格式化后的字符串
	 * @throws
	 * @Title: numberFormat
	 * @Date: 17-10-10 上午10:47
	 */
	public static String numberFormat(String pattern, BigDecimal number) {
		String numberStr = null;
		if (number == null) {
			return "";
		}
		try {
			if (pattern == null || pattern.equals("")) {
				numberStr = new DecimalFormat("#0.00##").format(number.doubleValue());
			} else {
				numberStr = new DecimalFormat(pattern).format(number.doubleValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numberStr;
	}

	/**
	 * 精确到小数位后两位
	 *
	 * @param num 输入的字符串
	 * @return java.lang.String 两个小数位的小数
	 * @throws
	 * @Title: isDouble
	 * @Date: 17-10-10 上午10:50
	 */
	public static String isDouble(String num) {
		if (num.equals("-") || StringUtils.isBlank(num)) {
			return "-";
		} else {
			DecimalFormat decimalFormat = new DecimalFormat("#.00");
			return decimalFormat.format(Double.valueOf(num));
		}
	}

	/**
	 * 返回负数
	 *
	 * @param num BigDecimal类型
	 * @return java.math.BigDecimal 负数
	 * @throws
	 * @Title: negative
	 * @Date: 17-10-10 上午10:52
	 */
	public static BigDecimal negative(BigDecimal num) {
		return NumberUtils.mul(num, new BigDecimal(-1));
	}

	/**
	 * 二进制转16进制
	 *
	 * @param bString 二进制
	 * @return java.lang.String 16进制
	 * @throws
	 * @Title: binaryString2hexString
	 * @Date: 17-10-10 上午10:53
	 */
	public static String binaryString2hexString(String bString) {
		if (bString == null || bString.equals("") || bString.length()%8 != 0)
			return null;
		StringBuffer tmp = new StringBuffer();
		int iTmp = 0;
		for (int i = 0; i < bString.length(); i += 4) {
			iTmp = 0;
			for (int j = 0; j < 4; j++) {
				iTmp += Integer.parseInt(bString.substring(i + j, i + j + 1)) << (4 - j - 1);
			}
			tmp.append(Integer.toHexString(iTmp));
		}
		return tmp.toString();
	}

	/**
	 * 16进制转二进制
	 *
	 * @param hexString 16进制
	 * @return java.lang.String 二进制
	 * @throws
	 * @Title: hexString2binaryString
	 * @Date: 17-10-10 上午10:54
	 */
	public static String hexString2binaryString(String hexString) {
		if (hexString == null || hexString.length()%2 != 0)
			return null;
		String bString = "", tmp;
		for (int i = 0; i < hexString.length(); i++) {
			tmp = "0000" + Integer.toBinaryString(Integer.parseInt(hexString.substring(i, i + 1), 16));
			bString += tmp.substring(tmp.length() - 4);
		}
		return bString;
	}

	//实例
	public static void main(String[] args) {
		System.out.println(NumberUtils.isNumberForImport("1.0"));
		// System.out.println((float)Math.ceil(5.5*10)/10);
		System.out.println(NumberUtils.numberFormat("#,##0.0000", new BigDecimal("53232332.3656")));
		System.out.println(NumberUtils.sub(new BigDecimal(6.0), new BigDecimal(5.3)));
		System.out.println(NumberUtils.compare(NumberUtils.sub(new BigDecimal(4900.23), new BigDecimal(4000)), BigDecimal.ZERO));
		/*long lang=1;
		String str1=Long.toBinaryString(lang);//将给定的数转为二进制字串
        
        System.out.println(str1);
        
        String str2=Long.toBinaryString(~lang);//将给定的数取反转为二进制字串  //将取反后的二进制串取最后的   长度与第一个串长度相等  的子串，这是我们需要的二进制串  
        String str=str2.substring(str2.length()-str1.length());
         //将它转换为十进制整数  
        int i=Integer.parseInt(str, 2);  System.out.println(i);
        
        int temp= 1;
        temp=~temp;
        temp=temp&0xFFFFFFFF;
        System.out.println(temp);
        System.out.println(0&0XFF);
        String aa = Long.toBinaryString(~1);
        System.out.println(aa);
        System.out.println(NumberUtil.binaryString2hexString(aa));
        String ad = "";
        String sa = "0000000000000111";
        for(int j = 0;j<sa.length();j++){
            String asdf = sa.substring(j,j+1);
            System.out.println(asdf);;
            //System.out.println(RfM1CardAction.binaryString2hexString(Long.toBinaryString(~Integer.valueOf(asdf))));
            ad = ad +Integer.toHexString(Integer.valueOf(asdf)^0X0F);
            System.out.println(Integer.toHexString(Integer.valueOf(asdf)^0X0F) );
        }
        System.out.println(ad);
        System.out.println(1^0X0F);
        System.out.println(Integer.toHexString(14) );*/
	}
}