package leetcode.again;

import java.util.Arrays;

//https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1173/
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
    	if(nums.length==0)return 0;
        int end = 0,start = 1;
        while(start<nums.length) {
        	if(nums[end]!=nums[start]) {
        		nums[++end]=nums[start];
        	}
        	start++;
        }
        return end+1;
    }
    public static void main(String[] args) {
    	RemoveDuplicates solution  = new RemoveDuplicates();
    	int [] temp = new int[] {0,0,1,2,2,3,4,4,5};
    	System.out.println(solution.removeDuplicates(temp));
    	System.out.println(Arrays.toString(temp));
    	System.out.println(solution.removeDuplicates(new int[0]));
    	System.out.println(solution.removeDuplicates(new int[1]));
	}
}
