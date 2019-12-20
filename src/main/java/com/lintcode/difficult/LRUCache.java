package com.lintcode.difficult;

import java.util.HashMap;
import java.util.Map;

/**
 * 134. LRU缓存策略
 * 中文English
 * 为最近最少使用（LRU）缓存策略设计一个数据结构，它应该支持以下操作：获取数据和写入数据。
 *
 * get(key) 获取数据：如果缓存中存在key，则获取其数据值（通常是正数），否则返回-1。
 * set(key, value) 写入数据：如果key还没有在缓存中，则写入其数据值。当缓存达到上限，它应该在写入新数据之前删除最近最少使用的数据用来腾出空闲位置。
 * 最终, 你需要返回每次 get 的数据.
 *
 * 样例
 * 样例 1:
 *
 * 输入：
 * LRUCache(2)
 * set(2, 1)
 * set(1, 1)
 * get(2)
 * set(4, 1)
 * get(1)
 * get(2)
 * 输出：[1,-1,1]
 * 解释：
 * cache上限为2，set(2,1)，set(1, 1)，get(2) 然后返回 1，set(4,1) 然后 delete (1,1)，因为 （1,1）最少使用，get(1) 然后返回 -1，get(2) 然后返回 1。
 * 样例 2:
 *
 * 输入：
 * LRUCache(1)
 * set(2, 1)
 * get(2)
 * set(3, 2)
 * get(2)
 * get(3)
 * 输出：[1,-1,2]
 * 解释：
 * cache上限为 1，set(2,1)，get(2) 然后返回 1，set(3,2) 然后 delete (2,1)，get(2) 然后返回 -1，get(3) 然后返回 2。
 */
public class LRUCache {

    /**
     * 自定义ListNode，并且记录key 和 节点对应的值
     */
    static class ListNode{
        public int key,val;
        public ListNode next;
        public ListNode(int key,int val){
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    private static int capacity,size;
    private static ListNode dummy, tail;
    private static Map<Integer, ListNode> keyToPrev;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.keyToPrev = new HashMap<>();
        this.dummy = new ListNode(0,0);
        this.tail = dummy;
    }

    private static void moveToTail(int key){
        ListNode pre = keyToPrev.get(key);
        ListNode cur = pre.next;

        if(tail == cur){
            return;
        }

        pre.next = pre.next.next; // 删除key 这个节点
        tail.next = cur; // 将这个节点放置到链表的末尾处

        if(pre.next != null){
            keyToPrev.put(pre.next.key,pre);
        }
        keyToPrev.put(cur.key,tail);

        tail = cur;
    }

    public static int get(int key) {
        if(!keyToPrev.containsKey(key)){
            return -1;
        }
        moveToTail(key);
        return tail.val;
    }

    public static void set(int key, int value) {
        if(get(key) != -1){
            ListNode pre = keyToPrev.get(key);
            pre.next.val = value;
            return;
        }
        if(size < capacity){
            size++;
            ListNode cur = new ListNode(key,value);
            tail.next = cur;
            keyToPrev.put(key,tail);

            tail = cur;
            return;
        }

        // replace the first node with new key, value
        ListNode first = dummy.next;
        keyToPrev.remove(first.key);
        first.key= key;
        first.val = value;
        keyToPrev.put(key,dummy);

        moveToTail(key);
    }

    public static void main(String[] args) {
        /**
         * LRUCache(2)
         * set(2, 1)
         * set(1, 1)
         * get(2)
         * set(4, 1)
         * get(1)
         * get(2)
         * 输出：[1,-1,1]
         */
        LRUCache lruCache = new LRUCache(2);
        set(2,1);
        set(1,1);
        System.out.println(get(2));  // 1
        set(4,1);
        System.out.println(get(1));
        System.out.println(get(2));

        /**
         * LRUCache(1)
         * set(2, 1)
         * get(2)
         * set(3, 2)
         * get(2)
         * get(3)
         * 输出：[1,-1,2]
         */
//        LRUCache lruCache1 = new LRUCache(1);
//        set(2,1);
//        System.out.println(get(2));
//        set(3,2);
//        System.out.println(get(2));
//        System.out.println(get(3));
    }
}
