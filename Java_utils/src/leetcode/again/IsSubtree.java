package leetcode.again;

//https://leetcode.com/problems/subtree-of-another-tree/
public class IsSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null&&t==null)return true;
        if(s==null||t==null)return false;
        return isEq(s,t)||isSubtree(s.right, t)||isSubtree(s.left, t);
        
        }
    public boolean isEq(TreeNode s, TreeNode t) {
    	if(s==null&&t==null)return true;
        if(s==null||t==null)return false;
        return s.val == t.val&&isEq(s.left, t.left)
        			&&isEq(s.right, t.right);
        	
        }
    
}
