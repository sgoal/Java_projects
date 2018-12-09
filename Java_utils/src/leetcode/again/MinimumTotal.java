package leetcode.again;

import java.util.Arrays;
import java.util.List;

public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
    	if(triangle.size()==0)return 0;
    	int n = triangle.size();
    	int m = triangle.get(n-1).size();
    	int dp[][] = new int[n][triangle.get(n-1).size()];
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
        	List<Integer> line = triangle.get(i);
                    	m = line.size();
        	for(int j=0;j<line.size();j++) {
        		if(i==0)dp[i][j]=line.get(j);
        		else if(i>0&&(j==0))dp[i][j]=dp[i-1][j]+line.get(j);
                else if(i>0&&(j==m-1))dp[i][j]=dp[i-1][j-1]+line.get(j);
        		else if(i>0&&j>0) {
        			dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1])+line.get(j);
        		}
        	}
                    	// System.out.println(Arrays.toString(dp[i]));
        	}
        for(int j=0;j<m;j++)ans=Math.min(ans, dp[n-1][j]);
        return ans;
    }
}