package com.lintcode.easy;

/**  
 * 212. 空格替换
设计一种方法，将一个字符串中的所有空格替换成 %20 。你可以假设该字符串有足够的空间来加入新的字符，且你得到的是“真实的”字符长度。

你的程序还需要返回被替换后的字符串的长度。

样例
样例 1：

输入：string[] = "Mr John Smith" and length = 13
输出：string[] = "Mr%20John%20Smith" and return 17
解释：
对于字符串 "Mr John Smith"，长度为 13。替换空格之后，参数中的字符串需要变为 "Mr%20John%20Smith"，并且把新长度 17 作为结果返回。
样例 2：

输入：string[] = "LintCode and Jiuzhang" and length = 21
输出：string[] = "LintCode%20and%20Jiuzhang" and return 25
解释：
对于字符串 "LintCode and Jiuzhang"，长度为 21。替换空格之后，参数中的字符串需要变为 "LintCode%20and%20Jiuzhang"，并且把新长度 25 作为结果返回。
挑战
在原字符串(字符数组)中完成替换，不适用额外空间

注意事项
如果使用 Java 或 Python, 程序中请用字符数组表示字符串。
 * @author zhouwenchen@021.com  
 * @date 2019年4月22日 上午11:14:03 
 */
public class ReplaceBlank {
	
/*	 public int replaceBlank(char[] string, int length) {
        // write your code here
        if(0==length) return 0;
        int num = 0;
        for(int i=0;i<length;i++){
            if(string[i] == ' ') num++;
        }
        
        int newLen = length + num*2;
        string[newLen] = 0;
        int j = 1;
        for(int i=length-1;i>=0;i--){
            if(string[i] != ' '){
                string[newLen - j] = string[i];
                j++;
            }
            else{
                string[newLen - j] = '0';
                j++;
                string[newLen - j] = '2';
                j++;
                string[newLen - j] = '%';
                j++; 
            }
        }
        return newLen;
    }*/
	
	 public static int replaceBlank(char[] string, int length) {
	        // write your code here
	        if (string == null || string.length == 0) {
	            return 0;
	        }
	        int count = 0;
	        for (int i = 0; i < string.length; i++) {
	            if (string[i] == ' ') {
	                count++;
	            }
	        }
	        int newLen = length + count * 2;
	        
	        for (int i = length - 1; i >= 0; i--) {
	            if (string[i] == ' ') {
	                string[i + count * 2] = '0';
	                string[i + count * 2 - 1] = '2';
	                string[i + count * 2 - 2] = '%';
	                count--;
	            } else {
	                string[i + count * 2] = string[i];
	            }
	        }
	        return newLen;
	    }
    
    public static void main(String[] args) {
//    	String string = "LintCode and Jiuzhang";
    	char[] string = "Mr John Smith".toCharArray();
    	int length = 17;
		int newlen = replaceBlank(string, string.length);
		System.out.println(string);
		System.out.println(newlen);
	}
}
