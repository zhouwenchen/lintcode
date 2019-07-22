package com.offer.test;

/**  
 * 反转字符串
 * 出入一个字符串，反转字符串，但是字符串中的单词不反转。其中特殊字符不作为考虑中的因素
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年7月18日 下午4:44:13 
 */
public class Reverse {
	public static String reverse(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		// 1.先反转字符串中的每一个字符
		String reverseStr = getreverseStr(str);
		// 2.仅反转每个单词中的字符
		String[] strings = reverseStr.split(" ");
		StringBuffer sb = new StringBuffer();
		for (String string : strings) {
			String temp = getreverseStr(string);
			sb.append(temp).append(" ");
		}
		return sb.toString().trim();
	}

	private static String getreverseStr(String str) {
		return new StringBuffer(str).reverse().toString();
	}

	public static void main(String[] args) {
		String reverse = reverse("I am a student.");
		System.out.println(reverse);
	}
}
