package leetcode.again;

import java.util.Arrays;
import java.util.LinkedList;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
//        System.out.println(Arrays.toString(paths));
        LinkedList<String> stack = new LinkedList<>();
        stack.addLast("");
        for(String str:paths) {
        	
        	if(stack.peekLast().equals("/")&&str.equals("/")) {
        		continue;
        	}else if(str.equals(".")||str.equals("")) {
        		continue;
        	}else if(str.equals("..")) {
        		if(!stack.peekLast().equals(""))
        		stack.pollLast();
        	}
        	else stack.addLast(str);
        }

        if(stack.size()==1)
        	stack.addFirst("");
        return String.join("/",stack);
    }
    
    public static void main(String[] args) {
    	SimplifyPath solution = new SimplifyPath();
    	System.out.println(
    			solution.simplifyPath("/a/../../b/../c//.//"));
    	System.out.println(
    			solution.simplifyPath("/a//b////c/d//././/.."));
    	System.out.println(
    			solution.simplifyPath("/"));
    	System.out.println(
    			solution.simplifyPath("/../"));
	}
}