package com.offer.test;

import java.util.Scanner;

/**  
 * 　　请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是'g'。
 * 	当从该字符流中读出前六个字符"google"时，第一个只出现一次的字符是'l'。
 * @author zhouwenchen@021.com  
 * @date 2019年7月16日 上午11:49:22 
 */
public class FirstCharacterInStream {
	private int index;
	private int[] occurence;
	
	public FirstCharacterInStream() {
		int index = 0;
		occurence = new int[256];
		for(int i = 0; i < occurence.length;i++){
			occurence[i] = -1;
		}
	}
	
	public void insert(char ch){
		if(occurence[(int) ch] == -1){
			occurence[(int) ch] = index; // 表示的是第一次出现的字符
		} else if(occurence[(int) ch] >=0){ // 表示不是第一次出现
			occurence[(int) ch] = -2;
		}
		index++;
	}
	
	public char getFirst() {
		int minIndex = Integer.MAX_VALUE;
		char ch = '#';
		for (int i = 0; i < occurence.length; i++) {
			if (occurence[i] >= 0 && occurence[i] < minIndex) {
				ch = (char) i;
				minIndex = occurence[i];
			}
		}
		return ch;
	}
	
	public static void main(String[] args) {
		FirstCharacterInStream fc = new FirstCharacterInStream();
		Scanner sc = new Scanner(System.in);
		while(true){
			String value = sc.next();
			fc.insert(value.toCharArray()[0]);
			char c = fc.getFirst();
			System.out.println(c);
		}
	}
}
