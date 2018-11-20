package leetcode.again;

public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
    	if(A.length<3)return false;
    	if(A[0]>A[1])return false;
    	boolean small=true;
    	for(int i=1;i<A.length;i++) {
    		if(A[i]-A[i-1]==0)return false;
    		if(small) {
    			if(A[i]<A[i-1])small=false;
    		}else{
    			if(A[i]>A[i-1])return false;
    		}
    		
    	}
    	
        return !small;
    }
}
