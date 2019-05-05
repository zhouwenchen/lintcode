package com.lintcode.easy;

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
public class NthToLast {
	
    public static ListNode nthToLast(ListNode head, int n) {
    	if(head == null || n < 1){
    		return null;	
    	}
    	
    	ListNode pre = head;
    	ListNode sub = head;
    	for(int i = 0; i < n-1; ++i){
			if (sub == null) {
				return null;
			}
    		sub = sub.next;
    	}
    	while(sub.next != null){
    		pre = pre.next;
    		sub = sub.next;
    	}
    	return pre.next;
    }
    
    public static void main(String[] args) {
    	ListNode list3 = new ListNode(3);
    	ListNode list2 = new ListNode(2);
    	ListNode list1 = new ListNode(1);
    	ListNode list5 = new ListNode(5);
    	
    	list3.next = list2;
    	list2.next = list1;
    	list1.next = list5;
    	
		ListNode listNode = nthToLast(list3, 2);
		System.out.print(listNode.val + "\t");
		
	}
}
