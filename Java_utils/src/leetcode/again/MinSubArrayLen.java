package leetcode.again;

public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
    	if(nums.length==0)return 0;
        int sums[] = new int[nums.length];
        sums[0]=nums[0];
        for(int i=1;i<nums.length;i++)sums[i]=nums[i]+sums[i-1];
        int res = nums.length;
        if(sums[sums.length-1]<s)return 0;
        for(int i=0,j=0;j<nums.length;) {
        	while(j<nums.length&&sums[j]-sums[i]<s) {
        		j++;
        	}
        	res = Math.min(res, j-i);
        	while(j<nums.length&&i<j&&sums[j]-sums[i]>s) {
        		i++;
        	}
        	
        }
        return res;
    }
    public static void main(String[] args) {
    	MinSubArrayLen solution = new MinSubArrayLen();
    	System.out.println(solution.minSubArrayLen(5, new int[] {2,3,1,2,4,3}));
	}
}
