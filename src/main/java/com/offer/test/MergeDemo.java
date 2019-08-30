package com.offer.test;

import com.lintcode.node.ListNode;

/**  
 * 合并两个排序好的链表
 * 
 * node1: 1->3->5->7;
 * node2: 2->4->6->8->9->10->11;
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年6月19日 下午2:56:33 
 */
public class MergeDemo {

	/**
	 * 使用递归的方式实现的
	 * @param node1
	 * @param node2
	 * @return
	 */
	public static ListNode merge(ListNode node1, ListNode node2) {
		// 1.如果有一个链表为空的话，那么直接返回另一个链表的首节点
		if (node1 == null && node2 == null) {
			return null;
		}
		if (node1 == null) {
			return node2;
		}
		if (node2 == null) {
			return node1;
		}
		
		// 指向node1和node2的首节点的值
		ListNode node = null;
		if (node1.val > node2.val){
			node = node2;
			node.next = merge(node1, node2.next);
		}else {
			node = node1;
			node.next = merge(node.next,node2);
		}
		
		return node;
	}

	/**
	 * 使用递归的方式实现的
	 * @param node1
	 * @param node2
	 * @return
	 */
	public static ListNode merge2(ListNode node1, ListNode node2) {
		// 1.如果有一个链表为空的话，那么直接返回另一个链表的首节点
		if (node1 == null && node2 == null) {
			return null;
		}
		if (node1 == null) {
			return node2;
		}
		if (node2 == null) {
			return node1;
		}
		
		// 指向node1和node2的首节点的值
		ListNode node = new ListNode(-1);
		ListNode head = node;
		while(node1 != null && node2 != null){
			if(node1.val < node2.val){
				head.next = node1;
				node1 = node1.next;
			} else {
				head.next = node2;
				node2 = node2.next;
			}
			head = head.next;
		}
		if (node1 == null) {
			head.next = node2;
		}
		if (node2 == null) {
			head.next = node1;
		}
		return node.next;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		ListNode node9 = new ListNode(9);
		ListNode node10 = new ListNode(10);
		ListNode node11 = new ListNode(11);

		node1.next = node3;
		node3.next = node5;
		node5.next = node7;

		node2.next = node4;
		node4.next = node6;
		node6.next = node8;
		node8.next = node9;
		node9.next = node10;
		node10.next = node11;
//		ListNode head = merge(node1, node2);
		ListNode head = merge2(node1, node2);
		if (head == null) {
			System.out.println(head);
		}
		while (head != null) {
			System.out.print(head.val + "\t");
			head = head.next;
		}

	}
}
