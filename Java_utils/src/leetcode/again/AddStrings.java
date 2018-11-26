package leetcode.again;

//https://leetcode.com/problems/add-strings/
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int c1=num1.length()-1,c2 = num2.length()-1;
        int c= 0,temp=0,t1=0,t2=0;
        StringBuffer sb = new StringBuffer();
        while (c1>=0||c2>=0||c>0) {
        	t1='0';t2='0';
        	if(c1>=0)t1 =num1.charAt(c1);
        	if(c2>=0)t2 =num2.charAt(c2);
			temp = t1-'0'+t2-'0'+c;
			System.out.println(temp+" "+(t1-'0')+"  "+(t2-'0'));
			c = temp/10;
			temp%=10;
			sb.append(temp);
			c1--;c2--;
			//System.out.println(sb);
		}
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
    	AddStrings solution = new AddStrings();
    	System.out.println(solution.addStrings("111", "19"));
    	System.out.println('1'-'0');
	}
}
