package leetcode.again;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;

public class AllOne {
	TreeMap<Integer, HashSet<String>> map;
	HashMap<String, Integer> keysMap;
    /** Initialize your data structure here. */
    public AllOne() {
    	map = new TreeMap<>();
    	keysMap = new HashMap<>();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
    	int count = keysMap.getOrDefault(key, 0)+1;
    	keysMap.remove(key);
    	keysMap.put(key, count);
    	HashSet<String> set = map.getOrDefault(count-1, new HashSet<>());
    	set.remove(key);
    	if(!set.isEmpty()) {
    		keysMap.put(set.iterator().next(), count-1);
    	}else {
    		map.remove(count-1);
    	}
    	set = map.getOrDefault(count, new HashSet<>());
    	set.add(key);
        map.put(count, set);
    	System.out.println("----------inc----------");
    	System.out.println(map);
    	System.out.println(keysMap);
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(keysMap.containsKey(key)) {
        	int count = keysMap.get(key);
        	if(count==1) {
        		keysMap.remove(key);
        		HashSet<String> list = map.get(count);
        		list.remove(key);
        		if(list.isEmpty())map.remove(count);
        	}else {
        		keysMap.put(key, count-1);
        		HashSet<String> list = map.get(count);
        		list.remove(key);
        		if(list.isEmpty())map.remove(count);
        		list = map.getOrDefault(count-1, new HashSet<>());
        		list.add(key);
        		map.put(count, list);
        		
        	}
        }
    	System.out.println("----------dec----------");
    	System.out.println(map);
    	System.out.println(keysMap);
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
    	if(map.isEmpty())
    		return "";
    	System.out.println("--------------------");
    	System.out.println(map);
    	System.out.println(keysMap);
        return map.lastEntry().getValue().iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
    	if(map.isEmpty())
    		return "";
    	 return map.firstEntry().getValue().iterator().next();
    }
    
    public static void main(String[] args) {
		AllOne solution = new AllOne();
		solution.inc("hello");
		solution.inc("goodbey");
		solution.inc("hello");
		solution.inc("hello");
		System.out.println(solution.getMaxKey());
		solution.inc("leet");
		solution.inc("code");
		solution.inc("leet");
		solution.dec("hello");
		solution.inc("leet");
		solution.inc("code");
		solution.inc("code");
		System.out.println(solution.getMaxKey());
	}
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
