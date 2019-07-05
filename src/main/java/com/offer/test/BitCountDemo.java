package com.offer.test;

/**  
 * 计算二进制中1的个数
 * @author zhouwenchen@021.com  
 * @date 2019年6月17日 下午3:21:54 
 */
public class BitCountDemo {
	
	/**
	 * 普通的方式实现 n左移的方式
	 * 如果此时数据是负数的话，这种右移的方式是错误的
	 * @param n
	 * @return
	 */
	public static int bitCount1(int n) {
		int count = 0;// 计数器
		while (n > 0) {
			if ((n & 1) == 1) {
				++count;
			}
			n >>= 1;
		}
		return count;
	}
	
	/**
	 * 更为精简的一种实现方式
	 * @param n
	 * @return
	 */
	public static int bitCount2(int n) {
		int count = 0;
		for (; n > 0; n >>= 1) {
			count += n & 1;
		}
		return count;
	}
	
	/**
	 * n&(n-1)，就会清除n最后一位的1
	 * 例如：8（1000）= 7（0111）+ 1（0001）    	8 & 7 = （1000）&（0111）= 0（0000）
	 * 	   7（0111）= 6（0110）+ 1（0001）	7 & 6 = （0111）&（0110）= 6（0110）
	 * 	   7 & 6 = （0111）&（0110）= 6（0110）
	 * 	   6 & 5 = （0110）&（0101）= 4（0100）
	 *     4 & 3 = （0100 &（0011）= 0（0000）
	 * @param n
	 * @return
	 */
	public static int bigCount3(int n){
		int count = 0;
		for (; n > 0; count++){
			n &=(n-1);
		}
		return count;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println(bitCount1(15));
//		System.out.println(bitCount1(-1)); // 如果是负数的话，这种解决方案是错误的
//		System.out.println(bitCount2(14));
		System.out.println(bitCount2(-1));
//		System.out.println(bigCount3(9));
	}
}
