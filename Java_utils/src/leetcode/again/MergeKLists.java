package leetcode.again;

import java.util.PriorityQueue;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
	    ListNode head = new ListNode(0),tail = head;
	    PriorityQueue<ListNode> queue = new PriorityQueue<>((x,y)->{return x.val-y.val;});
	    for(int i=0;i<lists.length;i++) {
	    	if(lists[i]!=null)
	    	queue.add(lists[i]);
	    }
	    while(!queue.isEmpty()) {
	    	ListNode node = queue.poll();
	    	tail.next = node;
	    	tail = node;
	    	if(node.next!=null)
	    		queue.add(node.next);
	    }
        
        return head.next;
    }
}