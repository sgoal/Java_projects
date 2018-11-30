package leetcode.again;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/pascals-triangle-ii/
//https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1171/
public class PascalsTriangleII
 {
    public List<Integer> getRow(int rowIndex) {
    	List<Integer> res = new ArrayList<>(rowIndex+1);
        if(rowIndex>=0)res.add(1);
        if(rowIndex>=1)res.add(1);
        if(rowIndex>1) {
        	for(int i=2;i<=rowIndex;i++) {
        		List<Integer> temp = new ArrayList<>(i+1);
        		temp.add(1);
        		for(int j=1;j<i;j++) {
        			temp.add(res.get(j)+res.get(j-1));
        		}
        		temp.add(1);
        		res = temp;
        	}
        }
        return res;
    }
    public static void main(String[] args) {
    	PascalsTriangleII solution = new PascalsTriangleII();
    	System.out.println(solution.getRow(1));
    	System.out.println(solution.getRow(2));
    	System.out.println(solution.getRow(3));
    	System.out.println(solution.getRow(4));
	}
}