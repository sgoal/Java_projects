package leetcode.again;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
    	Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
    	set1.retainAll(
    			Arrays.stream(nums2).boxed().collect(Collectors.toSet()));
        return set1.stream().mapToInt(x->x).toArray();
    }
}