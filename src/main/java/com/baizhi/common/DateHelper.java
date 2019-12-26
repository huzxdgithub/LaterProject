package com.baizhi.common;

import com.sx.utility.DateTools;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper extends DateTools {

	private DateHelper() {
	}

	private final static String FORMAT_STR_14 = "yyyyMMddHHmmss";
	private final static String FORMAT_STR_8 = "yyyyMMdd";
	private final static String FORMAT_STR_17 = "yyyyMMddHHmmssSSS";

	public static String long2str14(long time) {
		Date d = new Date(time);
		DateFormat df = new SimpleDateFormat(FORMAT_STR_14);
		return df.format(d);
	}

	public static String long2str8(long time) {
		Date d = new Date(time);
		DateFormat df = new SimpleDateFormat(FORMAT_STR_8);
		return df.format(d);
	}

	public static String long2str17(long time) {
		Date d = new Date(time);
		DateFormat df = new SimpleDateFormat(FORMAT_STR_17);
		return df.format(d);
	}

	/**
	 * @Title: double2Str
	 * @Description: TODO(double转换成String)
	 * @param d
	 * @return
	 * @return String 返回类型
	 */
	public static String double2Str(Double d) {
		if (d == null) {
			return "";
		}
		// DecimalFormat decimalFormat = new DecimalFormat("###0.00");//格式化设置
		// String a = decimalFormat.format(d);
		// d = Double.valueOf(a);
		NumberFormat nf = NumberFormat.getInstance();
		nf.setGroupingUsed(false);
		return (nf.format(d));
	}

	/**
	 * @Title: formatYMD
	 * @Description: TODO(格式化时间 2018年7月19日 )
	 * @param k_yxkssj
	 *            20180719
	 * @return 2018年7月19日
	 * @return String 返回类型
	 */
	public static String formatYMD(String k_yxkssj) {
		StringBuffer sj = new StringBuffer();
		String year = k_yxkssj.substring(0, 4);
		String moth = k_yxkssj.substring(4, 6);
		if ("0".equals(k_yxkssj.substring(4, 5))) {
			moth = k_yxkssj.substring(5, 6);
		}
		String day = k_yxkssj.substring(6, 8);
		if ("0".equals(k_yxkssj.substring(6, 7))) {
			day = k_yxkssj.substring(7, 8);
		}
		sj.append(year);
		sj.append("年");
		sj.append(moth);
		sj.append("月");
		sj.append(day);
		sj.append("日");
		return sj.toString();
	}

	/**
	 * @Title: formatHM
	 * @Description: TODO(格式化时间 时:分)
	 * @param k_yxkssj
	 *            20180702235959
	 * @return 23:59
	 * @return String 返回类型
	 */
	public static String formatHM(String k_yxkssj) {
		StringBuffer sj = new StringBuffer();
		String hour = k_yxkssj.substring(8, 10);
		if ("0".equals(k_yxkssj.substring(8, 9))) {
			hour = k_yxkssj.substring(9, 10);
		}
		String minute = k_yxkssj.substring(10, 12);
		sj.append(hour);
		sj.append(":");
		sj.append(minute);

		return sj.toString();
	}

	/**
	 * @Title: formatYMDHM
	 * @Description: TODO(格式化时间 年月日 时分)
	 * @param k_yxkssj
	 *            20180702235959
	 * @return 2018年7月2日 23:59
	 * @return String 返回类型
	 */
	public static String formatYMDHM(String k_yxkssj) {
		StringBuffer sj = new StringBuffer();
		String year = k_yxkssj.substring(0, 4);
		String moth = k_yxkssj.substring(4, 6);
		if ("0".equals(k_yxkssj.substring(4, 5))) {
			moth = k_yxkssj.substring(5, 6);
		}
		String day = k_yxkssj.substring(6, 8);
		if ("0".equals(k_yxkssj.substring(6, 7))) {
			day = k_yxkssj.substring(7, 8);
		}
		String hour = k_yxkssj.substring(8, 10);
		if ("0".equals(k_yxkssj.substring(8, 9))) {
			hour = k_yxkssj.substring(9, 10);
		}
		String minute = k_yxkssj.substring(10, 12);
		sj.append(year);
		sj.append("年");
		sj.append(moth);
		sj.append("月");
		sj.append(day);
		sj.append("日");
		sj.append("\t ");
		sj.append(hour);
		sj.append(":");
		sj.append(minute);

		return sj.toString();
	}

	/**
	 *
	 * @Title: fomat8Str
	 * @Description: TODO(格式化日期yyyy-mm-dd 为 yyyymmdd)
	 * @param str
	 * @return
	 * @return String 返回类型
	 */
	public static String fomat8Str(String str) {
		return str.replace("-", "");
	}

	/**
	 *
	 * @Title: getXyt
	 * @Description: TODO(获取指定时间的下N天)
	 * @param rq
	 * @param day1
	 *            20180702235959 1
	 * @return 20180703235959
	 * @return String 返回类型
	 */
	public static String getXyt(String rq, int day1) {
		SimpleDateFormat smf = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cld = Calendar.getInstance();
		Date date = null;
		try {
			date = smf.parse(rq);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cld.setTime(date);
		int day = cld.get(Calendar.DATE);
		cld.set(Calendar.DATE, day + day1);
		String res = smf.format(cld.getTime());
		return res;
	}

	/**
	 * @Title: getServiceDate
	 * @Description: TODO(获取当前时间 yyyy-mm-dd用于页面回显示服务器时间)
	 * @return
	 * @return String 返回类型
	 */
	public static String getServiceDate() {
		Date d = new Date(System.currentTimeMillis());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(d);
	}

	/**
	 * @Title: getBeforDate
	 * @Description: TODO(获取当前时间的前n天时间 yyyyMMdd)
	 * @param dateStr
	 * @param diff
	 * @return
	 * @return String 返回类型
	 */
	public static String getBeforDate(String dateStr, int diff) {
		return new DateTools().getBeforeTime(dateStr, FORMAT_STR_8, diff, FORMAT_STR_8);
	}

	/**
	 *
	 * @Title: dateFmt_ymdHms24
	 * @Description: TODO(格式化日期字符串 输出(yyyy-MM-dd hh:mm:ss) 24小时制)
	 * @param rq
	 *            yyyyMMddHHmmss
	 * @return yyyy-MM-dd hh:mm:ss
	 * @throws ParseException
	 * @return String 返回类型
	 */
	public static String dateFmt_ymdHms24(String rq) throws ParseException {
		// return dateFmt(rq, "yyyyMMddHHmmss", "yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = (Date) sdf1.parse(rq);
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf2.format(date);
	}

	/**
	 * @Title: dateFmt
	 * @Description: TODO(格式化日期字符串)
	 * @param dateString
	 *            日期字符串
	 * @param source
	 *            源格式
	 * @param target
	 *            目标格式
	 * @return
	 * @return String 返回类型
	 */
	public static String dateFmt(String dateString, String source, String target) {
		if (StringHelper.isEmpty(dateString)) {
			return "";
		}
		DateTools myjt = new DateTools();
		return myjt.fmtDate(dateString, source, target);
	}

	/**
	 * @Title: getNow
	 * @Description: TODO(获得当前时间(24小时制的yyyyMMddhhmmssSSS))
	 * @return
	 * @return String 返回类型
	 */
	public static String getNow() {
		DateTools mydt = new DateTools();
		return mydt.getDate();// 当前时间
	}

	/**
	 * @Title: getNow
	 * @Description: TODO(获得当前时间(指定时间格式的))
	 * @param format
	 * @return
	 * @return String 返回类型
	 */
	public static String getNow(String format) {
		DateTools mydt = new DateTools();
		return mydt.getDate(format);// 当前时间
	}

	/**
	 * @Title: getToday
	 * @Description: TODO(得到当前的时间 格式为yyyyMMdd)
	 * @return
	 * @return String 返回类型
	 */
	public static String getToday() {
		return getNow("yyyyMMdd");
	}

	/**
	 * @Title: dateFmt_qyr
	 * @Description: TODO(获得当前日期前一个月)
	 * @return yyyy-MM-dd
	 * @return String 返回类型
	 */
	public static String dateFmt_qyr() {
		DateTools mydt = new DateTools();
		return mydt.getBeforeTimeByM(mydt.getDate("yyyyMMdd"), "yyyyMMdd", 1, "yyyy-MM-dd");
	}

	/**
	 * @Title: dateFmt_hyr
	 * @Description: TODO(获得当前日期前、后几个月 )
	 * @param 1
	 *            -1
	 * @return yyyy-MM-dd
	 * @return String 返回类型
	 */
	public static String dateFmt_hyr(int mon) {
		DateTools mydt = new DateTools();
		return mydt.getBeforeTimeByM(mydt.getDate("yyyyMMdd"), "yyyyMMdd", mon, "yyyyMMddhhmmss");
	}

	/**
	 * @Title: getTodayFmt
	 * @Description: TODO(得到当前的时间 )
	 * @return yyyy-MM-dd
	 * @return String 返回类型
	 */
	public static String getTodayFmt() {
		return getNow("yyyy-MM-dd");
	}

	/**
	 * @Title: dateFmt_ymdhms
	 * @Description: TODO(格式化日期字符串 )
	 * @param rq
	 *            yyyy-MM-dd
	 * @return yyyyMMddHHmmss
	 * @return String 返回类型
	 */
	public static String dateFmt_ymdhms(String rq) {
		return dateFmt(rq, "yyyy-MM-dd", "yyyyMMddHHmmss");
	}

	/**
	 * @Title: dateFmt_ymdhms_cx
	 * @Description: TODO(格式化日期字符串 输入_查询结束时间)
	 * @param rq
	 *            yyyy-MM-dd
	 * @return yyyyMMdd235959
	 * @return String 返回类型
	 */
	public static String dateFmt_ymdhms_cx(String rq) {
		return dateFmt(rq, "yyyy-MM-dd", "yyyyMMdd") + "235959";
	}

	/**
	 * @Title: dateFmt_ymd
	 * @Description: TODO(格式化日期字符串 输出)
	 * @param rq
	 *            yyyyMMddHHmmss
	 * @return yyyy-MM-dd
	 * @return String 返回类型
	 */
	public static String dateFmt_ymd(String rq) {
		return dateFmt(rq, "yyyyMMddHHmmss", "yyyy-MM-dd");
	}

	/**
	 * @Title: dateFmt_ymdHms
	 * @Description: TODO(格式化日期字符串 输出)
	 * @param rq
	 *            yyyyMMddHHmmss
	 * @return (yyyy-MM-dd hh:mm:ss)
	 * @return String 返回类型
	 */
	public static String dateFmt_ymdHms(String rq) {
		return dateFmt(rq, "yyyyMMddHHmmss", "yyyy-MM-dd hh:mm:ss");
	}

	/**
	 * @Title: dateFmt_ymToymdhms
	 * @Description: TODO(格式化日期字符串 输出)
	 * @param rq
	 *            yyyy-MM
	 * @return yyyyMMddHHmmss
	 * @return String 返回类型
	 */
	public static String dateFmt_ymToymdhms(String rq) {
		return dateFmt(rq, "yyyy-MM", "yyyyMMddHHmmss");
	}

	/**
	 * @Title: dateFmt_ymdHms_to
	 * @Description: TODO(格式化日期字符串 转化输出)
	 * @param rq
	 *            (yyyy-MM-dd hh:mm:ss)
	 * @return yyyyMMddHHmmss
	 * @return String 返回类型
	 */
	public static String dateFmt_ymdHms_to(String rq) {
		return dateFmt(rq, "yyyy-MM-dd hh:mm:ss", "yyyyMMddHHmmss");
	}

	/**
	 * @Title: dateFmt_ym
	 * @Description: TODO(格式化日期字符串 输出)
	 * @param rq
	 * @return 2018-09
	 * @return String 返回类型
	 */
	public static String dateFmt_ym(String rq) {
		return rq.substring(0, 4) + "-" + rq.substring(4, 6);
	}

	/**
	 * @Title: dateFmt_ymdhms_begin
	 * @Description: TODO(格式化日期字符串 )
	 * @param rq
	 *            yyyy-MM-dd
	 * @return yyyyMMdd000000
	 * @return String 返回类型
	 */
	public static String dateFmt_ymdhms_begin(String rq) {
		return dateFmt(rq, "yyyy-MM-dd", "yyyyMMdd") + "000000";
	}
	
	public static String dateFmt_ymd_begin(String rq) {
		return dateFmt(rq, "yyyyMMddHHmmss", "yyyyMMdd") + "000000";
	}
	/**
	 * @Title: dateFmt_ymhms_begin
	 * @Description: TODO(格式化日期字符串 输入)
	 * @param rq
	 *            yyyy-MM
	 * @return yyyyMMdd000000
	 * @return String 返回类型
	 */
	public static String dateFmt_ymhms_begin(String rq) {
		return dateFmt(rq, "yyyy-MM", "yyyyMMdd") + "000000";
	}

	/**
	 * @Title: dateFmt_ymdhms_end
	 * @Description: TODO(格式化日期字符串 输入)
	 * @param rq
	 *            yyyy-MM-dd
	 * @return yyyyMMdd235959
	 * @return String 返回类型
	 */
	public static String dateFmt_ymdhms_end(String rq) {
		return dateFmt(rq, "yyyy-MM-dd", "yyyyMMdd") + "235959";
	}

	/**
	 * @Title: dateFmt_ymhms_end
	 * @Description: TODO(格式化日期字符串 输入)
	 * @param rq
	 *            yyyy-MM
	 * @return yyyyMMdd235959
	 * @return String 返回类型
	 */
	public static String dateFmt_ymhms_end(String rq) {
		return dateFmt(rq, "yyyy-MM", "yyyyMMdd") + "235959";
	}

	/**
	 * @Title: getXmt
	 * @Description: TODO(获得当前时间后的N分钟)
	 * @param rq
	 *            yyyyMMddHHmmss
	 * @param min
	 * @return yyyyMMddHHmmss
	 * @return String 返回类型
	 */
	public static String getXmt(String rq, int min) {
		SimpleDateFormat smf = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cld = Calendar.getInstance();
		Date date = null;
		try {
			date = smf.parse(rq);
			cld.setTime(date);
			int MINUTE = cld.get(Calendar.MINUTE);
			cld.set(Calendar.MINUTE, MINUTE + (min));
			String res = smf.format(cld.getTime());
			return res;
		} catch (ParseException e) {
			return "";
		}
	}

	/**
	 * @Title: getXyy
	 * @Description: TODO(获取指定时间的下N年)
	 * @param rq
	 *            yyyyMMddHHmmss
	 * @param year
	 * @return yyyyMMddHHmmss
	 * @return String 返回类型
	 */
	public static String getXyy(String rq, int year) {
		SimpleDateFormat smf = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cld = Calendar.getInstance();
		Date date = null;
		try {
			date = smf.parse(rq);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cld.setTime(date);
		int yea1r = cld.get(Calendar.YEAR);
		cld.set(Calendar.YEAR, yea1r + year);
		String res = smf.format(cld.getTime());
		return res;
	}

	/**
	 * @Title: getXym
	 * @Description: TODO(获取指定时间的下N个月)
	 * @param rq
	 *            yyyyMMddHHmmss
	 * @param month
	 * @return yyyyMMddHHmmss
	 * @return String 返回类型
	 */
	public static String getXym(String rq, int month) {
		SimpleDateFormat smf = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cld = Calendar.getInstance();
		Date date = null;
		try {
			date = smf.parse(rq);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cld.setTime(date);
		int month1 = cld.get(Calendar.MONTH);
		cld.set(Calendar.MONTH, month1 + month);
		String res = smf.format(cld.getTime());
		return res;
	}

	/**
	 * @Title: getQyt
	 * @Description: TODO(获取当期时间前N天)
	 * @param rq
	 *            yyyyMMddHHmmss
	 * @param day1
	 * @return yyyyMMddHHmmss
	 * @return String 返回类型
	 */
	public static String getQyt(String rq, int day1) {
		SimpleDateFormat smf = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cld = Calendar.getInstance();
		Date date = null;
		try {
			date = smf.parse(rq);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cld.setTime(date);
		int day = cld.get(Calendar.DATE);
		cld.set(Calendar.DATE, day - day1);
		String res = smf.format(cld.getTime());
		return res;
	}

	/**
	 * @Title: getWeek
	 * @Description: TODO(输入日期返回星期几)
	 * @param sDate
	 *            yyy-MM-dd HH:mm:ss
	 * @return
	 * @throws ParseException
	 * @return String 返回类型
	 */
	public static String getWeek(String sDate) throws ParseException {
		final String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		Calendar caledat = Calendar.getInstance();
		Date date = new Date();
		date = format.parse(sDate);
		caledat.setTime(date);
		int dayOfWeek = caledat.get(Calendar.DAY_OF_WEEK) - 1;
		if (dayOfWeek < 0) {
			dayOfWeek = 0;
		}
		return dayNames[dayOfWeek];
	}

	/**
	 * @Title: daysBetween
	 * @Description: TODO(两日期间隔天数)
	 * @param beforeDate
	 *            yyyyMMddHHmmss
	 * @param nowDate
	 *            yyyyMMddHHmmss
	 * @return
	 * @return int 返回类型
	 */
	public static int daysBetween(String beforeDate, String nowDate) {
		SimpleDateFormat smf = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cld = Calendar.getInstance();
		Date before = null;
		Date now = null;
		try {
			before = smf.parse(beforeDate);
			now = smf.parse(nowDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cld.setTime(before);
		long time1 = cld.getTimeInMillis();
		cld.setTime(now);
		long time2 = cld.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * @Title: getTimeByHour
	 * @Description: TODO(获得当前时间后的N小时)
	 * @param rq
	 *            yyyyMMddHHmmss
	 * @param hour
	 *            2
	 * @return
	 * @return String 返回类型
	 */
	public static String getTimeByHour(String rq, int hour) {
		SimpleDateFormat smf = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cld = Calendar.getInstance();
		Date date = null;
		try {
			date = smf.parse(rq);
			cld.setTime(date);
			int MINUTE = cld.get(Calendar.HOUR_OF_DAY);
			cld.set(Calendar.HOUR_OF_DAY, MINUTE + (hour));
			String res = smf.format(cld.getTime());
			return res;
		} catch (ParseException e) {
			return "";
		}
	}

	/**
	 * @Title: getSyt
	 * @Description: TODO(获取指定时间的上一天)
	 * @param rq
	 *            yyyyMMdd
	 * @return
	 * @return String 返回类型
	 */
	public static String getSyt(String rq) {
		SimpleDateFormat smf = new SimpleDateFormat("yyyyMMdd");
		Calendar cld = Calendar.getInstance();
		Date date = null;
		try {
			date = smf.parse(rq);
			cld.setTime(date);
			int day = cld.get(Calendar.DATE);
			cld.set(Calendar.DATE, day + (-1));
			String res = smf.format(cld.getTime());
			return res;
		} catch (ParseException e) {

			return "";
		}

	}

	/**
	 * @Title: between_rq1_rq2
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param rq1
	 *            yyyyMMdd
	 * @param rq2
	 *            yyyyMMdd
	 * @return 包括起始的那一天 20-21 算两天
	 * @return int 返回类型
	 */
	public static int between_rq1_rq2(String rq1, String rq2) {
		int year1 = new Integer(rq1.substring(0, 4));
		int year2 = new Integer(rq2.substring(0, 4));
		int month1 = formatDM(rq1.substring(4, 6));
		int month2 = formatDM(rq2.substring(4, 6));
		int day1 = formatDM(rq1.substring(6));
		int day2 = formatDM(rq2.substring(6));
		int sum = 0;
		if (year2 < year1) {
			return 0;
		}
		if (year2 == year1 && month2 < month1) {
			return 0;
		}
		if (year2 == year1 && month2 == month1 && day2 < day1) {
			return 0;
		}
		if (year1 == year2 && month1 == month2) {
			sum = 0;
		} else {
			sum = sum + dayByM(year1, month1) - day1;
		}
		if (year2 == year1) {
			if (month1 + 1 <= month2 - 1) {
				for (int i = month1 + 1; i <= month2 - 1; i++) {
					sum = sum + dayByM(year1, i);
				}
			}
		}
		if (year2 != year1) {
			for (int i = month1 + 1; i <= 12; i++) {
				sum = sum + dayByM(year1, i);
			}
			for (int i = year1 + 1; i <= year2; i++) {
				if (i == year2) {
					for (int j = 1; j <= month2 - 1; j++) {
						sum = sum + dayByM(i, j);
					}
				} else {
					for (int j = 1; j <= 12; j++) {
						sum = sum + dayByM(i, j);
					}
				}
			}
		}
		if (year1 == year2 && month1 == month2) {
			sum = sum + day2 - day1;
		} else {
			sum = sum + day2;
		}
		sum = sum + 1;
		return sum;
	}

	/**
	 * @Title: dayByM
	 * @Description: TODO(获取年下的月的最后一天)
	 * @param year
	 * @param month
	 * @return
	 * @return int 返回类型
	 */
	public static int dayByM(int year, int month) {
		int day = 0;
		switch (month) {
		case 4:
		case 6:
		case 9:
		case 11:
			day = 30;
			break;
		case 2:
			if ((year % 100 == 0 && year % 400 != 0) || year % 4 == 0) {
				day = 29;
			} else {
				day = 28;
			}
			break;
		default:
			day = 31;
			break;
		}
		return day;
	}

	/**
	 * @Title: formatDM
	 * @Description: TODO(将String转换成int)
	 * @param dm
	 * @return
	 * @return int 返回类型
	 */
	public static int formatDM(String dm) {
		int d = 0;
		if (dm.charAt(0) != '0') {
			d = new Integer(dm);
		} else {
			d = new Integer(dm.charAt(1) + "");
		}
		return d;
	}

	/**
	 * @Title: getXyt
	 * @Description: TODO(获取指定时间的下一天)
	 * @param rq
	 *            yyyyMMdd
	 * @return yyyyMMdd
	 * @return String 返回类型
	 */
	public static String getXyt(String rq) {
		SimpleDateFormat smf = new SimpleDateFormat("yyyyMMdd");
		Calendar cld = Calendar.getInstance();
		Date date = null;
		try {
			date = smf.parse(rq);
			cld.setTime(date);
			int day = cld.get(Calendar.DATE);
			cld.set(Calendar.DATE, day + 1);
			String res = smf.format(cld.getTime());
			return res;
		} catch (ParseException e) {

			return "";
		}

	}

	/**
	 * @Title: getXy
	 * @Description: TODO(获取当前年月的下月 )
	 * @param rq
	 *            yyyyMM
	 * @param num
	 * @return 例如 现在201412 得到201501
	 * @return String 返回类型
	 */
	public static String getXy(String rq, int num) {
		SimpleDateFormat smf = new SimpleDateFormat("yyyyMM");
		Calendar cld = Calendar.getInstance();
		Date date = null;
		try {
			date = smf.parse(rq);
			cld.setTime(date);
			int day = cld.get(Calendar.MONTH);
			cld.set(Calendar.MONTH, day + (num));
			String res = smf.format(cld.getTime());
			return res;
		} catch (ParseException e) {

			return "";
		}

	}

	/**
	 * @Title: getSjc
	 * @Description: TODO(获取两个日期间隔月数(开始日期是1号结束必须是结束月月底))
	 * @param ksrq
	 * @param jsrq
	 * @return
	 * @return long 返回类型
	 */
	public static long getSjc(String ksrq, String jsrq) {
		String day = "";
		if (ksrq != null && ksrq.length() == 10) {
			ksrq = dateFmt(ksrq, "yyyy-MM-dd", "yyyyMMdd");
			day = ksrq.substring(6);
		}
		if (ksrq != null && ksrq.length() == 7) {
			ksrq = dateFmt(ksrq, "yyyy-MM", "yyyyMM");
		}
		if (jsrq != null && jsrq.length() == 10) {
			jsrq = dateFmt(jsrq, "yyyy-MM-dd", "yyyyMMdd");
		}
		if (jsrq != null && jsrq.length() == 7) {
			jsrq = dateFmt(jsrq, "yyyy-MM", "yyyyMM");
		}
		if (StringHelper.isNotEmpty(ksrq) && StringHelper.isNotEmpty(jsrq)) {
			int year = Integer.parseInt(jsrq.substring(0, 4)) - Integer.parseInt(ksrq.substring(0, 4));
			int month = Integer.parseInt(jsrq.substring(4, 6)) - Integer.parseInt(ksrq.substring(4, 6));
			if ("01".equals(day)) {
				return year * 12 + month + 1;
			}
			return year * 12 + month;
		}
		return -1;
	}

	/**
	 * @Title: getXy
	 * @Description: TODO(获得传入月份的下一个月)
	 * @param rq
	 *            yyyyMM
	 * @return yyyyMM
	 * @return String 返回类型
	 */
	public static String getXy(String rq) {
		SimpleDateFormat smf = new SimpleDateFormat("yyyyMM");
		Calendar cld = Calendar.getInstance();
		Date date = null;
		try {
			date = smf.parse(rq);
			cld.setTime(date);
			int day = cld.get(Calendar.MONTH);
			cld.set(Calendar.MONTH, day + 1);
			String res = smf.format(cld.getTime());
			return res;
		} catch (ParseException e) {

			return "";
		}

	}

	/**
	 * @Title: getNd
	 * @Description: TODO(获取当前上年)
	 * @param rq
	 *            yyyy
	 * @param num
	 *            1
	 * @return 例如 现在2014 得到2013
	 * @return String 返回类型
	 */
	public static String getNd(String rq, int num) {
		SimpleDateFormat smf = new SimpleDateFormat("yyyy");
		Calendar cld = Calendar.getInstance();
		Date date = null;
		try {
			date = smf.parse(rq);
			cld.setTime(date);
			int day = cld.get(Calendar.YEAR);
			cld.set(Calendar.YEAR, day + (num));
			String res = smf.format(cld.getTime());
			return res;
		} catch (ParseException e) {

			return "";
		}
	}

	/**
	 * @Title: isLastDayOfMonth
	 * @Description: TODO(判断传入日期是不是当月最后一天)
	 * @param rq
	 *            "yyyyMMddHHmmss"
	 * @return
	 * @return boolean 返回类型
	 */
	public static boolean isLastDayOfMonth(String rq) {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			date = format.parse(rq);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, (calendar.get(Calendar.DATE) + 1));
		if (calendar.get(Calendar.DAY_OF_MONTH) == 1) {
			return true;
		}
		return false;
	}
}
