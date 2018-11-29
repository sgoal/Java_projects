package leetcode.again;

//https://leetcode.com/problems/max-consecutive-ones/
//https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1301/
public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int res=0;
        for(int i=0;i<nums.length;i++) {
        	if(nums[i]==1) {count++;res = Math.max(res, count);}
        	else {
				count=0;
			}
        }

        return res;
    }
    public static void main(String[] args) {
		FindMaxConsecutiveOnes solution = new FindMaxConsecutiveOnes();
		System.out.println(solution.findMaxConsecutiveOnes(new int[] {1}));
		System.out.println(solution.findMaxConsecutiveOnes(new int[] {0}));
		System.out.println(solution.findMaxConsecutiveOnes(new int[] {1,1,0,1,1,1}));
	}
}
