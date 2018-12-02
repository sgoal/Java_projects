package leetcode.again;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/split-array-into-fibonacci-sequence/
public class SplitIntoFibonacci {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>(S.length());
        helper(S, 0, res);
        return res;
    }
    
    boolean helper(String S,int index, List<Integer> res) {
    	if(S.length()==index&&res.size()>=3)return true;
    	
    	for(int i=index;i<S.length();i++) {
    		String sub = S.substring(index, i+1);
    		//leading zero
    		if(sub.length()>1&&sub.charAt(0)=='0')break;
    		long temp = Long.parseLong(sub);
    		if(temp>Integer.MAX_VALUE)break;
    		int size = res.size();
    		if(res.size()>=2&&temp>res.get(size-1)+res.get(size-2))
    			break;
    		if(size<2||temp==res.get(size-1)+res.get(size-2)) {
    			res.add((int) temp);
    			if(helper(S, i+1, res)) {
    				return true;
    			}
    			res.remove(res.size()-1);
    		}
    		
    	}
    	return false;
    }
    public static void main(String[] args) {
    	SplitIntoFibonacci solution = new SplitIntoFibonacci();
    	System.out.println(solution.splitIntoFibonacci("123456579"));
    	System.out.println(solution.splitIntoFibonacci("12345"));	
    	System.out.println(solution.splitIntoFibonacci("1101111"));	
    	System.out.println(solution.splitIntoFibonacci("0123"));
    	System.out.println(solution.splitIntoFibonacci("1011"));
    }
}