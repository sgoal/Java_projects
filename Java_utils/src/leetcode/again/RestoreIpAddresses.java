package leetcode.again;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
      
//        helper(s, 0, res,new StringBuffer(), 3);
        helper0(s, 0, res, "", 0);
        return res;
    }
    void helper(String s, int index, List<String> res, StringBuffer str, int si) {
//    	System.out.println(str + " " + index+ " " + si);
    	if(si==-1&&index==s.length()) {
    		res.add(str.toString());
    		return;
    	}
    	if(si<0||index>=s.length())return;
    	
    	
    	if(index>0)
    		str.append(".");
    	for(int i=index;i<s.length();i++) {
    		String nString = s.substring(index, i+1);
    		int temp = Integer.valueOf(nString);
    		
    		if(temp<=255&&temp>=0&&((temp==0&&nString.length()==1) ||!nString.startsWith("0"))) {
    			str.append(nString);
    			
    			helper(s, i+1, res,str, si-1);
    			str.delete(str.length()-nString.length(), str.length());
    		}else {
				break;
			}
    		
    	}
    	if(index>0)
    		str.deleteCharAt(str.length()-1);
    }
    
    /*
     * step: 0,1,2,3,4
     */
    void helper0(String s, int index, List<String> res, String str, int step) {
    	if(s.length()-index>(4-step)*3)return;
    	if(s.length()-index<(4-step)*1)return;
    	if(step==4&&index==s.length()) {
    		res.add(str.substring(0, str.length()-1));
    		return;
    	}
    	int num=0;
    	for(int i=index;i<s.length();i++) {
    		num = num*10+s.charAt(i)-'0';
    		if(num<=255) {
    			str += s.charAt(i);
    			helper0(s, i+1, res, str+'.', step+1);
    		}
    		if(num==0)break;//leading zero
    	}
    }
    public static void main(String[] args) {
    	RestoreIpAddresses solution = new RestoreIpAddresses();
    	System.out.println(solution.restoreIpAddresses("25525511135"));
    	System.out.println(solution.restoreIpAddresses("010010"));

	}
}