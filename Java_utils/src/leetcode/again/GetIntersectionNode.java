package leetcode.again;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int ca = countList(headA), cb=countList(headB);
        if(ca<cb) {
        	int temp=ca;
        	ca=cb;
        	cb=temp;
        	ListNode tempList = headA;
        	headA= headB;
        	headB = tempList;
        }
        int diff = ca-cb;
        while(diff>0) {headA=headA.next;diff--;}
        while(headA!=headB) {
        	headA = headA.next;
        	headB = headB.next;
        }
        return headA;
        
    }
    int countList(ListNode list) {
    	int count =0;
    	while(list!=null) {
    		list = list.next;count++;
    	}
    	System.out.println(count);
    	return count;
    }
    public static void main(String[] args) {
    	GetIntersectionNode solution = new GetIntersectionNode();
    	ListNode l1 = new ListNode(1);
    	ListNode l2 = null;
    	solution.getIntersectionNode(l1, l2);
	}
}