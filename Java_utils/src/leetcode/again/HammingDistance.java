package leetcode.again;

//https://leetcode.com/problems/hamming-distance/
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int c = x^y;
        int count = 0;
        while(c!=0) {c&=c-1;count++;}
        return count;
    }
    public static void main(String[] args) {
    	HammingDistance solution = new HammingDistance();
    	System.out.println(solution.hammingDistance(1, 4));
	}
}
