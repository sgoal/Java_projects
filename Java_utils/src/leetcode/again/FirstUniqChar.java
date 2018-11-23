package leetcode.again;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * @author sgoal
 *
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        Map<Character, Long> map =  s.chars().mapToObj(x->(char)x).collect(
        		Collectors.groupingBy(Character::valueOf, Collectors.counting()));
        int index[] = new int[] {-1};
        s.chars().forEach(x->{
        	if(map.getOrDefault((char)x,0l)==1&&index[0]==-1) {
        		index[0] = x;
        	}
        });
       return s.indexOf(index[0]);
    }
    
    public int firstUniqChar1(String s) {
       char[] map = new char[256];
       for(char c:s.toCharArray())map[c]++;
       for(int i=0;i<s.length();i++)
    	   if(map[s.charAt(i)]==1)return i;
       return -1;
    }
    public static void main(String[] args) {
		FirstUniqChar solution = new FirstUniqChar();
		System.out.println(solution.firstUniqChar("leetcode"));
	}
}
