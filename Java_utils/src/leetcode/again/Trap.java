package leetcode.again;

import java.util.LinkedList;

//https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1047/
public class Trap {
	//brute force
	 public int trap1(int[] height) {
	     int ans = 0,n=height.length;
	     int maxLeft=0,maxRight=0;
	     for(int i=0;i<n;i++) {
	    	 maxLeft=height[i];maxRight=height[i];
	    	 for(int j=0;j<i;j++) {
	    		 maxLeft = Math.max(maxLeft, height[j]);
	    	 }
	    	 for(int j=i+1;j<n;j++) {
	    		 maxRight = Math.max(maxRight, height[j]);
	    	 }
	    	 ans+= Math.min(maxLeft, maxRight)-height[i];
	     }
		 return ans;
	}
	 //two pointer
	 public int trap2(int[] height) {
	     int ans = 0,n=height.length;
	     int maxLeft=0,maxRight=0;
	     int leftMaxIndex = 0,rightMaxIndex=0;
	     for(int i=0;i<n;i++) {
	    	 if(i==0||i>=rightMaxIndex||height[i]>=maxLeft) {
	    		 rightMaxIndex=i;leftMaxIndex=i;
	    		 for(int j=0;j<i;j++)
	    			 if(height[j]>=height[leftMaxIndex])
	    				 leftMaxIndex = j;
	    		 for(int j=i+1;j<n;j++)
	    			 if(height[j]>=height[rightMaxIndex])
	    				 rightMaxIndex = j;
	    		 maxLeft = height[leftMaxIndex];
	    		 maxRight = height[rightMaxIndex];
	    		// System.out.println(maxLeft+"   "+maxRight + "  " + i);
	    	 }
	    	 ans += Math.min(maxRight, maxLeft)-height[i];
	    	
	     }
		 return ans;
	}
	 //dp
	 public int trap3(int[] height) {
	     int ans = 0,n=height.length;
	     int[] dpLeft = new int[n];
	     int[] dpRight = new int[n];
	     int max = 0;
	     for(int i=0;i<n;i++)
	    	 dpLeft[i]=max = Math.max(max, height[i]);
	     max = 0;
	     for(int i=n-1;i>=0;i--)
	    	 dpRight[i]=max = Math.max(max, height[i]);
	     for(int i=0;i<n;i++) {
	    	 ans += Math.min(dpRight[i],dpLeft[i])-height[i];
	     }
		 return ans;
	}
	 //stack
    public int trap4(int[] height) {
      return 0;
    	
    }
    public static void main(String[] args) {
    	Trap solution = new Trap();
    	
//    	System.out.println(solution.trap(new int[] {2,1,0,1,3}));
//    	System.out.println(solution.trap(new int[] {2,1,0,0,3}));
//    	System.out.println(solution.trap(new int[] {0,1,0,2}));
    	System.out.println(solution.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
//    	System.out.println(solution.trap(new int[] {2,1,0,2}));
	}
}