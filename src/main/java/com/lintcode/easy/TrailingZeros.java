package com.lintcode.easy;

/**  
	 * 2. 尾部的零
	中文English
	设计一个算法，计算出n阶乘中尾部零的个数
	
	样例
	样例  1:
		输入: 11
		输出: 2
		
		样例解释: 
		11! = 39916800, 结尾的0有2个。
	
	样例 2:
		输入:  5
		输出: 1
		
		样例解释: 
		5! = 120， 结尾的0有1个。
	
	挑战
	O(logN)的时间复杂度
 * @author zhouwenchen@021.com  
 * @date 2019年3月27日上午11:43:56   
 */
public class TrailingZeros {
    /*
     * @param n: An integer
     * @return: An integer, denote the number of trailing zeros in n!
     */
    
    public long trailingZeros(long n) {
    	long count = 0;
    	long temp = n / 5;
    	while(temp!=0){
    		count += temp;
    		temp/=5;
    	}
    	return count;
    }
    
    public static void main(String[] args) {
    	TrailingZeros trailingZeros = new TrailingZeros();
    	long zeros = trailingZeros.trailingZeros(101);
    	System.out.println(zeros);
	}
}
