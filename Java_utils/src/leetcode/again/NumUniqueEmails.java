package leetcode.again;

import java.util.ArrayList;
import java.util.HashSet;

public class NumUniqueEmails {
	   public int numUniqueEmails(String[] emails) {
	     HashSet<String> set = new HashSet<>();
	     for(String string:emails) {
	    	 int index = string.lastIndexOf('@');
	    	 String localName = string.substring(0,index);
	    	 StringBuilder sb = new StringBuilder();
	    	 for(char c:localName.toCharArray()) {
	    		 if(c=='+')break;
	    		 if(c=='.')continue;
	    		 sb.append(c);
	    	 }
	    	 sb.append(string.substring(index));
	    	set.add(sb.toString());
	     }
	     return set.size();
	    }
	   public static void main(String[] args) {
		NumUniqueEmails uniqueEmails = new NumUniqueEmails();
		int i = uniqueEmails.numUniqueEmails(new String[] {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"})
;		System.out.println(i);
		}
}
