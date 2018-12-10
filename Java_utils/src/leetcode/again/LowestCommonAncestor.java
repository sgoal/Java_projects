package leetcode.again;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class LowestCommonAncestor {
	HashMap<TreeNode, Integer> counter = new HashMap<>();
	TreeNode ans = null;
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return null;
        ans = null;
        helper(root, p, q);
        return ans;
    }
    
    int helper(TreeNode root, TreeNode p, TreeNode q) {
    	if(root==null)return 0;
    	if(counter.containsKey(root))return counter.get(root);
    	int count=0;
    	if(root==p||root==q)count++;
    	int l = helper(root.left, p, q);
    	if(l==1&&count==1) {
    		ans=root;
    		return 2;
    	}
    	int r = helper(root.right, p, q);
      	if(r==1&&count==1) {
    		ans=root;
    		return 2;
    	}
    	if(l==1&&r==1) {
    		ans = root;
    	}
    	return count+l+r;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return null;
        LinkedList<TreeNode> stack = new LinkedList<>();
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        stack.push(root);
        parent.put(root, null);
        while(!parent.containsKey(q)||!parent.containsKey(p)) {
        	TreeNode temp = stack.pop();
        	if(temp.left!=null) {
        		parent.put(temp.left,temp);
        		stack.push(temp.left);
        	}
        	if(temp.right!=null) {
        		parent.put(temp.right, temp);
        		stack.push(temp.right);
        	}
        }
        HashSet<TreeNode> set = new HashSet<>();
        while(q!=null) {
        	set.add(q);
        	q = parent.get(q);
        }
        while(!set.contains(p)) {
        	p = parent.get(p);
        }
        return p;
    }
}