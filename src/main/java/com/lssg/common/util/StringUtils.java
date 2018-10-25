package com.lssg.common.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串处理类
 * 
 * @author LJ
 * @date 2015年9月26日 下午1:03:14
 * @version V1.0
 */
public class StringUtils {
	/**
	 * 使用指定的字符填充字符串（前面填充）
	 * 
	 * @param s
	 *            要填充的字符串
	 * @param length
	 *            填充后字符串长度
	 * @param c
	 *            填充使用的字符
	 * @return 填充后的字符串
	 */
	public static String prepad(String s, int length, char c) {
		int needed = length - s.length();
		if (needed <= 0) {
			return s;
		}
		char padding[] = new char[needed];
		java.util.Arrays.fill(padding, c);
		StringBuffer sb = new StringBuffer(length);
		sb.append(padding);
		sb.append(s);
		return sb.toString();
	}

	/**
	 * 使用指定的字符填充字符串
	 * 
	 * @param s
	 *            要填充的字符串
	 * @param length
	 *            填充后字符串长度
	 * @param c
	 *            填充使用的字符
	 * @return 填充后的字符串
	 */
	public static String postpad(String s, int length, char c) {
		int needed = length - s.length();
		if (needed <= 0) {
			return s;
		}
		char padding[] = new char[needed];
		java.util.Arrays.fill(padding, c);
		StringBuffer sb = new StringBuffer(length);
		sb.append(s);
		sb.append(padding);
		return sb.toString();
	}

	/**
	 * 使用指定的字符填充字符串（首尾填充）
	 * 
	 * @param s
	 *            要填充的字符串
	 * @param length
	 *            填充后字符串长度
	 * @param c
	 *            填充使用的字符
	 * @return 填充后的字符串
	 */
	public static String midpad(String s, int length, char c) {
		int needed = length - s.length();
		if (needed <= 0) {
			return s;
		}
		int beginning = needed / 2;
		int end = beginning + needed % 2;
		char prepadding[] = new char[beginning];
		java.util.Arrays.fill(prepadding, c);
		char postpadding[] = new char[end];
		java.util.Arrays.fill(postpadding, c);
		StringBuffer sb = new StringBuffer(length);
		sb.append(prepadding);
		sb.append(s);
		sb.append(postpadding);
		return sb.toString();
	}

	/**
	 * 使用指定的字符串分割目标字符串
	 * 
	 * @param s
	 *            目标字符串
	 * @param delimiter
	 *            分割符
	 * @return 分割后的字符串数组
	 */
	public static String[] split(String s, String delimiter) {
		int delimiterLength;
		int stringLength = s.length();
		if (delimiter == null || (delimiterLength = delimiter.length()) == 0) {
			return new String[] { s };
		}
		int count;
		int start;
		int end;
		count = 0;
		start = 0;
		while ((end = s.indexOf(delimiter, start)) != -1) {
			count++;
			start = end + delimiterLength;
		}
		count++;
		String[] result = new String[count];
		count = 0;
		start = 0;
		while ((end = s.indexOf(delimiter, start)) != -1) {
			result[count] = (s.substring(start, end));
			count++;
			start = end + delimiterLength;
		}
		end = stringLength;
		result[count] = s.substring(start, end);
		return (result);
	}

	/**
	 * 使用指定的字符串分割目标字符串(包含分隔符)
	 * 
	 * @param s
	 *            目标字符串
	 * @param delimiter
	 *            分割符
	 * @return 分割后的字符串数组
	 */
	public static String[] splitIncludeDelimiters(String s, String delimiter) {
		int delimiterLength;
		int stringLength = s.length();
		if (delimiter == null || (delimiterLength = delimiter.length()) == 0) {
			return new String[] { s };
		}
		int count;
		int start;
		int end;
		count = 0;
		start = 0;
		while ((end = s.indexOf(delimiter, start)) != -1) {
			count += 2;
			start = end + delimiterLength;
		}
		count++;
		String[] result = new String[count];
		count = 0;
		start = 0;
		while ((end = s.indexOf(delimiter, start)) != -1) {
			result[count] = (s.substring(start, end));
			count++;
			result[count] = delimiter;
			count++;
			start = end + delimiterLength;
		}
		end = stringLength;
		result[count] = s.substring(start, end);

		return (result);
	}

