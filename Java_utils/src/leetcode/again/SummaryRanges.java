package leetcode.again;

import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/summary-ranges/
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length==0)return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        int start = 0;
        int n = nums.length;
        for(int i=0;i<n;i++) {
        	if (i==n-1) {
				ans.add(start==i?String.valueOf(nums[start]):nums[start]+"->"+nums[i]);
			}else {
				if(nums[i]+1!=nums[i+1]) {
					ans.add(start==i?String.valueOf(nums[start]):nums[start]+"->"+nums[i]);
					start = i+1;
				}
			}
        }
        return ans;
    }
    public static void main(String[] args) {
    	SummaryRanges solution = new SummaryRanges();
    	System.out.println(solution.summaryRanges(new int[] {0,1,2,4,5,7}));
    	System.out.println(solution.summaryRanges(new int[] {0,2,3,4,6,8,9}));
    	System.out.println(solution.summaryRanges(new int[] {0}));
    	
	}
}