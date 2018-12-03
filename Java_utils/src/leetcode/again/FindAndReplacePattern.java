package leetcode.again;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/find-and-replace-pattern/
public class FindAndReplacePattern {
	HashMap<Character, Character> map = new HashMap<>(512);
	HashMap<Character, Character> patternMap = new HashMap<>(512);
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        ArrayList<String> res = new ArrayList<>(words.length);
    	for(String s:words)
        	if(check(s, pattern)) {
        		res.add(s);
        	}
    	
    	return res;
    }
    
    boolean check(String t,String pattern) {
    	if(t.length()!=pattern.length())return false;
    	map.clear();
    	patternMap.clear();
    	for(int i=0;i<t.length();i++) {
    		char c= t.charAt(i);
    		if(map.containsKey(c)) {
    			if(map.get(c)!=pattern.charAt(i))return false;
    		}else {
    			if(patternMap.containsKey(pattern.charAt(i))) {
    				if(patternMap.get(pattern.charAt(i))!=c)return false;
    			}
    			map.put(c, pattern.charAt(i));
    			
    			patternMap.put(pattern.charAt(i), c);
    		}
    	}
    	return true;
    }
    
    boolean check1(String t,String pattern) {
    	if(t.length()!=pattern.length())return false;
    	map.clear();
    	for(int i=0;i<t.length();i++) {
    		char c= t.charAt(i);
    		char p = pattern.charAt(i);
    		if(map.containsKey(c)) {
    			if(map.get(c)!=p)return false;
    		}else {
    			map.put(c, pattern.charAt(i));			
    		}
    	}
    	boolean seen[] = new boolean[26];
    	for(char c:map.values()) {
    		if(seen[c-'a'])return false;
    		seen[c-'a']=true;
    	}
    	return true;
    }
    public static void main(String[] args) {
    	FindAndReplacePattern solution = new FindAndReplacePattern();
    	System.out.println(solution.check("abc", "efg"));
    	System.out.println(solution.check("acbc", "egfg"));
    	System.out.println(solution.check("abc", "abb"));
    	System.out.println(solution.check("mee", "abb"));
    	System.out.println("----------------------");
    	System.out.println(solution.check1("abc", "efg"));
    	System.out.println(solution.check1("acbc", "egfg"));
    	System.out.println(solution.check1("abc", "abb"));
    	System.out.println(solution.check1("mee", "abb"));
	}
}