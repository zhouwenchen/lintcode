package com.offer.test;

import java.util.Stack;

/**  
 * 包含min函数的栈
 * @author zhouwenchen@021.com  
 * @date 2019年6月20日 上午10:39:53 
 */
public class StackWithMin {

	private static Stack<Integer> data = new Stack<Integer>();
	private static Stack<Integer> min = new Stack<Integer>();

	/**
	 * 入栈操作
	 */
	public static void stackWithMinPush(int value) {
		data.push(value);
		if (min.size() == 0 || value < min.peek()) {
			min.push(value);
		} else {
			min.push(min.peek());
		}
	}

	/**
	 * 出栈操作
	 * @param value
	 */
	public static void stackWithMinPop() {
		if (data.size() > 0 && min.size() > 0) {
			data.pop();
			min.pop();
		}
	}

	/**
	 * data栈的栈顶元素
	 * @return
	 */
	public static int stackWithDataTop() {
		if (data.size() > 0) {
			return data.peek();
		}
		return 0;
	}

	/**
	 * min栈的栈顶元素，栈顶元素为data栈中现有元素的最小元素
	 */
	public static int stackWithMinMin() {
		if (data.size() > 0 && min.size() > 0) {
			return min.peek();
		}
		return 0;
	}

	public static void main(String[] args) {
		stackWithMinPush(3);
		System.out.println("入栈中值是：3");
		System.out.println("栈中此时最小值是：" + stackWithMinMin());
		stackWithMinPush(4);
		System.out.println("入栈中值是：4");
		System.out.println("栈中此时最小值是：" + stackWithMinMin());
		stackWithMinPush(2);
		System.out.println("入栈中值是：2");
		System.out.println("栈中此时最小值是：" + stackWithMinMin());
		stackWithMinPush(1);
		System.out.println("入栈中值是：1");
		System.out.println("栈中此时最小值是：" + stackWithMinMin());
		
		System.out.println("此时开始出栈操作");
		stackWithMinPop();
		System.out.println("栈中此时最小值是：" + stackWithMinMin());
		stackWithMinPop();
		System.out.println("栈中此时最小值是：" + stackWithMinMin());
		stackWithMinPop();
		System.out.println("栈中此时最小值是：" + stackWithMinMin());
		stackWithMinPop();
		System.out.println("栈中此时最小值是：" + stackWithMinMin());
		
	}
}
