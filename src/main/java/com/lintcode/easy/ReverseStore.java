package com.lintcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 822. 相反的顺序存储
 * 给出一个链表，并将链表的值以倒序存储到数组中。
 *
 * 样例
 * 样例1
 *
 * 输入: 1 -> 2 -> 3 -> null
 * 输出: [3,2,1]
 * 样例2
 *
 * 输入: 4 -> 2 -> 1 -> null
 * 输出: [1,2,4]
 * 注意事项
 * 您不能改变原始链表的结构。
 * ListNode 有两个成员变量：ListNode.val 和 ListNode.next
 */
public class ReverseStore {
    /**
     * 1.先统计链表中节点的长度
     * 2.创建集合，从后往前添加数据
     * @param head 链表的头结点
     * @return 返回集合中的数据
     */
    private static List<Integer> reverseStore(ListNode head) {
        // 1.遍历链表中节点的长度
        int len = 0;
        ListNode p = head;
        while(p != null){
            len++;
            p = p.next;
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i< len;i++){
            result.add(head.val);
            head = head.next;
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        List<Integer> result = reverseStore(node1);
        result.stream().forEach(System.out::print);
    }
}
