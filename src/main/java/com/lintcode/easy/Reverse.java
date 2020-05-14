package com.lintcode.easy;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * 35. 翻转链表
翻转一个链表

样例
样例1:
对于链表 1->2->3, 翻转链表为 3->2->1
样例2:
对于链表 1->2->3->4, 翻转链表为 4->3->2->1

挑战
在原地一次翻转完成
 Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年3月27日上午11:43:56   
 */
public class Reverse {
	
	public static ListNode reverse(ListNode head) {
		if(head == null){
			return null;
		}

		ListNode first = head;
		//建立一个新的节点用来存放结果
		ListNode reverseHead = null;
		while (first != null) {
			// 头结点的下一个节点设置为null
 			ListNode second = first.next;
			first.next = reverseHead;
			reverseHead = first;
			first = second;
		}
		return reverseHead;
	}

	/**
	 * 递归实现
	 * @param head
	 * @return
	 */
	public static ListNode reverseList(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode second = head.next;
		ListNode reverseHead = reverseList(second);
		second.next = head;
		
		head.next = null;
		return reverseHead;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		
		node1.next = node2;
		node2.next = node3;
		
//		ListNode head = reverse(node1);
		ListNode head = reverseList(node1);
		
		while(head!= null){
			if(head.next == null){
				System.out.print(head.val+"->null");
			} else {
				System.out.print(head.val+"->");
			}
			head = head.next;
		}
	}
}

/**  
 * 定义节点
 */
class ListNode {
	int val;
	ListNode next;

	public ListNode(int x) {
		this.val = x;
		this.next = null;
	}
}