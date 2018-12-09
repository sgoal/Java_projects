package leetcode.again;

public class MaxSubArray {
    public int maxSubArray0(int[] nums) {
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
    
 public int maxSubArray(int[] nums) {
	 if(nums.length==0)return 0;
	 int ans = Integer.MIN_VALUE;
	 int cur=0,min=0;
	 for(int i=0;i<nums.length;i++) {
		 cur+=nums[i];
		 ans = Math.max(ans, cur-min);
		 min = Math.min(cur, min);

	 }
	 return ans;
    }
    public static void main(String[] args) {
    	MaxSubArray solution = new MaxSubArray();
    	System.out.println(solution.maxSubArray(new int[] {-1}));
    	System.out.println(solution.maxSubArray(new int[] {-1,-2}));
    	System.out.println(solution.maxSubArray(new int[] {-2,1}));
    	System.out.println(solution.maxSubArray(new int[] {1,2,3}));
    	System.out.println(solution.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
	}
}
