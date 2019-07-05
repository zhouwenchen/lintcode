package com.lintcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.lintcode.node.TreeNode;

/**  
 * 70. 二叉树的层次遍历 II
给出一棵二叉树，返回其节点值从底向上的层次序遍历（按从叶节点所在层到根节点所在的层遍历，然后逐层从左往右遍历）

样例
例1:

输入:
{1,2,3}
输出:
[[2,3],[1]]
解释:
    1
   / \
  2   3
它将被序列化为 {1,2,3}
层次遍历
例2:

输入:
{3,9,20,#,#,15,7}
输出:
[[15,7],[9,20],[3]]
解释:
    3
   / \
  9  20
    /  \
   15   7
它将被序列化为 {3,9,20,#,#,15,7}
层次遍历
 * @author zhouwenchen@021.com  
 * @date 2019年6月6日 下午3:29:59 
 */
public class LevelOrderBottom {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(root == null){
    		return result;
    	}
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	while(!queue.isEmpty()){
    		int size = queue.size();
    		
    		// 使用层次遍历的方式
    		List<Integer> level =  new ArrayList<Integer>();
    		for(int i = 0; i < size;i++){
    			TreeNode head = queue.poll();
    			level.add(head.val);
    			if(head.left != null){
    				queue.offer(head.left);
    			}
    			if(head.right != null){
    				queue.offer(head.right);
    			}
    		}
    		result.add(level);
    	}
    	
    	// 翻转
    	Collections.reverse(result);
    	return result;
    }
    
    public static void main(String[] args) {
    	TreeNode node3 = new TreeNode(3);
		TreeNode node9 = new TreeNode(9);
		TreeNode node20 = new TreeNode(20);
		TreeNode node15 = new TreeNode(15);
		TreeNode node7 = new TreeNode(7);
		
		node3.left = node9;
		node3.right = node20;
		node20.left = node15;
		node20.right = node7;
		
		List<List<Integer>> list = levelOrderBottom(node3);
		for (List<Integer> list2 : list) {
			System.out.println(list2);
		}
	}
}
