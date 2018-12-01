package leetcode.again;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/leaf-similar-trees/
public class LeafSimilar {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return helper(root1, new ArrayList<>()).equals(helper(root2, new ArrayList<>()));
    }
    List<Integer> helper(TreeNode root, List<Integer> res) {
    	if(root==null)return null;
    	if(root.left==null&&root.right==null)res.add(root.val);
    	else {
			helper(root.left, res);
			helper(root.right, res);
		}
    	return res;
    }
}