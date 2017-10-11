package com.ducetech.framework.util;

import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.util.*;


/**
 * 扩展字符串工具类
 *
 * @ClassName: ExtStringUtils
 * @Date 17-10-9 下午1:34
 */
public class ExtStringUtils {
	private static final Log logger = LogFactory.getLog(ExtStringUtils.class);

	public static final String WIN_ENTER = "\r\n";

	private final static char CHARS[] = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C',
			'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
			'Y', 'Z'};


	/**
	 * 右省略的方式表示字符串，len长度后的字符串表示为“...”
	 *
	 * @param oldStr 字符串
	 * @param len    需要展示的长度
	 * @return java.lang.String
	 * @throws
	 * @Title: cutRedundanceStr
	 * @Date: 17-10-9 下午1:36
	 */
	public static String cutRedundanceStr(String oldStr, int len) {
		if (oldStr == null) {
			return "";
		}
		if (oldStr.length() <= len) {
			return oldStr;
		} else {
			return (oldStr.substring(0, len) + " ...");
		}
	}

	/**
	 * 左省略，len长度前的字符串表示为“...”
	 *
	 * @param oldStr 字符串
	 * @param len    需要省略的长度
	 * @return java.lang.String
	 * @throws
	 * @Title: cutLeftRedundanceStr
	 * @Date: 17-10-9 下午1:38
	 */
	public static String cutLeftRedundanceStr(String oldStr, int len) {
		if (oldStr == null) {
			return "";
		}
		if (oldStr.length() <= len) {
			return oldStr;
		} else {
			return ("..." + oldStr.substring(oldStr.length() - len, oldStr.length()));
		}
	}

	/**
	 * 使用替换的字符串替换原字符串中的需要替换的字符串
	 *
	 * @param source      原字符串
	 * @param findWhat    需要替换的字符串
	 * @param replaceWith 替换的字符串
	 * @param caseSence   是否忽略大小写 true 不忽略 false 忽略
	 * @return java.lang.String
	 * @throws
	 * @Title: replace
	 * @Date: 17-10-9 下午1:54
	 */
	public static String replace(String source, String findWhat, String replaceWith, boolean caseSence) {
		return replace(new StringBuffer(source), findWhat, replaceWith, caseSence).toString();
	}

	/**
	 * 使用替换的字符串替换原字符串中的需要替换的字符串,不忽略大小写
	 *
	 * @param source      原字符串
	 * @param findWhat    需要替换的字符串
	 * @param replaceWith 替换的字符串
	 * @return java.lang.String
	 * @throws
	 * @Title: replace
	 * @Date: 17-10-9 下午1:56
	 */
	public static String replace(String source, String findWhat, String replaceWith) {
		return replace(new StringBuffer(source), findWhat, replaceWith, true).toString();
	}

	/**
	 * 使用替换的字符串替换原StringBuffer中的需要替换的字符串,不忽略大小写
	 *
	 * @param source      原StringBuffer
	 * @param findWhat    需要替换的字符串
	 * @param replaceWith 替换的字符串
	 * @return java.lang.StringBuffer
	 * @throws
	 * @Title: replace
	 * @Date: 17-10-9 下午1:46
	 */
	public static StringBuffer replace(StringBuffer source, String findWhat, String replaceWith) {
		return replace(source, findWhat, replaceWith, true);
	}

	/**
	 * 使用替换的字符串替换原StringBuffer中的需要替换的字符串
	 *
	 * @param source      原StringBuffer
	 * @param findWhat    需要替换的字符串
	 * @param replaceWith 替换的字符串
	 * @param caseSence   是否忽略大小写 true 不忽略 false 忽略
	 * @return java.lang.StringBuffer
	 * @throws
	 * @Title: replace
	 * @Date: 17-10-9 下午1:46
	 */
	public static StringBuffer replace(StringBuffer source, String findWhat, String replaceWith, boolean caseSence) {
		if (source == null || findWhat == null || replaceWith == null) {
			return source;
		}
		if (findWhat.length() == 0) {
			return source;
		}
		int fromIndex = 0;
		int occIndex = -1;
		if (caseSence) {
			occIndex = source.toString().indexOf(findWhat, fromIndex);
		} else {
			occIndex = source.toString().toUpperCase().indexOf(findWhat.toUpperCase(), fromIndex);
		}

		while (occIndex >= 0) {
			source.delete(occIndex, occIndex + findWhat.length());
			source.insert(occIndex, replaceWith);
			fromIndex = occIndex + replaceWith.length();
			if (caseSence) {
				occIndex = source.toString().indexOf(findWhat, fromIndex);
			} else {
				occIndex = source.toString().toUpperCase().indexOf(findWhat.toUpperCase(), fromIndex);
			}
		}
		return source;
	}

	/**
	 * 对html中的特殊字符进行编码
	 *
	 * @param str
	 * @return java.lang.String
	 * @throws
	 * @Title: htmlEncode
	 * @Date: 17-10-9 下午2:01
	 */
	public static String htmlEncode(String str) {
		if (str == null) {
			return "";
		}
		String tmp = str;
		tmp = replace(tmp, "&", "&amp;", false);
		tmp = replace(tmp, "<", "&lt;", false);
		tmp = replace(tmp, "\"", "&quot;", false);
		tmp = replace(tmp, ">", "&gt;", false);

		tmp = replace(tmp, " ", " &nbsp;", false);
		tmp = replace(tmp, "\n", "<br>", false);

		return tmp;
	}

	/**
	 * 对js值进行编码
	 *
	 * @param str
	 * @return java.lang.String
	 * @throws
	 * @Title: jsValueEncode
	 * @Date: 17-10-9 下午2:06
	 */
	public static String jsValueEncode(String str) {
		return jsValueEncode(str, "\"");
	}

	/**
	 * 对js值进行编码,加上前缀和后缀
	 *
	 * @param str
	 * @param pack 前缀和后缀
	 * @return java.lang.String
	 * @throws
	 * @Title: jsValueEncode
	 * @Date: 17-10-9 下午2:07
	 */
	public static String jsValueEncode(String str, String pack) {
		if (str == null) {
			return null;
		}
		String tmp = str;
		tmp = replace(tmp, "\\", "\\\\", true);
		tmp = replace(tmp, "\n", "\\n", true);
		tmp = replace(tmp, "\"", "\\\"", true);
		tmp = replace(tmp, "'", "\\'", true);
		return pack + tmp + pack;
	}

	/**
	 * 对表单属性值进行编码
	 *
	 * @param str
	 * @return java.lang.String
	 * @throws
	 * @Title: formFieldValueEncode
	 * @Date: 17-10-9 下午2:08
	 */
	public static String formFieldValueEncode(String str) {
		return formFieldValueEncode(str, "\"");
	}

	/**
	 * 对表单属性值进行编码,加上前缀和后缀
	 *
	 * @param str
	 * @param pack 前缀和后缀
	 * @return java.lang.String
	 * @throws
	 * @Title: formFieldValueEncode
	 * @Date: 17-10-9 下午2:09
	 */
	public static String formFieldValueEncode(String str, String pack) {
		if (str == null) {
			return pack + pack;
		}
		String tmp = str;
		tmp = replace(tmp, "\"", "&quot;", false);
		tmp = pack + tmp + pack;
		return tmp;
	}


	/**
	 * 对字符串进行重新编码
	 *
	 * @param source        字符串
	 * @param decodeCharset 原编码
	 * @param encodeCharset 新编码
	 * @return java.lang.String
	 * @throws
	 * @Title: recode
	 * @Date: 17-10-9 下午2:14
	 */
	public static String recode(String source, String decodeCharset, String encodeCharset)
			throws UnsupportedEncodingException {
		if (decodeCharset.equalsIgnoreCase(encodeCharset)) {
			return source;
		} else {
			return new String(source.getBytes(decodeCharset), encodeCharset);
		}
	}

	/**
	 * 根据前缀和后缀返回字符串中符合规则的字符串数组
	 * return the parameter list.
	 * findParam("Ther versionId is {versionId}, created by {userId}.",'{','}')
	 * will return ["{versionId}","{userId}"]
	 *
	 * @param src         字符串
	 * @param patternFrom 前缀
	 * @param patternTo   后缀
	 * @return java.lang.String[]
	 * @throws
	 * @Title: findParam
	 * @Date: 17-10-9 下午2:18
	 */
	public static String[] findParam(String src, char patternFrom, char patternTo) {
		ArrayList list = new ArrayList();
		int i, j = 0, c = 0;
		while (c < src.length()) {
			i = src.indexOf(patternFrom, c);
			if (i != -1) {
				j = src.indexOf(patternTo, i + 1);
				if (j != -1) {
					list.add(src.substring(i, j + 1));
					c = j + 1;
				} else {
					break;
				}
			} else {
				break;
			}
		}
		String[] result = new String[list.size()];
		for (i = 0; i < list.size(); i++) {
			result[i] = (String) list.get(i);
		}
		return result;
	}

	//TODO
	public static String setParam(String src, HashMap values, char patternFrom, char patternTo) {
		if (values == null) {
			return src;
		}
		String reStr = src;
		String name = null;
		Object value = null;
		String[] params = findParam(src, patternFrom, patternTo);
		for (int k = 0; k < params.length; k++) {
			name = params[k];
			value = values.get(name.substring(1, name.length() - 1));
			if (values.containsKey(name.substring(1, name.length() - 1)) && (value != null)) {
				reStr = replace(reStr, name, value.toString(), false);
			}
		}
		return reStr;
	}

	/**
	 * 将字符串按某个特定字符串分割
	 *
	 * @param str 字符串
	 * @param id  特定字符串
	 * @return java.util.ArrayList
	 * @throws
	 * @Title: split
	 * @Date: 17-10-9 下午2:34
	 */
	public static ArrayList split(String str, String id) {
		ArrayList vt = new ArrayList();
		if ((str != null) && (id != null) && (!str.equals("")) && (!id.equals(""))) {
			int beginindex = 0 - id.length();
			int endindex = 0;
			int end = str.lastIndexOf(id);
			if (end == -1) {
				vt.add(str);
			} else {
				while (endindex < end) {
					endindex = str.indexOf(id, beginindex + id.length());
					vt.add(str.substring(beginindex + id.length(), endindex));
					beginindex = endindex;
				}
				vt.add(str.substring(endindex + id.length(), str.length()));
			}
		}
		return vt;
	}

	/**
	 * 首字母转大写
	 *
	 * @param s
	 * @return java.lang.String
	 * @throws
	 * @Title: toUpperCaseFirstOne
	 * @Date: 17-10-10 下午4:16
	 */
	public static String toUpperCaseFirstOne(String s) {
		if (org.apache.commons.lang.StringUtils.isBlank(s)) {
			return s;
		}
		if (Character.isUpperCase(s.charAt(0))) {
			return s;
		} else {
			return (new StringBuffer()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
		}
	}

	/**
	 * 首字母转小写
	 *
	 * @param s
	 * @return java.lang.String
	 * @throws
	 * @Title: toLowerCaseFirstOne
	 * @Date: 17-10-10 下午4:14
	 */
	public static String toLowerCaseFirstOne(String s) {
		if (org.apache.commons.lang.StringUtils.isBlank(s)) {
			return s;
		}
		if (Character.isLowerCase(s.charAt(0))) {
			return s;
		} else {
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
		}
	}


	/**
	 * 判断字符串是否全部都为小写
	 *
	 * @param value 待判断的字符串
	 * @return
	 * @autor:chenssy
	 * @date:2014年8月9日
	 */
	public static boolean isAllLowerCase(String value) {
		if (value == null || "".equals(value)) {
			return false;
		}
		for (int i = 0; i < value.length(); i++) {
			if (Character.isLowerCase(value.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断字符串是否全部大写
	 *
	 * @param value 待判断的字符串
	 * @return
	 * @autor:chenssy
	 * @date:2014年8月9日
	 */
	public static boolean isAllUpperCase(String value) {
		if (value == null || "".equals(value)) {
			return false;
		}
		for (int i = 0; i < value.length(); i++) {
			if (Character.isUpperCase(value.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 反转字符串
	 *
	 * @param value 待反转的字符串
	 * @return
	 * @autor:chenssy
	 * @date:2014年8月9日
	 */
	public static String reverse(String value) {
		if (value == null) {
			return null;
		}
		return new StringBuffer(value).reverse().toString();
	}

	/**
	 * 读取文件内容
	 *
	 * @param fileName 文件路径
	 * @return java.lang.String 如果文件不存在或者不是一个文件则返回null
	 * @throws
	 * @Title: getFileContent
	 * @Date: 17-10-9 下午2:47
	 */
	public static String getFileContent(String fileName) throws FileNotFoundException, IOException {
		File file = new File(fileName);
		if (!file.exists() || !file.isFile()) {
			return null;
		}

		BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "GB2312"));
		StringBuffer content = null;
		try {
			content = new StringBuffer("");
			String tmp = r.readLine();
			while (tmp != null) {
				content = content.append(tmp).append(WIN_ENTER);
				tmp = r.readLine();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			r.close();
		}
		return content.toString();
	}

	/**
	 * 获取根据开头和结尾将字符串中符合条件的部分的集合
	 *
	 * @param src   字符串
	 * @param start 开头
	 * @param end   结尾
	 * @return java.util.List
	 * @throws
	 * @Title: getInterContent
	 * @Date: 17-10-9 下午2:52
	 */
	public static List getInterContent(String src, String start, String end) {
		List tmp = new ArrayList();
		int i = src.indexOf(start);
		int j = -1;
		while (i >= 0) {
			j = src.indexOf(end, i + start.length());
			if (j >= 0) {
				tmp.add(src.substring(i + start.length(), j));
			}
			i = src.indexOf(start, i + start.length());
		}
		return tmp;
	}

	/**
	 * 获取一定长度的随机数
	 *
	 * @param length 长度
	 * @return java.lang.String
	 * @throws
	 * @Title: getRandomNumber
	 * @Date: 17-10-9 下午2:56
	 */
	public static String getRandomNumber(int length) {
		int randomNumber;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			randomNumber = (int) (Math.random()*10);
			sb.append(randomNumber);
		}
		return sb.toString();
	}

	/**
	 * 获取下一个字符
	 *
	 * @param c 当前字符
	 * @return char
	 * @throws
	 * @Title: getNextChar
	 * @Date: 17-10-9 下午2:57
	 */
	public static char getNextChar(char c) {
		for (int i = 0; i < CHARS.length; i++) {
			if (c == CHARS[i] && i != CHARS.length - 1) {
				return CHARS[i + 1];
			}
		}
		throw new RuntimeException("can not get the next char.");
	}

	/**
	 * Find the index of the searchStr in the string array strs.
	 * Return -1, if not found.
	 * <p>
	 * <pre>
	 * StringUtil.indexOf(["s1", "s2"], "s1", true) = 0
	 * StringUtil.indexOf(["s1", "s2"], "S1", true) = -1
	 * </pre>
	 *
	 * @param strs        the string array to check, maybe null
	 * @param searchStr   the string to search for, maybe null
	 * @param caseSensive is it case sensive while finding the searchStr
	 *                    in the searchStr
	 * @return int index of the searchStr found in the strs, -1 if not found
	 * @throws
	 * @Title: indexOf
	 * @Date: 17-10-9 下午3:00
	 */
	public static int indexOf(String[] strs, String searchStr, boolean caseSensive) {

		if (strs == null || strs.length == 0) {
			return -1;
		}
		for (int i = 0; i < strs.length; i++) {
			if (isEqual(strs[i], searchStr, caseSensive)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Find the index of the searchStr in the string array strs
	 * Return -1, if not found.
	 * <p>
	 * <pre>
	 * StringUtil.indexOf(["s1", "s2"], "s1", true) = 0
	 * StringUtil.indexOf(["s1", "s2"], "S1", true) = -1
	 * </pre>
	 *
	 * @param strs      the string array to check, maybe null
	 * @param searchStr the string to search for, maybe null
	 * @return int index of the searchStr found in the strs, -1 if not found
	 * @throws
	 * @Title: indexOf
	 * @Date: 17-10-9 下午3:00
	 */
	public static int indexOf(String[] strs, String searchStr) {
		return indexOf(strs, searchStr, true);
	}

	/**
	 * 判断两个字符串是否相等
	 *
	 * @param s1          字符串
	 * @param s2          字符串
	 * @param caseSensive 大小写是否敏感 true 敏感 false 不敏感
	 * @return boolean
	 * @throws
	 * @Title: isEqual
	 * @Date: 17-10-9 下午3:10
	 */
	private static boolean isEqual(String s1, String s2, boolean caseSensive) {
		if (caseSensive) {
			return s1 == null ? s2 == null : s1.equals(s2);
		} else {
			return s1 == null ? s2 == null : s1.equalsIgnoreCase(s2);
		}
	}

	private static final String[] EMPTY_STRING_ARRAY = new String[0];


	/**
	 * Returns a string array contains all the String object in the
	 * Collection c
	 *
	 * @param c Collection of String object
	 * @return java.lang.String[]
	 * @throws
	 * @Title: toArray
	 * @Date: 17-10-9 下午3:15
	 */
	public static String[] toArray(Collection c) {
		if (c == null || c.size() == 0) {
			return EMPTY_STRING_ARRAY;
		}
		String[] result = new String[c.size()];
		int i = 0;
		for (Iterator iter = c.iterator(); iter.hasNext(); ) {
			result[i++] = (String) iter.next();
		}
		return result;
	}

	/**
	 * Return the result of left minus right
	 * StringUtil.minus(["s1", "s2"], ["s1"], true) = ["s2"]
	 * StringUtil.minus(["s1", "s2"], ["S1"], false) = ["s2"]
	 *
	 * @param left
	 * @param right
	 * @param caseSensive 大小写是否敏感 true 敏感 false 不敏感
	 * @return java.lang.String[]
	 * @throws
	 * @Title: minus
	 * @Date: 17-10-9 下午3:24
	 */
	public static String[] minus(String[] left, String[] right, boolean caseSensive) {
		if (left == null || left.length == 0) {
			return EMPTY_STRING_ARRAY;
		}
		if (right == null || right.length == 0) {
			return left;
		}
		List result = new ArrayList(left.length);
		for (int i = 0; i < left.length; i++) {
			int index = indexOf(right, left[i], caseSensive);
			if (index == -1) {
				result.add(left[i]);
			}
		}
		return toArray(result);
	}

	/**
	 * 返回两个字符数组的差集,大小写敏感
	 *
	 * @param left
	 * @param right
	 * @return java.lang.String[]
	 * @throws
	 * @Title: minus
	 * @Date: 17-10-9 下午3:26
	 */
	public static String[] minus(String[] left, String[] right) {
		return minus(left, right, true);
	}

	/**
	 * Return a String object join all String object in param c, and add
	 * param left and param right to every String object on the left side
	 * and right side, separaing with param separator.
	 * join(["s1", "s2"], "left", "right", ",") = "lefts1right,lefts2right"
	 *
	 * @param c
	 * @param left
	 * @param right
	 * @param separator
	 * @return java.lang.String
	 * @throws
	 * @Title: join
	 * @Date: 17-10-9 下午3:29
	 */
	public static String join(Collection c, String left, String right, String separator) {

		if (c == null || c.size() == 0) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		boolean firstFlag = true;
		for (Iterator it = c.iterator(); it.hasNext(); ) {
			if (firstFlag) {
				firstFlag = false;
			} else if (separator != null) {
				sb.append(separator);
			}
			String s = (String) it.next();
			if (left != null) {
				sb.append(left);
			}
			sb.append(s);
			if (right != null) {
				sb.append(right);
			}
		}
		return sb.toString();
	}

	/**
	 * 将两个字符串数组合并到一个字符串数组中
	 *
	 * @param s1 字符串数组
	 * @param s2 字符串数组
	 * @return java.lang.String[]
	 * @throws
	 * @Title: plus
	 * @Date: 17-10-9 下午3:32
	 */
	public static String[] plus(String[] s1, String[] s2) {
		if (s1 == null) {
			return s2 == null ? EMPTY_STRING_ARRAY : s2;
		}
		if (s2 == null) {
			return s1;
		}

		String[] result = new String[s1.length + s2.length];

		System.arraycopy(s1, 0, result, 0, s1.length);
		System.arraycopy(s2, 0, result, s1.length, s2.length);
		return result;
	}

	/**
	 * converts the specified String array to a token String
	 * the token is a char ','. if array is null or zero length,
	 * return an empty String; if the element in the array is null or empty
	 * String, ignores this element
	 *
	 * @param array
	 * @return java.lang.String
	 * @throws
	 * @Title: convertArrayToString
	 * @Date: 17-10-9 下午3:37
	 */
	public static String convertArrayToString(String[] array) {
		if (array == null || array.length == 0) {
			return "";
		}
		final char token = ',';
		StringBuffer result = new StringBuffer();

		for (int i = 0, size = array.length; i < size; i++) {
			if (array[i] == null || array[i].length() == 0) {
				continue;
			}
			result.append(array[i]);
			result.append(token);
		}
		// deletes the last char of \'
		if (result.length() > 1) {
			result.deleteCharAt(result.length() - 1);
		}

		return result.toString();
	}

	/**
	 * if str starts with a prefix which is included in prefixes collection
	 * return true, otherwise return false
	 *
	 * @param str
	 * @param prefixes a collection of String objects
	 * @return boolean if str starts with a prefix which is included in prefixes collection
	 * return true, otherwise return false
	 * @throws
	 * @Title: containsPrefix
	 * @Date: 17-10-9 下午3:41
	 */
	public static boolean containsPrefix(String str, Collection prefixes) {
		if (str != null && prefixes != null) {
			Iterator it = prefixes.iterator();
			while (it.hasNext()) {
				String prefix = (String) it.next();
				if (str.startsWith(prefix)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Get the next order id according to the order id of current version id
	 * order id is last two characters, they indicate a order numeber
	 * eg. 00, 01, 02, ...10, 11, ... 99
	 *
	 * @param versionIdWithOrder
	 * @return java.lang.String
	 * @throws
	 * @Title: getNextOrderId
	 * @Date: 17-10-9 下午3:43
	 */
	public static String getNextOrderId(String versionIdWithOrder) {
		String nextOrderId;

		if (versionIdWithOrder == null || versionIdWithOrder.length() <= 0) {
			nextOrderId = "00";
		} else {
			char major = versionIdWithOrder.charAt(versionIdWithOrder.length() - 2);
			char minor = versionIdWithOrder.charAt(versionIdWithOrder.length() - 1);
			// if last number equal 9, the order id need to re-arrenge
			if (minor == '9') {
				minor = '0';
				major++;
			} else {
				minor++;
			}
			nextOrderId = "" + major + minor;
		}

		return nextOrderId;
	}

	/**
	 * If code value in range [-64, -17], it's a character header with enconding UTF-8
	 *
	 * @param codeValue
	 * @return boolean
	 * @throws
	 * @Title: isCharacterHeaderWithUTF8
	 * @Date: 17-10-9 下午3:45
	 */
	private static boolean isCharacterHeaderWithUTF8(int codeValue) {
		if (codeValue >= -64 && codeValue <= -17) {
			return true;
		}
		return false;
	}


	/**
	 * If code value in range [-128, -65], it's a character body with enconding UTF-8
	 *
	 * @param codeValue
	 * @return boolean
	 * @throws
	 * @Title: isCharacterBodyWithUTF8
	 * @Date: 17-10-9 下午3:46
	 */
	private static boolean isCharacterBodyWithUTF8(int codeValue) {
		if (codeValue >= -128 && codeValue <= -65) {
			return true;
		}
		return false;
	}

	/**
	 * cut off string which consists of chinese characters and ascii characters
	 * with UTF-8 encoding way
	 * <p>
	 * UTF-8 encoding mode
	 * 0xxx xxxx [0, 127] for ascii
	 * 110x xxxx 10xx xxxx [-33, -64] [-65, -128] for chinese character
	 * 1110 xxxx 10xx xxxx 10xx xxxx [-32, -17] [-65, -128] [-65, -128] for chinese character
	 *
	 * @param originalStr
	 * @param length
	 * @return java.lang.String
	 * @throws
	 * @Title: cutStringWithUTF8
	 * @Date: 17-10-9 下午3:47
	 */
	public static String cutStringWithUTF8(String originalStr, int length) throws UnsupportedEncodingException {
		String result = null;
		byte[] bytes = originalStr.getBytes("UTF-8");
		if (length <= bytes.length) {
			int codeValue = bytes[length - 1];
			if (logger.isDebugEnabled()) {
				logger.debug("codeValue at last place: " + codeValue);
			}
			if (codeValue > 0) {
				result = new String(bytes, 0, length, "UTF-8");

			} else if (isCharacterHeaderWithUTF8(codeValue)) {
				result = new String(bytes, 0, length - 1, "UTF-8");

			} else if (isCharacterBodyWithUTF8(codeValue)) {
				codeValue = bytes[length - 2];
				if (logger.isDebugEnabled()) {
					logger.debug("codeValue at the second last place: " + codeValue);
				}

				if (isCharacterHeaderWithUTF8(codeValue)) {
					result = new String(bytes, 0, length - 2, "UTF-8");

				} else if ((isCharacterBodyWithUTF8(codeValue))) {
					result = new String(bytes, 0, length, "UTF-8");
				}
			}
		}

		return result;
	}

	/**
	 * cut off string which consists of chinese characters and ascii characters
	 * with charsetName encoding way
	 *
	 * @param str
	 * @param length
	 * @param charsetName
	 * @return java.lang.String
	 * @throws
	 * @Title: cutString
	 * @Date: 17-10-9 下午3:48
	 */
	public static String cutString(String str, int length, String charsetName) throws UnsupportedEncodingException {
		int len = str.getBytes(charsetName).length;
		if (len > length) {
			char[] chars = str.toCharArray();
			int i = 0;
			for (; i < chars.length; i++) {
				String tstr = new String(chars, 0, i + 1);
				if (tstr.getBytes(charsetName).length > length) {
					i--;
					break;
				}
			}
			return new String(chars, 0, i + 1);
		}

		return str;
	}


	/**
	 * 将编码为 ISO-8859-1 格式的字符串转换为 UTF-8
	 *
	 * @param string
	 * @return java.lang.String
	 * @throws
	 * @Title: encodeUTF8
	 * @Date: 17-10-9 下午3:52
	 */
	public static String encodeUTF8(String string) {
		String str = "";
		try {
			str = new String(string.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(), e);
		}
		return str;
	}


	/**
	 * 判断字符是否包含中文
	 *
	 * @param str 字符串
	 * @return boolean 包含返回true 不包含返回false
	 * @throws
	 * @Title: hasChinese
	 * @Date: 17-10-9 下午3:53
	 */
	public static boolean hasChinese(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.substring(i, i + 1).matches("[\\u4e00-\\u9fa5]+")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 对象属性转换为字段
	 * 例如：userName to user_name
	 *
	 * @param property 属性
	 * @return java.lang.String 字段
	 * @throws
	 * @Title: propertyToField
	 * @Date: 17-10-9 下午3:54
	 */
	public static String propertyToField(String property) {
		if (null == property) {
			return "";
		}
		char[] chars = property.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (char c : chars) {
			if (CharUtils.isAsciiAlphaUpper(c)) {
				sb.append("_" + StringUtils.lowerCase(CharUtils.toString(c)));
			} else {
				sb.append(c);
			}
		}
		return sb.toString().toUpperCase();
	}

	/**
	 * 字段转换成对象属性
	 * 例如：user_name to userName
	 *
	 * @param field 属性
	 * @return java.lang.String 字段
	 * @throws
	 * @Title: fieldToProperty
	 * @Date: 17-10-9 下午3:55
	 */
	public static String fieldToProperty(String field) {
		if (null == field) {
			return "";
		}
		char[] chars = field.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (c == '_') {
				int j = i + 1;
				if (j < chars.length) {
					sb.append(StringUtils.upperCase(CharUtils.toString(chars[j])));
					i++;
				}
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * 将异常对象解析成字符串
	 *
	 * @param e 异常对象
	 * @return java.lang.String 异常对象的字符串信息
	 * @throws
	 * @Title: parseExceptionStackString
	 * @Date: 17-10-9 下午3:56
	 */
	public static String parseExceptionStackString(Throwable e) {
		//处理异常堆栈字符串
		StringWriter strWriter = new StringWriter();
		if (e != null) {
			PrintWriter writer = new PrintWriter(new BufferedWriter(strWriter));
			e.printStackTrace(writer);
			writer.flush();
			strWriter.flush();
		}
		String exceptionStack = strWriter.getBuffer().toString();
		return exceptionStack;
	}

	/**
	 * 删除字符串两边的空格
	 *
	 * @param str 字符串
	 * @return java.lang.String 如何字符串为null,则返回为空
	 * @throws
	 * @Title: trim
	 * @Date: 17-10-9 下午3:58
	 */
	public static String trim(String str) {
		str = str == null ? "" : str.trim();
		return str;
	}

	/**
	 * 删除字符串两边的空格
	 *
	 * @param obj 字符串
	 * @return java.lang.String 如何字符串为null,则返回为空
	 * @throws
	 * @Title: trim
	 * @Date: 17-10-9 下午3:58
	 */
	public static String trim(Object obj) {
		String str = String.valueOf(obj);
		return trim(str);
	}

	/**
	 * 删除字符串两边的空格
	 *
	 * @param obj
	 * @return java.lang.String 如何字符串为null,则返回为null
	 * @throws
	 * @Title: trimToNull
	 * @Date: 17-10-9 下午4:00
	 */
	public static String trimToNull(Object obj) {
		String str = String.valueOf(obj);
		str = (str == null) ? null : str.trim();
		return str;
	}


	//实例
	public static void main(String[] args) {
		String result = setParam("Ther versionId is {versionId}, created by {userId}.", new HashMap(), '{', '}');
		System.out.println(result);
	}
}
