package leetcode.again;

public class SplitListToParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0,n=0,last=0, i=0,count=0;
        ListNode temp = root;
        while(temp!=null)len++;
        n = len/k;last=len%k;
        ListNode[] res = new ListNode[k];
        ListNode lastNode = root;
        while(root!=null) {
        	while(count<=n) {
        		if(res[i]==null)
        			res[i]=root;
        		else {
        			
        		}
        		count++;
        	}
        }
        return res;
    }
}
