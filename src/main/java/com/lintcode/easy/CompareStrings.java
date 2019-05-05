package com.lintcode.easy;

/**  
 * 
 * 55. 比较字符串
比较两个字符串A和B，确定A中是否包含B中所有的字符。字符串A和B中的字符都是 大写字母

样例
给出 A = "ABCD" B = "ACD"，返回 true

给出 A = "ABCD" B = "AABC"， 返回 false

注意事项
在 A 中出现的 B 字符串里的字符不需要连续或者有序。
 * @author zhouwenchen@021.com  
 * @date 2019年3月27日上午11:43:56   
 */
public class CompareStrings {
	
    public static boolean compareStrings(String A, String B) {
    	if(B == null ||B.length() == 0){
    		return true;
    	}
    	String[] b_arr = B.split("");
    	for (String b : b_arr) {
    		if(!A.contains(b)){
    			return false;
    		}
    		
    		// 替换匹配到的字符，但是只能替换其中一个，但是不可以替换多个字符
    		A = A.replaceFirst(b, "");
    	}
    	return true;
    }
    
	public static void main(String[] args) {
//		String A = "ABCD";
//		String B = "ACd";
//		String A = "ABCD";
//		String B = "AABC";
		String A = "AAAAAAAAAAAABBBBBCDD";
		String B = "ABCDD";
		boolean c = compareStrings(A, B);
		System.out.println(c);
	}
}
