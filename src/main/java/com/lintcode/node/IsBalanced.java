package com.lintcode.node;

/**  
 * 93. 平衡二叉树
给定一个二叉树,确定它是高度平衡的。对于这个问题,一棵高度平衡的二叉树的定义是：一棵二叉树中每个节点的两个子树的深度相差不会超过1。 

样例
样例  1:
	输入: tree = {1,2,3}
	输出: true
	
	样例解释:
	如下，是一个平衡的二叉树。
		  1  
		 / \                
		2  3
	
样例  2:
	输入: tree = {3,9,20,#,#,15,7}
	输出: true
	
	样例解释:
	如下，是一个平衡的二叉树。
		  3  
		 / \                
		9  20                
		  /  \                
		 15   7 
	
样例  2:
	输入: tree = {1,#,2,3,4}
	输出: false
	
	样例解释:
	如下，是一个不平衡的二叉树。1的左右子树高度差2
		  1  
		   \                
		   2                
		  /  \                
		 3   4
 * @author zhouwenchen@021.com  
 * @date 2019年3月27日上午11:43:56   
 */
public class IsBalanced {
    public static boolean isBalanced(TreeNode root) {
    	return maxDepth(root) != -1;
    }
    
    private static int maxDepth(TreeNode root) {
    	if(root == null){
    		return 0;
    	}
    	int left = maxDepth(root.left);
    	int right = maxDepth(root.right);
    	
    	if(left == -1 || right == -1|| Math.abs(left-right) > 1){
    		return -1;
    	}
    	return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {

    	TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		
//		node1.left = node2;
		node1.right = node3;
//		node2.left = node4;
//		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		
		boolean b = isBalanced(node1);
		System.out.println(b);
	}
}