	/**
	 * 转换字符串数组到字符串
	 * 
	 * @param array
	 *            字符串数组
	 * @param delimiter
	 *            连接字符串
	 * @return 转换后的字符串
	 */
	public static String join(String[] array, String delimiter) {
		int delimiterLength = delimiter.length();
		if (array.length == 0)
			return "";
		if (array.length == 1) {
			if (array[0] == null)
				return "";
			return array[0];
		}
		int length = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null)
				length += array[i].length();
			if (i < array.length - 1)
				length += delimiterLength;
		}
		StringBuffer result = new StringBuffer(length);
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null)
				result.append(array[i]);
			if (i < array.length - 1)
				result.append(delimiter);
		}
		return result.toString();
	}

	/**
	 * 字符串替换
	 * 
	 * @param s
	 *            目标字符串
	 * @param find
	 *            要替换的内容
	 * @param replace
	 *            替换字符串
	 * @return 结果字符串
	 */
	public static String replace(String s, String find, String replace) {
		int findLength;
		int stringLength = s.length();
		if (find == null || (findLength = find.length()) == 0) {
			return s;
		}
		if (replace == null) {
			replace = "";
		}
		int replaceLength = replace.length();
		int length;
		if (findLength == replaceLength) {
			length = stringLength;
		} else {
			int count;
			int start;
			int end;
			count = 0;
			start = 0;
			while ((end = s.indexOf(find, start)) != -1) {
				count++;
				start = end + findLength;
			}
			if (count == 0) {
				return s;
			}
			length = stringLength - (count * (findLength - replaceLength));
		}

		int start = 0;
		int end = s.indexOf(find, start);
		if (end == -1) {
			return s;
		}
		StringBuffer sb = new StringBuffer(length);
		while (end != -1) {
			sb.append(s.substring(start, end));
			sb.append(replace);
			start = end + findLength;
			end = s.indexOf(find, start);
		}
		end = stringLength;
		sb.append(s.substring(start, end));

		return (sb.toString());
	}

	/**
	 * 字符串数组排序
	 * 
	 * @param arr
	 *            排序后字符串
	 */
	public static void sortStringArray(String[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].compareTo(arr[j]) > 0) {
					String temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	/**
	 * 字符串数组打印
	 * 
	 * @param arr
	 *            字符串数组
	 */
	public static void printArray(String[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			if (i != arr.length - 1)
				System.out.print(arr[i] + ",");
			else
				System.out.print(arr[i] + "]");
		}
	}

	/**
	 * 输入流转字符数组
	 * 
	 * @param is
	 *            输入流
	 * @return 字符数组
	 * @throws IOException
	 */
	public static byte[] stream2Byte(InputStream is) throws IOException {
		byte[] in_b = null;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		int i = -1;
		while ((i = is.read()) != -1) {
			os.write(i);
		}
		in_b = os.toByteArray();
		return in_b;
	}

	/**
	 * 输入流转字符串
	 * 
	 * @param is
	 *            输入流
	 * @return 字符串
	 * @throws IOException
	 */
	public static String stream2String(InputStream is) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		StringWriter sw = new StringWriter();
		int i = -1;
		while ((i = br.read()) != -1) {
			sw.write(i);
		}
		return sw.getBuffer().toString();
	}

	/**
	 * 字符串转输入流
	 * 
	 * @param str
	 *            字符串
	 * @return 输入流
	 */
	public static InputStream string2Stream(String str) {
		ByteArrayInputStream is = new ByteArrayInputStream(str.getBytes());
		return is;
	}

	/**
	 * 字节数组转输入流
	 * 
	 * @param by
	 *            字节数组
	 * @return 输入流
	 */
	public static InputStream byte2Stream(byte[] by) {
		ByteArrayInputStream stream = new ByteArrayInputStream(by);
		return stream;
	}

	/**
	 * 字符串转大写金额
	 * 
	 * @param str
	 *            字符串
	 * @return 大写金额
	 */
	public static String string2Big(String str) {
		double value;
		try {
			value = Double.parseDouble(str.trim());
		} catch (Exception e) {
			return null;
		}
		char[] hunit = { '拾', '佰', '仟' };
		char[] vunit = { '万', '亿' };
		char[] digit = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' };
		long midVal = (long) (value * 100);
		String valStr = String.valueOf(midVal);
		String head = valStr.substring(0, valStr.length() - 2);
		String rail = valStr.substring(valStr.length() - 2);
		String prefix = "";
		String suffix = "";
		if (rail.equals("00")) {
			suffix = "整";
		} else {
			suffix = digit[rail.charAt(0) - '0'] + "角" + digit[rail.charAt(1) - '0'] + "分";
		}
		char[] chDig = head.toCharArray();
		char zero = '0';
		byte zeroSerNum = 0;
		for (int i = 0; i < chDig.length; i++) {
			int idx = (chDig.length - i - 1) % 4;
			int vidx = (chDig.length - i - 1) / 4;
			if (chDig[i] == '0') {
				zeroSerNum++;
				if (zero == '0') {
					zero = digit[0];
				} else if (idx == 0 && vidx > 0 && zeroSerNum < 4) {
					prefix += vunit[vidx - 1];
					zero = '0';
				}
				continue;
			}
			zeroSerNum = 0;
			if (zero != '0') {
				prefix += zero;
				zero = '0';
			}
			prefix += digit[chDig[i] - '0'];
			if (idx > 0)
				prefix += hunit[idx - 1];
			if (idx == 0 && vidx > 0) {
				prefix += vunit[vidx - 1];
			}
		}
		if (prefix.length() > 0)
			prefix += '圆';
		return prefix + suffix;
	}

	/**
	 * 过滤危险字符
	 * 
	 * @param str
	 *            目标字符串
	 * @return 已过滤字符串
	 */
	public static String filterString(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("'", "");
		str = str.replaceAll(";", "");
		str = str.replaceAll("--", "");
		str = str.replaceAll("%", "");
		return str;
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 *            目标字符串
	 * @return 是/否
	 */
	public static boolean isNullString(String str) {
		return (null == str || "".equals(str.trim()) || "null".equals(str.trim().toLowerCase())) ? true : false;
	}

	/**
	 * 根据Unicode编码完美的判断中文汉字和符号
	 * 
	 * @param c
	 *            字符
	 * @return 是/否
	 */
	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串中是否只数字、字母或下划线，长度6-20位
	 * 
	 * @param str
	 *            目标字符串
	 * @return 是/否
	 */
	public static boolean isNumberAndLetter(String str) {
		Pattern p = Pattern.compile("^[a-zA-Z0-9_]{6,20}$");
		Matcher m = p.matcher(str);
		return m.matches();
	}

	/**
	 * 判断字符串中是否只包含中文汉字
	 * 
	 * @param str
	 *            目标字符串
	 * @return 是/否
	 */
	public static boolean isChineseHave(String str) {
		if (str == null)
			return false;
		return str.matches("[\u4e00-\u9fa5]");
	}

	/**
	 * 判断字符串是否只有中文汉字
	 * 
	 * @param str
	 *            目标字符串
	 * @return 是/否
	 */
	public static boolean isChineseAll(String str) {
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (!isChinese(c)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断邮政编码
	 * 
	 * @param str
	 *            目标字符串
	 * @return 是/否
	 */
	public static boolean isPostcode(String str) {
		Pattern p = Pattern.compile("[1-9]\\d{5}(?!\\d)");
		Matcher m = p.matcher(str);
		return m.matches();
	}

	/**
	 * 判断邮箱合法性
	 * 
	 * @param email
	 *            目标字符串
	 * @return 是/否
	 */
	public static boolean isEmail(String email) {
		if ((email == null) || (email.trim().length() == 0)) {
			return false;
		}
		String regEx = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(email.trim().toLowerCase());
		return m.find();
	}

	public final static String[] PHONE_PREFIX = new String[] { "130", "131", "132", "133", "134", "135", "136", "137",
			"138", "139", "140", "141", "142", "143", "144", "145", "146", "147", "148", "149", "150", "151", "152",
			"153", "154", "155", "156", "157", "158", "159", "160", "161", "162", "163", "164", "165", "166", "167",
			"168", "169", "180", "181", "182", "183", "184", "185", "186", "187", "188", "189", "190", "191", "192",
			"193", "194", "195", "196", "197", "198", "199" };

	/**
	 * 判断手机号码合法性
	 * 
	 * @param mdn
	 *            目标字符串
	 * @param checkLen
	 *            是否验证长度
	 * @return 是/否
	 */
	public static boolean isPhoneNumber(String mdn, boolean checkLen) {
		if (mdn == null || mdn.equals("")) {
			return false;
		}

		if (mdn.startsWith("+86")) {
			mdn = mdn.substring(3);
		}
		if (checkLen && mdn.length() != 11) {
			return false;
		}
		boolean flag = false;
		String p = mdn.length() > 3 ? mdn.substring(0, 3) : mdn;
		for (int i = 0; i < PHONE_PREFIX.length; i++) {
			if (p.equals(PHONE_PREFIX[i])) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			return false;
		}
		return true;
	}

	/**
	 * 判断手机号码合法性
	 * 
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobileNumber(String mobiles) {
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}

	/**
	 * 过滤指定标签
	 * 
	 * @param str
	 * @param tag
	 * @return
	 */
	public static String fiterHtmlTag(String str, String tag) {
		String regxp = "<\\s*" + tag + "\\s+([^>]*)\\s*>";
		Pattern pattern = Pattern.compile(regxp);
		Matcher matcher = pattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		boolean result = matcher.find();
		while (result) {
			matcher.appendReplacement(sb, "");
			result = matcher.find();
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 过滤所有HTML标签,保留换行
	 * 
	 * @param input
	 * @return
	 */
	public static String filterHtmlTag(String input) {
		if (input == null || input.trim().equals("")) {
			return "";
		}
		// 替换换行
		/*
		 * input = input.replaceAll("</p>", "\r\n"); input = input.replaceAll("</h1>",
		 * "\r\n"); input = input.replaceAll("</h2>", "\r\n"); input =
		 * input.replaceAll("</h3>", "\r\n"); input = input.replaceAll("</h4>", "\r\n");
		 * input = input.replaceAll("</h5>", "\r\n"); input = input.replaceAll("</h6>",
		 * "\r\n"); input = input.replaceAll("</li>", "\r\n");
		 */
		// 去掉所有html元素,
		input = input.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
		return input;
	}

	/**
	 * 阿拉伯数字转中文小写
	 * 
	 * @param num
	 */
	public static String numberToChinese(Integer num) {
		String[] aa = { "", "十", "百", "千", "万", "十万", "百万", "千万", "亿", "十亿" };
		String[] bb = { "一", "二", "三", "四", "五", "六", "七", "八", "九" };
		String cstr = "";
		char[] ch = num.toString().toCharArray();
		int maxindex = ch.length;
		if (maxindex == 2) {
			for (int i = maxindex - 1, j = 0; i >= 0; i--, j++) {
				if (ch[j] != 48) {
					if (j == 0 && ch[j] == 49) {
						cstr += aa[i];
					} else {
						cstr += bb[ch[j] - 49] + aa[i];
					}
				}
			}
		} else {
			for (int i = maxindex - 1, j = 0; i >= 0; i--, j++) {
				if (ch[j] != 48) {
					cstr += bb[ch[j] - 49] + aa[i];
				}
			}
		}
		return cstr;
	}

	public static boolean isValidDate(String str) {
		boolean convertSuccess = true;
		// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		try {
			// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
			format.setLenient(false);
			format.parse(str);
		} catch (ParseException e) {
			// e.printStackTrace();
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			convertSuccess = false;
		}
		return convertSuccess;
	}

	public static String parseTime(String datdString) {
		datdString = datdString.replace("GMT", "").replaceAll("\\(.*\\)", "");
		// 将字符串转化为date类型，格式2016-10-12
		SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss z", Locale.ENGLISH);
		Date dateTrans = null;
		try {
			dateTrans = format.parse(datdString);
			return new SimpleDateFormat("yyyy-MM-dd").format(dateTrans).replace("-", "/");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return datdString;

	}

	/**
	 * 使用 Map按key进行排序得到key=value的字符串
	 * 
	 * @param map
	 * @param eqaulsType
	 *            K与V之间的拼接字符串 = 或者其他...
	 * @param spliceType
	 *            K-V与K-V之间的拼接字符串 & 或者|...
	 * @return
	 */
	public static String stringByKey(Map<String, String> map, String eqaulsType, String spliceType) {
		if (map == null || map.isEmpty()) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (sb.length() == 0) {
				sb.append(entry.getKey()).append(eqaulsType).append(entry.getValue());
			} else {
				sb.append(spliceType).append(entry.getKey()).append(eqaulsType).append(entry.getValue());
			}
		}

		return sb.toString();
	}

	/**
	 * 
	 * 方法名称:transStringToMap
	 * 
	 * 传入参数:mapString 形如 username'chenziwen^password'1234
	 * 
	 * 返回值:Map
	 * 
	 */

	public static Map transStringToMap(String mapString) {

		Map map = new HashMap();

		StringTokenizer items;

		for (StringTokenizer entrys = new StringTokenizer(mapString, "^"); entrys.hasMoreTokens();

				map.put(items.nextToken(), items.hasMoreTokens() ? ((Object) (items.nextToken())) : null))

			items = new StringTokenizer(entrys.nextToken(), "'");

		return map;

	}

	/**
	 * 方法名称:transMapToString 传入参数:map 返回值:String 形如 username'chenziwen^password'1234
	 */
	public static String transMapToString(Map map) {
		Map.Entry entry;
		StringBuffer sb = new StringBuffer();
		for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {
			entry = (Map.Entry) iterator.next();
			sb.append(entry.getKey().toString().trim()).append(':').append(entry.getValue().toString().trim())
					.append(iterator.hasNext() ? "," : "");
		}
		return sb.toString();
	}

	public static String toJsonArray(List<Object> list) {
		if (null == list || list.size() == 0)
			throw new RuntimeException("数组列表为空!");
		StringBuilder sb = new StringBuilder();
		int size = list.size();
		sb.append("{");
		sb.append("[");
		for (int i = 0; i < size; i++) {
			sb.append(list.get(i).toString());
			if (size > 1 && i < (size - 1)) {
				sb.append(",");
			}
		}
		sb.append("]}");
		return sb.toString();
	}

	private static final String SEP1 = ",";
	private static final String SEP2 = "|";
	private static final String SEP3 = "=";

	public static String ListToString(List<?> list) {
		StringBuffer sb = new StringBuffer();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) == null || list.get(i) == "") {
					continue;
				}
				// 如果值是list类型则调用自己
				if (list.get(i) instanceof List) {
					sb.append(ListToString((List<?>) list.get(i)));
					sb.append(SEP1);
				} else if (list.get(i) instanceof Map) {
					sb.append(MapToString((Map<?, ?>) list.get(i)));
					sb.append(SEP1);
				} else {
					sb.append(list.get(i));
					sb.append(SEP1);
				}
			}
		}
		return  sb.toString();
	}

	/**
	 * Map转换String
	 * 
	 * @param map
	 *            :需要转换的Map
	 * @return String转换后的字符串
	 */
	public static String MapToString(Map<?, ?> map) {
		StringBuffer sb = new StringBuffer();
		// 遍历map
		for (Object obj : map.keySet()) {
			if (obj == null) {
				continue;
			}
			Object key = obj;
			Object value = map.get(key);
			if (value instanceof List<?>) {
				sb.append(key.toString() + SEP1 + ListToString((List<?>) value));
				sb.append(SEP2);
			} else if (value instanceof Map<?, ?>) {
				sb.append(key.toString() + SEP1 + MapToString((Map<?, ?>) value));
				sb.append(SEP2);
			} else {
				sb.append(key.toString() + SEP3 + value.toString());
				sb.append(SEP2);
			}
		}
		return "M" + sb.toString();
	}

}
