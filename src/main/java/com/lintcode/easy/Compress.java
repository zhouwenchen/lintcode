package com.lintcode.easy;

import java.util.HashMap;
import java.util.Map;

/**  
 * 213. 字符串压缩
中文English
设计一种方法，通过给重复字符计数来进行基本的字符串压缩。

例如，字符串 aabcccccaaa 可压缩为 a2b1c5a3 。而如果压缩后的字符数不小于原始的字符数，则返回原始的字符串。

可以假设字符串仅包括 a-z 的字母。

样例
样例 1：

输入：str = "aabcccccaaa"
输出："a2b1c5a3"
样例 2：

输入：str = "aabbcc"
输出："aabbcc"
 * @author zhouwenchen@021.com  
 * @date 2019年6月3日 上午11:44:53 
 */
public class Compress {
	public static void main(String[] args) {
//		String str = "aabcccccaaa"; // a2b1c5a3
//		String str = ""; 	// a2b1c5a3
		String str = "a"; 	// a2b1c5a3
		String compress = compress(str);	
		System.out.println(compress); 
	}
	
	public static String compress(String originalString) {
		if("".equals(originalString)){
			return "";
		}
		String[] arrs = originalString.split("");
		StringBuilder sb = new StringBuilder();
		Map<String, Integer> map = new HashMap<>();
		String first = "";
		for (int i = 0; i <arrs.length;i++) {
			String key = arrs[i];
			if(!map.containsKey(key)){
				if(i!=0){
					sb.append(first).append(map.get(first));
//					System.out.println(sb);
					map.clear();
				}
				map.put(key, 1);
			}else{
				map.put(key, map.get(key)+1);
			}
			first = key;
		}
		String result = sb.append(first).append(map.get(first)).toString();
		result = result.length()<originalString.length()?result:originalString;
		return result;
	}
}
