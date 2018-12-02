package leetcode.again;

import java.util.HashSet;
import java.util.List;

//https://leetcode.com/problems/keys-and-rooms/
public class CanVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> seen = new HashSet<>();
        helper(rooms, 0, seen);
        return seen.size()==rooms.size();
    }
    void helper(List<List<Integer>> rooms, int next,HashSet<Integer> seen) {
    	if(seen.contains(next))return;
		seen.add(next);
    	for(int n:rooms.get(next)) {
    		helper(rooms, n, seen);
    	}
    }
}