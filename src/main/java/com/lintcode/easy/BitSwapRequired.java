package com.lintcode.easy;

/**  
 * 181. 将整数A转换为B
如果要将整数n转换为m，需要改变多少个bit位？

样例
Example 1:
	Input: n = 31, m = 14
	Output:  2
	
	Explanation:
	(11111) -> (01110) there are two different bits.


Example 2:
	Input: n = 1, m = 7
	Output:  2
	
	Explanation:
	(001) -> (111) will change two bits.


注意事项
Both n and m are 32-bit integers.
 * @author zhouwenchen@021.com  
 * @date 2019年4月18日 下午4:24:19 
 */
public class BitSwapRequired {
	
	public static int bitSwapRequired(int a, int b) {
		// 根据生成的二进制的长度进行格式化
		String abyte = Integer.toBinaryString(a);
		String bbyte = Integer.toBinaryString(b);
		int maxlen = Math.max(abyte.length(), bbyte.length());
		String str = String.format("%0"+maxlen+"d", Integer.parseInt(abyte));  
		String str1 = String.format("%0"+maxlen+"d", Integer.parseInt(bbyte));  
		
		String[] a_arr = str.split("");
		String[] b_arr = str1.split("");
		int m = 0;
		for(int i = 0; i < a_arr.length;i++){
			if(!a_arr[i].equals(b_arr[i])){
				m++;
			}
		}
		return m;
	}
	
	public static int bitSwapRequired1(int a, int b) {
		int count = 0;
		for(int c = a^b;c!=0;c=c>>>1){
			count +=c&1;
		}
		return count;
	}
    
	public static void main(String[] args) {
		int a = 31;
		int b = 14;
		
//		int a = 1;
//		int b = -1;
		
		int m = bitSwapRequired1(a, b);
		System.out.println(m);
		
		
		System.out.println(Integer.toBinaryString(a) +"\t"+ Integer.toBinaryString(b));
		System.out.println(a^b);
		System.out.println(a^b>>>1);
//		
//		String a = Integer.toBinaryString(1); // 11111
//		String b = Integer.toBinaryString(-1); // 1111
//		System.out.println(a+ "\t" +b);
		
//		 String str = String.format("%05d", Integer.parseInt(Integer.toBinaryString(15)));  
//		 System.out.println(str); // 0000000001   
	}
}
