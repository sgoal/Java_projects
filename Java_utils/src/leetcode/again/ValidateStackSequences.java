package leetcode.again;

import java.util.LinkedList;

//https://leetcode.com/problems/validate-stack-sequences/
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
    	if(pushed.length!=popped.length)return false;
    	if(pushed.length==0)return true;
        LinkedList<Integer> stack = new LinkedList<>();
        int index = 0,indexPush=0;
        stack.push(pushed[indexPush++]);
        while(!stack.isEmpty()) {
        	while(!stack.isEmpty()&&stack.peek()==popped[index]) {
        		stack.pop();
        		index++;
        	} 
        	if(indexPush<pushed.length) {
        		stack.push(pushed[indexPush++]);
        	}else {
        		if(!stack.isEmpty()&&stack.peek()!=popped[index])
        			return false;
        	}
        	
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
    	ValidateStackSequences solution = new ValidateStackSequences();
    	System.out.println(solution.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
    	System.out.println(solution.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
	}
}