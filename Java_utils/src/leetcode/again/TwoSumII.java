package leetcode.again;

import java.util.Arrays;
//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
//https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1153/
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length<2)return new int[0];
    	int start = 0,end = numbers.length-1;
    	while(start<end) {
    		int temp = numbers[start]+numbers[end];
    		if(temp==target)return new int[] {start+1,end+1};
    		else if (temp>target) {
				end--;
			}else {
				start++;
			}
    	}
    	return new int[0];
    }
    public static void main(String[] args) {
    	TwoSumII solution = new TwoSumII();
    	System.out.println(Arrays.toString(solution.twoSum(new int[] {6,7}, 9)));
    	System.out.println(Arrays.toString(solution.twoSum(new int[] {2,7,11,15}, 9)));
    	System.out.println(Arrays.toString(solution.twoSum(new int[] {2,7,11,15}, 10)));
	}
}