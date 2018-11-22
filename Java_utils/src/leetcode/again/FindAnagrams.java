package leetcode.again;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// * int findSubstring(string s){
//        vector<int> map(128,0);
//        int counter; // check whether the substring is valid
//        int begin=0, end=0; //two pointers, one point to tail and one  head
//        int d; //the length of substring
//
//        for() { /* initialize the hash map here */ }
//
//        while(end<s.size()){
//
//            if(map[s[end++]]-- ?){  /* modify counter here */ }
//
//            while(/* counter condition */){ 
//                 
//                 /* update d here if finding minimum*/
//
//                //increase begin to make it invalid/valid again
//                
//                if(map[s[begin++]]++ ?){ /*modify counter here*/ }
//            }  
//
//            /* update d here if finding maximum*/
//        }
//        return d;
//  }

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * @author sgoal
 *
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {

       Map<Character, Long> map =  p.chars().mapToObj(x->(char)x).collect(
    		   Collectors.groupingBy(Character::valueOf,Collectors.counting()));
        List<Integer> res = new ArrayList<>();
        int begin=0,end=0;
        int counter= 0;
        int d=0;
        while(end<s.length()) {
        	long temp = map.getOrDefault(s.charAt(end),0l);
        	//System.out.println(map);
        	if(map.containsKey(s.charAt(end))) {
        		//mean in p
        		map.put(s.charAt(end),temp-1);
        		if(temp>0)
        		counter++;
        	}
        	end++;
        	if(counter==p.length()) {
    			res.add(begin);
    		}
        	//windows size is always p.length
        	while(end-begin==p.length()) {
        		
        		if(map.containsKey(s.charAt(begin))) {
        			map.put(s.charAt(begin), map.get(s.charAt(begin))+1);
        			if(map.get(s.charAt(begin))>0)//it's ok
        			counter--;
        		}
        		begin++;
        	}
        	
        }
        return res;

    }
    public static void main(String[] args) {
    	FindAnagrams solution = new FindAnagrams();
    	//System.out.println(solution.findAnagrams("abab", "ab"));
    	System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
    	System.out.println(solution.findAnagrams("cbraebabacd", "abc"));
	}
}
