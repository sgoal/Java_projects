package leetcode.again;

import java.util.LinkedList;

public class CBTInserter {
    TreeNode root;
    LinkedList<TreeNode> nodes = new LinkedList<>();

    public CBTInserter(TreeNode root) {
        this.root = root;
        nodes.add(root);
    }
    
    public int insert(int v) {
    	TreeNode p = null;
    	while(p==null){
    		TreeNode aNode = nodes.getFirst();
    		if(aNode.left==null) {
    			aNode.left = new TreeNode(v);
    			p = aNode;
    			break;
    		}else if(aNode.right==null) {
    			aNode.right = new TreeNode(v);
    			p = aNode  ;
    			break;
    		}else {
				nodes.poll();
				nodes.addLast(aNode.left);
				nodes.addLast(aNode.right);
			}
    	}
    	return p.val;
    }
    
    public TreeNode get_root() {
        return this.root;
    }
}
