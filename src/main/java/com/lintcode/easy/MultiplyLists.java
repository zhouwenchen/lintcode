package com.lintcode.easy;

/**
 *
 756. 两数相乘
 给出两个链表形式表示的数字,写一个函数得到这两个链表相乘乘积。

 样例
 样例 1:

 输入：9->4->6->null,8->4->null
 输出：79464
 解释：946*84=79464
 样例 2:

 输入：3->2->1->null,1->2->null
 输出：3852
 解释：321*12=3852
 */
public class MultiplyLists {
    /**
     * 遍历两个链表，将链表中的值拼接成指定的数值
     * @param l1 第一个链表
     * @param l2 第二个链表
     * @return 两个链表整数的乘积
     */
    private static long multiplyLists(ListNode l1, ListNode l2) {
       ListNode p = l1;
       long num1 = 0;
       while(p != null){
           num1 *= 10;
           num1 += p.val;
           p = p.next;
       }
       p = l2;
       long num2 = 0;
       while(p != null){
           num2 *= 10;
           num2 += p.val;
           p = p.next;
       }
        return num1 * num2;
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);

        ListNode node11 = new ListNode(1);
        ListNode node22 = new ListNode(2);

        node3.next = node2;
        node2.next = node1;

        node11.next = node22;

        long result = multiplyLists(node3, node11);
        System.out.println(result);
    }
}
