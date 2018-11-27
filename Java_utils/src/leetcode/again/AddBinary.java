package leetcode.again;

//https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1160/
public class AddBinary {
    public String addBinary(String a, String b) {
        int c = 0;
        int la=a.length()-1,lb=b.length()-1;
        StringBuffer sb = new StringBuffer();
        while(c>0||la>=0||lb>=0) {
        	int ta = 0,tb=0;
        	if(la>=0)ta = a.charAt(la--)-'0';
        	if(lb>=0)tb = b.charAt(lb--)-'0';
        	int temp = ta+tb+c;
        	c = temp/2;
        	temp%=2;
        	sb.append(temp);
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
    	AddBinary solution = new AddBinary();
    	System.out.println(solution.addBinary("11", "1"));
	}
}
