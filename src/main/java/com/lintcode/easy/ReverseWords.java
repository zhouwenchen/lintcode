package com.lintcode.easy;

/**  
 * 
 * 53. 翻转字符串中的单词
给定一个字符串，逐个翻转字符串中的每个单词。

样例
样例  1:
	输入:  "the sky is blue"
	输出:  "blue is sky the"
	
	样例解释: 
	返回逐字反转的字符串.

样例 2:
	输入:  "hello world"
	输出:  "world hello"
	
	样例解释: 
	返回逐字反转的字符串.

说明
单词的构成：无空格字母构成一个单词，有些单词末尾会带有标点符号
输入字符串是否包括前导或者尾随空格？可以包括，但是反转后的字符不能包括
如何处理两个单词间的多个空格？在反转字符串中间空格减少到只含一个
 * @author zhouwenchen@021.com  
 * @date 2019年3月27日上午11:43:56   
 */
public class ReverseWords {
	public static String reverseWords2(String s) {
		StringBuffer sb = new StringBuffer();
		char[] charArr = s.toCharArray();
		int len = charArr.length - 1;
		for (int i = 0; i < charArr.length; i++) {
			sb.append(String.valueOf(charArr[len--]));
		}
		return String.valueOf(sb);
	}
	
	public static String reverseWords(String s) {
		StringBuffer sb = new StringBuffer();
		String[] arrs = s.split(" ");
		for (int i = arrs.length - 1; i >= 0; i--) {
			sb.append(String.valueOf(arrs[i]));
			sb.append(" ");
		}
		return String.valueOf(sb);
	}
	 
	public static void main(String[] args) {
//		String string = "abcdefg";
//		String string = "ab cd";
		String string = "How are you?";
		
		String str = reverseWords2(string);
		System.out.println(str);
	}
}
