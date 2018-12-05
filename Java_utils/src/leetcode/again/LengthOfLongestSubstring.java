package leetcode.again;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * @author sgoal
 *
 */
public class LengthOfLongestSubstring {
	public int lengthOfLongestSubstring1(String s) {
		HashSet<Character> set = new HashSet<>();
		int end = 0, begin = 0;
		int res = 0;
		while (end < s.length()) {
			if (!set.contains(s.charAt(end))) {
				set.add(s.charAt(end++));
				res = Math.max(res, end - begin);
			} else {
				set.remove(s.charAt(begin++));
			}

		}
		return res;
	}

	public int lengthOfLongestSubstring2(String s) {
		HashSet<Character> seen = new HashSet<>();
		int res = 0;
		int index = 0, end = 0, n = s.length();
		while (end < n) {
			char cur = s.charAt(end);
			if (seen.contains(cur)) {
				seen.remove(s.charAt(index++));
			} else {
				seen.add(cur);
				res = Math.max(res, end - index + 1);
				end++;
			}

		}
		return res;
	}

	
	public int lengthOfLongestSubstring(String s) {
		int res = 0;
		int index = 0, end = 0, n = s.length();
		int[] map = new int[128];//char to pos
	
		while (end < n) {
			index = Math.max(map[s.charAt(end)], index);
			res = Math.max(res, end - index + 1);
			map[s.charAt(end)]= end+1;
			end++;

		}
		return res;
	}

	public static void main(String[] args) {
		LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
		System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
		System.out.println(solution.lengthOfLongestSubstring("abreghe"));
		System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
		System.out.println(solution.lengthOfLongestSubstring("aabaab!bb"));
		System.out.println(solution.lengthOfLongestSubstring("tmmzuxt"));
		System.out.println(solution.lengthOfLongestSubstring(" "));
	}
}
