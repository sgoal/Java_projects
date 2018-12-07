package leetcode.again;

import java.util.Arrays;

//https://leetcode-cn.com/problems/permutation-in-string/
public class Multiply {
    public String multiply(String num1, String num2) {
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        int n1=arr1.length,n2=arr2.length;
        int index1=n1-1,index2=n2-1,c=0;
        int[] res = new int[10000];
        StringBuilder sb = new StringBuilder(n1+n2+2);
        int base = 1;
        for(int j=index1;j>=0;j--) {
        	char c1 = arr1[j];
        	int t1 = (c1-'0')*base;
        	for(int i=index2;i>=0;i--) {
        		int t2 = arr2[i]-'0';
        		res[index2-j+index1-i]+= t1*t2;
        	}
        }
        System.out.println(Arrays.toString(res));
        int len = res.length-1;
        while(len>=0&&res[len]==0 )len--;
        for(int i=0;i<=len;i++) {
        	
        	int t = (res[i]+c)%10;
        	c = (res[i]+c)/10;
        	sb.append(t);
    	}
        if(c>0||sb.length()==0)
        	sb.append(c);
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
    	Multiply solution = new Multiply();
    	System.out.println(solution.multiply("123", "235"));
    	System.out.println(solution.multiply("408", "8"));
    	System.out.println(solution.multiply("408", "5"));
    	System.out.println(solution.multiply("408", "0"));
	}
}