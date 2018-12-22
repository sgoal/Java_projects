package leetcode.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
public class FindDisappearedNumbers {
	//sort,o(n)
    public List<Integer> findDisappearedNumbers1(int[] nums) {
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int last = -1;
			while (nums[i] != i + 1) {
				int j = nums[i] - 1;
				if (j == last) {
					break;
				}
				swap(i, j, nums);
				last = j;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				ans.add(i + 1);
			}
		}
		return ans;
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> ans = new ArrayList<>();
		
		for (int i = 0; i < nums.length; i++) {
			int val = Math.abs(nums[i])-1;
			if(nums[val]>0) {
				nums[val] = -nums[val];
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >0) {
				ans.add(i+ 1);
			}
		}
		return ans;
    }
    void swap(int i, int j, int[] nums) {
    	int t = nums[i];
    	nums[i]=nums[j];
    	nums[j]=t;
    }
    public static void main(String[] args) {
    	FindDisappearedNumbers solution = new FindDisappearedNumbers();
    	System.out.println(
    			solution.findDisappearedNumbers(new int[] {2,1,2,2}));
    	System.out.println(
    			solution.findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1}));
	}
}
