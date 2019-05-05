package com.lintcode.easy;

/**
 * 你可以假设输入一定在小写字母 a ~ z 之间 输入: 'a' 输出: 'A'
 */
public class LowercaseToUppercase {

	public static void main(String[] args) {
		lowercaseToUppercase('a');
	}

	public static char lowercaseToUppercase(char character) {
		char upperCase = Character.toUpperCase(character);
		System.out.println(upperCase);
		return upperCase;
	}
}
