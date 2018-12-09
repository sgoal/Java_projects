package leetcode.again;

public class MaxProfitII {
    public int maxProfit1(int[] prices) {
        int res = 0;
        int now = Integer.MAX_VALUE;
        for(int i:prices) {
        	if(i>now) {res+=i-now;}
        	now=i;
        }
        return res;
    }
    public int maxProfit(int[] prices) {
        int res = 0;
        int i=0,n=prices.length;
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        while(i<n-1) {
        	while(i<n-1&&prices[i]>=prices[i+1])i++;
        	min=prices[i];
        	while(i<n-1&&prices[i]<=prices[i+1])i++;
        	max = prices[i];
        	res += max-min;
        		
        }
        return res;
    }
    public static void main(String[] args) {
    	MaxProfitII solution = new MaxProfitII();
    	System.out.println(solution.maxProfit(new int[] {5,4,3,2,1}));
    	System.out.println(solution.maxProfit(new int[] {1,2,3,4,5}));
    	System.out.println(solution.maxProfit(new int[] {7,1,5,3,6,4}));
	}
}