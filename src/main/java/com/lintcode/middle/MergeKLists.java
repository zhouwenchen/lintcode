package com.lintcode.middle;

import com.lintcode.node.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 104. 合并k个排序链表
 * 中文English
 * 合并k个排序链表，并且返回合并后的排序链表。尝试分析和描述其复杂度。
 *
 * 样例
 * 样例 1:
 * 	输入:   [2->4->null,null,-1->null]
 * 	输出:  -1->2->4->null
 *
 * 样例 2:
 * 	输入: [2->6->null,5->null,7->null]
 * 	输出:  2->5->6->7->null
 */
public class MergeKLists {

    /**
     * 思路1.遍历将链表集合中的所有的元素，存放到list集合中，排序之后，在重新遍历生成链表
     * 思路2.找寻出K个链表中的最小节点，并将其从K个链表集中剔除，再将其添加到新的链表中，直到K个链表都为空为止 TODO
     * 思路3.
     * @param lists 链表集合
     * @return 头结点
     */
    public static ListNode mergeKLists(List<ListNode> lists) {
        if(lists == null){
            return null;
        }
        // 思路1
        List<Integer> resultLists = new ArrayList<>();
        for(ListNode node: lists){
            while (node != null){
                resultLists.add(node.val);
                node = node.next;
            }
        }
        // 排序
        Collections.sort(resultLists);
        // 重新生成排序的链表
        ListNode head = new ListNode(0);
        ListNode temp = head;
        for(Integer val: resultLists){
            temp.next = new ListNode(val);
            temp = temp.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node2 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node2.next = node6;
        List<ListNode> lists = new ArrayList<>();
        lists.add(node2);
        lists.add(node5);
        lists.add(node7);

        ListNode resultListNode = mergeKLists(lists);
        while (resultListNode != null){
            System.out.print(resultListNode.val + " -> ");
            resultListNode = resultListNode.next;
        }
        System.out.print("null");
    }
}
