package leetcode.again;

import java.util.ArrayList;
import java.util.List;
/**
 * Definition for a binary tree node.
 * */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class AllPossibleFBT {
	
	   public List<TreeNode> allPossibleFBT(int N) {
	        List<TreeNode> nodes = new ArrayList<>();
	        TreeNode root = new TreeNode(0);
	        getTree(N-1, root, nodes,root);
	        return nodes;
	    }
	   
	   void getTree(int n,TreeNode node, List<TreeNode> res,TreeNode root) {
		   if(n==0) {res.add(copy(root));return;}
		   if(n==1) {
			   return;
		   }

		   node.left = new TreeNode(0);
		   node.right = new TreeNode(0);
		   if(n-2==0) {res.add(copy(root));return;}
		   getTree(n-2, node.left, res, root);
		   node.left = new TreeNode(0);
		   getTree(n-2, node.right, res,root);
		   node.right = new TreeNode(0);
		     
	   }
	   TreeNode copy(TreeNode root) {
		   if(root==null)return null;
		   TreeNode treeNode = new TreeNode(0);
		   treeNode.left = copy(treeNode.left);
		   treeNode.right = copy(treeNode.right);
		   return treeNode;
	   }
}
