package com.lintcode.easy;

/**  
 * 
 * 174. 删除链表中倒数第n个节点
给定一个链表，删除链表中倒数第n个节点，返回链表的头节点。

样例
Example 1:
	Input: list = 1->2->3->4->5->null， n = 2
	Output: 1->2->3->5->null


Example 2:
	Input:  list = 5->4->3->2->1->null, n = 2
	Output: 5->4->3->1->null

挑战
O(n)时间复杂度

注意事项
链表中的节点个数大于等于n
 * @author zhouwenchen@021.com  
 * @date 2019年4月17日 下午3:24:31 
 */
public class RemoveNthFromEnd {
	
    public static ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode p = head;
    	ListNode q = head;
    	
    	for(int i = 0;i < n;i++){
    		p = p.next;
    	}
    	
    	if(p == null){
    		head = head.next;
    		return head;
    	}
    	while(p.next != null){
    		p = p.next;
    		q = q.next;
    	}
    	q.next = q.next.next;
    	
        return head;
    }
    
    public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		ListNode list2 = new ListNode(2);
		ListNode list3 = new ListNode(3);
		ListNode list4 = new ListNode(4);
		ListNode list5 = new ListNode(5);
		
		list1.next = list2;
		list2.next = list3;
		list3.next = list4;
		list4.next = list5;
		
		ListNode node = removeNthFromEnd(list1, 2);
		while(node != null){
			System.out.print(node.val+" ");
			node = node.next;
		}
	
	}
}
