package com.offer.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**  
 * 字符串的排列
 * 题目：终端随机输入一串字符串，输出该字符串的所有排列。

　　例如，输入：“abc”，输出：abc、acb、bac、bca、cab、cba
 * @author zhouwenchen@021.com  
 * @date 2019年6月24日 下午3:05:13 
 */
public class RecursionPermutation {
	
	private static List<String> result = new ArrayList<>();
	private static HashSet<String> set = new HashSet<>();
	
	public static List<String> permutation(String str){
		if(str == null){
			return result;
		} else {
			  Permutation(str, 0, str.length() - 1);
		}
		result.addAll(set);
		return result;
	}
	
	/**
	 * @param str
	 * @param start
	 * @param end
	 */
	private static void Permutation(String str, int start, int end) {
		char[] array = str.toCharArray();
		String r = null;
		if(start == end){
			r = String.valueOf(array);
			set.add(r);
		} else {
			for (int i = start; i <= end; i++) {
				char tmp = array[start];
				array[start] = array[i];
				array[i] = tmp;
				Permutation(String.valueOf(array), start + 1, array.length - 1);

				tmp = array[start];
				array[start] = array[i];
				array[i] = tmp;
			}
		}
		
	}

	public static void main(String[] args) {
		List<String> lists = permutation("abc");
		for (String str : lists) {
			System.out.println(str);
		}
	}
}
