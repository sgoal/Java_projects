package leetcode.again;

//https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1161/
//https://leetcode.com/problems/implement-strstr/
public class StrStrimpl {
    public int strStr(String haystack, String needle) {
       if(haystack==null||needle==null||haystack.length()<needle.length())return -1;
       if(needle.length()==0)return 0;
       int end = haystack.length()-needle.length()+1;
       for(int i=0;i<end;) {
    	  while(i<end&&haystack.charAt(i)!=needle.charAt(0)) {i++;}
    	  if(i<end) {
    		int j=0,je=needle.length()-1;
    		while(i+j<haystack.length()&&j<=je&&haystack.charAt(i+j)==needle.charAt(j)
    				&&haystack.charAt(i+je)==needle.charAt(je)) {j++;je--;}
    		//System.out.println(j + "  " + je + "  " + end);
    		if(j>je)return i;
    	  }
    	  i++;
       }
       return -1;
    }
    public static void main(String[] args) {
    	StrStrimpl solution = new StrStrimpl();
    	System.out.println(solution.strStr("abcdefg", "cd"));
    	System.out.println(solution.strStr("abcdefgggggh", "ggh"));
    	System.out.println(solution.strStr("aaaaaaaaaaaaaab", "aaaaaab"));
	}
}
