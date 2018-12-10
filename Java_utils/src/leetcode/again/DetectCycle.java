package leetcode.again;
//https://leetcode.com/problems/linked-list-cycle-ii/
//Let the distance from the first node to the the node where cycle begins be A, 
//and let say the slow pointer travels travels A+B. 
//The fast pointer must travel 2A+2B to catch up. The cycle size is N.
//A+B+N = 2A+2B
//N=A+B
public class DetectCycle {
    public ListNode detectCycle1(ListNode head) {
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
    
    public ListNode detectCycle(ListNode head) {
    	if(head == null)return null;
    	ListNode fast=head,slow = head;
    	while(fast!=null&&fast.next!=null)  {
    		fast = fast.next.next;
    		slow = slow.next;
    		if(fast==slow) {
        		while(head!=slow) {
        			head=head.next;
        			slow = slow.next;
        		}
        		return head;
        	}
    	}
    
    	return null;
    }
}
