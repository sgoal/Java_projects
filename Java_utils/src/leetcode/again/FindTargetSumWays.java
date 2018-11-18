package leetcode.again;

import java.util.HashMap;
import java.util.Map;

public class FindTargetSumWays {
	  public int findTargetSumWays(int[] nums, int S) {
	        HashMap<Integer, Integer> map = new HashMap<>();
	        map.put(0, 1);
	        for(int i:nums) {
	        	HashMap<Integer, Integer> temp = new HashMap<>();
	        	for(Map.Entry<Integer, Integer> entry
	        			:map.entrySet()) {
	        		temp.put(entry.getKey()+i, entry.getValue()+
	        				temp.getOrDefault(entry.getKey()+i,0));
	        		temp.put(entry.getKey()-i, entry.getValue()+
	        				temp.getOrDefault(entry.getKey()-i,0));
	        	}
	        	map = temp;
	        }
	        return map.getOrDefault(S, 0);
	  }
	  
	  public int findTargetSumWays1(int[] nums, int S) {
	        int[] dp = new int[nums.length+1];
	        for(int i:nums) {
	        	//TODO
	        }
	        return 0;
	  }
	  
}
