package leetcode.again;

//https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1151/
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int end = 0, index=0;
        while(end<nums.length&&nums[end]!=val)end++;
        if(end==nums.length)return end;
        for(index=end+1;index<nums.length;index++) {
        	if(nums[index]!=val) {
        		nums[end++]=nums[index];
        		nums[index]=val;
        	}
        	while(end<nums.length&&nums[end]!=val)end++;
        }
        return end;
    }
}
