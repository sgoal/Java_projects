package leetcode.again;

import java.util.TreeMap;

//https://leetcode.com/problems/hand-of-straights/
public class IsNStraightHand {
    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for(int i:hand) {
        	if(count.containsKey(i)) {
        		count.replace(i, count.get(i)+1);
        	}else {
        		count.put(i, 1);
        	}
        }
        
        while(count.size()>0) {
        	int first = count.firstKey();
        	for(int i=0;i<W;i++) {
        		if(!count.containsKey(i+first))return false;
        		if(count.get(i+first)==1)count.remove(i+first);
        		else {
        			count.replace(i+first, count.get(i+first)-1);
        		}
        		
        	}
        }
        return true;
        
    }
}
