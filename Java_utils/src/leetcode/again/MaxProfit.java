package leetcode.again;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int res = 0,min=Integer.MAX_VALUE;
        for(int i:prices) {
        	min = Math.min(i, min);
        	res = Math.max(i-min,res);
        }
        return res;
    }
    public static void main(String[] args) {
    	MaxProfit solution = new MaxProfit();
    	System.out.println(solution.maxProfit(new int[] {7,6,5,4,3}));
    	System.out.println(solution.maxProfit(new int[] {7,1,5,3,6,4}));
	}
}