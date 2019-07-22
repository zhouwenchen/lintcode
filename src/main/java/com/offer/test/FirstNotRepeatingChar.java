package com.offer.test;

import java.util.HashSet;

/**  
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年7月16日 上午9:34:02 
 */
public class FirstNotRepeatingChar {
	public static int firstNotRepeatingChar(String s) {
		if (s == null || s.length() < 1) {
			return -1;// 表示没有
		}
		
		HashSet<Character> set = new HashSet<Character>();
		char[] ch = s.toCharArray();
		for(int i = 0; i < s.length()-1;i++){
			for(int j = i+1; j < ch.length;j++){
				if(set.contains(ch[i])){
					break;
				}
				if(ch[i]==ch[j]){
					set.add(ch[i]);
					break;
				}
				if(j==ch.length-1){
					return i;
				}
			}
		}
		return -1;
	}
	
	/**
	 * 使用第二种方式实现的
	 * @param s
	 * @return
	 */
	public static int firstNotRepeatingChar2(String s) {
		int[] words = new int[58];
		
		// 使用hash的思路，将字符串中的字符存入到数组中
		for(int i = 0; i < s.length();i++){
			words[((int)s.charAt(i))-65] += 1;
		}
		
		for(int i = 0; i < s.length();i++){
			if(words[((int)s.charAt(i))-65] == 1){
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		String str = "abaccdeef";
//		int loc = firstNotRepeatingChar(str);
		int loc = firstNotRepeatingChar2(str);
		char c = str.toCharArray()[loc];
		System.out.println(c);
	}
}
