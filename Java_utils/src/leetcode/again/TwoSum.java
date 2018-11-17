package leetcode.again;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
public class TwoSum {
	   
	   public int[] twoSum(int[] nums, int target) {
		   Map<Integer, Integer> aMap = new HashMap<>();
	       boolean found = false;
	       int[] data = {0,0};
		   IntStream.range(0, nums.length).filter(idx->{
			   if(aMap.containsKey(target-nums[idx])) {
				   data[0]=aMap.get(target-nums[idx]);
				   data[1]=idx;
				   return !found;}
			   else {
				   aMap.put(nums[idx], idx);
				   return true;
			   }
		   }).toArray();
		   return data;
	    }
	   
	   public static void main(String[] args) {
		TwoSum twoSum = new TwoSum();
		System.out.println(Arrays.toString(
				twoSum.twoSum(new int []{3,2,4},6)));
		System.out.println(Arrays.toString(
				twoSum.twoSum(new int []{2,7,11,15},9)));
		System.out.println(Arrays.toString(
				twoSum.twoSum(new int []{3,3},6)));
	}
}
