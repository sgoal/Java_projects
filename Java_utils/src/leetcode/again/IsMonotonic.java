package leetcode.again;

//https://leetcode.com/problems/monotonic-array/
public class IsMonotonic {
    public boolean isMonotonic(int[] A) {
        if(A.length<2)return true;
        int start = 0;
        int sign =0,n=A.length;
        while(start<n-1&&sign==0) {sign=A[start+1]-A[start];start++;}
        if(start==n-1)return true;
        for(int i=start;i<n-1;i++) {
        	if(sign<0) {
        		if(A[i+1]-A[i]>0)return false;
        	}
        	if(sign>0) {
        		if(A[i+1]-A[i]<0)return false;
        	}
        }
        return true;
    }
    public static void main(String[] args) {
    	IsMonotonic solution = new IsMonotonic();
    	System.out.println(solution.isMonotonic(new int[] {1,2,3,3,3,4,5}));
    	System.out.println(solution.isMonotonic(new int[] {1,1,1,1,}));
    	System.out.println(solution.isMonotonic(new int[] {5,4,2,1}));
    	System.out.println(solution.isMonotonic(new int[] {5,4,9,2,1}));
	}
}
