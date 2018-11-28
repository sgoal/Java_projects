package leetcode.again;

import java.util.HashSet;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * @author sgoal
 *
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
    	HashSet<Character> set = new HashSet<>();
    	int end=0,begin=0;
    	int res= 0;
    	while(end<s.length()) {
    		if(!set.contains(s.charAt(end))){
                set.add(s.charAt(end++));
                res = Math.max(res, end-begin);
            }
    		else {
    			set.remove(s.charAt(begin++));    			
			}
     		
    	}
        return res;
    }
    public static void main(String[] args) {
    	LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
    	System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
    	System.out.println(solution.lengthOfLongestSubstring("abreghe"));
    	System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    	System.out.println(solution.lengthOfLongestSubstring("aabaab!bb"));

	}
}
