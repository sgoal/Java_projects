package leetcode.again;

import java.util.HashSet;

//https://leetcode.com/problems/bitwise-ors-of-subarrays/
public class SubarrayBitwiseORs {
    public int subarrayBitwiseORs(int[] A) {
    	HashSet<Integer> seen = new HashSet<>(),res = new HashSet<>();
    	int n=A.length;
    	seen.add(0);
    	for(int i=0;i<n;i++) {
    		HashSet<Integer> seen1 = new HashSet<>();
    		for(int v:seen)seen1.add(A[i]|v);
    		seen1.add(A[i]);
    		seen = seen1;
    		res.addAll(seen);
    	}
    	return res.size();
        
    }
    public static void main(String[] args) {
    	SubarrayBitwiseORs solution = new SubarrayBitwiseORs();
    	System.out.println(solution.subarrayBitwiseORs(new int[] {1,2,4}));
    	System.out.println(solution.subarrayBitwiseORs(new int[] {1,1,2}));
    	System.out.println(solution.subarrayBitwiseORs(new int[] {3,11}));
    	System.out.println(solution.subarrayBitwiseORs(new int[] {12,10}));
	}
}