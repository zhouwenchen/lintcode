package com.lintcode.easy;

/**  
 * 170. 旋转链表
给定一个链表，旋转链表，使得每个节点向右移动k个位置，其中k是一个非负数

样例
样例 1:

输入：1->2->3->4->5  k = 2
输出：4->5->1->2->3
样例 2:

输入：3->2->1  k = 1
输出：1->3->2

这道旋转链表的题和之前那道 Rotate Array 旋转数组 很类似，但是比那道要难一些，因为链表的值不能通过下标来访问，只能一个一个的走，
我们可能首先想到的就是用快慢指针来解，快指针先走k步，然后两个指针一起走，当快指针走到末尾时，慢指针的下一个位置是新的顺序的头结点，这样就可以旋转链表了，自信满满地写完程序，放到OJ上跑，以为能一次通过，
结果就跪在了各种特殊情况，首先一个就是当原链表为空时，直接返回NULL，还有就是当k大于链表长度和k远远大于链表长度时该如何处理，我们需要首先遍历一遍原链表得到链表长度n，然后k对n取余，这样k肯定小于n，就可以用上面的算法了。

 * @author zhouwenchen@021.com  
 * @date 2019年4月18日 下午8:43:38 
 */
public class RotateRight {
    public static ListNode rotateRight(ListNode head, int k) {
    	if(head == null || k == 0){
    		return head;
    	}
    	// 1.先遍历获取到长度。
    	int m = 0;
    	ListNode temp = head;
    	while(temp != null){
    		m++;
    		temp = temp.next;
    	}
    	
    	// 获取到 m%k的
    	int n = k%m;
    	if(n==0){
    		return head;
    	}
    	ListNode p = head,q = head;
    	for(int i = 0; i < n; i++){
    		p = p.next;
    	}
    	while(p.next!=null){
    		p = p.next;
    		q = q.next;
    	}
    	
    	// p 到达了链表节点的结尾
    	ListNode temp2 = head;
    	head = q.next;
    	q.next = null;
    	p.next = temp2;
    	
    	return head;
    }
    
    public static void main(String[] args) {

//		ListNode list1 = new ListNode(1);
//		ListNode list2 = new ListNode(2);                                                                                                                                                                                                                                                                                               
//		ListNode list3 = new ListNode(3);
//		ListNode list4 = new ListNode(4);
//		ListNode list5 = new ListNode(5);
//
//		list1.next = list2;
//		list2.next = list3;
//		list3.next = list4;
//		list4.next = list5;
    	
    	ListNode list1 = new ListNode(1);
		
		ListNode head = rotateRight(list1,1);
		while (head != null) {
			System.out.print(head.val + "\t");
			head = head.next;
		}
	
	}
}
