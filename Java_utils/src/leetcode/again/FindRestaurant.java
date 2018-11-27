package leetcode.again;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//https://leetcode.com/problems/minimum-index-sum-of-two-lists/
public class FindRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = IntStream.range(0, list1.length).mapToObj(Integer::valueOf).collect(Collectors.toMap(i->(String)list1[i],i->i));
        int min = Integer.MAX_VALUE;
        ArrayList<String> res = new ArrayList<>();
        for(int i=0;i<list2.length;i++) {
        	if(map.containsKey(list2[i])) {
        		if(i+map.get(list2[i])<min) {
        			res.clear();
        			min = i+map.get(list2[i]);
        			res.add(list2[i]);
        		}else if (i+map.get(list2[i])==min) {
        			min = i+map.get(list2[i]);
        			res.add(list2[i]);
				}
        	}
        }
        return res.stream().toArray(String[]::new);
    }
}