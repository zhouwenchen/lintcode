package com.lintcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**  
 * 209. 第一个只出现一次的字符
给出一个字符串，找出第一个只出现一次的字符。

样例
样例 1:
	输入: "abaccdeff"
	输出:  'b'
	
	解释:
	'b' 是第一个出现一次的字符


样例 2:
	输入: "aabccd"
	输出:  'b'
	
	解释:
	'b' 是第一个出现一次的字符
 * @author zhouwenchen@021.com  
 * @date 2019年4月22日 上午9:56:06 
 */
public class FirstUniqChar {
	
    public static char firstUniqChar(String str) {
    	String[] arr = str.split("");
    	Map<String,String> map = new HashMap<String,String>();
    	for (String key : arr) {
    		if(!map.containsKey(key)){
    			map.put(key, "1");
    		} else if("1".equals(map.get(key))){
    			map.put(key, "2");
    		}
    	}
    	
    	Set<String> set = map.keySet();
		for (String string : set) {
			if ("1".equals(map.get(string))) {
				return string.charAt(0);
			}
		}
    	return ' ';
    }
    
    public static char firstUniqChar1(String str) {
    	int[] hash = new int[128];
    	char[] cs = str.toCharArray();
    	for (char c : cs) {
			hash[c]++;
		}
    	
    	for (char c : cs) {
			if(hash[c] == 1){
				return c;
			}
		}
    	return ' ';
    }
    
    public static char firstUniqChar2(String str) {
    	Map<Character,Integer> map = new TreeMap<Character,Integer>();
    	for(Character c : str.toCharArray()){
    		map.putIfAbsent(c, 0);
    		map.put(c, map.get(c)+1);
    	}
    	for(Character c: map.keySet()){
    		if(map.get(c)==1){
    			return c;
    		}
    	}
    	return ' ';
    }
    
    public static void main(String[] args) {
    	String str = "abaccdeff";
		char c = firstUniqChar(str );
		System.out.println(c);
	}
}
