package leetcode.again;

public class Test001 {
	class LinkNode{
		LinkNode(int v){
			val = v;
		}
		int val;
		LinkNode next;
	}

public LinkNode add(LinkNode node1, LinkNode node2) {
	node1 = reverse(node1);
	node2 = reverse(node2);
	LinkNode head = new LinkNode(0);
	int c = 0;
	while(c>0||node1!=null||node2!=null) {
		int n1=0,n2=0;
		if(node1!=null){
			n1 = node1.val;
			node1 = node1.next;
		}
		if(node2!=null) {
			n2 = node2.val;
			node2 = node2.next;
		}
		int t = n1+n2+c;
		c = t/10;
		
		LinkNode cur = new LinkNode(t%10);
		cur.next = head.next;
		head.next = cur;
	 
	}
	return head.next;
}

LinkNode reverse(LinkNode head) {
	LinkNode dummy = new LinkNode(0);
	while(head!=null) {
		LinkNode temp = head.next;
		head.next = dummy.next; 
		dummy.next = head;
		head = temp;
	}
	return dummy.next;
}
public static void main(String[] args) {
	
}
}
