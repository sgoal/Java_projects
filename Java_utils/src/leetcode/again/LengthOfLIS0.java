package leetcode.again;

import java.util.Arrays;

//https://leetcode.com/problems/longest-increasing-subsequence/
public class LengthOfLIS0 {
    public int lengthOfLIS0(int[] nums) {
    	int n= nums.length;
    	if(n==0)return 0;
        int dp[] = new int[n];
        int len=0;
        for(int i=0;i<n;i++) {
        	int pos = Arrays.binarySearch(dp, 0, len, nums[i]);
        	System.out.println(pos+"   ");
        	if(pos<0)pos = -(pos+1);
        	dp[pos]=nums[i];
        	if(pos==len) {
        		len++;
        	}
            System.out.println(pos+" "+Arrays.toString(dp));
        }
        System.out.println(Arrays.toString(dp));
        return len;	
        
    }
    public int lengthOfLIS(int[] nums) {
    	int n= nums.length;
    	if(n==0)return 0;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int ans = 0;
        for(int i=0;i<n;i++) {
        	for(int j=0;j<i;j++) {
        		if(nums[i]>nums[j]) {
        			dp[i]=Math.max(dp[i], dp[j]+1);
        		}
        	}
        	ans = Math.max(ans, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return ans;	
        
    }
    public static void main(String[] args) {
    	LengthOfLIS0 solution = new LengthOfLIS0();
    	System.out.println(solution.lengthOfLIS0(new int[] {10,9,2,5,3,7,101,18}));
	}
}