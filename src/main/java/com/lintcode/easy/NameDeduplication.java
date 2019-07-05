package com.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

/**  
 * 
 * 487. 姓名去重
给一串名字，将他们去重之后返回。两个名字重复是说在忽略大小写的情况下是一样的。

样例
例1:

输入:["James", "james", "Bill Gates", "bill Gates", "Hello World", "HELLO WORLD", "Helloworld"]


输出:["james", "bill gates", "hello world", "helloworld"]
例2:

输入:["cmy","Cmy"]

输出:["cmy"]
说明
你可以假设名字只包含大小写字母和空格。
 * @author zhouwenchen@021.com  
 * @date 2019年6月3日 下午8:51:33 
 */
public class NameDeduplication {
	public static void main(String[] args) {
//		String[] names = new String[]{"James", "james", "Bill Gates", "bill Gates", "Hello World", "HELLO WORLD", "Helloworld"};
		String[] names = new String[]{};
		List<String> list = nameDeduplication(names);
		for (String string : list) {
			System.out.print(string + "\t");
		}
	}
	
    public static List<String> nameDeduplication(String[] names) {
    	if(names.length == 0){
    		return new ArrayList<>();
    	}
    	List<String> list = new ArrayList<>(names.length);
    	for (String string : names) {
    		String lowStr = string.toLowerCase();
    		if(list.contains(lowStr)){
    			continue;
    		}
    		list.add(lowStr);
    	}
    	return list;
    }
}
