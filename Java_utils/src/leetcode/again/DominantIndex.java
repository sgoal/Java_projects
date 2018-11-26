package leetcode.again;

import java.util.Arrays;
import java.util.stream.IntStream;

//https://leetcode.com/problems/largest-number-at-least-twice-of-others/
//https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1147/
public class DominantIndex {
    public int dominantIndex(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        boolean ok = Arrays.stream(nums).allMatch(x->max==x || max>=2*x);
        System.out.println(ok+" fff "+max);
        return ok?IntStream.range(0, nums.length).filter(x->nums[x]==max).findFirst().getAsInt():-1;
       }
    public static void main(String[] args) {
		DominantIndex solution = new DominantIndex();
		System.out.println(solution.dominantIndex(new int[] {0,0,0,1}));
	}
}
