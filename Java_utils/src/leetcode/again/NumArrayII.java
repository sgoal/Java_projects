package leetcode.again;

import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/range-sum-query-mutable/
public class NumArrayII {
	List<Integer> segmentTree;
	int[] data;
    public NumArrayII(int[] nums) {
        data = nums;
        segmentTree = new ArrayList<>(nums.length*2);
        int n = nums.length;
        for(int i=0;i<n;i++)segmentTree.add(0);
        for(int i=0;i<n;i++)segmentTree.add( nums[i]);
        for(int i=n-1;i>0;i--) {
        	segmentTree.set(i, segmentTree.get(i*2)+segmentTree.get(i*2+1));
        	}
    }
    
    public void update(int i, int val) {
    	i+=data.length;
    	segmentTree.set(i, val);
    	while(i>1) {
    		i/=2;
        	segmentTree.set(i, segmentTree.get(i*2)+segmentTree.get(i*2+1));
        }
    }
    
    public int sumRange(int i, int j) {
    	int n = data.length;
        i+=n;
        j+=n+1;
        int sum = 0;
        while(i<j) {
        	if((i&1)==1) {
        		sum+= segmentTree.get(i);
        		i++;
        	}
        	if((j&1)==1) {
        		j--;
        		sum+= segmentTree.get(j);
        	}
        	i/=2;j/=2;
        }
        return sum;
    }
    
    public static void main(String[] args) {
    	NumArrayII solution = new NumArrayII(new int[] {1,3,5});
    	System.out.println(solution.segmentTree);
    	System.out.println(solution.sumRange(0, 2));
	}
}