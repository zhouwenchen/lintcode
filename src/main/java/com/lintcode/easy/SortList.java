package com.lintcode.easy;

/**  
 * 
 * 98. 链表排序
在 O(n log n) 时间复杂度和常数级的空间复杂度下给链表排序。

样例
样例 1:
	输入:  1->3->2->null
	输出:  1->2->3->null

样例 2:
	输入: 1->7->2->6->null
	输出: 1->2->6->7->null
	
挑战
分别用归并排序和快速排序做一遍。
 * @author zhouwenchen@021.com  
 * @date 2019年4月19日 上午11:46:17 
 */
public class SortList {
	
    /** 链表的插入排序
     * @param head
     * @return
     */
	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode pre = head;// pre指向已经排序的节点
		ListNode cur = head.next; // cur 指向待排序的节点

		ListNode aux = new ListNode(-1);// 辅助节点
		aux.next = head;

		while (cur != null) {
			if (cur.val < pre.val) {
				// 先把cur节点删除
				pre.next = cur.next;

				// 从前往后找到l2.va > cur.val ，然后把cur 节点插入到 l1和l2之间
				ListNode l1 = aux;
				ListNode l2 = aux.next;

				// 如果cur.val 大于 l2.则 l1,l2顺势往后
				while (cur.val > l2.val) {
					l1 = l2;
					l2 = l2.next;
				}

				// 此时cur.val < l2.val 的值
				l1.next = cur;
				cur.next = l2;

				cur = pre.next; // cur 指向下一个待排序的节点
			} else {
				pre = cur;
				cur = cur.next;
			}
		}
		return aux.next;
	}
	
	
	/**
	 * 归并排序
	 * @param head
	 * @return
	 */
	public static ListNode mergeSort(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode mid = getMid(head);// 获取链表的中间节点
		
		// 把链表从中间拆分成两个链表，head 和second 链表
		ListNode second = mid.next;
		mid.next = null;
		
		// 对这两个子链表进行排序
		ListNode left = mergeSort(head);
		ListNode right = mergeSort(second);
		
		// 合并连个子链表
		ListNode merge = merge(left,right);
		
		return merge;
	}
	
	/**
	 * 合并两个节点
	 * @param left
	 * @param right
	 * @return
	 */
	private static ListNode merge(ListNode left, ListNode right) {
		// 辅助节点，排好序的节点将会连接到dummy后面
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy; // tail 指向最后一个排好序的节点
		while(left !=null && right !=null){
			if(left.val < right.val){
				tail.next = left;
				left = left.next;
			}else{
				tail.next = right;
				right = right.next;
			}
			tail = tail.next;
		}
		
		if(left!=null){
			tail.next = left;
		}else{
			tail.next  = right;
		}
		return dummy.next;
	}


	/**
	 * 获取链表的中间节点
	 * @param head
	 * @return
	 */
    private static ListNode getMid(ListNode head) {
    	if(head == null || head.next == null){
    		return head;
    	}
    	ListNode slow = head;
    	ListNode faster = head.next;
    	while(faster != null && faster.next !=null){
    		slow = slow.next;
    		faster = faster.next.next;
    	}
		return slow;
	}


	public static void main(String[] args) {
    	ListNode list1 = new ListNode(1);
    	ListNode list3 = new ListNode(3);
    	ListNode list2 = new ListNode(2);
    	
    	list1.next = list3;
    	list3.next = list2;
    	
//		ListNode head = sortList(list1);
		ListNode head = mergeSort(list1);
		while (head != null) {
			System.out.print(head.val + "\t");
			head = head.next;
		}
	}
}
