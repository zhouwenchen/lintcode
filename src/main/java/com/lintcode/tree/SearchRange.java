package com.lintcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.lintcode.node.TreeNode;

/**  
 * 11. 二叉查找树中搜索区间
给定一个二叉查找树和范围[k1, k2]。按照升序返回给定范围内的节点值。

样例
样例 1:

输入：{5},6,10
输出：[]
        5
它将被序列化为 {5}
没有数字介于6和10之间
样例 2:

输入：{20,8,22,4,12},10,22
输出：[12,20,22]
解释：
        20
       /  \
      8   22
     / \
    4   12
它将被序列化为 {20,8,22,4,12}
[12,20,22]介于10和22之间
 * @author zhouwenchen@021.com  
 * @date 2019年6月6日 上午11:18:27 
 */
public class SearchRange {
	public static List<Integer> searchRange(TreeNode root, int k1, int k2) {
		List<Integer> lists = new ArrayList<Integer>();
		if(root == null){
			return lists;
		}
		// 1.先遍历二叉树，放入到queue队列中
		List<TreeNode> queue = new ArrayList<TreeNode>();
		queue.add(root);
		TreeNode node = null;
		for (int i = 0; i < queue.size(); i++) {
			node = queue.get(i);
			if (node == null) {
				continue;
			}
			if(node.left != null){
				queue.add(node.left);
			}
			if(node.right != null){
				queue.add(node.right);
			}
		}
		
		// 2.循环遍历数据
		for (TreeNode treeNode : queue) {
			if(k1 <= treeNode.val && k2>=treeNode.val){
				lists.add(treeNode.val);
			}
		}
		Collections.sort(lists);
		return lists;
	}
    
    public static void main(String[] args) {
    	TreeNode node20 = new TreeNode(20);
    	TreeNode node8 = new TreeNode(8);
    	TreeNode node22 = new TreeNode(22);
    	TreeNode node4 = new TreeNode(4);
    	TreeNode node12 = new TreeNode(12);
    	
    	node20.left = node8;
    	node20.right = node22;
    	node8.left = node4;
    	node8.right = node12;
    	
		List<Integer> lists = searchRange(node20, 10, 22);
//		List<Integer> lists = searchRange2(node20, 10, 22);
		for (Integer integer : lists) {
			System.out.println(integer);
		}
	}
    
    /**
     * 第二种使用递归的方式实现
     * @param root
     * @param k1
     * @param k2
     * @return
     */
    private static List<Integer> result ;
    public static List<Integer> searchRange2(TreeNode root, int k1, int k2) {
    	result = new ArrayList<Integer>();
    	helper(root, k1, k2);
    	return result;
    }

	private static void helper(TreeNode root, int k1, int k2) {
		if(root == null){
			return;
		}
		if(root.val > k1){
			helper(root.left, k1, k2);
		}
		if(root.val >=k1 && root.val<=k2){
			result.add(root.val);
		}
		if(root.val < k2){
			helper(root.right, k1, k2);
		}
	}
}
