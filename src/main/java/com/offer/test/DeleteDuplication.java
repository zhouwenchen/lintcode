package com.offer.test;

import com.lintcode.node.ListNode;

/**  
 * 删除链表中重复的节点
 * 1.如果链表为空，或者只有一个结点，直接返回
 * 2.如果链表结点大于等于2，则比较当前结点和下一个结点是否相同，如果相同，则删除当前结点和下一个结点，比较下下个结点是否和当前结点相同，如果相同继续删除，直至与当前结点不同\
 * 3.返回链表表头是第一个不重复结点，需要一个前驱结点prenode记录不重复链表，其next应该初始为NULL，如果有下一个不重复结点，则next是下一个不重复结点。
 * 
 * 链表形如如下的方式：1->2->3->3->4->4->5 
 * @author zhouwenchen@021.com  
 * @date 2019年6月18日 下午5:30:40 
 */
public class DeleteDuplication {
	
	/**
	 * 思路：
	 * 
	 * @param head
	 */
	public static ListNode deleteDuplication(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode root = new ListNode(0);
		root.next = head;
		ListNode pre = root;
		ListNode cur = head;
		while (cur != null) {
			if (cur.next != null && cur.val == cur.next.val) {
				while (cur.next != null && cur.val == cur.next.val) {
					cur = cur.next;
				}
				pre.next = cur.next;
			} else {
				pre = cur;
			}
			cur = cur.next;
		}

		return root.next;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node33 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node44 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node33;
		node33.next = node4;
		node4.next = node44;
		node44.next = node5;

		ListNode root = deleteDuplication(node1);
		if (root == null) {
			System.out.println(root);
		} else {
			while (root != null) {
				System.out.println(root.val);
				root = root.next;
			}
		}
	}
}
