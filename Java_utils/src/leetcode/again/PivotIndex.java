package leetcode.again;

import java.util.Arrays;

//https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1144/
//https://leetcode.com/problems/find-pivot-index/
public class PivotIndex {
    public int pivotIndex1(int[] nums) {
    	if(nums.length==0)return -1;
    	if(nums.length==1)return 0;
    	
        int sums[] = new int[nums.length];
        sums[0]=nums[0];
       
        for(int i=1;i<sums.length;i++)
        	sums[i] = sums[i-1]+nums[i];
        System.out.println(Arrays.toString(sums));
        for(int j=0;j<sums.length;j++) {
        	int left = 0;
        	if(j>0) {left = sums[j-1];}
       
        	int right = sums[sums.length-1]-sums[j];
        	if(left==right)return j;
        }
        
        return -1;
    }
    public int pivotIndex(int[] nums) {
    	if(nums.length==0)return -1;
    	if(nums.length==1)return 0;
    	
        int sums[] = new int[nums.length+1];
        for(int i=1;i<sums.length;i++)
        	sums[i] = sums[i-1]+nums[i-1];
        System.out.println(Arrays.toString(sums));
        for(int j=1;j<sums.length;j++) {
        	int left = sums[j-1];
        	int right = sums[sums.length-1]-sums[j];
        	if(left==right)return j-1;
        }
        
        return -1;
    }
    public static void main(String[] args) {
		PivotIndex solution = new PivotIndex();
	System.out.println(solution.pivotIndex(new int[] {1,7,3,6,5,6}));
	System.out.println(solution.pivotIndex(new int[] {1,0}));
	System.out.println(solution.pivotIndex(new int[] {-1,-1,-1,0,1,1}));

	}
}
