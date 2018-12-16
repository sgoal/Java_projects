package leetcode.again;

import java.util.Arrays;
import java.util.LinkedList;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	if(root==null) {return "null";}
    	String ans = String.valueOf(root.val);
    	ans += ',' + serialize(root.left);
    	ans += ',' + serialize(root.right);
    	return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if(data==null||data.isEmpty())return null;
        String[] nodes = data.split(",");
        LinkedList<String> ns = new LinkedList<>(Arrays.asList(nodes));
        return build(ns);
    }
    TreeNode build(LinkedList<String> nodes) {
    	if(nodes.isEmpty())return null;
    	if(nodes.getFirst().equals("null")) {nodes.removeFirst();return null;}
    	TreeNode node = new TreeNode(Integer.valueOf(nodes.getFirst()));
    	nodes.removeFirst();
    	node.left = build(nodes);
    	node.right = build(nodes);
    	return node;
    }
    public static void main(String[] args) {
    	Codec solution = new Codec();
    	System.out.println(solution.serialize(solution.deserialize("1,2,3,null,null,4,null,null,5,null,null")));
    	System.out.println(solution.serialize(solution.deserialize("")));
	}
}