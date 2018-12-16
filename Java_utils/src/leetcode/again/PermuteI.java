package leetcode.again;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/permutations/
public class PermuteI {

	public List<List<Integer>> permute(int[] nums) {
		boolean seen[] = new boolean[nums.length];
		List<List<Integer>> ans = new ArrayList<>();
		dfs(nums, seen, new ArrayList<>(), ans);
		return ans;
	}
	
	void dfs(int nums[],boolean seen[],List<Integer> temp,List<List<Integer>> ans) {
		if(temp.size()==nums.length) {
			ans.add(new ArrayList<>(temp));
			return;
		}
		for(int i=0;i<nums.length;i++) {
			if(seen[i])continue;
			seen[i]=true;
			temp.add(nums[i]);
			dfs(nums, seen,temp, ans);
			temp.remove(temp.size()-1);
			seen[i]=false;
		}
	}
	public static void main(String[] args) {
		PermuteI solution = new PermuteI();
		System.out.println(solution.permute(new int[] {1,2,3}));
	}
}
