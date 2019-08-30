package com.lintcode.easy;

import com.lintcode.node.ListNode;

/**  
 * 166. 链表倒数第n个节点
找到单链表倒数第n个节点，保证链表中节点的最少数量为n。

样例
Example 1:
	Input: list = 3->2->1->5->null, n = 2
	Output: 1


Example 2:
	Input: list  = 1->2->3->null, n = 3
	Output: 1

 * @author zhouwenchen@021.com  
 * @date 2019年4月29日 下午7:51:04 
 */
public class FindKthToTail1 {
	
	/**
	 * 遍历两次实现查找倒数第k个位置的节点的值
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public static ListNode FindKthToTail1(ListNode head, int k) {
		int len = 0;
		ListNode pre = head;
		while (pre != null) {
			len++;
			pre = pre.next;
		}

		// 如果len == k的话，直接返回头结点
		if (len == k) {
			return head;
		} else if (len < k) {
			return null;
		}
		// 倒数第k个节点，也就是正数第n - k + 1 = 4 -k + 1
		ListNode sub = head;
		for (int i = 0; i < (len - k + 1) - 1; i++) {
			sub = sub.next;
		}

		return sub;
	}
	
	/**
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public static ListNode FindKthToTail(ListNode head, int k) {
		if (head == null || k == 0) {
			return null;
		}

		ListNode ahead = head;
		ListNode behind = null;

		for (int i = 0; i < k - 1; i++) {
			if (ahead.next != null) {
				ahead = ahead.next;
			} else {
				return null;
			}
		}
		behind = head;
		while (ahead.next != null) {
			ahead = ahead.next;
			behind = behind.next;
		}

		return behind;
	}
    
    public static void main(String[] args) {
    	
    	ListNode list1 = new ListNode(1);
    	ListNode list2 = new ListNode(2);
    	ListNode list3 = new ListNode(3);
    	ListNode list4 = new ListNode(4);
    	
    	list1.next = list2;
    	list2.next = list3;
    	list3.next = list4;
    	
//		ListNode listNode = FindKthToTail(list1, 5);
		ListNode listNode = FindKthToTail1(list1, 5);
		if(listNode != null){
			System.out.print(listNode.val + "\t");
		}else {
			System.out.println(listNode);
		}
	}
}
