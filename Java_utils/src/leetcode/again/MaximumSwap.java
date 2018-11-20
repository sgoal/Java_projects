package leetcode.again;

public class MaximumSwap {
	//The given number is in the range [0, 108],不会溢出
	public int maximumSwap(int num) {
	 char[] nums = Integer.toString(num).toCharArray();
	 int max=-1,min=-1;
	 int max_index = 0;
	 for(int i=nums.length-1;i>=0;i--) {
		 if(nums[i]>max) {
			 max = nums[i];
			
			 continue;
		 }
		 if(nums[i]<max) {
			 min = i;
			 max_index = i;
		 }
	 }
	 
	 if(min!=-1) {
	 char temp = nums[min];
	 nums[min]=nums[max_index];
	 nums[max_index]=temp;
	 }
	
	 
       return Integer.valueOf(new String(nums));
    }
    public int maximumSwap1(int num) {
    	int n = 1;
    	int nu=1;
    	while(n*10<=num) {
    		n*=10;
    		nu++;
    	}
    	System.out.println(nu);
    	int res = num;
    	for(int i=0;i<nu;i++) {
    		for(int j=0;j<nu;j++) {
    			int temp = swap(num, i, j);
    			if(swap(num, i, j)>res)res = temp;
    		}
    	}
       return res;
    }
    int swap(int a, int li, int lj) {
    	int temp = (int) Math.pow(10, li);
    	int temp1 = (int) Math.pow(10, lj);
    	int i = (a/temp)%10;
    	int j = (a/temp1)%10;
    	temp = temp*(j-i);
    	temp1 = temp1*(i-j);
    	return a+temp1+temp;
    }

    public static void main(String[] args) {
    	MaximumSwap s = new MaximumSwap();
    	System.out.println(s.maximumSwap(
    			9193));
      	System.out.println(s.maximumSwap(
    			1993));
     	System.out.println(s.maximumSwap(
     			99901));
      	
    	System.out.println(s.maximumSwap(45219));
		System.out.println(s.swap(2713, 0, 2));
		System.out.println(Integer.MAX_VALUE);
	}
}
