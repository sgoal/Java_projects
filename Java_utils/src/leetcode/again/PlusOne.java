package leetcode.again;

import java.util.Arrays;

//https://leetcode.com/problems/plus-one/
//https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1148/
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int c= 1;
    	for(int i=digits.length-1;i>=0;i--) {
        	digits[i]+=c;
        	c = digits[i]/10;
        	digits[i] %=10;
        }
    	if(c>0) {
    		int res[] = new int[digits.length+1];
    		res[0]=c;
    		for(int i=1;i<=digits.length;i++)
    			res[i]=digits[i-1];
    		return res;
    	}
    	return digits;
    }
    
    public static void main(String[] args) {
		PlusOne solution  = new PlusOne();
		System.out.println(Arrays.toString(solution.plusOne(new int[] {9,9,9})));
		System.out.println(Arrays.toString(solution.plusOne(new int[] {1,1,9})));
	}
}