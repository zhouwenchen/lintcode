package com.offer.test;

/**  
 * 左旋转字符串
 * 将字符串左旋转两位，比如说abcdefg，左旋就是cdefgab
 * @author zhouwenchen@021.com  
 * @date 2019年7月18日 下午7:30:45 
 */
public class LeftRoateString {
	
	/**
	 * 先将目标字符串分割成两个字符串，然后方便旋转后拼接起来，之后再次旋转
	 * @param str
	 * @param k
	 * @return
	 */
	public static String leftRoateString(String str, int k) {
		if (str == null || str.length() <= k) {
			return str;
		}

		String left = str.substring(0, k);
		String right = str.substring(k);

		left = getReserver(left);
		right = getReserver(right);

		return getReserver(left + right);
	}
	
	private static String getReserver(String str) {
		StringBuffer sb = new StringBuffer();
		return sb.append(str).reverse().toString();
	}

	public static void main(String[] args) {
		String str = "abcdefg";
		String resultStr = leftRoateString(str,2);
		System.out.println(resultStr);
	}
}
