package leetcode.again;

public class  MaxProduct {
    public int maxProduct(int[] nums) {
    	if(nums.length==0)return 0;
    	long last_max=nums[0],last_min = nums[0];
    	long res = nums[0];
        for(int i=1;i<nums.length;i++) {
        	//last_max = Math.max(last_max, Math.max(nums[i]*last_max, nums[i]*last_min));
        	long temp = last_max;
        	last_max = Math.max(nums[i]*last_max, Math.max(nums[i], nums[i]*last_min));
        	last_min = Math.min(nums[i]*temp, Math.min(nums[i], nums[i]*last_min));
        	res = Math.max(res, last_max);
        }
        return (int) res;
    }
    public static void main(String[] args) {
    	MaxProduct solution = new MaxProduct();

    	System.out.println(solution.maxProduct(new int[] {2,3,-2,4}));
    	System.out.println(solution.maxProduct(new int[] {-1,-4,5,6}));
    	System.out.println(solution.maxProduct(new int[] {-1,0,-4,}));
	}
}
