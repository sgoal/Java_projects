package leetcode.again;

import java.util.Arrays;

public class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
    	if(nums.length==0)return 0;
    	int n = nums.length;
        int dp[] = new int[n];
        int res = 1;
        for(int i=0;i<n;i++) {
        	dp[i]=1;
        	if(i>0&&nums[i-1]<nums[i]) {
        		dp[i] = Math.max(dp[i], dp[i-1]+1);
        		res = Math.max(res, dp[i]);
        	}
        	
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }
    public static void main(String[] args) {
    	FindLengthOfLCIS solution = new FindLengthOfLCIS();
    	System.out.println(solution.findLengthOfLCIS(new int[] {1,3,5,4,7}));
	}
}