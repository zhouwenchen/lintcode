package com.lintcode.middle;

import com.lintcode.node.ListNode;

/**
 * 102. 带环链表
 * 中文English
 * 给定一个链表，判断它是否有环。
 *
 * 样例
 * ```
 * 样例 1:
 * 	输入: 21->10->4->5,  then tail connects to node index 1(value 10).
 * 	输出: true
 *
 * 样例 2:
 * 	输入: 21->10->4->5->null
 * 	输出: false
 *
 * ```
 * 挑战
 * 不要使用额外的空间
 */
public class HasCycle {
    /**
     * 使用快慢指针实现操作
     * 1.fast先每次执行2.slow 每次执行1.
     * 2.当相遇 的时候 快指针从头开始遍历，并且此时每次执行1.
     * 3.当快慢指针再次相遇的时候，此时表示的就是环的入口
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        // 1.判断是否有环
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 指向3 节点。从而形成一个环
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
        node5.next = node6;

        node6.next = node3;

        boolean b = hasCycle(node1);
        System.out.println("链表是否存在环" + b);
    }
}
