package com.lintcode.difficult;

import com.lintcode.node.ListNode;

/**
 * 103. 带环链表 II
 * 中文English
 * 给定一个链表，如果链表中存在环，则返回到链表中环的起始节点，如果没有环，返回null。
 *
 * 样例
 * 样例 1:
 *
 * 输入：null,no cycle
 * 输出：no cycle
 * 解释：
 * 链表为空，所以没有环存在。
 * 样例 2:
 *
 * 输入：-21->10->4->5，tail connects to node index 1
 * 输出：10
 * 解释：
 * 最后一个节点5指向下标为1的节点，也就是10，所以环的入口为10。
 * 挑战
 * 不使用额外的空间
 */
public class DetectCycle {
    /**
     * 思路：使用快慢指针来实现
     *      fast 每一次走两步，slow 每次走一步
     *      注意：不适用额外的空间，我们使用 head 进行遍历，从而不使用额外的空间来实现
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow){
            if(fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        // 如果退出循环，表示的是，此时 slow 表示的是第一次相遇的节点
        // 然后再从头节点进行遍历，慢指针从 slow 开始遍历,再次相遇的时候，此时就是环的入口的节点
        while(head != slow.next){
            head = head.next;
            slow = slow.next;
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
        node5.next = node6;

        node6.next = node3; // 环的入口节点

        ListNode result = detectCycle(node1);
        System.out.println("环的节点是：\t" + result.val);
    }
}
