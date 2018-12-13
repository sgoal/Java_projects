package leetcode.again;

import java.util.PriorityQueue;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
    	if(nums.length==0)return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++) {
        	if(queue.size()==k&&nums[i]>queue.peek()) {
        		queue.poll();
        		queue.add(nums[i]);
        	}else {
        		if(queue.size()<k)
        		queue.add(nums[i]);
			}
        	
        	System.out.println(queue);
        }
        
        System.out.println(queue);
        return queue.peek();
    }
    public static void main(String[] args) {
    	FindKthLargest solution  = new FindKthLargest();
    	System.out.println(solution.findKthLargest(new int[] {3,2,1,5,6,4},2));
	}
}