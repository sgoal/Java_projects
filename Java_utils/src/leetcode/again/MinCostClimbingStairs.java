package leetcode.again;

public class MinCostClimbingStairs {
	public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length+2];
        for(int i=2;i<=cost.length;i++) {
        	//System.out.println(i);
        	dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
        }
        
        return Math.min(dp[cost.length], 
        		dp[cost.length-1]+cost[cost.length-1]);
    }
	public static void main(String[] args) {
		MinCostClimbingStairs solution = new MinCostClimbingStairs();
		System.out.println(solution.minCostClimbingStairs(
				new int[] {10, 15, 20}));
		System.out.println(solution.minCostClimbingStairs(
				new int[] {0, 0, 0,1}));
	}
}
