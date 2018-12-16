package leetcode.again;

import java.util.Arrays;

//https://leetcode.com/problems/next-permutation/
public class NextPermutation {
    public void nextPermutation(int[] nums) {
       int index =nums.length-2;
       while(index>=0&&nums[index]>=nums[index+1])index--;
       if(index>=0) {
    	   int temp = nums.length-1;
    	   while(nums[temp]<=nums[index]) {
    		   temp--;
    	   }
    	   swap(nums,index,temp);
       }
       int end = nums.length-1;
       while(index<end) {
    	   swap(nums,++index,end--);
       }
    }
    void swap(int nums[], int i, int j) {
    	int temp = nums[i];
    	nums[i]=nums[j];
    	nums[j]=temp;
    }
    
    public static void main(String[] args) {
    	NextPermutation solution = new NextPermutation();
    	int[] temp = new int [] {1,2,3,2};
    	solution.nextPermutation(temp);
    	System.out.println(Arrays.toString(temp));
    	
    	temp = new int [] {3,2,1};
    	solution.nextPermutation(temp);
    	System.out.println(Arrays.toString(temp));
    	
    	temp = new int [] {1,3,2};
    	solution.nextPermutation(temp);
    	System.out.println(Arrays.toString(temp));
	}
}