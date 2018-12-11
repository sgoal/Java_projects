package leetcode.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Definition for singly-linked list.

public class SortList {
	public ListNode sortList(ListNode head) {
		ArrayList<Integer> list = new ArrayList<>();
		for (; head != null;) {
			list.add(head.val);
			head = head.next;
		}
		// list.sort((x,y)->x-y);
		quickSort(list, 0, list.size() - 1);
		head = new ListNode(0);
		ListNode temp = head;
		for (int i : list) {
			temp.next = new ListNode(i);
			temp = temp.next;
		}
		return head.next;
	}

	public ArrayList<Integer> quickSort(ArrayList<Integer> list, int l, int r) {
		if (l < r) {
			int p = partion(list, l, r);
			quickSort(list, l, p - 1);
			quickSort(list, p + 1, r);
		}
		return list;
	}

	public int partion(ArrayList<Integer> list, int l, int r) {
		int povit = list.get(r), index = l - 1;
		for (int i = l; i < r; i++) {
			if (list.get(i) <= povit) {
				index++;
				int temp = list.get(index);
				list.set(index, list.get(i));
				list.set(i, temp);
			}

		}
		int temp = list.get(index + 1);
		list.set(index + 1, list.get(r));
		list.set(r, temp);
		return index + 1;
	}

	public static void main(String[] args) {

	}

}

class SortList1 {
	public ListNode sortList(ListNode head) {
		if (head == null)
			return head;
		List<ListNode> temp = new ArrayList<>();
		ListNode temp0 = head;
		do {
			temp.add(temp0);
		} while ((temp0 = temp0.next) != null);
		temp = mergeSort(temp);
		temp0 = new ListNode(0);
		ListNode tail = temp0;
		for (ListNode node : temp) {
			tail.next = node;
			tail = tail.next;
		}
		tail.next = null;
		return temp0.next;
	}

	List<ListNode> mergeSort(List<ListNode> list) {
		if (list.size() == 1)
			return list;
		int start = 0, end = list.size();
		int mid = (end - start) / 2 + start;
		List<ListNode> list1 = mergeSort(list.subList(start, mid));
		List<ListNode> list2 = mergeSort(list.subList(mid, end));
		List<ListNode> temp = merge(list1, list2);
		return temp;
	}

	List<ListNode> merge(List<ListNode> list, List<ListNode> list1) {
		ArrayList<ListNode> temp = new ArrayList<>(list1.size() + list.size() + 1);
		int mid0 = list.size(), mid1 = list1.size();
		int start0 = 0, start1 = 0;
		while (start0 < mid0 || start1 < mid1) {
			if (start0 < mid0 && start1 < mid1 && list.get(start0).val <= list1.get(start1).val) {
				temp.add(list.get(start0++));
			} else if (start0 < mid0 && start1 < mid1 && list.get(start0).val > list1.get(start1).val) {
				temp.add(list1.get(start1++));
			} else if (start0 < mid0) {
				temp.add(list.get(start0++));
			} else if (start1 < mid1) {
				temp.add(list1.get(start1++));
			}

		}
		return temp;
	}
}

class SortList2 {
	public ListNode sortList(ListNode head) {
		if(head==null||head.next==null)return head;
		ListNode fast = head,slow = head, prev=null;
		while(fast!=null&&fast.next!=null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = null;
		slow = sortList(slow);
		head = sortList(head);
		ListNode dummy = new ListNode(0),tail = dummy;
		while(slow!=null||head!=null) {
			if(slow!=null&&head!=null) {
				if(slow.val<=head.val) {
					tail.next = slow;
					slow = slow.next;
				}else {
					tail.next = head;
					head = head.next;
				}
			}else if (slow!=null) {
				tail.next = slow;
				slow = slow.next;
			}else if (head!=null) {
				tail.next = head;
				head = head.next;
			}
			tail = tail.next;
		}
		return dummy.next;
	}

}