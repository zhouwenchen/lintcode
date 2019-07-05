package com.offer.test;

import java.util.Stack;

import com.lintcode.node.ListNode;

/**  
 * 从尾到头打印链表
 * @author zhouwenchen@021.com  
 * @date 2019年6月13日 上午11:39:24 
 */
public class PrintListReserver {
	
	/**
	 * 可以使用递归的方式实现
	 * @param root
	 */
	public static void printListReserver(ListNode root){
		if(root!=null){
			if(root.next !=null){
				printListReserver(root.next);
			}
			System.out.print(root.val+"\t");
		}
	}
	
	/**
	 * 使用栈的实现方式
	 * @param root
	 */
	public static void printListReserver2(ListNode root){
		Stack<Integer> stack = new Stack<>();
		while(root!=null){
			stack.push(root.val);
			root = root.next;
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pop()+"\t");
		}
	}
	
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
//		printListReserver(node1);
		printListReserver2(node1);
	}
}	
