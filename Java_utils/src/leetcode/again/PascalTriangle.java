package leetcode.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1170/
public class PascalTriangle
 {
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> res = new ArrayList<>();
    	if(numRows>=1)res.add(Arrays.asList(1));
//    	if(numRows>=2)res.add(Arrays.asList(1,1));
    	for(int i=1;i<numRows;i++) {
    		List<Integer> last = res.get(i-1);
    		List<Integer> now =new ArrayList<>(last.size()+1);
    		now.add(1);
    		for(int j=1;j<i;j++) {
    			now.add(last.get(j-1)+last.get(j));
    		}
    		now.add(1);
    		res.add(now);
    	}
    	return res;
    }
    public static void main(String[] args) {
    	PascalTriangle solution = new PascalTriangle();
    	System.out.println(solution.generate(1));
    	System.out.println(solution.generate(5));
    	System.out.println(solution.generate(2));
	}
}
