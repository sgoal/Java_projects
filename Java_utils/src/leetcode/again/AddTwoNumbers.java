package leetcode.again;

import java.util.LinkedList;


public class AddTwoNumbers {
    public ListNode addTwoNumbers0(ListNode l1, ListNode l2) {
        LinkedList<ListNode> stack1 = new LinkedList<>();
        LinkedList<ListNode> stack2 = new LinkedList<>();
        ListNode t1 = l1,t2=l2;
        while(t1!=null) {
        	stack1.push(t1);
        	t1=t1.next;
        }
        while(t2!=null) {
        	stack2.push(t2);
        	t2=t2.next;
        }
        ListNode head = new ListNode(0);
        int c= 0;
        while((!stack1.isEmpty())||(!stack2.isEmpty())||c>0) {
        	int n1=0,n2=0;
        	if(!stack1.isEmpty()) {
        		n1 = stack1.pop().val;
        	}
        	if(!stack2.isEmpty()) {
        		n2 = stack2.pop().val;
        	}
        	ListNode temp = new ListNode(n1+n2+c);
        	if(temp.val>=10) {
        		temp.val -= 10;
        		c= 1;
        	}else {
        		c=0;
        	}
        	temp.next = head.next;
        	head.next = temp;
        }
       return head.next;
    }
    
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode reverseL1 = (l1),reverseL2=(l2),head = new ListNode(0),tail=head,temp;
    	int c = 0;
    	while(c>0||reverseL1!=null||reverseL2!=null) {
    		int t1 = 0,t2=0;
    		if(reverseL1!=null) {
    			t1 = reverseL1.val;reverseL1 = reverseL1.next;
    		}
    		if(reverseL2!=null) {
    			t2 = reverseL2.val;reverseL2 = reverseL2.next;
    		}
    		c = t1+t2+c;
    		temp = new ListNode(c%10);
    		c /= 10;
    		
    		temp.next = tail.next;
    		tail.next = temp;
    		tail = tail.next;
    	}
    	return head.next;
    }
    
    ListNode reverse(ListNode list) {
    	ListNode head = new ListNode(0),temp;
    	while(list!=null) {
    		temp = list.next;
    		list.next = head.next;
    		head.next = list;
    		list = temp;
    	}
    	return head.next;
    }
}