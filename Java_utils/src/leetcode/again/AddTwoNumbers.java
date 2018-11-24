package leetcode.again;

import java.util.LinkedList;


public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
}