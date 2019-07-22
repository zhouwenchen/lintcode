package com.offer.test;

/**  
 * 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该子字符串的长度。
 * 
 * 动态规划，用f(i)表示以i个字符结尾不包含重复子字符串的最长长度，从左向右扫描

1、若第i个字符在之前没出现过，则 f(i) = f(i-1) + 1;

2、若第i个字符在之前出现过，

计算第i个字符距离上次出现之间的距离为d

(a)若d <= f(i-1)，则说明第i个字符上次出现在f(i-1)对应的不重复字符串之内，那么这时候更新 f(i) = d

(b)若d > f(i-1)，则无影响,f(i) = f(i-1) + 1

例如arabcacfr

f(0) =1,  a

f(1) = 2,  ar

f(2) = 2,  ra，因为d=2，f(1)=2，所以上一个a在f(1)之中

f(3) = 3,  rab

f(4) = 4,  rabc

f(5) = 3,  bca，因为d=3，f(1)=4，所以上一个a一定在f(4)中

f(6) = 2,  ac

f(7) = 3,  acf

f(8) = 4,  acfr，因为d=7,f(7)=3,因此上一个r不在f(7)中，f(8) = f(7) + 1
 * @author zhouwenchen@021.com  
 * @date 2019年7月15日 下午5:20:33 
 */
public class LengthOfLongestSubstring {
	
	public static int lengthOfLongestSubstring(String s) {
		if(s.length() == 0){
			return 0;
		}
		int curLen = 0;
		int maxLen = 0;
		int[] position = new int[26];
		for(int i = 0; i < 26;i++){
			position[i] = -1;
		}
		
		// 遍历字符串
		char[] arr = s.toCharArray();
		for(int i = 0; i < arr.length; i ++){
			int preIndex = position[arr[i] - 'a'];
			if(preIndex < 0 || i - preIndex > curLen){ // 没有出现过，或者 d > f(i - 1)
				curLen++;
			} else { // 表示出现过了
				if(curLen > maxLen){
					maxLen = curLen;
				}
				curLen = i - preIndex; // f(i) = d
			}
			position[arr[i] - 'a'] = i;
		}
		if(curLen > maxLen){
			maxLen = curLen;
		}
		
		return maxLen;
	}
	
	public static void main(String[] args) {
		String s = "arabcacfr";
		int len = lengthOfLongestSubstring(s);
		System.out.println(len);
	}
}
