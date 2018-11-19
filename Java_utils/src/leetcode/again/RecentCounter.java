package leetcode.again;

import java.util.LinkedList;

public class RecentCounter {
	LinkedList<Integer> queue = new LinkedList<>();
    public RecentCounter() {
    }
    
    public int ping(int t) {
    	queue.addLast(t);
    	while(queue.peekFirst()<t-3000) queue.pop();
        return queue.size();
    }
}
