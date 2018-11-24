package leetcode.again;

import leetcode.again.SolutionRandomeNode.ListNode;
//https://leetcode.com/problems/linked-list-cycle-ii/
//2k-k=nr,k=nr
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
    	if(head == null)return null;
        ListNode hare = head;
        ListNode tortoise = head;
        do {
        	if(hare.next==null)return null;
        	tortoise = tortoise.next;
        	hare = hare.next.next;
        }while(hare!=tortoise&&hare!=null);
        
        if(hare==tortoise) {
        	while(head!=tortoise) {
        		head = head.next;
        		tortoise = tortoise.next;
        	}
        	return head;
        }
    	return null;
    }
}
