package leetcode.again;

import java.util.ArrayList;
import java.util.Arrays;

//Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class SortList {
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        for(;head!=null;) {
        	list.add(head.val);head=head.next;
        }
        //list.sort((x,y)->x-y);
        quickSort(list, 0, list.size()-1);
        head =new ListNode(0);
        ListNode temp = head;
        for(int i:list) {
        	temp.next = new ListNode(i);
        	temp = temp.next;
        }
        return head.next;
    }
    
    public ArrayList<Integer> quickSort(ArrayList<Integer> list, int l,int r){
    	if(l<r) {
    		int p = partion(list,l,r);
    		quickSort(list, l, p-1);
    		quickSort(list, p+1, r);
    	}
    	return list;
    }
    
    public int partion(ArrayList<Integer> list, int l,int r){
    	int povit = list.get(r), index=l-1;
    	for(int i=l;i<r;i++) {
    		if(list.get(i)<=povit) {
    			index++;
    			int temp = list.get(index);
    			list.set(index, list.get(i));
    			list.set(i, temp);
    		}
    		
    	}
    	int temp = list.get(index+1);
		list.set(index+1, list.get(r));
		list.set(r, temp);
    	return index+1;
    }
    
    public static void main(String[] args) {
	
	}
    
}