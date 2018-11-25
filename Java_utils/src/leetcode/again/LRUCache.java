package leetcode.again;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/lru-cache
public class LRUCache {
	
	class DoubleLinkedNode{
		int key;
		int val;
		DoubleLinkedNode prev;
		DoubleLinkedNode next;
	}
	
	private Map<Integer, DoubleLinkedNode> map = new HashMap<>();
	private int cap = 0;
	private DoubleLinkedNode head = null;
	private DoubleLinkedNode tail = null;
	
    public LRUCache(int capacity) {
        cap = capacity;
        head = new DoubleLinkedNode();
        tail = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
        	DoubleLinkedNode node =  map.get(key);
        	moveHead(node);
            System.out.println(key + "  " + node.val);
        	return node.val;
        }
        System.out.println(key + "  " +  -1);
        return -1;
    }
    
    public void put(int key, int value) {
    	System.out.println("put "+key + " " + value);
    
    	if(map.containsKey(key)) {
    		DoubleLinkedNode node = map.get(key);
    		node.val = value;
    		moveHead(node);
    	}else {
    		if(map.size()==cap) {
        		deleteTail();
        	}
    	     map.put(key,addHead(key, value));
    	}
 
    }
    
    private void deleteTail() {
    	tail = tail.prev;
    	if(tail==null) tail = head;
    	if(tail.next!=null)
    		map.remove(tail.next.key);
    	tail.next = null;
    }
    
    private DoubleLinkedNode addHead(int key, int val) {
    	DoubleLinkedNode node = new DoubleLinkedNode();
    	node.key = key;
    	node.val = val;
    	node.next = head.next;
    	if(head.next != null)
    		head.next.prev = node;
    	else
    		tail = node;
    	head.next = node;
    	return node;
    }
    
    private DoubleLinkedNode moveHead(DoubleLinkedNode temp) {
    	if(temp==head.next)return temp;
    	
    	temp.prev.next=temp.next;
    	if(temp.next!=null)
    		temp.next.prev = temp.prev;
    	else
    		tail = temp.prev;
    		
    	temp.next = head.next;
    	if(head.next!=null)
    		head.next.prev = temp;
    	head.next = temp;
    	temp.prev = head;
		if(temp.next==null)
			tail = temp;
    	return temp;
    }
    public static void main(String[] args) {
    	LRUCache cache = new LRUCache( 2 /* capacity */ );

    	cache.put(1, 1);
    	cache.put(2, 2);
    	cache.get(1);       // returns 1
    	cache.put(3, 3);    // evicts key 2
    	cache.get(2);       // returns -1 (not found)
    	cache.put(4, 4);    // evicts key 1
    	cache.get(1);       // returns -1 (not found)
    	cache.get(3);       // returns 3
    	cache.get(4);       // returns 4
    	System.out.println("-------");
    	 cache = new LRUCache( 1 /* capacity */ );

    	cache.put(2, 1);
    	cache.get(2);
    	cache.put(3,2);       // returns 1
    	cache.get(2);    // evicts key 2
    	cache.get(3);       // returns -1 (not found)
    	System.out.println("-------");
   	 cache = new LRUCache( 2 /* capacity */ );
   	cache.get(2);
   	cache.put(2, 6);
   	cache.get(1);
   	cache.put(1,5);       // returns 1
   	cache.put(1,2);    // evicts key 2
   	cache.get(1);       // returns -1 (not found)
   	cache.get(2); 
	}
}
