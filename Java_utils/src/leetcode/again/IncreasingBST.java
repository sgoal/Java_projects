package leetcode.again;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/increasing-order-search-tree/
public class IncreasingBST {
    public TreeNode increasingBST1(TreeNode root) {
    	if(root==null)return root;
        List<TreeNode> nodes = helper(root, new ArrayList<>());
        int n = nodes.size();
        for(int i=0;i<n;i++) {
        	TreeNode node = nodes.get(i);
        	node.left=null;
        	if(i<n-1)
        		node.right = nodes.get(i+1);
        	else
        		node.right = null;
        }
        return nodes.get(0);
    }
    List<TreeNode> helper(TreeNode root, List<TreeNode> res) {
    	if(root==null)return null;
    	helper(root.left, res);
    	res.add(root);
    	helper(root.right, res);
    	return res;
    }
    
    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
    	if(root==null)return root;
    	cur = null;

    	TreeNode res = new TreeNode(0);
    	cur = res;
    	inorder(root);
        return res.right;
    }
    
    public void inorder(TreeNode root) {
    	if(root==null)return;
    	inorder(root.left);
    	root.left = null;
    	cur.right = root;
    	cur = root;
    	inorder(root.right);
    }
}
