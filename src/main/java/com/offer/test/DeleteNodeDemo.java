package com.offer.test;

import com.lintcode.node.ListNode;

/**  
 * 删除链表中的某一个节点，时间复杂度为 O(1)
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年6月18日 下午3:12:28 
 */
public class DeleteNodeDemo {
	
	/**
	 * 遍历链表，如果删除指定的节点，并将删除节点的上一个节点的指针指向删除节点的下一个节点，从而实现删除链表节点
	 * 但是这种遍历链表删除数据的方式，时间复杂度为O(n),
	 * @param head
	 * @param node
	 */
	public static void delteNode1(ListNode head, ListNode node) {
		// 1.参数的合法性检查
		if (head == null || node == null) {
			return;
		}
		
		// 2.如果删除的是头结点
		if(head == node){
			ListNode pNext = node.next;
			node.val = pNext.val;
			node.next = pNext.next;
			return;
		}
		// 2.删除不是头结点的
		for(ListNode pNode = head;pNode.next != null ; pNode = pNode.next){
			if(pNode.next == node){
				pNode.next = node.next;
				return;
			}
		}
	}
	
	
	/**
	 * 删除某一个节点，将删除节点的下一个节点，复制到删除节点的位置，然后删除下一个节点，也就相当于删除了当前的节点的链表数据
	 * 时间复杂度 O(1)
	 * 
	 * 1.删除的节点不在链表的尾部
	 * 2.链表只要一个头结点
	 * 3.删除尾部的节点
	 * 
	 * @param head
	 * @param node
	 */
	public static void deleteNode2(ListNode head, ListNode node) {
		if(head == null || node == null){
			return;
		}
		// 1.删除的节点不在链表的尾部
		if(node.next != null){
			ListNode pNext = node.next;
			node.val = pNext.val;
			node.next = pNext.next;
		}else if(head == node){
			// 2.链表只要一个头结点
			head = null;
			node = null;
		} else {
			// 3.删除尾部的节点
			ListNode pNode = head;
			while(pNode.next != node){
				pNode = pNode.next;
			}
			pNode.next = null;
		} 
		
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

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;

		// 删除某一个节点
//		 delteNode1(node1, node7);
		
		// 删除头结点
//		delteNode1(node1, node1);
		
		// 删除尾结点
//		delteNode1(node1, node8);
		
//		deleteNode2(node1, node8);
		
		// 删除链表中间的某一个节点
//		deleteNode2(node1, node7);
		
		// 删除链表的头部节点
		deleteNode2(node1, node1);
		
		
		 
		while(node1 != null){
			System.out.print(node1.val + "\t");
			node1 = node1.next;
		}
	}
}
