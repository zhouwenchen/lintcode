package com.lintcode.easy;

/**  
 * 8. 旋转字符串
中文English
给定一个字符串（以字符数组的形式给出）和一个偏移量，根据偏移量原地旋转字符串(从左向右旋转)

样例
样例  1:
	输入:  str="abcdefg", offset = 3
	输出: "efgabcd"
	
	样例解释: 
	返回旋转后的字符串。

样例 2:
	输入: str="abcdefg", offset = 0
	输出: "abcdefg"
	
	样例解释: 
	返回旋转后的字符串

样例 3:
	输入: str="abcdefg", offset = 1
	输出: "gabcdef"
	
	样例解释: 
	返回旋转后的字符串

样例 4:
	输入: str="abcdefg", offset =2
	输出:"fgabcde"
	
	样例解释: 
	返回旋转后的字符串
挑战
在数组上原地旋转，使用O(1)的额外空间

注意事项
offset >= 0
 * @author zhouwenchen@021.com  
 * @date 2019年3月27日上午11:43:56   
 */
public class RotateString {

	public void rotateString(char[] str, int offset) {
		// write your code here
		char temp;
		if (offset == 0) {
			return;
		}
		if (str.length == 0) {
			return;
		}
		int len = str.length;
		for (int i = 1; i <= offset % len; i++) {
			temp = str[len - 1];
			int j = len - 2;
			while (j >= 0) {
				str[j + 1] = str[j];
				j--;
			}
			str[0] = temp;
		}
	}

	public static void main(String[] args) {
		RotateString rotateString = new RotateString();
		char[] abc = "abcdefg".toCharArray();
		rotateString.rotateString(abc, 3);

		for (char c : abc) {
			System.out.print(c + "\t");
		}
	}
}
