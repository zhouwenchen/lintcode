package com.offer.test;

import java.util.ArrayList;
import java.util.List;

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
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pNext = head.next;  // head为当前节点，pNext 为下一个当前节点的下一个节点。 
		head.next = null; // 反转后的当前节点为下一个节点的后继节点，当前节点也就是链表的尾结点
		ListNode reverseHead = reverseList(pNext); // 递归下一个链表的节点，当做当前节点。
		pNext.next = head;// 下一个节点指向当前节点。也就实现了链表的反转的效果
		return reverseHead;
	}
	
	/**
	 * 使用辅助空间，实现链表的反转,此方式比较浪费空间，而且需要两次遍历，效率不占优势
	 * @param head
	 * @return
	 */
	public static ListNode reverseList1(ListNode head){
		// 1.先遍历链表，将链表中的值添加到数组中，
		if(head == null){
			return null;
		}
		List<ListNode> list = new ArrayList<ListNode>();
		while(head != null){
			list.add(head);
			head = head.next;
		}
		
		// 2.从后向前遍历数组，从而将值包装到链表中
		for(int i = list.size() -1;i >= 0;i--){
			ListNode node = list.get(i);
			if(i==0){
				node.next = null;
			} else {
				node.next = list.get(i-1);
			}
		}
		head = list.get(list.size()-1);
		return head;
	}
	
	/**
	 * 定义三个指针，当前节点的指针，当前节点的上一个指针，当前节点的下一个指针
	 * @param head
	 * @return
	 */
	public static ListNode reverseList2(ListNode head){
		if(head == null){
			return null;
		}
		ListNode reverseHead = null;
		// 当前节点
		ListNode currentNode = head;
		// 当前节点的上一个节点
		ListNode preNode = null;
		while(currentNode != null){
			// 当前节点的下一个节点
			ListNode nextNode = currentNode.next;
			if(nextNode != null){
				reverseHead = nextNode;
			}
			// 将当前节点指向上一个节点
			currentNode.next = preNode;
			// 前一个节点指向当前节点
			preNode = currentNode;
			// 当前节点指向下一个节点
			currentNode = nextNode;
			
		}
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

//		ListNode node = reverseList(node1);
//		ListNode node = reverseList1(node1);
		ListNode node = reverseList2(node1);
		if (node == null) {
			System.out.println(node);
		}
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
}
