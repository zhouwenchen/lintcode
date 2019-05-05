package com.lintcode.easy;

/**  
 * 165. 合并两个排序链表
将两个排序链表合并为一个新的排序链表

样例
样例 1:
	输入: list1 = null, list2 = 0->3->3->null
	输出: 0->3->3->null


样例2:
	输入:  list1 =  1->3->8->11->15->null, list2 = 2->null
	输出: 1->2->3->8->11->15->null

 * @author zhouwenchen@021.com  
 * @date 2019年4月18日 下午3:39:37 
 */
public class MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if(l1 == null) return l2;
    	if(l2 == null) return l1;
    	
    	ListNode tail = new ListNode(0);
    	ListNode temp = tail;
    	ListNode i,j;
		for (i = l1, j = l2; i != null && j != null;) {
			if(i.val < j.val){
				temp.next = i;
				i = i.next;
			} else {
				temp.next = j;
				j = j.next;
			}
			temp = temp.next;
		}
		temp.next = i == null ? j : j==null?i:null;
		
    	return tail.next;
    }
    
	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		ListNode list3 = new ListNode(3);
		ListNode list8 = new ListNode(8);
		ListNode list11 = new ListNode(11);
		ListNode list15 = new ListNode(15);
		
		ListNode list2 = new ListNode(2);
		
		list1.next = list3;
		list3.next = list8;
		list8.next = list11;
		list11.next = list15;

		ListNode head = mergeTwoLists(list1, list2);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
}
