package com.lintcode.easy;

/**
 *166. 链表倒数第n个节点
 * 找到单链表倒数第n个节点，保证链表中节点的最少数量为n。
 *
 * 样例
 * Example 1:
 * 	Input: list = 3->2->1->5->null, n = 2
 * 	Output: 1
 *
 *
 * Example 2:
 * 	Input: list  = 1->2->3->null, n = 3
 * 	Output: 1
 */
public class NthToLast {
    public static void main(String[] args) {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        ListNode node5 = new ListNode(5);
        node3.next = node2;
        node2.next = node1;
        node1.next = node5;

        ListNode resultNode = nthToLast(node3, 2);
        System.out.println("链表倒数第n个节点的值是："+resultNode.val);
    }

    public static ListNode nthToLast(ListNode head, int n) {
        if(head == null){
            return  null;
        }
        // 1.链表p1 和 p2 指向头结点
        ListNode p1 = head;
        ListNode p2 = head;

        // p2 节点先于p1 节点先行 n 个节点的位置
        for(int i = 0; i < n; i++){
            p2 = p2.next;
        }
        // p1 和 p2 一起遍历，直到 p2 到达链表的末尾，此时p1的位置，就是 链表倒数第 n 的位置
        while(p2 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
