package com.offer.test;

import com.lintcode.node.ComplexListNode;

/**  
 * 复杂链表的复制
 * 
 * 请实现函数 ComplexListNode clone(ComplexListNode head)，复制一个复杂链表。在复杂链表中，每个结点除了有一个 next 域指向下一个结点外，还有一个 sibling 指向链表中的任意结点或者 null。
 * @author zhouwenchen@021.com  
 * @date 2019年6月24日 上午10:33:56 
 */
public class CloneComplexListNode {
	
	private static ComplexListNode clone(ComplexListNode root){
		if(root == null){
			return null;
		}
		// 1.0	先复制节点
		clones(root);
		// 2.0	再连接 sibling节点
		connectNodes(root);
		// 3.0	再拆分整个链表,返回链表的头结点
		return reconnectNodes(root);
	}
	/**
	 * 复制一个链表，并且将复制后的结点插入到被复制的结点后面，只链接复制结点的next字段
	 */
	private static void clones(ComplexListNode root) {
		while(root != null){
			// 创建一个新的节点
			ComplexListNode tmp = new ComplexListNode(0);
//			tmp.val = root.val;
			tmp.val = root.val + 100;//TODO 用于测试的时候用的
			tmp.next = root.next;
			root.next = tmp;
			root = tmp.next;
		}
	}
	
	/**
	 * 复制 sibling 节点的值
	 */
	private static void connectNodes(ComplexListNode root) {
		while(root != null){
			if(root.sibling != null){
				root.next.sibling = root.sibling.next;
			}
			// 处理下一个节点的值
			root = root.next.next;
		}
	}
	
	/**
	 * 拆分整个链表，并返回头结点，奇数表示的是原链表，偶数表示的是复制之后的链表结构
	 * @param 链表的头结点
	 * @return 复制之后的链表的头结点
	 */
	private static ComplexListNode reconnectNodes(ComplexListNode head) {
		if(head == null){
			return null;
		}
		// 用于记录复制链表的头结点的值
		ComplexListNode newHead = head.next;
		// 正在处理的节点的值
		ComplexListNode pointer = newHead;
		head.next = newHead.next;
		head = head.next;
		while(head != null){
			pointer.next = head.next;
			pointer = pointer.next;
			head.next = pointer.next;
			head = pointer.next;
			
		}
		return newHead;
	}


	public static void main(String[] args) {
		ComplexListNode node1 = new ComplexListNode(1);
		ComplexListNode node2 = new ComplexListNode(2);
		ComplexListNode node3 = new ComplexListNode(3);
		ComplexListNode node4 = new ComplexListNode(4);
		ComplexListNode node5 = new ComplexListNode(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		node1.sibling = node3;
		node3.sibling = node5;
		
		ComplexListNode node = clone(node1);
		while(node != null){
			System.out.print(node.val + "->");
			node = node.next;
			if(node==null){
				System.out.print("null");
			}
		}
	}
}
