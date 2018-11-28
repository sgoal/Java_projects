package leetcode.again;

import java.util.Arrays;

//https://leetcode.com/problems/rotate-string/
//https://leetcode.com/problems/rotate-string/solution/
public class RotateString {
    public boolean rotateString1(String A, String B) {
        if(A.length()!=B.length())return false;
        if(A == B)return true;
        StringBuilder sa = new StringBuilder(A);
        StringBuilder sb = new StringBuilder(B);
        for(int i=0;i<A.length();i++) {
        	char a = sa.charAt(0);
        	sa = sa.deleteCharAt(0);
        	sa.append(a);
        	
        	if(sa.toString().equals(sb.toString()))return true;
        }
        return false;
       
        
    }
    
    public boolean rotateString(String A, String B) {
    	if(A.length()!=B.length())return false;
        String AA = A+A;
        return AA.contains(B);
        
    }
    

        public boolean rotateString2(String A, String B) {
            int N = A.length();
            if (N != B.length()) return false;
            if (N == 0) return true;

            //Compute shift table
            int[] shifts = new int[N+1];
            Arrays.fill(shifts, 1);
            int left = -1;
            for (int right = 0; right < N; ++right) {
                while (left >= 0 && (B.charAt(left) != B.charAt(right)))
                    left -= shifts[left];
                shifts[right + 1] = right - left++;
            }

            //Find match of B in A+A
            int matchLen = 0;
            for (char c: (A+A).toCharArray()) {
                while (matchLen >= 0 && B.charAt(matchLen) != c)
                    matchLen -= shifts[matchLen];
                if (++matchLen == N) return true;
            }

            return false;
        }
 
    public static void main(String[] args) {
    	RotateString solution = new RotateString();
    	System.out.println(solution.rotateString("", ""));
    	System.out.println(solution.rotateString("abcd", "cdab"));
    	System.out.println(solution.rotateString("abcd", "cbab"));
    	System.out.println(solution.rotateString("abcd", "bcab"));
    	System.out.println(solution.rotateString("aacd", "acba"));
	}
}