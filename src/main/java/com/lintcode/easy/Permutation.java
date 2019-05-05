package com.lintcode.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**  
 * 
 * 211. 字符串置换
给定两个字符串，请设计一个方法来判定其中一个字符串是否为另一个字符串的置换。

置换的意思是，通过改变顺序可以使得两个字符串相等。

样例
Example 1:
	Input:  "abcd", "bcad"
	Output:  True


Example 2:
	Input: "aac", "abc"
	Output:  False

 * @author zhouwenchen@021.com  
 * @date 2019年4月22日 上午10:35:59 
 */
public class Permutation {
	
	public static boolean Permutation(String A, String B) {
		if (A == null && B == null) {
			return true;
		} else if (A != null && B != null && A.length() != B.length()) {
			return false;
		}
		List<String> listA = Arrays.asList(A.split(""));
		List<String> listB = Arrays.asList(B.split(""));

		Collections.sort(listA);
		Collections.sort(listB);
		
		String strA = String.join("", listA);
		String strB = String.join("", listB);

		return strA.equals(strB) ? true : false;
	}
    
    public static void main(String[] args) {
    	String A = "abcd";
    	String B = "bcad";
    	
//    	String A = "";
//    	String B = "a";
    	
//    	String A = "asfhjhsajfhjahsfueuhuqpasjfnmxznbdsafueqhuuuhuhuihu7y8u87890-0---kjsafkjaskjfsalkfnmzxncmncfafuenfjasnfjkanhds";
//    	String B = "afkjaskhjaafuehfasfhjhsajfhuh-kjsjasnfjkanhdshsfuihu7y8u87890-0-fueqhuuujfqpalkfnmz-ueuhufnmsjsaxznbdsaxncmncf";
//    	String C = "asfhjhsajfhjahsfueuhuqpasjfnmxznbdsafueqhuuuhuhuihu7y8u87890-0---kjsafkjaskjfsalkfnmzxncmncfafuenfjasnfjkanhds";
		boolean c = Permutation(A, B);
		System.out.println(c);
	}
}
