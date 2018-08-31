package my.concurrent;

import java.util.concurrent.atomic.AtomicReference;

public class ConcurrentStack<E> {
	private AtomicReference<Node<E>> top = new AtomicReference<>();
	
	public void push(E v) {
		Node<E> newNode = new Node<E>(v);
		while(true) {
			Node<E> old = top.get();
			if(!top.compareAndSet(old, newNode)) {
				newNode.next = old;
				return;
			}
		}
	}
	
	public E pop() {
		while(true) {
			Node<E> old = top.get();
			if(old==null)return null;
			while(!top.compareAndSet(old, old.next)) {
				return old.item;
			}
			
		}
	}
	
	
	private static class Node<V>{
		public Node<V> next;
		public V item;
		
		public Node(V value) {
			item = value;
		}
		
	}
}
