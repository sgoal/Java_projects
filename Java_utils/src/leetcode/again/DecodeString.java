package leetcode.again;

public class DecodeString {
    public String decodeString1(String s) {
       if(s==null||s.isEmpty())return "";
       int num = 0;
       int left=0,start=0;
       StringBuilder res = new StringBuilder();
       for(int i=0;i<s.length();i++) {
    	   char cur = s.charAt(i);
    	   if(cur<='9'&&cur>='0'&&left==0) {
    		   num = cur-'0' + 10*num;
    	   }else {
    		   if(cur=='[') {
    			   if(left==0) {start=i;}
    			   left++;
    		   }
    		   else if(cur==']') {
    			   left--;
    			   if(left==0) {
    				   String temp = decodeString(s.substring(start+1, i));
        			   //System.out.println(temp+ "  " + num);
    				   for(int j=0;j<num;j++)
        				   res.append(temp);
        			   num=0;
        		   }
    		   }else {
    			   if(left==0)
    				   res.append(cur);
    		   }
    		   
    	   }
       }
       return res.toString();
    }
    public String decodeString(String s) {
        if(s==null||s.isEmpty())return "";
        tempAns = "";
        helper(0,s);
        return tempAns;
     }
    String tempAns = "";
    public int helper(int start, String s) {
    	String res= "";
    	int i=start;
    	int num = 0;
    	while(i<s.length()&&s.charAt(i)!=']') {
    		char cur = s.charAt(i);
    		
    		if(cur>='0'&&cur<='9') {
    			while(i<s.length()&&(cur=s.charAt(i))>='0'&&cur<='9') {
    				num = num*10+cur-'0';
    				i++;
    			}
    			i++;//[
    			i =helper(i,s);
    			System.out.println(tempAns);
    			i++;//]
    			while(num>0) {
    				res+= tempAns;
    				num--;
    			}
    	
    			
    		}else {
    			res += cur;
    			i++;
    		}
    	}
    	tempAns = res;
    	return i;
    }
    public static void main(String[] args) {
		DecodeString solution = new DecodeString();
		System.out.println(solution.decodeString("3[ab2[g]]"));
		System.out.println(solution.decodeString("3[ff]g10[vfg]"));
		System.out.println(solution.decodeString("3[ff3[v5[t]]]"));
	}
}