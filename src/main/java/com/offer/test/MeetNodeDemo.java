package com.offer.test;

import com.lintcode.node.ListNode;

/**  
 * 链表中环的入口节点
 * 思路：
 * 1.判断是否有环（如果链表中有cur.next == null ,说明没有环）
 * 2.环的长度（链表中的）
 * 3.环的入口节点
 * @author zhouwenchen@021.com  
 * @date 2019年6月19日 上午10:28:10 
 */
public class MeetNodeDemo {
	
	/**
	 * @param head
	 * @return
	 */
	public static ListNode meetNode(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		ListNode fast = head.next.next;
		ListNode slow = head.next;

		while (fast != slow) {
			if (fast.next != null && fast.next.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			} else {
				return null;
			}
		}

		fast = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
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
		node6.next = node3;
		
		ListNode node = meetNode(node1);
		System.out.println(node.val);
	}
}
