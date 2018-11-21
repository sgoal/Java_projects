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

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {

       Map<Character, Long> map =  p.chars().mapToObj(x->(char)x).collect(
    		   Collectors.groupingBy(Character::valueOf,Collectors.counting()));
        List<Integer> res = new ArrayList<>();
        return res;

    }
    public static void main(String[] args) {
    	FindAnagrams solution = new FindAnagrams();
    	//System.out.println(solution.findAnagrams("abab", "ab"));
    	System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
	}
}
/