package leetcode.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDuplicates {
	//O(n) sort
    public List<Integer> findDuplicates1(int[] nums) {
        for(int i=0;i<nums.length;i++) {
        	int last = -1;
        	while(nums[i]!=i+1) {
        		int j = nums[i]-1;
        		if(j==last)break;
        		//swap
        		last = nums[j];
        		nums[j]=nums[i];
        		nums[i]=last;
        		last = j;
        	}
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
        	if(nums[i]!=i+1) {
        		ans.add(nums[i]);
        	}
        }
        return ans;
    }
    //O(nlogn) sort
    public List<Integer> findDuplicates2(int[] nums) {
    	Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
        	if(i>0&&nums[i]==nums[i-1]) {
        		ans.add(nums[i]);
        	}
        }
        return ans;
    }
    //O(n) 
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
    	for(int i=0;i<nums.length;i++) {
    		int val = Math.abs(nums[i])-1;
    		if(nums[val]<0) {
    			ans.add(val+1);
    		}else {
    			nums[val] = -nums[val];
    		}
    		
    	}
        return ans;
    }
}
