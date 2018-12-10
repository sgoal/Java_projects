package leetcode.again;

//https://leetcode-cn.com/problems/merge-two-sorted-lists/
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(l1!=null||l2!=null) {
        	if(l1!=null&&l2!=null) {
        		if(l1.val<l2.val) {
        			l1=insertTail(tail, l1);
        			tail = tail.next;
        		}else {
        			l2=insertTail(tail, l2);
        			tail = tail.next;
        		}
        	}else if(l1!=null) {
        		l1=insertTail(tail, l1);
        		tail = tail.next;
        	}else if (l2!=null) {
        		l2=insertTail(tail, l2);
        		tail = tail.next;
			}
        }
        return head.next;
    }
    
    ListNode insertTail(ListNode tail, ListNode next) {
    	ListNode temp = next.next;
    	tail.next = next;
    	return temp;
    }
	
}
