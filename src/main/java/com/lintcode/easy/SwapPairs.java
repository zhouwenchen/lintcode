package com.lintcode.easy;

/**
 * 451. 两两交换链表中的节点
 * 中文English
 * 给一个链表，两两交换其中的节点，然后返回交换后的链表。
 *
 * 样例
 * 样例 1：
 *
 * 输入：1->2->3->4->null
 * 输出：2->1->4->3->null
 * 样例 2：
 *
 * 输入：5->null
 * 输出：5->null
 * 挑战
 * 你的算法只能使用常数的额外空间，并且不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class SwapPairs {

    public static ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(-1);
        temp.next = head;
        head = temp;
        while (head.next != null && head.next.next != null){
            ListNode n1 = head.next;
            ListNode n2 = head.next.next;

            head.next = n2;
            n1.next = n2.next;
            n2.next = n1;

            head = n1;
        }

        return temp.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node = swapPairs(node1);
        while(node != null){
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.print("null");
    }
}
