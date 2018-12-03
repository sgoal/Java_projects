package leetcode.again;

import java.util.Arrays;

//https://leetcode.com/problems/knight-dialer/
public class KnightDialer {
	int moves[][] = new int[][] { { 4, 6 }, { 6, 8 }, { 7, 9 }, { 4, 8 }, { 0, 3, 9 }, // 0-4
			{}, { 0, 1, 7 }, { 2, 6 }, { 1, 3 }, { 2, 4 }// 5-9
	};

	public int knightDialer(int N) {
		if (N == 1)
			return 10;
		long ans = 0;
		int mod = 1_000_000_007;
		int dp[][] = new int[N][10];
		Arrays.fill(dp[0], 1);
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int n : moves[j])
					dp[i][j] = (dp[i][j]+dp[i - 1][n])%mod;
			}
		}
		for(long a:dp[N-1])
			ans +=a;
		ans %=mod;	
		return (int) ans;
	}
	
	public int knightDialer1(int N) {
		if (N == 1)
			return 10;
		long dp[] = new long[10];
        long dp1[] = new long[10];
        Arrays.fill(dp, 1);
        dp[5]=0;
        int mod = 1_000_000_007;
        for( int i=0;i<N-1;i++) {
        	dp1[0]=(dp[4]+dp[6])%mod;
        	dp1[1]=(dp[6]+dp[8])%mod;
        	dp1[2]=(dp[7]+dp[9])%mod;
        	dp1[3]=(dp[4]+dp[8])%mod;
        	dp1[4]=(dp[0]+dp[3]+dp[9])%mod;
        	dp1[6]=(dp[0]+dp[1]+dp[7])%mod;
        	dp1[7]=(dp[2]+dp[6])%mod;
        	dp1[8]=(dp[1]+dp[3])%mod;
        	dp1[9]=(dp[2]+dp[4])%mod;
        	long[] temp = dp;
        	dp=dp1;
        	dp1 = temp;
          }
        long ans = 0;
		for(long a:dp)
			ans =(ans+a)%mod;
		ans %=mod;	
		return (int) ans;
	}
	public static void main(String[] args) {
		KnightDialer solution = new KnightDialer();
//		System.out.println(solution.knightDialer1(1));
//		System.out.println(solution.knightDialer1(2));
		System.out.println(solution.knightDialer1(3));
		System.out.println(solution.knightDialer(4));
		System.out.println(solution.knightDialer1(4));
		System.out.println(solution.knightDialer1(161));
		System.out.println(solution.knightDialer(161));
//		System.out.println(solution.knightDialer1(1000));
		
	}
}