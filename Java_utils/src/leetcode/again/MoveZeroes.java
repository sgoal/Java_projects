package leetcode.again;

import java.util.Arrays;
//https://leetcode.com/problems/move-zeroes/
//https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1174/
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if(nums.length==0)return;
        int z=0,end=0,n=nums.length;
        while(z<n&&end<n) {
        	while(z<n&&nums[z]!=0)z++;
        	while(end<n&&nums[end]==0)end++;
        	if(z<end&&z<n&&end<n) {
        		nums[z++]=nums[end];
        		nums[end++]=0;
        	}else {
				end++;
			}
        }
    }
    public static void main(String[] args) {
    	MoveZeroes solution = new MoveZeroes();
    	int[] temp = new int[] {0,1,0,2,3,4,0,5,6};
    	solution.moveZeroes(temp);
    	System.out.println(Arrays.toString(temp));
	}
}
