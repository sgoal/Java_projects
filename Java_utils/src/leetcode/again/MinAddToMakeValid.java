package leetcode.again;

import java.util.LinkedList;

public class MinAddToMakeValid {
	

	public int minAddToMakeValid(String S) {
		LinkedList<Character> stack = new LinkedList<>();
		if (S.length() <= 1)
			return S.length();
		for(char c:S.toCharArray()) {
			if(c=='(')stack.push(c);
			else if (c==')') {
				if(stack.size()>0 &&stack.peek()=='(')stack.pop();
				else  {
					stack.push(')');
				}
			}
		}
		
		return stack.size();
	}

	public static void main(String[] args) {
		MinAddToMakeValid makeValid = new MinAddToMakeValid();
		System.out.println(makeValid.minAddToMakeValid("((("));
		System.out.println(makeValid.minAddToMakeValid("((()"));
		System.out.println(makeValid.minAddToMakeValid("))((("));
		System.out.println(makeValid.minAddToMakeValid(""));
		System.out.println(makeValid.minAddToMakeValid(")(()("));
		System.out.println(makeValid.minAddToMakeValid("()()"));
		System.out.println(makeValid.minAddToMakeValid("((())"));
	}
}
