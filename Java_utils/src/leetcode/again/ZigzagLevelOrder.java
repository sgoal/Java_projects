package leetcode.again;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	if(root==null)return new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        boolean leftToRight = true;
        int lastLevel = 1;
        queue.add(root);
        TreeNode temp = null;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tempArray = new ArrayList<>();
        while(!queue.isEmpty()) {
        	temp = queue.pollLast();
        	lastLevel--;
        	if(temp.left!=null) {
        		queue.addFirst(temp.left);
        	}
        	if(temp.right!=null) {
        		queue.addFirst(temp.right);
        	}
        	tempArray.add(temp.val);
        	if(lastLevel==0) {
        		lastLevel = queue.size();
        		if(leftToRight) {
        			ans.add(tempArray);
        		}else {
        			Collections.reverse(tempArray);
        			ans.add(tempArray);
				}
        		leftToRight = !leftToRight;
        		tempArray = new ArrayList<>();
        	}
        	
        }
        return ans;
    }
}