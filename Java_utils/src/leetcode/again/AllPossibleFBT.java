package leetcode.again;

import java.util.ArrayList;
import java.util.HashMap;
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
   HashMap<Integer, List<TreeNode>> cache = new HashMap<>();
   public List<TreeNode> allPossibleFBT(int N) {
	   if(cache.containsKey(N))return cache.get(N);
        List<TreeNode> nodes = new ArrayList<>();
        if(N<=0)return nodes;
        if(N%2==0)return nodes;
        if(N==1)nodes.add(new TreeNode(0));
        else {
	        
	        for(int i=0;i<N;i++) {
	        	int x = N-1-i;
	        	for(TreeNode node0:allPossibleFBT(x))
	        		for(TreeNode node1:allPossibleFBT(i)) {
	        			TreeNode root = new TreeNode(0);
	        			root.left = node0;
	        			root.right =node1;
	        			nodes.add(root);
	        		}
	        }
	        cache.put(N,nodes);
        }
        return nodes;
    }
	   
	   
}
