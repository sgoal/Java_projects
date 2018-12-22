package leetcode.again;
//https://leetcode.com/problems/odd-even-linked-list/
public class OddEvenList {
    public ListNode oddEvenList1(ListNode head) {
        int count = 0;
        ListNode odd = new ListNode(0),even = new ListNode(0);
        ListNode oddCur = odd,evenCur = even;
        while(head!=null) {
        	if(count%2==0) {//odd
        		oddCur = oddCur.next = head;
        	}else {
        		evenCur = evenCur.next = head;
        	}
        	ListNode temp = head.next;
        	head.next=null;
        	head = temp;
        	count++;
        }

        oddCur.next=even.next;
        
        return odd.next;
    }
    public ListNode oddEvenList(ListNode head) {
    	if(head==null)return null;
        ListNode odd = head,even = head.next;
        ListNode oddCur = odd,evenCur = even;
        while(evenCur!=null&&evenCur.next!=null) {
        	oddCur = oddCur.next = evenCur.next;
        	evenCur = evenCur.next = oddCur.next;
       
       }

        oddCur.next=even;
        
        return odd;
    }
    public static void main(String[] args) {
		ListNode temp = ListNodeUtls.generateList("1,2,3,4,5");
		OddEvenList solution = new OddEvenList();
		String s = ListNodeUtls.listNodeToString(
				solution.oddEvenList(temp));
		System.out.println(s);
		
		temp = ListNodeUtls.generateList("1");
		s = ListNodeUtls.listNodeToString(
				solution.oddEvenList(temp));
		System.out.println(s);
	}
}