package com.lintcode.easy;
/**  
 * 13. 字符串查找
中文English
对于一个给定的 source 字符串和一个 target 字符串，你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。如果不存在，则返回 -1。

样例
样例  1:
	输入: source = "source" ， target = "target"
	输出:-1
	
	样例解释: 
	如果source里没有包含target的内容，返回-1

样例 2:
	输入: source = "abcdabcdefg" ，target = "bcd"
	输出: 1
	
	样例解释: 
	如果source里包含target的内容，返回target在source里第一次出现的位置

挑战
O(n2)的算法是可以接受的。如果你能用O(n)的算法做出来那更加好。（提示：KMP）

说明
在面试中我是否需要实现KMP算法？

不需要，当这种问题出现在面试中时，面试官很可能只是想要测试一下你的基础应用能力。当然你需要先跟面试官确认清楚要怎么实现这个题。
 * @author zhouwenchen@021.com  
 * @date 2019年3月27日上午11:43:56   
 */
public class StrStr {
    
	public static int strStr(String source, String target) {
		if(source == null || target == null){
			return -1;
		}
		if("".equals(source) && "".equals(target) || source!=null && "".equals(target)){
			return 0;
		}
		if(source.length()==target.length() && source.equals(target)){
			return 0;
		}
		char c = target.charAt(0);
		for(int i=0; i < source.length();i++){
			if(source.charAt(i)==c){
				String sourceStr;
				if(source.length()-i <= target.length()){
					sourceStr = source.substring(i);
				} else {
					sourceStr = source.substring(i,target.length()+1);
				}
				if(target.equals(sourceStr)){
					return i;
				}
			}
		}
		return -1;
	}
	
	
	public static int strStr1(String source, String target) {
		if(source == null || target == null){
			return -1;
		}
		if("".equals(source) && "".equals(target) || source!=null && "".equals(target)){
			return 0;
		}
		if(source.length()==target.length() && source.equals(target)){
			return 0;
		}
		char[] t = source.toCharArray();
		char[] p = target.toCharArray();
		int i = 0; // 主串的位置
		int j = 0; // 模式串的位置
		
		while(i < t.length && j < p.length){
			if(t[i] == p[j]){
				i++;
				j++;
			} else{
 				i = i-j+1; 	// 一旦不匹配，i后退
				j = 0; 		// j归零
			}
		}
		
		if(j == p.length){
			return i -j;
		}else {
			return -1;
		}
	}
	
	public static int strStr2(String source, String target) {
		if(source == null ||target == null){
			return -1;
		}
		int i,j;
		for(i = 0;i < source.length()-target.length()+1;i++){
			for(j = 0; j<target.length();j++){
				if(source.charAt(i+j) != target.charAt(j)){
					break;
				}
			}
			if(j == target.length()){
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
//		String source = "abcdabcdefg";
//		String target = "bcd";
		
//		String source = "";
//		String target = "";
		
//		String source = "";
//		String target = "a";
		
//		String source = "a";
//		String target = "";
		
//		String source = null;
//		String target = "a";
		
//		String source = "lintcode";
//		String target = "lintcode";
		
		String source = "abcde";
		String target = "e";
		
		int index = strStr2(source,target);
		System.out.println(index);
		
//		int index = strStr2(source,target);
//		System.out.println(index);
	}
}