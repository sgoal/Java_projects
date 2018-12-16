package leetcode.again;

import java.util.Arrays;

public class ReverseWordsI {
    public String reverseWords0(String s) {
        if(s.length()==0)return s;
        char[] temp = s.toCharArray();
        StringBuilder sb = new StringBuilder(s.length());
        s.length();
        int start = 0;
        for(int i=s.length()-1;i>=0;) {
        	if(temp[i]==' ')i--;
        	else {
        		start = i;
        		while(i>=0&&temp[i]!=' ')i--;

        		sb.append(s.substring(i+1, start+1));
        		sb.append(' ');
//        	System.out.println(sb);
        	}
        }
        return sb.toString().trim();
    }
    public String reverseWords(String s) {
        if(s.length()==0)return s;
        String[] words = s.trim().split("\\s+");
//        System.out.println(Arrays.toString(words));
        int i=0,j=words.length-1;
        while(i<j) {
        	String temp=words[i];
        	words[i++]=words[j];
        	words[j--]=temp;}
        return String.join(" ", words);
    }
    public static void main(String[] args) {
    	ReverseWordsI solution = new ReverseWordsI();
    	System.out.println(solution.reverseWords("hello"));
    	System.out.println(solution.reverseWords(" hello "));
    	System.out.println(solution.reverseWords("the sky is blue"));
    	System.out.println(solution.reverseWords(" hello  ni  hao  "));
	}
}
