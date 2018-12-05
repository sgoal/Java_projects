package leetcode.again;

import java.util.Map;
import java.util.stream.Collectors;

//https://leetcode-cn.com/problems/permutation-in-string/
public class CheckInclusion {
    public boolean checkInclusion1(String s1, String s2) {
        if(s1.length()>s2.length())return false;
        Map<Character, Long> mapCount =  s1.chars().mapToObj(x->(char)(x)).collect(Collectors.groupingBy(Character::valueOf,Collectors.counting()));
        int end=0,begin=0,n=s2.length();
        int counter = 0;
        while(end<n) {
        	char cur = s2.charAt(end);
        	if(mapCount.getOrDefault(cur, 0l)>0) {
        		if(counter==0)begin = end;
        		counter++;
        		mapCount.put(cur, mapCount.get(cur)-1);
//        		System.out.println(counter + " " + cur);
        		if(counter==s1.length())
        			return true;
        		end++;
        	}else {
        		if(counter!=0&&begin<n) {
        			mapCount.put(s2.charAt(begin), mapCount.get(s2.charAt(begin))+1);
        			begin++;
        			counter--;
        		}else {
        			end++;
        		}
        	}
		
        }
        return counter==s1.length();
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())return false;
        Map<Character, Long> mapCount =  s1.chars().mapToObj(x->(char)(x)).collect(Collectors.groupingBy(Character::valueOf,Collectors.counting()));
        int end=0,begin=0,n=s2.length();
        int counter = 0;
        while(end<n) {
        	char cur = s2.charAt(end);
        	if(mapCount.getOrDefault(cur, 0l)>0) {
        		counter++;
        		mapCount.put(cur, mapCount.get(cur)-1);
//        		System.out.println(counter + " " + cur);
        		if(counter==s1.length())
        			return true;
        		end++;
        	}else {
        		if(counter!=0&&begin<n) {
        			char c = s2.charAt(begin++);
        			if(mapCount.containsKey(c)) {
	        			mapCount.put(c, mapCount.get(c)+1);
	        			counter--;
        			}
        		}else {
        			end++;
        		}
        	}
		
        }
        return false;
    }
    public static void main(String[] args) {
    	CheckInclusion solution = new CheckInclusion();
    	System.out.println(solution.checkInclusion("cab", "31313bacc"));
    	System.out.println(solution.checkInclusion("cab", "313a13bcc"));
    	System.out.println(solution.checkInclusion("adc", "dcda"));
	}
}