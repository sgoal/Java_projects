package leetcode.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PermuteII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] seen = new boolean[nums.length];
        dfs(nums, seen, new ArrayList<>(), ans);
        return ans;
    }
    void dfs(int[] nums,boolean[] seen,List<Integer> temp,
    		List<List<Integer>> ans) {
    	if(temp.size()==nums.length) {
    		ans.add(new ArrayList<>(temp));
    		return;
    	}

    	for(int i=0;i<nums.length;i++) {
    		if(seen[i])continue;
    		if(i>0&&!seen[i-1]&&nums[i]==nums[i-1])continue;
    		seen[i]=true;
    		temp.add(nums[i]);
//    		System.out.println(temp);
    		dfs(nums, seen, temp, ans);
    		temp.remove(temp.size()-1);
    		seen[i]=false;
    	}
    }
    
    public static void main(String[] args) {
    	PermuteII solution = new PermuteII();
    	System.out.println(solution.permuteUnique(new int[] {1,2,1}));
	}
   
}