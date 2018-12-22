package leetcode.again;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
//https://leetcode.com/problems/letter-case-permutation/
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<StringBuffer> temp = new ArrayList<>();
        temp.add(new StringBuffer(S.length()));
        for(char c:S.toCharArray()) {
    		int len = temp.size();
        	if(Character.isLetter(c)) {
        		for(int i=0;i<len;i++) {
        			StringBuffer sb = new StringBuffer(temp.get(i));
        			if(Character.isLowerCase(c))
        				sb.append(Character.toUpperCase(c));
        			else
        				sb.append(Character.toLowerCase(c));
        			temp.add(sb);
        		}
        	}
        	for(int i=0;i<len;i++) {
    			temp.get(i).append(c);
    		}
        	
        }
        return temp.stream().map(x->x.toString())
        		.collect(Collectors.toList());
    }
    public static void main(String[] args) {
    	LetterCasePermutation solution = new LetterCasePermutation();
    	System.out.println(solution.letterCasePermutation("a12b"));
    	System.out.println(solution.letterCasePermutation("c"));
    	System.out.println(solution.letterCasePermutation("C"));
	}
}
