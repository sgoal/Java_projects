package leetcode.again;

public class MinFallingPathSum {
	/*
	 * dp[j] means min value of jumping to A[i][j-1]
		dp[j] = A[i][j-1] plus jump from left, straight, right( dp[j-1],dp[j],dp[j+1])
		I use 10000000(a large number) to initialize edge,because -100 <=A[i][j] <=100
	 */
	  public int minFallingPathSum(int[][] A) {
	   	   if(A[0].length==0)return 0;
		   int[] dp = new int[A[0].length+2];
		   int[] dp0 = new int[A[0].length+2];
		   dp[0]=1000000;dp[dp.length-1]=10000000;
		   dp0[0]=1000000;dp0[dp.length-1]=10000000;
		   int min = 1000000;
		   for(int i=0;i<A.length;i++) {
			   for(int j=1;j<dp.length-1;j++) {
				   dp0[j] = A[i][j-1] +
						   Math.min(Math.min(dp[j], dp[j+1]),dp[j-1]);
			   }
			   int temp[]=dp0;
			   dp0=dp;
			   dp=temp;
		   }
		   for(int j=1;j<dp.length-1;j++) min = Math.min(min, dp[j]);
		   return min;
	    }
	  
	  public int minFallingPathSum1(int[][] A) {
	   	 int n = A.length;
	   	 for(int i=1;i<n;i++)
	   		 for(int j=0;j<n;j++) {
	   			 int best = A[i-1][j];
	   			 if(j<n-1)
	   				 best = Math.min(best, A[i-1][j+1]);
	   			 if(j>0)
	   				 best = Math.min(best, A[i-1][j-1]);
	   			 A[i][j]+=best;
	   			 
	   		 }
	   	 int ans = Integer.MAX_VALUE;
	   	 for(int a:A[n-1])
	   		 ans = Math.min(ans, a);
	   	 return ans;
	  }

}
