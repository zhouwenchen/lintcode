package com.offer.test;

import java.util.Stack;

/**  
 * 使用两个栈实现队列操作，也就是说实现队列的先进先出的操作
 * @author zhouwenchen@021.com  
 * @date 2019年6月13日 下午3:48:23 
 */
public class TowStackQueue {
	private static Stack<Integer> stack1 = new Stack<Integer>();
	private static Stack<Integer> stack2 = new Stack<Integer>();
	
	/**
	 * 往队尾添加元素
	 * @param value
	 */
	public static void appendTail(int value){
		stack1.push(value);
	}
	
	/**
	 * 从队头移除数据，并返回
	 */
	public static Integer delteHead(){
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		return stack2.pop();
	}
	
	public static void main(String[] args) {
		appendTail(1);
		appendTail(2);
		appendTail(3);
		appendTail(4);
		System.out.println(delteHead());
		System.out.println(delteHead());
		System.out.println(delteHead());
		appendTail(5);
		System.out.println(delteHead());
		System.out.println(delteHead());
	}
}	
