package leetcode.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	
    public List<List<Integer>> threeSum(int[] nums) {
    	Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int start = 0, end = nums.length-1;
        for(int i=0;i<nums.length;i++) {
        	if(i>0&&nums[i]==nums[i-1])continue;
        	start = i+1;end=nums.length-1;
        	while(start<end) {
        		System.out.println(start + "  " + end);
        		if(nums[start]+nums[end]+nums[i]==0) {
        			res.add(Arrays.asList(nums[i],nums[start++],nums[end--]));
//        			System.out.println(res);
        			while(end>=start&&nums[end]==nums[end+1])end--;
        			while(end>=start&&nums[start]==nums[start-1])start++;
        		}else if(nums[start]+nums[end]+nums[i]>0) {
        			end--;
        		}
        		else {
					start++;
				}
        	}

        }
        return new ArrayList<>(res);
    }
	
    //TLE
    public List<List<Integer>> threeSum1(int[] nums) {
    	Arrays.sort(nums);
    	System.out.println(Arrays.toString(nums));
        boolean[] used = new boolean[nums.length];
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums, 0, 0, used, temp,0, res);
        return new ArrayList<>(res);
    }
    
    void helper(int[] num, int index, int step, boolean[] used,
    		List<Integer> temp, int tempSum, Set<List<Integer>> res) {

    	if(tempSum ==0&&step==3) {
    		List<Integer> t = new ArrayList<>(temp);
    		Collections.sort(t);
    		res.add(t);
    		return;
    	}
    	if(index>=num.length)return;
    	if(step>0&&(tempSum>0))return;
    	if(step>=3)return;
    	for(int i=index;i<num.length;i++) {
    		if(used[i])continue;
//    		if(i>0&&num[i-1]==num[i])continue;
    		used[i]=true;
    		temp.add(num[i]);
    		helper(num, i+1, step+1, used, temp,tempSum+num[i], res);
    		temp.remove(step);
    		used[i]=false;
    	}
    	
    }
    public static void main(String[] args) {
    	ThreeSum solution = new ThreeSum();
    System.out.println(solution.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
    System.out.println(solution.threeSum(new int[] {0,0,0,0}));
	}
}
