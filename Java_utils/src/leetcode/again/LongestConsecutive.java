package leetcode.again;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0)return 0;
        Set<Integer> set = Arrays.stream(nums).mapToObj(Integer::valueOf).collect(Collectors.toSet());
        int ans = 0;
        for(int i:nums) {
        	if(!set.contains(i-1)) {
        		int temp = 1;
        		while(set.contains(i+temp)) {
        			temp++;
        		}
        		ans = Math.max(ans, temp);
        	}
        	
        }
  
        return ans;
    }

    public int longestConsecutive2(int[] nums) {
    	 int n = nums.length;
         if(n==0)return 0;
         Arrays.sort(nums);
         int ans = 0;
         int temp = 0;
         for(int i=0;i<nums.length;i++) {
        	 if(i==0)temp++;
        	 else {
				if(nums[i]==nums[i-1]+1) {
					temp++;
				}else if(nums[i]==nums[i-1]){
					
				}else {
					ans = Math.max(ans, temp);
					temp = 1;
				}
				
			}
         }
         return Math.max(ans, temp);
    }
    public static void main(String[] args) {
		int[] n=new int[] {100, 4, 200, 1, 3, 2};
		LongestConsecutive solution = new LongestConsecutive();
		System.out.println(solution.longestConsecutive(n));
		System.out.println(solution.longestConsecutive(new int[] {2,2,2}));
		System.out.println(solution.longestConsecutive(new int[] {1,2,0,1}));
		System.out.println(solution.longestConsecutive(new int[] {1,3,5,2,4}));
		System.out.println(solution.longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1}));
	}
}