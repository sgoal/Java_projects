package leetcode.again;

//https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1038/
public class ReverseList {
    public ListNode reverseList1(ListNode head) {
        ListNode tempHead = new ListNode(0),temp;
        while(head!=null) {
        	temp = head.next;
        	head.next = tempHead.next;
        	tempHead.next = head;
        	head = temp;
        }
        return tempHead.next;
    }
  
}