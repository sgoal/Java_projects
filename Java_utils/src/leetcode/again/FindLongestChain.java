package leetcode.again;

import java.util.Arrays;

public class FindLongestChain {
    public int findLongestChain(int[][] pairs) {
    	if(pairs.length==0)return 0;
        Arrays.sort(pairs, (x,y)->x[0]-y[0]);
        //System.out.println(Arrays.toString(Arrays.stream(pairs).flatMapToInt(x->Arrays.stream(x)).toArray()));
        int dp[] = new int[pairs.length];
        Arrays.fill(dp, 1);

        //pairs[x][1] < pairs[x][1] 
        for(int i=1;i<pairs.length;i++) {
        	for(int j=0;j<i;j++) {
        		if(pairs[i][0]>pairs[j][1]) {
        			dp[i] = Math.max(dp[i], dp[j]+1);
        		}else {
        			dp[i] = Math.max(dp[i], dp[j]);
        		}
        	}
        }
        return dp[dp.length-1];
    }
    public static void main(String[] args) {
		FindLongestChain solution = new FindLongestChain();
		int a = solution.findLongestChain(new int[][] {{1,3},{6,7},{2,3}});
		System.out.println(a);
		a = solution.findLongestChain(new int[][] {{1,2},{3,4},{2,3}});
		System.out.println(a);
		a = solution.findLongestChain(new int[][] {{-10,-8},{8,9},{-5,0},{6,10},{-6,-4},{1,7},{9,10},{-4,7}});
		System.out.println(a);

	}
}