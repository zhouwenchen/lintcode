package com.lintcode.easy;

/**  
 * 
 * 167. 链表求和
你有两个用链表代表的整数，其中每个节点包含一个数字。数字存储按照在原来整数中相反的顺序，使得第一个数字位于链表的开头。写出一个函数将两个整数相加，用链表形式返回和。

样例
样例 1:
	输入: 7->1->6->null, 5->9->2->null
	输出: 2->1->9->null
	
	样例解释:
	617 + 295 = 912
	912 转换成链表:  2->1->9->null


样例 2:
	输入:  3->1->5->null, 5->9->2->null
	输出: 8->0->8->null
	
	样例解释: 
	513 + 295 = 808
	808 转换成链表: 8->0->8->null

 * @author zhouwenchen@021.com  
 * @date 2019年4月17日 下午8:31:14 
 */
public class AddLists {
	public static ListNode addLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode l3 = null;
		ListNode head = new ListNode(0);
		int shi = 0;
		while (l1 != null && l2 != null) {
			ListNode cur = new ListNode(0);
			cur.val = l1.val + l2.val + shi;
			if (cur.val >= 10) {
				shi = cur.val / 10;
				int ge = cur.val % 10;
				cur.val = ge;
			}
			l1 = l1.next;
			l2 = l2.next;
			if (l3 == null) {
				l3 = new ListNode(0);
				l3 = cur;
				head = l3;
			} else {
				l3.next = cur;
				l3 = l3.next;
			}
		}
		ListNode temp = new ListNode(0);
		if(l2!=null && l1 ==null){
			temp = l2;
			l2 = l1;
			l1 = temp;
		}
		while(l2==null && l1 != null){
			ListNode cur = new ListNode(0);
			cur.val = l1.val + shi;
			if (cur.val >= 10) {
				shi = cur.val / 10;
				int ge = cur.val % 10;
				cur.val = ge; 
			}
			l3.next = cur;
			l1 = l1.next;
			l3 = l3.next;
			if(shi > 0 && l1 ==null){
				cur = new ListNode(shi);
				l3.next = cur;
			}
		}
		return head;
	}
	
	
	public static ListNode addLists1(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;

		int carry = 0;
		for (ListNode i = l1, j = l2; i != null || j != null;) {
			int sum = carry;
			sum += (i != null) ? i.val : 0;
			sum += (j != null) ? j.val : 0;

			tail.next = new ListNode(sum % 10);
			tail = tail.next;

			carry = sum / 10;
			i = (i == null) ? i : i.next;
			j = (j == null) ? j : j.next;
		}
		if (carry != 0) {
			tail.next = new ListNode(carry);
		}
		return dummy.next;
	}
	
    public static void main(String[] args) {
    	ListNode list7 = new ListNode(7);
		ListNode list1 = new ListNode(1);
		ListNode list6 = new ListNode(6);
		
		ListNode list5 = new ListNode(5);
		ListNode list9 = new ListNode(9);
		ListNode list2 = new ListNode(2);
		
		list7.next = list1;
		list1.next = list6;
		
		list5.next = list9;
		list9.next = list2;
		ListNode head = addLists1(list7, list5);
    	
//    	ListNode list9 = new ListNode(9);
//    	ListNode list99 = new ListNode(9);
//    	
//    	ListNode list29 = new ListNode(9);
//    	
//    	list9.next = list99;
//    	
//    	
//    	ListNode head = addLists1(list29, list9);

		while(head != null){
			System.out.print(head.val+" ");
			head = head.next;
		}
	}
}
