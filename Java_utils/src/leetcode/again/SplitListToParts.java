package leetcode.again;

public class SplitListToParts {
    public ListNode[] splitListToParts0(ListNode root, int k) {
        int len = 0,n=0,mod=0, i=0,count=0;
        ListNode temp = root;
        while(temp!=null) {len++;temp = temp.next;}
        n = len/k;mod=len%k;
        ListNode[] res = new ListNode[k];
        ListNode lastNode = root;
        System.out.println(n + "  " + mod);
        while(root!=null) {
        	while(i<k&&count<n+(i<mod?1:0)&&root!=null) {
        		lastNode = root;
        		if(res[i]==null)
        			res[i]=root;
        		root = root.next;	
        		count++;
        	}
        	lastNode.next = null;
        	count = 0;
        	i++;
        }
        return res;
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
    	int len=0,rem=0,n=0;
    	ListNode temp = root;
    	while(temp!=null) {
    		temp=temp.next;
    		len++;
    	}
    	n=len/k;rem=len%k;
       	ListNode res[] = new ListNode[k];
    	for(int i=0;i<k;i++) {
    		ListNode cur = root,prev = root;
    		for(int j=0;j<n+(i<rem?1:0);j++) {
    			if(cur!=null) {
    				prev = cur;
    				cur=cur.next;
    			}
    		}
    		res[i]=root;
    		if(prev!=null)prev.next=null;
    		root = cur;
    	}

        return res;
    }
    public static void main(String[] args) {
    	ListNode node1 = new ListNode(1);
    	ListNode node2 = new ListNode(2);
    	node1.next = node2;
    	ListNode node3 = new ListNode(3);
    	node2.next = node3;
    	ListNode node4 = new ListNode(4);
    	node3.next = node4;    	
    	SplitListToParts solution = new SplitListToParts();
    	solution.splitListToParts(node1, 3);
	}
}
