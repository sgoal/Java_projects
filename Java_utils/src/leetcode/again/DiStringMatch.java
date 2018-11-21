package leetcode.again;

import java.util.Arrays;

public class DiStringMatch {
    public int[] diStringMatch(String S) {
        int right=S.length(), left=0;
        int res[] = new int[S.length()+1];
        int i=0;
        for(char c:S.toCharArray()) {
        	if(c=='D') {
        		res[i]=right--;
        	}
        	if(c=='I') {
        		res[i]=left++;
        	}
        	i++;
        }
        res[i]=left;
        return res;
    }
    public static void main(String[] args) {
		DiStringMatch solution = new DiStringMatch();
		System.out.println(Arrays.toString(solution.diStringMatch("IDID")));
	}
}
