package com.lintcode.tree;

import com.lintcode.node.TreeNode;

/**  
 * 95. 验证二叉查找树
给定一个二叉树，判断它是否是合法的二叉查找树(BST)

一棵BST定义为：

节点的左子树中的值要严格小于该节点的值。
节点的右子树中的值要严格大于该节点的值。
左右子树也必须是二叉查找树。
一个节点的树也是二叉查找树。
样例
样例 1:

输入：{-1}
输出：true
解释：
二叉树如下(仅有一个节点）:
	-1
这是二叉查找树。
样例 2:

输入：{2,1,4,#,#,3,5}
输出：true
解释：
	二叉树如下：
	  2
	 / \
	1   4
	   / \
	  3   5
这是二叉查找树。
 * @author zhouwenchen@021.com  
 * @date 2019年6月10日 下午5:48:45 
 */
public class IsValidBST {
	
	/**
	 * 这种解决方案是错误的，由于没有考虑到子节点和祖先节点的值得比较
	 * @param root
	 * @return
	 */
//    public static boolean isValidBST(TreeNode root) {
//    	if(root == null){
//    		return true;
//    	}
//    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
//    	queue.add(root);
//    	
//    	while(!queue.isEmpty()){
//    		TreeNode head = queue.poll();
//    		TreeNode left = head.left;
//    		if(left != null && left.val >= head.val){
//    			return false;
//    		}
//    		TreeNode right = head.right;
//    		if(right != null && right.val <= head.val){
//    			return false;
//    		}
//    		if(left !=null){
//    			queue.add(left);
//    		}
//    		if(right != null){
//    			queue.add(right);
//    		}
//    	}
//    	
//    	return true;
//    }
	
	/***
	 * 本地测试没有问题，lintcode测试不通过。
	 * @param args
	 */
//	private static boolean firstNode = true;
//	private static int lastVal = Integer.MAX_VALUE;
//	public static boolean isValidBST(TreeNode root) {
//		if (root == null) {
//			return true;
//		}
//		if (!isValidBST(root.left)) {
//			return false;
//		}
//		if (!firstNode && lastVal >= root.val) {
//			return false;
//		}
//		firstNode = false;
//		lastVal = root.val;
//		if (!isValidBST(root.right)) {
//			return false;
//		}
//		return true;
//	}
	
	/**
	 * 我们测试实现的方式
	 * @param root
	 * @return
	 */
	public static boolean isValidBST(TreeNode root) {
		return divConq(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	private static boolean divConq(TreeNode root, long min, long max) {
		if(root == null){
			return true;
		}
		if(root.val <= min || root.val >=max){
			return false;
		}
//		return divConq(root.left,min,Math.min(max, root.val)) 
//			&& divConq(root.right,Math.max(min, root.val),max);
		return divConq(root.left, min, root.val) && 
				divConq(root.right, root.val, max);
	}


	public static void main(String[] args) {
    	TreeNode node2 = new TreeNode(2);
    	TreeNode node1 = new TreeNode(1);
//    	TreeNode node9 = new TreeNode(9);
    	TreeNode node4 = new TreeNode(4);
    	TreeNode node3 = new TreeNode(3);
    	TreeNode node5 = new TreeNode(5);
    	
    	node2.left = node1;
//    	node1.left = node9;
    	node2.right = node4;
    	node4.left = node3;
    	node4.right = node5;
		
		
		// 测试案例2   {10,5,#,1,100}
//		TreeNode node10 = new TreeNode(10);
//		TreeNode node5 = new TreeNode(5);
//		TreeNode node1 = new TreeNode(1);
//		TreeNode node100 = new TreeNode(100);
//		
//		node10.left = node5;
//		node5.left = node1;
//		node5.right = node100;
		
//		TreeNode node2 = new TreeNode(2);
//		TreeNode node1 = new TreeNode(1);
//		TreeNode node3 = new TreeNode(3);
//		
//		node2.left = node1;
//		node2.right = node3;
		
		boolean b = isValidBST(node2);
		System.out.println(b);
	}
}
