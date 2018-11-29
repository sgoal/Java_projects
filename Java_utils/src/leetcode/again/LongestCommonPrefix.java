package leetcode.again;

//https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1162/
//https://leetcode.com/problems/longest-common-prefix/
//https://leetcode.com/problems/longest-common-prefix/solution/
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
    	if(strs.length==0)return "";
    	if(strs.length==1)return strs[0];
        for(int i=0;;i++) {
        	String last = null;
        	for(String s:strs) {
        		if(i>=s.length())return s;
        		if (last!=null&&last.charAt(i)!=s.charAt(i)) {
					return s.substring(0, i);
				}
        		last=s;
        	}
        }
        
    }
    public static void main(String[] args) {
    	LongestCommonPrefix solution = new LongestCommonPrefix();
    	System.out.println(solution.longestCommonPrefix(new String[] {"ghggg","ghg","ghg6821"}));
    	System.out.println(solution.longestCommonPrefix(new String[] {"g","ghg","ghg6821"}));
    	System.out.println(solution.longestCommonPrefix(new String[] {"g","ghg","hhg6821"}));
    	System.out.println(solution.longestCommonPrefix(new String[] {"g","ghg","hhg6821"}));
    	System.out.println(solution.longestCommonPrefix(new String[] {"g","g","g"}));
	}
}