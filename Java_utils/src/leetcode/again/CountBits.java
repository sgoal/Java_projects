package leetcode.again;

import java.util.Arrays;

public class CountBits {
    public int[] countBits(int num) {
    	/**
    	 * as you see, 3->11 (2+1) ,9 ->1001(8+1) ,10->1010 (8+2),11->1011 (8+3)
		 *bits of num can be (bits of 2^N) one plus bits of (num-2^N)
		 *so just find the right 2^N, you will find solution.
    	 */
    	if(num==0)return new int[1];
    	int counts[] = new int[num+1];
    	int base = 2;
    	counts[1]=1;
    	for(int i=2;i<=num;i++) {
    		counts[i] = 1 + counts[i-base];
    		if(base*2<=i+1)base*=2;
    	}
    	return counts;
    }
    
    public static void main(String[] args) {
		CountBits countBits = new CountBits();
		System.out.println(Arrays.toString(countBits.countBits(11))
				);
	}
}
