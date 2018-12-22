package leetcode.again;

import java.util.Arrays;

public class ListNodeUtls {
	public static ListNode generateList(int ...args) {
		ListNode root = new ListNode(0),cur=root;
		for(int i=0;i<args.length;i++) {
			cur = cur.next = new ListNode(args[i]);
		}
		return root.next;
	}
	/**
	 * format:[1,2,3,4,5] or 1,2,3,4,5,6
	 * @param listString
	 * @return
	 */
	public static ListNode generateList(String listString) {
		if(listString.isEmpty())return null;
		listString = listString.replace("[", "").replace("]", "");
		String strs[] = listString.split(",");
		return generateList(
				Arrays.stream(strs).mapToInt(Integer::valueOf)
				.toArray());
	}
	
	public static int[] listNodeToArray(ListNode root) {
		int len =0;
		ListNode cur = root;
		while(cur!=null) {
			cur=cur.next;
			len++;
		}
		int[]res = new int[len];
		int i=0;
		while(root!=null) {
			res[i++]=root.val;
			root = root.next;
		}
		return res;
	}
	
	/**
	 * listNode to like: 1,2,3,4
	 * @param root
	 * @return
	 */
	public static String listNodeToString(ListNode root) {
		if(root==null)return "";
		String[] strs = Arrays.stream(listNodeToArray(root)).
				mapToObj(String::valueOf).toArray(String[]::new);
		return String.join(",",strs);
	}
	
	/**
	 * listNode to like: [1,2,3,4]
	 * @param root
	 * @return
	 */
	public static String listNodeToStringParentheses(ListNode root) {
		if(root==null)return "[]";
		String[] strs = Arrays.stream(listNodeToArray(root)).
				mapToObj(String::valueOf).toArray(String[]::new);
		return "["+String.join(",",strs)+"]";
	}
	
	/**
	 * print listNode array to like: [[1,2,3],[2,3,4],[]]
	 * @param nodes
	 * @return
	 */
	public static String listNodeArrayToStringParentheses(ListNode[] nodes) {
		if(nodes==null)return "[]";
		String[] array = Arrays.stream(nodes)
		.map(node->listNodeToStringParentheses(node))
		.toArray(String[]::new);
		return "["+String.join(",",array)+"]";
	}
	
	/**
	 * [[1,2,3],[2,3,4],[]] to listnode Array
	 * @param nodes
	 * @return
	 */
	public static ListNode[] stringTolistNodeArray(String nodes) {
		if(nodes==null||nodes.isEmpty())return null;
		String[] temps = nodes.split("\\],\\[");
		return Arrays.stream(temps).map(str->{
			String a = str.replace("[", "").replace("]", "");
			return generateList(a);
		}).toArray(ListNode[]::new);
		
	}
	
	public static void main(String[] args) {
		String s = listNodeToStringParentheses(generateList("1,2,3,4,5"));
		System.out.println(s);
		
		s = listNodeArrayToStringParentheses(stringTolistNodeArray("[[1,2,3],[2,3,4],[]]"));
		System.out.println(s);
	}
}
