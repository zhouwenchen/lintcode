package com.lintcode.easy;

/**
 * 219. 在排序链表中插入一个节点
 * 中文English
 * 在链表中插入一个节点。
 *
 * 样例
 * 样例 1：
 *
 * 输入：head = 1->4->6->8->null, val = 5
 * 输出：1->4->5->6->8->null
 * 样例 2：
 *
 * 输入：head = 1->null, val = 2
 * 输出：1->2->null
 */
public class InsertNode2 {
    /**
     * 思路1：遍历链表存入到集合中，然后将节点值直接插入到集合中，最后在生成链表，从而实现排序链表汇总的插入节点的值
     * 思路2：遍历链表，判断插入的节点和此时链表的节点值得大小，如果此时节点大于
     * @param head
     * @param val
     * @return
     */
    public static ListNode insertNode(ListNode head, int val) {
        // 1.判断链表是否为空
        ListNode node1 = new ListNode(val);
        if(head == null ){
            return node1;
        }
        // val 是最小的
        if(val <= head.val){
            node1.next = head;
            return node1;
        }
        ListNode temp = head;
        ListNode pre = head;
        while (temp != null){
            if(temp.next != null && temp.next.val >= val){
                node1.next = temp.next;
                temp.next = node1;
                return head;
            } else if(temp.next == null && temp.val < val){
                temp.next = node1;
                return head;
            }
            temp = temp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
//        ListNode node4 = new ListNode(4);
//        ListNode node6 = new ListNode(6);
//        ListNode node8 = new ListNode(8);

        ListNode node5 = new ListNode(5);

//        node1.next = node4;
//        node4.next = node6;
//        node6.next = node8;

        ListNode resultNode = insertNode(node1, 2);
        while (resultNode != null){
            System.out.print(resultNode.val + " -> ");
            resultNode = resultNode.next;
        }
        System.out.print("null");
    }
}
