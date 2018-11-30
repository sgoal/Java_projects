package leetcode.again;

import java.util.Arrays;

//https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1182/
public class RotateArray
 {
    public int[] rotate(int[] nums, int k) {
    	   if(nums == null || nums.length < 2){
    	        return nums;
    	    }
    	k%=nums.length;
       reserve(nums, 0, nums.length-k-1);
       reserve(nums, nums.length-k, nums.length-1);
       reserve(nums, 0, nums.length-1);
        return nums;
    }
    
    void reserve(int[] nums,int i, int j) {
    	while(i<j) {
    		int temp = nums[i];
    		nums[i++]=nums[j];
    		nums[j--]=temp;
    		
    	}
    }
    
    
    public static void main(String[] args) {
    	RotateArray solution = new RotateArray();
    	;
    	System.out.println(Arrays.toString(solution.rotate(new int[] {1, 2,3,4,5,6,7},3)));
	}
}
