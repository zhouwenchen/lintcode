package com.offer.test;

import java.util.LinkedList;
import java.util.List;

/**  
 * 圆圈中最后剩下的数字(约瑟夫环问题)
 * 题目：0, 1, … , n-1 这 n 个数字排成一个圈圈，从数字 0 开始每次从圆圏里删除第 m 个数字。求出这个圈圈里剩下的最后一个数字。
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年7月22日 上午9:42:56 
 */
public class LastRemaining {
	public static int lastRemaining(int n, int m) {
		if (n < 1 || m < 1) {
	        return -1;
	    }
		List<Integer> list = new LinkedList<>();
		for(int i = 0; i < n;i++){
			list.add(i);
		}
		// 要删除元素的位置
		int idx = 0;
		while (list.size() > 1) {
			for (int i = 1; i < m; i++) {
				idx = (idx + 1) % list.size();
			}
			list.remove(idx);
		}
		return list.get(0);
	}
	
	  public static int lastRemaining2(int n, int m) {
	        if (n < 1 || m < 1) {
	            return -1;
	        }
	        int last = 0;
	        for (int i = 2; i <=n ; i++) {
	            last = (last + m)%i;
	        }
	        return last;
	    }

	public static void main(String[] args) {
//		int last = lastRemaining(6, 3); // 0
		int last = lastRemaining2(6, 3); // 0
//		int last = lastRemaining(5, 3); // 5
//		int last = lastRemaining2(5, 3); // 5
		System.out.println(last);
	}
}
