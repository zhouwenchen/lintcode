package com.offer.test;

import java.util.Scanner;

/**  
 * 正则表达式的匹配 java 
 * 请实现一个函数用来匹配包含'.'和'*'的正则表达式。模式中的字符‘.’表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"及"ab*a"均不匹配。
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年6月18日 下午6:54:21 
 */
public class MatchPatternCoreDemo {
	public static boolean match(String input,String pattern){
		if(input == null || pattern == null){
			return false;
		}
		
		return matchCore(input,0,pattern,0);
	}
	
	/**
	 * 递归实现
	 * @param input
	 * @param i
	 * @param pattern
	 * @param j
	 * @return
	 */
	private static boolean matchCore(String input, int i, String pattern, int p) {
		if((input.length() == i) && (pattern.length()==p)){
			// 1.表示的是input和patter都匹配到了末尾的字符
			return true;
		}
		if((input.length() == i) && (pattern.length()!=p) ){
			// 2.表示的是input和patter某一个到达了尾部，但是另一个并没有到尾部
			return false;
		}
		if((input.length() != i) && (pattern.length()== p)){
			return false;
		}
		if((p+1<pattern.length())&&(pattern.charAt(p+1)=='*')){//pattern第二个字符为*
			 if((input.charAt(i)==pattern.charAt(p))||(pattern.charAt(p)=='.')){
				  //首字母相匹配
				return matchCore(input, i + 1, pattern, p + 2) // *表示出现1次
						|| matchCore(input, i + 1, pattern, p) // *表示出现多次
						|| matchCore(input, i, pattern, p + 2); // *表示出现0次 ， a ... p* ...
				// TODO 绕蒙了
			 }else {
				 //首字母不匹配
				 return matchCore(input,i,pattern,p+2);
			 }
		}
		if ((input.charAt(i) == pattern.charAt(p)) || (pattern.charAt(p) == '.')) {
			// pattern第二个字母不是*，且首字母匹配
			return matchCore(input, i + 1, pattern, p + 1);
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println(" 请输入第一个字符串："); 
			String str1 = scanner.nextLine();
//			Scanner scanner2 = new Scanner(System.in);
			System.out.println(" 请输入第一个字符串：");
			String str2 = scanner.nextLine();
			System.out.println("匹配的结果是：");
			System.out.println(match(str1, str2));
		}
	}
}
