package com.offer.test;

/**  
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * 
 * 1.标记符号，小数点，e是否出现过，这几个标识
 * 2.e后面一定要接数字
 * 3.不能同时存在两个e
 * 4.第二次出现+-符号，则必须紧接在e之后
 * 5.第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
 * 6.e后面不能接小数点，小数点不能出现两次
 * 7.不合法字符
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年7月31日 下午4:29:37 
 */
public class IsNumeric {
	
	/**
	 * // TODO 不完善的版本
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(char[] str) {
		// 标记符号、小数点、e是否出现过
		boolean sign = false, decimal = false, hasE = false;
		for (int i = 0; i < str.length; i++) {
			if (str[i] == 'e' || str[i] == 'E') {
				if (i == str.length - 1)
					return false; // e后面一定要接数字
				if (hasE)
					return false; // 不能同时存在两个e
				hasE = true;
			} else if (str[i] == '+' || str[i] == '-') {
				// 第二次出现+-符号，则必须紧接在e之后
				if (sign && str[i - 1] != 'e' && str[i - 1] != 'E')
					return false;
				// 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
				if (!sign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E')
					return false;
				sign = true;
			} else if (str[i] == '.') {
				// e后面不能接小数点，小数点不能出现两次
				if (hasE || decimal)
					return false;
				decimal = true;
			} else if (str[i] < '0' || str[i] > '9') // 不合法字符
				return false;
		}
		return true;
	}
	

	/**
	 * // TODO 完善的版本信息
	 * 1.指数符号前必须有整数
	 * 2.指数符号后必须有整数
	 * 3.只能有一个指数符号
	 * 4.小数点只能出现在指数符号之前
	 * 5.小数点不能出现在最后一位上
	 * 6.小数点只能出现一次
	 * 7.第一次出现+''-'符号只能在第一个字符或者指数符号后
	 * 8.第二出现'+''-'符号只能在指数符号后
	 * 9.'+''-'符号不能出现在最后一位上
	 * 10.其它的非数字字符
	 * @param str
	 * @return
	 */
	private static boolean isNumeric2(char[] str) {
		if (str == null)
			return false;

		boolean sign = false, deciminal = false, hasE = false; // '+''-'符号、小数点和指数符号出现标志
		for (int i = 0; i < str.length; i++) {
			if (str[i] == 'e' || str[i] == 'E') {
				if (i == 0)
					return false; // 指数符号前必须有整数
				if (i == str.length - 1)
					return false; // 指数符号后必须有整数
				if (hasE)
					return false; // 只能有一个指数符号
				hasE = true;
			} else if (str[i] == '.') {
				if (hasE)
					return false; // 小数点只能出现在指数符号之前
				if (i == str.length - 1)
					return false; // 小数点不能出现在最后一位上
				if (deciminal)
					return false; // 小数点只能出现一次
				deciminal = true;
			} else if (str[i] == '+' || str[i] == '-') {
				// 第一次出现+''-'符号只能在第一个字符或者指数符号后
				if (!sign && i != 0 && !hasE)
					return false;
				if (sign && !hasE)
					return false; // 第二出现'+''-'符号只能在指数符号后
				if (i == str.length - 1)
					return false; // '+''-'符号不能出现在最后一位上
				sign = true;
			} else if (str[i] < '0' || str[i] > '9')
				return false; // 其它的非数字字符
		}
		return true;
	}
	
	

	public static void main(String[] args) {
//		char[] str = "5e2".toCharArray();
//		char[] str = "1.5e2".toCharArray();
		char[] str = "e123".toCharArray();
		
		
//		boolean b = isNumeric(str);
		boolean b = isNumeric2(str);
		System.out.println(b);
	}
}

