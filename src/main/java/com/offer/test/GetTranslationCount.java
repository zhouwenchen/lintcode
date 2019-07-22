package com.offer.test;

/**  
 * 把数字翻译成字符串
 * 因此一个数字可能有多种翻译。例如，12258有5种不同的翻译，bccfi,bwfi,bczi,mcfi,mzi。
 * @author zhouwenchen@021.com  
 * @date 2019年7月9日 下午8:41:23 
 */
public class GetTranslationCount {
	
	public static int getTranslationCount(int num){
		if(num < 0){
			return 0;
		}
		if(num == 1){
			return 1;
		}
		
		return getTranslationCount(Integer.toString(num));
	}
	
	private static int getTranslationCount(String num) {
		int f1 = 0;
		int f2 = 1;
		int g = 0;
		int temp;
		for(int i = num.length() -2;i >=0;i--){
			if(Integer.parseInt(num.charAt(i)+""+num.charAt(i+1))<26){
				g=1;
			}else {
				g = 0;
			}
			temp = f2;
			f2 = f2+g*f1;
			f1 = temp;
		}
		return f2;
	}

	public static void main(String[] args) {
		int string = getTranslationCount(12258);
		System.out.println(string);
	}
}
