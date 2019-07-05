package com.offer.test;

import com.lintcode.node.ListNode;

/**  
 * 反转链表
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年6月19日 下午2:06:32 
 */
public class ReverseList {
	
	/**
	 * 使用递归的方式实现
	 * @param head
	 * @return
	 */
	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pNext = head.next;
		head.next = null;
		ListNode reverseHead = reverseList(pNext);
		pNext.next = head;
		return reverseHead;
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

		ListNode node = reverseList(node1);
		if (node == null) {
			System.out.println(node);
		}
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
}
