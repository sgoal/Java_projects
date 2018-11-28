package leetcode.again;

//https://leetcode.com/problems/buddy-strings/
public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if(A.length()!=B.length())return false;
        if(A.equals(B)) {
        	char [] hash = new char[256];
            for(int i=0;i<A.length();i++) {
            	hash[A.charAt(i)]++;
            	if(hash[A.charAt(i)]>1)return true;
            }
            return false;
        }
        int count = 0;
        int p0 = -1,p1=-1;
        for(int i=0;i<A.length();i++) {
        	if(A.charAt(i)!=B.charAt(i)) {count++;
        	if(p0==-1&&count==1) {p0=i;};
        	if(p1==-1&&count==2) {p1=i;};
        	if(count>2)return false;
        	}
        	
        }
        return count == 2&&A.charAt(p0)==B.charAt(p1)&&A.charAt(p1)==B.charAt(p0);
    }
    public static void main(String[] args) {
    	BuddyStrings solution = new BuddyStrings();
    	System.out.println(solution.buddyStrings("ab", "ba"));
    	System.out.println(solution.buddyStrings("abcgh", "bacgh"));
    	System.out.println(solution.buddyStrings("acghb", "bacgh"));
	}
}