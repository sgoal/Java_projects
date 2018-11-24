package leetcode.again;

import java.util.Arrays;

//https://leetcode.com/problems/find-the-duplicate-number/
public class FindDuplicate {
	public int findDuplicate(int[] nums) {
		Arrays.sort(nums);
		for(int i=0;i<nums.length-1;i++)
			if(nums[i]==nums[i+1])
				return nums[i];
		return 0;
    }
	
	public int findDuplicate1(int[] nums) {
		int hare = nums[0];
		int tortoise = nums[0];
		do {
			hare = nums[nums[hare]];
			tortoise = nums[tortoise];
		}while(hare!=tortoise);
		int ptr1=nums[0];
		int ptr2 = tortoise;
		while(ptr1!=ptr2){
			ptr2= nums[ptr2];
			ptr1 = nums[ptr1];
		}
		
		return ptr1;
    }
}
