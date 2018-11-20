package leetcode.again;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
       if(nums.length<1)return 0;
       if(nums.length==1)return nums[0];
       int dp[] = new int[nums.length];
       dp[0]=nums[0];
       for(int i=1;i<nums.length;i++) {
    	   dp[i] = nums[i]+dp[i-1];
       }
       int res = Integer.MIN_VALUE;
       int min = 0;
       for(int i=0;i<dp.length;i++) {
    	   res = Math.max(res, dp[i]-min);
    	   min = Math.min(dp[i], min);
       }
       return res;
    }
    public static void main(String[] args) {
    	MaxSubArray solution = new MaxSubArray();
    	System.out.println(solution.maxSubArray(new int[] {-1}));
    	System.out.println(solution.maxSubArray(new int[] {-1,-2}));
    	System.out.println(solution.maxSubArray(new int[] {-2,1}));
	}
}
