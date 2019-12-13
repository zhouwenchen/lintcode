package com.lintcode.easy;

/**
 * 36. 翻转链表 II
 * 中文English
 * 翻转链表中第m个节点到第n个节点的部分
 *
 * 样例
 * 例1:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 输出: 1->4->3->2->5->NULL.
 * 例2:
 *
 * 输入: 1->2->3->4->NULL, m = 2 and n = 3,
 * 输出: 1->3->2->4->NULL.
 * 挑战
 * Reverse it in-place and in one-pass
 *
 * 注意事项
 * m，n满足1 ≤ m ≤ n ≤ 链表长度
 *
 */
public class ReverseBetween {

    /**
     * 根据 “翻转链表 Reverse ”的思路
     * 1.链表从m处开始翻转
     * 2.链表翻转到 n 处结束
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode first = head;
        ListNode sencode = null;
        ListNode pre = new ListNode(-1);
        ListNode temp = pre;
        pre.next = head;
        for(int i = 0; i < m - 1; i++){
            first = first.next;
            pre = pre.next;
        }
        ListNode reverseHead = null; // 用来存放中间的结果数据的
        // first 此时表示的是最后连接的节点
        ListNode lastNode = first;
        for(int i = 0; i < n - m + 1; i++){
            sencode = first.next;
            first.next = reverseHead;
            reverseHead = first;
            first = sencode;
        }
        pre.next = reverseHead;
        // 翻转后的链表的尾部，如何正确到连接到剩余未翻转的链表
        lastNode.next = sencode;
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;

//        ListNode reverseNode = reverseBetween(node1,2,4);
        ListNode reverseNode = reverseBetween(node1,2,3);
        while(reverseNode != null){
            System.out.print(reverseNode.val + " -> ");
            reverseNode = reverseNode.next;
        }
        System.out.print("null");
    }
}