package leetcode.again;

import java.util.Arrays;
//https://leetcode.com/problems/array-partition-i/
//https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1154/
public class ArrayPairSumI {
    public int arrayPairSum(int[] nums) {
        if(nums.length==0)return 0;
        Arrays.sort(nums);
        int l = nums.length/2;
        int sum = 0;
        for(int i=0;i<=l;i++) {
        	sum += nums[i*2];
        }
        return sum;
    }
}
