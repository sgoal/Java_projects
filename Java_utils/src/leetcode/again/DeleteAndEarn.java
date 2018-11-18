package leetcode.again;

import java.util.HashMap;

public class DeleteAndEarn {

	public int deleteAndEarn(int[] nums) {
		 if(nums==null||nums.length==0){
	            return 0;
	        }
	        int[] dp = new int[10001];
	        for(int i:nums)dp[i]+=i;
	        for(int i=2;i<10001;i++){
	            dp[i] = Math.max(dp[i-2]+dp[i],dp[i-1]);
	        }
	        return dp[10000];
	}
	    
}
