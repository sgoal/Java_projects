package leetcode.again;

import java.util.LinkedList;

//https://leetcode.com/problems/convert-bst-to-greater-tree/
public class ConvertBST {
	int sum = 0;
    public TreeNode convertBST1(TreeNode root) {
        //need add right child,or add parent
    	if(root!=null) {
    		convertBST1(root.right);
    		sum += root.val;
    		root.val = sum;
    		convertBST1(root.left);
    	}
    	return root;
    }
    
    public TreeNode convertBST(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        int sum1 = 0;
        TreeNode node = root;
        while(!stack.isEmpty()||node!=null) {
        	while(node!=null) {
        		stack.addFirst(node);
        		node = node.right;
        	}
        	node = stack.pop();
        	sum1 += node.val;
        	node.val =sum1;
        	node = node.left;
        }
    	return root;
    }
    
}
