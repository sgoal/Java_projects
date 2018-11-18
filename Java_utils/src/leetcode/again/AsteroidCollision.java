package leetcode.again;

import java.util.LinkedList;

public class AsteroidCollision {
	   public int[] asteroidCollision(int[] asteroids) {
	        LinkedList<Integer> stack = new LinkedList<>();
	        for(int i:asteroids) {
	        	 if (i > 0 || stack.isEmpty() || stack.getLast() < 0)
	                 stack.add(i);
	             else if (stack.getLast() <= -i)
	                 if (stack.pollLast() < -i) i--;
	        }
	        return stack.stream().mapToInt(Integer::intValue).toArray();
	    }
}
