package leetcode.again;

import java.util.Arrays;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
    	if(matrix.length==0)return 0;
    	int n=matrix.length,m=matrix[0].length;
        int[][] dp = new int[n][m];
        int res = 0;
        for(int i=0;i<n;i++)
        	for(int j=0;j<m;j++) {
        		if(matrix[i][j]=='1') {
        		if(i==0||j==0) {dp[i][j]=1;}
        		else
        			dp[i][j]=1+Math.min(
        				Math.min(dp[i-1][j-1], dp[i][j-1]),
        				dp[i-1][j]); 
        		res = Math.max(res, dp[i][j]);
        		} 		
        	}
//        for(int i=0;i<n;i++)
//        	System.out.println(Arrays.toString(dp[i]));
        return res*res;
    }
    public static void main(String[] args) {
		char[][] ma = new char[][] {
			{'1','0','1','0','0'},
			{'1','0','1','1','1'},
			{'1','1','1','1','1'},
			{'1','0','0','1','0'}};
			MaximalSquare solution = new MaximalSquare();
			System.out.println(solution.maximalSquare(ma));
			System.out.println(solution.maximalSquare(new char[][] {{'1'},}));
	}
}
