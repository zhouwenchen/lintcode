package com.lintcode.easy;

/**
 * 1609. 链表的中间结点
 *
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 * 样例
 * Example 1:
 *
 * Input: 1->2->3->4->5->null
 * Output: 3->4->5->null
 * Example 2:
 *
 * Input: 1->2->3->4->5->6->null
 * Output: 4->5->6->null
 * 注意事项
 * The number of nodes in the given list will be between 1 and 100.
 */
public class MiddleNode {

    public static ListNode middleNode(ListNode head) {
        ListNode p = head;
        // 1.统计链表的长度
        int len = 0;
        while (p != null){
            len++;
            p = p.next;
        }

        // 2.计算中间节点的位置
        int mid = len / 2 ;
//        mid = len % 2 == 0 ? mid + 1 : mid ;

        // 遍历到位置mid，直接返回该节点就行了
        for(int i = 0; i < mid; i++){
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        node5.next = node6;

        ListNode node = middleNode(node1);
        while(node != null){
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.print("null");
    }
}
