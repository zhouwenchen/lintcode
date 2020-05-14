package com.lintcode.easy;

/**  
 * 49. 字符大小写排序
中文English
给定一个只包含字母的字符串，按照先小写字母后大写字母的顺序进行排序。

样例
样例 1:
	输入:  "abAcD"
	输出:  "acbAD"

样例 2:
	输入: "ABC"
	输出:  "ABC"
	
挑战
在原地扫描一遍完成

注意事项
小写字母或者大写字母他们之间不一定要保持在原始字符串中的相对位置。
 * @author zhouwenchen@021.com  
 * @date 2019年7月4日 下午3:26:12 
 */
public class SortLetters {
	public static void sortLetters(char[] chars) {
		if (chars == null) {
			return;
		}
		int start = 0;
		int end = chars.length - 1;

		while (start < end) {
			while (start < end && chars[start] > 90) { // 表示的是小写字母
				start++;
			}
			while (start < end && chars[end] <= 90) {
				end--;
			}
			if(start < end){
				char tmp = chars[start];
				chars[start] = chars[end];
				chars[end] = tmp;
				start++;
				end--;
			}
		}
	}
    
    public static void main(String[] args) {
//    	char[] chars = "abAcD".toCharArray();
//    	char[] chars = "abAcAcD".toCharArray();
    	char[] chars = "ab".toCharArray();
		sortLetters(chars);
		System.out.println(chars);
		
//		System.out.println(chars[0] < 97);
//		
//		System.out.println((int)'A');
//		System.out.println((int)'Z');
//		System.out.println((int)'a');
	}
}
