package leetcode.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1046/
public class GetPermutation {
	
	public String getPermutation(int n, int k) {
		String ans = "";
		int[] factors = new int[n+1];
		factors[0]=1;
		for(int i=1;i<=n;i++) {
			factors[i]=factors[i-1]*i;
		}
		List<Integer> nums = new LinkedList<>();
		for(int i=1;i<=n;i++)nums.add(i);
//		System.out.println(Arrays.toString(factors));
		k--;
		for(int i=1;i<=n;i++) {
			int next = k/factors[n-i];
			ans += nums.get(next);
			nums.remove(next);
			k %=factors[n-i];
		}
        return ans;
    }
	
	
    String res = "";
    int num = 0;
	public String getPermutation1(int n, int k) {
		res = "";
		boolean[] seen = new boolean[n+1];
		helper(1, "", 0, n, k,seen);
        return res;
    }
	boolean helper(int index, String temp, int step, int n, int k,boolean[] seen) {
        if(num==k) {
        	res=temp;
        	return true;
        }

        for(int i=1;i<=n;i++) {
        	if(seen[i])continue;
        	seen[i]=true;
            if(temp.length()==n-1)
            	num++;
        	if(helper(index+1, temp+i, step, n, k,seen)) {
        		return true;
        	}
        	seen[i]=false;
        }
        return false;
    }
	public static void main(String[] args) {
		GetPermutation solution = new GetPermutation();
		System.out.println(solution.getPermutation(3, 5));
	}
}
