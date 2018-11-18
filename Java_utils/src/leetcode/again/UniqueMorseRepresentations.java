package leetcode.again;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueMorseRepresentations {
	  public int uniqueMorseRepresentations(String[] words) {
		  String[] datas = 
			  {".-","-...","-.-.","-..",".","..-.","--.",
			"....","..",".---","-.-",".-..","--","-.","---",
			".--.","--.-",".-.","...","-","..-","...-",
			".--","-..-","-.--","--.."}; 
		  Map<Character, String> map = new HashMap<>();
		  for(char i='a';i<='z';i++) {
			  map.put(i, datas[i-'a']);
		  }
		  HashSet<String> set = new HashSet<>();
		  
		  for(String a:words) {
			  String bString = "";
			  for(char i:a.toCharArray()) {
				  bString += map.get(i);
			  }
			  set.add(bString);
		  }
		  return set.size();
	   }
	  
	  public static void main(String[] args) {
		UniqueMorseRepresentations n = new UniqueMorseRepresentations();
		int a = n.uniqueMorseRepresentations(new String[] {"gin", "zen", "gig", "msg"});
		System.out.println(a);
	  }
}
