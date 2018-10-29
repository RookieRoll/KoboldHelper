package com.kobold.regex;

public class RegexConst {
	/**
	 * 邮箱校验
	 */
	public static final String EMAIL_REGEX = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";

	/**
	 * 国内手机校验
	 */
	public static  final  String CHINA_PHONE="^((13[0-9])|(15[^4])|(18[0-9])|(17[0-9])|(147))\\d{8}$";

	/**
	 * 校验是否是网址
	 */
	public static  final String WEB_URL="(((https|http)?://)?([a-z0-9]+[.])|(www.))\\w+[.|\\/]([a-z0-9]{0,})?[[.]([a-z0-9]{0,})]+((/[\\S&&[^,;\u4E00-\u9FA5]]+)+)?([.][a-z0-9]{0,}+|/?)";

	/**
	 * 带区号电话号码
	 */
	public static String PHONE_AREA="^[0][1-9]{2,3}-[0-9]{5,10}$";
	/**
	 * 不带区号电话号码
	 */
	public static  String PHONE="^[1-9]{1}[0-9]{5,8}$";

	/**
	 * 整数
	 */
	public static  String NUMBER="^-?[1-9]\\d*$";
	/**
	 * 负整数
	 */
	public static String NEGATIVE_NUMBER="^-[1-9]\\d*$ ";
	/**
	 * 正整数
	 */
	public static  String NATURAL_NUMBER="^[1-9]\\d*$";


}
