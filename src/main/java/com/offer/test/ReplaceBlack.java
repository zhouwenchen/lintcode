package com.offer.test;

/**  
 * 替换空格，将一段字符串中的空格，替换成 "%20"
 * @author zhouwenchen@021.com  
 * @date 2019年6月12日 下午5:31:02 
 */
public class ReplaceBlack {
	public static int replaceBlack(char[] str){
		if(str==null){
			return 0;
		}
		// 1.先遍历字符串中，包含的空格的数量
		int newLength = str.length;
		int space = 0;// 空格的个数
		for(int i = 0;i < newLength;i++){
			if (str[i] == ' ') {
				space++;
			}
		}
		// 替换之后新的数组的长度
		newLength = str.length + space*2;
		int index = newLength;
		char[] result = new char[newLength];
		// 2.从后向前进行
		for(int i = str.length-1;i>=0;i--){
			if(str[i] == ' '){
				result[--index] = '0';
				result[--index] = '2';
				result[--index] = '%';
			} else {
				result[--index] = str[i];
			}
		}
		return newLength;
	}
	
	public static void main(String[] args) {
		char[] str = "We are happy.".toCharArray();
		int result = replaceBlack(str);
		System.out.println(result);
	}
}
