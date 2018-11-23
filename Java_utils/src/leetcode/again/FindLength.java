package leetcode.again;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 * @author sgoal
 *
 */
public class FindLength {
    public int findLength(int[] A, int[] B) {
    	int dp[][] = new int[A.length+1][B.length+1];//means longest from A[i:],B[j:]
    	int res = 0;
    	for(int i=A.length-1;i>=0;i--)
    		for(int j=B.length-1;j>=0;j--) {
    			if(A[i]==B[j]) {
    				dp[i][j] = dp[i+1][j+1] + 1;
    				res = Math.max(res, dp[i][j]);
    				System.out.println("------------------");
    				System.out.println(Arrays.toString(Arrays.copyOfRange(A, i,A.length)));
    				System.out.println(Arrays.toString(Arrays.copyOfRange(B, j,B.length)));
    			}
    		}
        return res;
    }
    
    public int findLength1(int[] A, int[] B) {
    	int dp[] = new int[B.length+1];//means longest from A[i:],B[j:]
    	int dp0[] = new int[B.length+1];//means longest from A[i:],B[j:]
    	int res = 0;
    	for(int i=A.length-1;i>=0;i--) {
    		for(int j=B.length-1;j>=0;j--) {
    			if(A[i]==B[j]) {
    				dp [j] = dp0[j+1] + 1;
    				res = Math.max(res, dp[j]);
    				System.out.println(res);
    				System.out.println("------------------");
    				System.out.println(Arrays.toString(Arrays.copyOfRange(A, i,A.length)));
    				System.out.println(Arrays.toString(Arrays.copyOfRange(B, j,B.length)));
    			}else {
    				dp[j]=0;
    			}
    		}
    		int temp[] = dp0;
    		dp0 = dp;
    		dp = temp;
    		}
        return res;
    }
    
    public static void main(String[] args) {
    	FindLength solution = new FindLength();
    	System.out.println(solution.findLength1(new int[] {1,0,0,0,1,0,0,1,0,0}, new int[] {0,1,1,1,0,1,1,1,0,0}));
//    	System.out.println(solution.findLength1(new int[] {1,2,3,2,1}, new int[] {3,2,1,4,7}));
	}
}