package com.lintcode.difficult;

import com.lintcode.node.ListNode;

/**
 *450. K组翻转链表
 * 中文English
 * 给你一个链表以及一个k,将这个链表从头指针开始每k个翻转一下。
 * 链表元素个数不是k的倍数，最后剩余的不用翻转。
 *
 * 样例
 * Example 1
 *
 * Input:
 * list = 1->2->3->4->5->null
 * k = 2
 * Output:
 * 2->1->4->3->5
 * Example 2
 *
 * Input:
 * list = 1->2->3->4->5->null
 * k = 3
 * Output:
 * 3->2->1->4->5
 *
 *
 */
public class ReverseKGroup {

    /**
     * k组链表的翻转实现
     * 1.先统计链表的长度
     * 2.判断需要翻转的链表
     *
     * @param head 头节点
     * @param k 翻转链表的长度
     * @return 翻转后链表额头节点
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        // 统计链表的长度
        if(head == null){
            return head;
        }
        int len = 0;
        ListNode p1 = head;
        while (p1 != null){
            len++;
            p1 = p1.next;
        }

        // 如果k> len,那么直接返回原链表 head
        int count = len / k;
        // 翻转链表的节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head;
        ListNode sencode = null;
        int m = 0;
        ListNode OneHead = null;
        ListNode TwoHead = null;

        while (m < count){

            ListNode reverNode = null;
            if(OneHead == null && TwoHead == null){
                OneHead = head;
            }else if(OneHead != null && TwoHead == null){
                TwoHead = sencode;
            } else{
                OneHead = TwoHead;
                TwoHead = sencode;
            }

            // 指定节点的链表的翻转
            for(int i = 0; i < k;i++){
                sencode = first.next;
                first.next = reverNode;
                reverNode = first;
                first = sencode;
            }

            if(m == 0){ // 表示的是第一次，需要 dummy.next = reverNode
               dummy.next = reverNode;
            }else if(m > 0 & OneHead != null ){
                OneHead.next = reverNode;
            }
            m++;
        }
        if(TwoHead != null ){
            TwoHead.next = sencode;
        } else if(OneHead != null){
            OneHead.next = sencode;
        }
        return dummy.next;
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
        node4.next = node5;

        ListNode result = reverseKGroup(node1, 2);
        while(result != null){
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.print("null");
    }
}
