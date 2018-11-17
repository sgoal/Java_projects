package leetcode.again;

import java.util.HashMap;
import java.util.LinkedList;

public class FreqStack {
	HashMap<Integer, LinkedList<Integer>> freqToStack = new HashMap<>();
	HashMap<Integer, Integer> numToFreq = new HashMap<>();
	int maxFreq = 0;

    public FreqStack() {
        
    }
    
    public void push(int x) {
    	int f = numToFreq.getOrDefault(x, 0)+1;
    	numToFreq.put(x, f);
    	if(!freqToStack.containsKey(f))freqToStack.put(f, new LinkedList<>());
    	freqToStack.get(f).push(x);
    	maxFreq = Math.max(f, maxFreq);
    }
    
    public int pop() {
    	int x = freqToStack.get(maxFreq).pollFirst();
    	numToFreq.put(x, maxFreq-1);
    	if(freqToStack.get(maxFreq).size()==0)maxFreq--;
        return x;
    }
    
    public static void main(String[] args) {
		FreqStack freqStack = new FreqStack();
		freqStack.push(5);
		freqStack.push(7);
		freqStack.push(1);
		freqStack.push(7);
		freqStack.push(5);
		System.out.println(freqStack.pop());
		System.out.println(freqStack.pop());
	}
}
