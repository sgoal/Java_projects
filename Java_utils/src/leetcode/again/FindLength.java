package leetcode.again;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 * @author sgoal
 *
 */
public class FindLength {
    public int findLength(int[] A, int[] B) {
    	if(A.length<B.length) {int temp[]=A;A=B;B=temp;}
        Map<Integer, Long> map = Arrays.stream(B).boxed().collect(Collectors.groupingBy(x->x, Collectors.counting()));
    	int begin=0,end=0;
    	int counter = 0;
    	while(end<A.length) {
    		
    	}
        return 0;
    }
    
    public static void main(String[] args) {
    	FindLength solution = new FindLength();
    	System.out.println(solution.findLength(new int[] {1,2,3,2,1}, new int[] {3,2,1,4,7}));
	}
}