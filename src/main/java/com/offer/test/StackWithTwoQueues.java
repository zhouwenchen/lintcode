package com.offer.test;

import java.util.LinkedList;
import java.util.Queue;

/**  
 * 两个队列实现栈的功能
 * @author zhouwenchen@021.com  
 * @date 2019年6月13日 下午7:40:42 
 */
public class StackWithTwoQueues {
	
	private static Queue<Object> queue1 = new LinkedList<Object>(); 
	private static Queue<Object> queue2 = new LinkedList<Object>();
	
	/**
	 * 栈中添加元素
	 */
	public static void push(Object obj){
		queue1.add(obj);
	}
	
	/**
	 * 栈中弹出元素
	 */
	public static Object pop(){
		Object obj = null;
		if(!queue1.isEmpty()){
			// 将queue1中的数据，仅保留一个。其他都顺序出队到queue2中
			while(queue1.size()>1){
				queue2.add(queue1.poll());
			}
			if(queue1.size() == 1){
				obj = queue1.poll();
			}
			
			// 将queue2中的值添加到queue1中
			while(!queue2.isEmpty()){
				queue1.add(queue2.poll());
			}
		}
		return obj;
	}
	
	public static void main(String[] args) {
		push(1);
		push(2);
		push(3);
		
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
	}
}
