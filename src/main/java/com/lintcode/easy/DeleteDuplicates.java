package com.lintcode.easy;

/**  
 * 112. 删除排序链表中的重复元素
给定一个排序链表，删除所有重复的元素每个元素只留下一个。

样例
样例 1:
	输入:  null
	输出:  null

样例 2:
	输入: 1->1->2->null
	输出: 1->2->null

样例 3:
	输入: 1->1->2->3->3->null
	输出: 1->2->3->null

 * @author zhouwenchen@021.com
 * @date 2019年4月17日 下午8:07:37
 */
public class DeleteDuplicates {
	
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode cur = head;
		while(cur.next != null){
			if(cur.val == cur.next.val){
				cur.next = cur.next.next;
			}else{
				cur = cur.next;
			}
		}
		
		return head;
	}
    
    public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		ListNode list11 = new ListNode(1);
		ListNode list2 = new ListNode(2);
		ListNode list3 = new ListNode(3);
		ListNode list33 = new ListNode(3);
		
		list1.next = list11;
		list11.next = list2;
		list2.next = list3;
		list3.next = list33;
		
		ListNode node = deleteDuplicates(list1);
		while(node != null){
			System.out.print(node.val+" ");
			node = node.next;
		}
	
	}
}
