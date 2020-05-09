package com.lintcode.tree;

import java.util.ArrayList;
import java.util.List;

import com.lintcode.node.TreeNode;

/**  
 * 7. 二叉树的序列化和反序列化
设计一个算法，并编写代码来序列化和反序列化二叉树。将树写入一个文件被称为“序列化”，读取文件后重建同样的二叉树被称为“反序列化”。

如何反序列化或序列化二叉树是没有限制的，你只需要确保可以将二叉树序列化为一个字符串，并且可以将字符串反序列化为原来的树结构。

样例
样例 1：

输入：{3,9,20,#,#,15,7}
输出：{3,9,20,#,#,15,7}
解释：
二叉树 {3,9,20,#,#,15,7}，表示如下的树结构：
	  3
	 / \
	9  20
	  /  \
	 15   7
它将被序列化为 {3,9,20,#,#,15,7}
样例 2：

输入：{1,2,3}
输出：{1,2,3}
解释：
二叉树 {1,2,3}，表示如下的树结构：
   1
  / \
 2   3
它将被序列化为 {1,2,3}
我们的数据是进行 BFS 遍历得到的。当你测试结果 Wrong Answer 时，你可以作为输入调试你的代码。
 * @author zhouwenchen@021.com  
 * @date 2019年6月6日 上午9:08:11 
 */
public class SerializeAndDeserialize {
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
//		String serialize = serialize(node3);
//		System.out.println(serialize);
		
		TreeNode deserialize = deserialize("{3,9,20,#,#,15,7}");

		System.out.println(deserialize);
	}
	
	/**
	 * 二叉树序列化成字符串形式
	 * @param root
	 * @return
	 */
	public static String serialize(TreeNode root) {
		if (root == null) {
			return "{}";
		}

		// 1.遍历将树的所有的节点放入到queue集合中
		List<TreeNode> queue = new ArrayList<TreeNode>();
		queue.add(root);

		for (int i = 0; i < queue.size(); i++) {
			TreeNode node = queue.get(i);
			if (node == null) {
				continue;
			}
			queue.add(node.left);
			queue.add(node.right);
		}

		// 从队尾开始，删除为空的数据，也是为了一下好遍历集合做准备
		while (queue.get(queue.size() - 1) == null) {
			queue.remove(queue.size() - 1);
		}
		
		// 2.遍历集合，拼接成目标字符串 {3,9,20,#,#,15,7}
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append(queue.get(0).val);
		for(int i = 1;i < queue.size();i++){
			if(queue.get(i) == null){
				sb.append(",#");
			} else {
				sb.append(",");
				sb.append(queue.get(i).val);
			}
		}
		sb.append("}");
		return sb.toString();
	}

    /**
     * 字符串反序列化成二叉树的数据结构
     * @param data
     * @return
     */
    public static TreeNode deserialize(String data) { // {3,9,20,#,#,15,7}
    	if("{}".equals(data)){
    		return null;
    	}
    	
    	// 1.先对字符串处理，转化成数组
    	String[] vals = data.substring(1,data.length()-1).split(",");
    	// 2.遍历数组
    	List<TreeNode> queue = new ArrayList<TreeNode>();
    	TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
    	queue.add(root); // 头结点
    	
    	int index = 0;
    	boolean isLeftChild = true;
    	TreeNode node = null;
    	for(int i = 1;i < vals.length;i++){
    		if(!vals[i].equals("#")){
    			node = new TreeNode(Integer.parseInt(vals[i]));
    			if(isLeftChild){
    				queue.get(index).left = node;
    			}else {
    				queue.get(index).right = node;
    			}
    			queue.add(node);
    		}
      		if(!isLeftChild){
    			index++;
    		}
    		isLeftChild = ! isLeftChild;
    	}
    	
    	return root;
    }
}
