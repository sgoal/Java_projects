package leetcode.again;

//https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1183/
public class ReverseString {
    public String reverseString(String s) {
        if(s.length()==0)return s;
        int i=0,j=s.length()-1;
        char[] temp = s.toCharArray();
        while(i<j) {
        	char c = temp[i];
        	temp[i++]=temp[j];
        	temp[j--]=c;
        }
        return new String(temp);
    }
}
