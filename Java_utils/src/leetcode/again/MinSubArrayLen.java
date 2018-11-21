package leetcode.again;

public class MinSubArrayLen {
    public int minSubArrayLen1(int s, int[] nums) {
    	if(nums.length==0)return 0;
        int sums[] = new int[nums.length+1];
        for(int i=1;i<sums.length;i++)sums[i]=nums[i-1]+sums[i-1];
        int res = nums.length;
        if(sums[sums.length-1]<s)return 0;
        for(int i=1,j=1;j<sums.length;) {
        	while(j<sums.length&&sums[j]-sums[i-1]<s) {
        		j++;
        	}
        	System.out.println(j+" 2 "+i);
        	if(j<sums.length&&sums[j]-sums[i-1]>=s)
        		res = Math.min(res, j-i+1);
        	while(j<sums.length&&i<j&&sums[j]-sums[i-1]>=s) {
        		i++;
        		res = Math.min(res, j-i+1);
        		System.out.println(j+" 1 "+i);
        	}
        	
        	
        }
        return res;
    }
    public int minSubArrayLen(int s, int[] nums) {
    	if(nums.length==0)return 0;
    	int res = Integer.MAX_VALUE,sum=0;
    	int i=0,j=0;
    	while(j<nums.length) {
    		sum+= nums[j++];
    		while(sum>=s&&i<j) {
    			res = Math.min(res, j-i);//j have j++
    			sum -= nums[i];
    			i++;
    			
    		}
    		
    	}
        return res==Integer.MAX_VALUE?0:res;
    }
    public static void main(String[] args) {
    	MinSubArrayLen solution = new MinSubArrayLen();
    	System.out.println(solution.minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
    	System.out.println(solution.minSubArrayLen(5, new int[] {2,3,1,1,1,1,1}));
	}
}
