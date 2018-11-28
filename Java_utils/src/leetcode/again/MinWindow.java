package leetcode.again;

import java.util.Map;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        Map<Character,Long> map =  t.chars().mapToObj(x->(char)x).collect(
        		Collectors.groupingBy(Character::valueOf, Collectors.counting()));
        int end=0,begin=0;int counter=0;
        int res = Integer.MAX_VALUE;
        String temp1 = "";
        while(end<s.length()) {
        	char c = s.charAt(end);
        	long temp = map.getOrDefault(s.charAt(end), 0l);
        	if(map.containsKey(c)) {
        		map.put(c,temp-1);
        		if(temp>0)counter++;
        	}
        	end++;
        	

        	while(counter==t.length()) {
        		if(counter==t.length()&&res>=end-begin) {
            		res = Math.min(res, end-begin);
            		temp1 = s.substring(begin, end);
            		System.out.println(temp1);
            	}
        		char b = s.charAt(begin);
        		if(map.containsKey(b)) {
        			long t1 = map.get(b);
        			map.put(b, t1+1);
        			if(t1==0)counter--;
        		}
        		begin++;
        	}
        }
        return temp1;
    }
    public static void main(String[] args) {
		MinWindow solution = new MinWindow();
		System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
	}
}
