package leetcode.again;

import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 */
public class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
    	//bfs
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> nextQueue = new LinkedList<>();
        queue.add(root);
        int res = root.val;
        TreeNode cur = null;
        while(!queue.isEmpty()) {
        	cur = queue.pop();
        	if(cur.left!=null) {
        		nextQueue.addLast(cur.left);
        	}
        	if(cur.right!=null) {
        		nextQueue.addLast(cur.right);
        	}
        	if(queue.isEmpty()&&!nextQueue.isEmpty()) {
        		res = nextQueue.peek().val;
        	}
        	if(queue.isEmpty()) {
        		LinkedList<TreeNode> temp = queue;
        		queue = nextQueue;
        		nextQueue =temp;
        	}
        }
        return res;
    }
}