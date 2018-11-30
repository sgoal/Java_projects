package leetcode.again;
//https://leetcode.com/problems/reverse-words-in-a-string-iii/
//https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1165/
public class ReverseWordsIII {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        int n = s.length();
        for(int i=0;i<n;) {
        	while(i<n&&s.charAt(i)==' ')i++;
        	int start = i;
        	while(i<n&&s.charAt(i)!=' ')i++;
        	for(int j=i-1;j>=start;j--)sb.append(s.charAt(j));
        	if(i<n)
        	sb.append(" ");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
		ReverseWordsIII solution = new ReverseWordsIII();
		System.out.println(solution.reverseWords("s'teL ekat edoCteeL tsetnoc"));
	}
}
