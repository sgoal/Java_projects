package leetcode.again;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/additive-number/
public class IsAdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        List<BigInteger> res = new ArrayList<>(num.length());
        return helper(num,0,res);
    }
    boolean helper(String num, int i, List<BigInteger> res) {
		if(res.size()>2&&i==num.length())return true;
		for(int j=i;j<num.length();j++) {
			String sub = num.substring(i, j+1);
			if(sub.length()>1&&sub.charAt(0)=='0')return false;
			BigInteger temp = new BigInteger(sub);
			//if(temp>=Integer.MAX_VALUE)return false;
			int size = res.size();
			if(res.size()>1&&temp.compareTo(res.get(size-1).add(res.get(size-2)))>0)
				return false;
			if(size<2||temp.equals(res.get(size-1).add(res.get(size-2)))) {
				res.add( temp);
				if(helper(num, j+1, res))
					return true;
				res.remove(res.size()-1);
			}
		}
		return false;
	}
	public static void main(String[] args) {
    	IsAdditiveNumber solution = new IsAdditiveNumber();
    	System.out.println(solution.isAdditiveNumber("112358"));
    	System.out.println(solution.isAdditiveNumber("10113"));
    	System.out.println(solution.isAdditiveNumber("199100199"));
    	System.out.println(solution.isAdditiveNumber("121474836472147483648"));
    	System.out.println(solution.isAdditiveNumber("11235813213455890144"));
	}
}
