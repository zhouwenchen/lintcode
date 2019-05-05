package com.lintcode.easy;

/**  
 * 96. 链表划分
给定一个单链表和数值x，划分链表使得所有小于x的节点排在大于等于x的节点之前。

你应该保留两部分内链表节点原有的相对顺序。

样例
样例  1:
	输入: list = null, x = 0
	输出: null
	
	样例解释:
	空链表本身满足要求

样例 2:
	输入: list = 1->4->3->2->5->2->null, x = 3
	输出: 1->2->2->4->3->5->null
	
	样例解释: 
	要保持原有的相对顺序。

 * @author zhouwenchen@021.com  
 * @date 2019年3月27日上午11:43:56   
 */
public class Partition {
	
	public static ListNode partition(ListNode head, int x) {
		if (head == null) {
			return null;
		}
		ListNode leftDummy = new ListNode(0);
		ListNode rightDummy = new ListNode(0);
		ListNode left = leftDummy;
		ListNode right = rightDummy;
		while (head != null) {
			if (head.val < x) {
				left.next = head;
				left = head;
			} else {
				right.next = head;
				right = head;
			}
			head = head.next;
		}

		right.next = null;
		left.next = rightDummy.next;
		return leftDummy.next;
	}
	
	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		ListNode list2 = new ListNode(2);
		ListNode list21 = new ListNode(2);
		ListNode list3 = new ListNode(3);
		ListNode list4 = new ListNode(4);
		ListNode list5 = new ListNode(5);
		
		list1.next = list4;
		list4.next = list3;
		list3.next = list2;
		list2.next = list5;
		list5.next = list21;
		
		ListNode node = partition(list1, 3);
		while(node != null){
			System.out.print(node.val+" ");
			node = node.next;
		}
	}
	
}