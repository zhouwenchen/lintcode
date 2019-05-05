package com.lintcode.easy;

/**  
 * 173. 链表插入排序
中文English
用插入排序对链表排序

样例
样例 1:
	输入: 0->null
	输出: 0->null

样例 2:
	输入:  1->3->2->0->null
	输出 :0->1->2->3->null

 * @author zhouwenchen@021.com  
 * @date 2019年4月18日 下午7:18:52 
 */
public class InsertionSortList {
	
/*	public static ListNode insertionSortList(ListNode head) {
		ListNode dummy = new ListNode(0);
		while(head != null){
			ListNode node = dummy;
			while(node.next!=null && node.next.val < head.val){
				node = node.next;
			}
			ListNode temp = head.next;
			head.next = node.next;
			node.next = head;
			head = temp;
		}
		return dummy.next;
	}*/
    
	/**
	 * 链表的插入排序
	 * @param head
	 * @return
	 */
	public static ListNode insertionSortList1(ListNode head) {
		if(head ==null || head.next == null){
			return null;
		}
		
		ListNode pre = head; // pre 指向已经有序的节点
		ListNode cur = head.next; // cur 指向待排序的节点
		
		ListNode aux = new ListNode(-1);
		aux.next = head;
		
		while(cur != null){
			if(cur.val < pre.val){
				// 先把cur节点从当前链表删除，然后再讲cur节点插入到合适的位置
				pre.next = cur.next;
				
				// 从前往后找到l2.val > cur.val的值，然后将cur插入到l1和l2之间
				ListNode l1 = aux;
				ListNode l2 = aux.next;
				while(cur.val > l2.val){
					l1 = l2;
					l2 = l2.next;
				}
				
				// 将cur节点插入到l1和l2之间
				l1.next = cur;
				cur.next = l2;
				
				cur = pre.next;
			} else {
				pre = cur;
				cur = cur.next;
			}
			
		}
		return aux.next;
	}
	
	/**
	 * 链表的快速排序
	 * @param head
	 * @return
	 */
	public static ListNode insertionSortList2(ListNode head){
		
		return null;
	}
	
	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		ListNode list3 = new ListNode(3);
		ListNode list2 = new ListNode(2);                                                                                                                                                                                                                                                                                               
		ListNode list0 = new ListNode(0);

		list1.next = list3;
		list3.next = list2;
		list2.next = list0;
		
		ListNode head = insertionSortList1(list1);
		while (head != null) {
			System.out.print(head.val + "\t");
			head = head.next;
		}
	}
}
