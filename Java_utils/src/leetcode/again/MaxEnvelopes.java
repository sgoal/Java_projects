package leetcode.again;

import java.util.Arrays;

public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
    	if(envelopes.length==0)return 0;
    	Arrays.sort(envelopes, (int[]x,int[]y)->x[0]==y[0]?x[1]-y[1]:x[0]-y[0]);
    	Arrays.stream(envelopes).forEach(x->{System.out.println(Arrays.toString(x));});
//    	System.out.println(Arrays.toString(envelopes[0]));
    	int dp[] = new int[envelopes.length];
    	Arrays.fill(dp, 1);
    	int ans = 0;
    	for(int i=0;i<envelopes.length;i++) {
    		
    		for(int j=0;j<i;j++) {
    			int[] cur = envelopes[j];
	    		if(envelopes[i][0]>cur[0]&&envelopes[i][1]>cur[1]) {
	    			dp[i] = Math.max(dp[j]+1, dp[i]);
	    		}
    		}
    		ans = Math.max(ans, dp[i]);
    	}
    	return ans;
    }
    public static void main(String[] args) {
    	MaxEnvelopes solution = new MaxEnvelopes();
//    	System.out.println(solution.maxEnvelopes(new int[][] 
//    		{{5,4},{6,4},{6,7},{2,3}}));
	
  	System.out.println(solution.maxEnvelopes(new int[][] 
  		   {{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}}));
	}
 
}
