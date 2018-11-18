package leetcode.again;

import java.util.Arrays;

public class NumArray {
	int dp[];
    public NumArray(int[] nums) {
    	//dp[i+1] = sum(num[0....i]
        dp = new int[nums.length+1];
        for(int i=1;i<=nums.length;i++) {
        	dp[i] = dp[i-1]+nums[i-1];
        }
    }
    
    public int sumRange(int i, int j) {
        return dp[j+1]-dp[i];
    }
    
    public static void main(String[] args) {
		NumArray solution = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
		System.out.println(Arrays.toString(solution.dp));
		System.out.println(solution.sumRange(0, 2));
    }
}
