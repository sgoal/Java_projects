package leetcode.again;

//https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterOfBinaryTree {
    private int res = 0;
	public int diameterOfBinaryTree(TreeNode root) {
		if(root==null)return 0;
        res = 0;
        helper(root);
        return res-1;
    }
    public int helper(TreeNode root) {
    	if(root ==null)return 0;
    	int l = helper(root.left);
    	int r = helper(root.right);
    	res = Math.max(res,  1+l+r);
    	return 1 + Math.max(l, r);
    }
}