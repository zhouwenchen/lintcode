package com.offer.test;

import com.lintcode.node.ListNode;

/**  
 * 输入两个链表，找出它们的第一个公共结点
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年7月16日 下午5:40:16 
 */
public class FindFirstCommonNode {
	
	/**
	 * 思路，（1）遍历两个链表，获取到两个链表的长度，
	 * 	         （2） 长的链表先遍历n个3位置，然后两个链表同时遍历，知道遍历的节点相同为止
	 * @param node1
	 * @param node2
	 * @return
	 */
	public static ListNode findFirstCommonNode(ListNode node1,ListNode node2) {
		if(node1== null || node2 == null){
			return null;
		}
		// 遍历两个链表，获取到两个链表的长度
		int len1 = 0;
		int len2 = 0;
		ListNode temp1 = node1;
		ListNode temp2 = node2;
		while(temp1 != null){
			len1++;
			temp1 = temp1.next;
		}
		while (temp2 != null) {
			len2++;
			temp2 = temp2.next;
		}

		int len = len1 > len2 ? len1 - len2 : len2 - len1;
		
		if(len1 == len2){
			return node1;
		} else if(len1 > len2){
			for(int i = 0; i < len; i++){
				node1 = node1.next;
			}
			while(node1.next != null && node2.next != null &&  node1!= node2){
				node1 = node1.next;
				node2 = node2.next;
			}
		} else {
			for(int i = 0; i < len; i++){
				node2 = node2.next;
			}
			while(node1.next != null && node2.next != null &&  node1 != node2){
				node1 = node1.next;
				node2 = node2.next;
			}
		}
		
		if(node1==node2){
			return node1;
		}
		return null;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node6;
		
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		
		ListNode node = findFirstCommonNode(node1,node4);
		if(node != null){
			System.out.println(node.val);
		} else {
			System.out.println(node);
		}
	}
}
