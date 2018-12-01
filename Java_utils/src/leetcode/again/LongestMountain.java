package leetcode.again;
//https://leetcode.com/problems/longest-mountain-in-array/
public class LongestMountain {
    public int longestMountain(int[] A) {
        int n = A.length,index=0,res=0;
        while(index<n-1) {
        	
        	while(index<n-1&&A[index]>=A[index+1])index++;
        	int start = index;
        	while(index<n-1&&A[index]<A[index+1])index++;
        	if(index<n-1&&A[index]>A[index+1]) {
        	while(index<n-1&&A[index]>A[index+1])index++;
        	res = Math.max(res, index-start+1);
        	}
        
        }
        return res;
    }
    public static void main(String[] args) {
    	LongestMountain solution = new LongestMountain();
    	System.out.println(solution.longestMountain(
    			new int[] {2,1,4,7,3,2,5}));
    	System.out.println(solution.longestMountain(
    			new int[] {2,2,2}));
	}
}