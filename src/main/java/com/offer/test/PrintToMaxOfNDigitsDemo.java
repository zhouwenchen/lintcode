package com.offer.test;

/**  
 * 输入数字n，按顺序打印出从1到最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数即999。
 * @author zhouwenchen@021.com  
 * @date 2019年6月18日 下午2:17:14 
 */
public class PrintToMaxOfNDigitsDemo {

	/**
	 * 第一种方式，计算出第n位的最大值。然后循环遍历，获取到值
	 * @param n
	 */
	public static void printToMaxOfNDigits1(int n) {
		if (n <= 0) {
			return;
		}
		long number = 1;
		int i = 0;
		while(i < n){
			number *= 10;
			++i;
		}
		for (long j = 1; j < number; j++) { //利用for循环输出从1到最大的n位数
			System.out.print(j + " ");
			if(j%5 == 0){
				System.out.println();
			}
		}
	}

	/**
	 * 使用字符串的方式，解决整型最大值的问题
	 * TODO 不是太明白，有待继续探究【20190731】	思考问题：
	 */
	public static void printToMaxOfDigits2(int n) {
		if (n <= 0) {
			System.out.println("输入的没有意义" + n);
			return;
		}

		// 申明一个字符数组，用来存放一个大数的形式
		char[] number = new char[n];
		for (int i = 0; i < number.length; i++) {// 初始化字符数组为字符串‘0’
			number[i] = '0';
		}

		while (!increment(number)) {// 如果字符数组不溢出的情况下，那么将循环的遍历 TODO
			printNumber(number);// 遍历满足条件的数组 TODO
		}
	}
	
	/**
	 * 打印字符串
	 * @param number
	 */
	private static void printNumber(char[] number) {
		boolean isBeginning0 = true;
		int nLength = number.length;
		for (int i = 0; i < nLength; ++i) {
			if (isBeginning0 && number[i] != '0') {
				isBeginning0 = false;
			}
			if (!isBeginning0) {
				System.out.print(number[i]);
			}
		}
		System.out.println();
	}

	/**
	 * 字符串的递增操作
	 * @param number
	 * @return
	 */
	private static boolean increment(char[] number) {
		boolean isOverflow = false; 	// 判断是否溢出
		int nTakeOver = 0;				// 判断是否进位
		int nLength = number.length;

		for (int i = nLength - 1; i >= 0; --i) {
			int nSum = number[i] - '0' + nTakeOver;
			if (i == nLength - 1) {		// 末尾自加1
				++nSum;
			}
			if (nSum >= 10) { 			// 判断是否需要进位
				if (i == 0) {
					isOverflow = true;
				} else {
					nSum -= 10;
					nTakeOver = 1;
					number[i] = (char) ('0' + nSum);
				}
			} else {
				number[i] = (char) (nSum + '0');
				break;
			}
		}

		return isOverflow;
	}

	public static void main(String[] args) {
		// 第一种方式的弊端，在于没有考虑到类型的最大值，可能会导致整型的溢出操作，所以没有考虑到代码的鲁棒性的问题。
//		printToMaxOfNDigits1(3);
		
		// 可以使用的是字符串来解决整型的最大值的问题。
		printToMaxOfDigits2(3);
	}
}
