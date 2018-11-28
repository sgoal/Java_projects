package leetcode.again;

import java.util.Arrays;

//https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
public class FindUnsortedSubarray {
	//O(nlogn)
    public int findUnsortedSubarray(int[] nums) {
        int[] temp = Arrays.copyOf(nums,nums.length);
        Arrays.sort(temp);
        int i=0,j=nums.length-1;
        while(i<=j&&temp[i]==nums[i]) {i++;}
        while(i<=j&&temp[j]==nums[j]) {j--;}
        if(j<i)return 0;
        return j-i+1;
        
    }
   
}
