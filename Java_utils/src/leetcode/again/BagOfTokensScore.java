package leetcode.again;

import java.util.Arrays;

//https://leetcode.com/problems/bag-of-tokens/
public class BagOfTokensScore {
	//if I can,I will got all point == tokens.length
	//but I can't,because I dont have enough power; but I can use 1 point buy most power,then I use least power to get a point;
	//So I sorted array,then I get point as can as possible,then I buy a largest token, then I get point as can as possible....
    public int bagOfTokensScore(int[] tokens, int P) {
    	if(tokens.length==0)return 0;
        int max= 0;
        int cur = 0;
    	Arrays.sort(tokens);
        int least = 0,largest = tokens.length-1;
        System.out.println(Arrays.toString(tokens));
        while(least<=largest&&P>=tokens[least]) {
        	while(least<=largest&&P>=tokens[least]) {P-=tokens[least++];cur++; max = Math.max(max, cur);}
        	if(least<=largest&&cur>0) {P+=tokens[largest--];cur--;}
        } 
        return max;
    }
    
    public static void main(String[] args) {
    	BagOfTokensScore solution = new BagOfTokensScore();
    	System.out.println(solution.bagOfTokensScore(new int[] {27}, 50));
    	System.out.println(solution.bagOfTokensScore(new int[] {100}, 50));
    	System.out.println(solution.bagOfTokensScore(new int[] {100,200}, 150));
    	System.out.println(solution.bagOfTokensScore(new int[] {100,200,300,400}, 200));
    	System.out.println(solution.bagOfTokensScore(new int[] {100,50,200,300}, 200));
    	System.out.println(solution.bagOfTokensScore(new int[] {33,4,28,24,96}, 35));

	}
}
