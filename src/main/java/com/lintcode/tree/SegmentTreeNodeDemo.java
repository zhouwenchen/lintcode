package com.lintcode.tree;

import com.lintcode.node.SegmentTreeNode;

/**  
 * 201. 线段树的构造
线段树是一棵二叉树，他的每个节点包含了两个额外的属性start和end用于表示该节点所代表的区间。start和end都是整数，并按照如下的方式赋值:

根节点的 start 和 end 由 build 方法所给出。
对于节点 A 的左儿子，有 start=A.left, end=(A.left + A.right) / 2。
对于节点 A 的右儿子，有 start=(A.left + A.right) / 2 + 1, end=A.right。
如果 start 等于 end, 那么该节点是叶子节点，不再有左右儿子。
实现一个 build 方法，接受 start 和 end 作为参数, 然后构造一个代表区间 [start, end] 的线段树，返回这棵线段树的根。

样例
样例 1:

输入：[1,4]
输出："[1,4][1,2][3,4][1,1][2,2][3,3][4,4]"
解释：
	               [1,  4]
	             /        \
	      [1,  2]           [3, 4]
	      /     \           /     \
	   [1, 1]  [2, 2]     [3, 3]  [4, 4]
样例 2:

输入：[1,6]
输出："[1,6][1,3][4,6][1,2][3,3][4,5][6,6][1,1][2,2][4,4][5,5]"
解释：
	       [1,  6]
             /        \
      [1,  3]           [4,  6]
      /     \           /     \
   [1, 2]  [3,3]     [4, 5]   [6,6]
   /    \           /     \
[1,1]   [2,2]     [4,4]   [5,5]
说明
线段树(又称区间树), 是一种高级数据结构，他可以支持这样的一些操作:

查找给定的点包含在了哪些区间内
查找给定的区间包含了哪些点
见百科：
线段树
区间树

/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end) {
 *         this.start = start, this.end = end;
 *         this.left = this.right = null;
 *     }
 * }

 * @author zhouwenchen@021.com  
 * @date 2019年6月11日 下午2:05:23 
 */
public class SegmentTreeNodeDemo {
	public static SegmentTreeNode build(int start, int end) {
		if (start > end) {
			return null;
		}

		SegmentTreeNode root = new SegmentTreeNode(start, end);
		if (start != end) {
			int mid = (start + end) / 2;
			root.left = build(start, mid);
			root.right = build(mid + 1, end);
		}

		return root;
	}

	public static void main(String[] args) {
		SegmentTreeNode segmentTreeNode = build(1, 3);
		System.out.println(segmentTreeNode);
	}
}
