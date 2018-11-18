package leetcode.again;

public class ArrangeCoins {
	  public int arrangeCoins(int n) {
	        int index = 1,times = 0;
	        while(n>times) {
	        	n-= index;
	        	times++;index++;
	        }
	        return times;
	        
	    }
	  public static void main(String[] args) {
		ArrangeCoins solution = new ArrangeCoins();
		System.out.println(solution.arrangeCoins(5));
	}
}
