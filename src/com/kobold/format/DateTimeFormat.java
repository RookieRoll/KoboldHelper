package com.kobold.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeFormat {
	/**
	 * 将时间转换为指定的格式
	 *
	 * @param date   时间
	 * @param format 转换的格式
	 * @return 转换后的时间字符串格式
	 */
	public static String formatDateTime(Date date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	/**
	 * 将指定的日期转换为Date
	 * @param time 某种格式的日期
	 * @param format 格式
	 * @return 转换后的日期
	 */
	public static Date formatToDateTime(String time, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		try {
			Date date = dateFormat.parse(format);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
