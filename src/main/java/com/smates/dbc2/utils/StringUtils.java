package com.smates.dbc2.utils;

/**
 * 对String类型操作的工具类
 * @author baijw12
 *
 */
public class StringUtils {
	
	/**
	 * 判断字符串是否是null,'null',""中的一个
	 * @return 是返回true,不是返回false
	 */
	public static boolean isEmpty(String str){
		return str == null || str.length() == 0 || str.equals("null");
	}

}
