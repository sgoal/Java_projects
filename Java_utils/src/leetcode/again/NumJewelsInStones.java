package leetcode.again;

import java.util.Set;
import java.util.stream.Collectors;

public class NumJewelsInStones {
	  public int numJewelsInStones(String J, String S) {
	   Set<Integer> set = J.chars().boxed().collect(Collectors.toSet());
	   
	   S.toLowerCase();
	   
	   return (int) S.chars().boxed().filter(x->set.contains(x)).count();
	   
	   
	   }
	  public static void main(String[] args) {
		NumJewelsInStones numJewelsInStones = new NumJewelsInStones();
		System.out.println(numJewelsInStones.numJewelsInStones("aA", "aAAbbbb"));
	}
}
