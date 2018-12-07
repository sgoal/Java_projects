package leetcode.again;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

//https://leetcode.com/problems/accounts-merge/
public class AccountsMerge {
	
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
    	UnionFind unionFind = new UnionFind(1000*10+1);
    	HashMap<String, String> emailToName = new HashMap<>();
    	HashMap<String, Integer> emailToId = new HashMap<>();
    	int count = 0;
    	for(List<String> account:accounts) {
    		String name = "";
    		for(String email:account) {
    			if(name=="") {
    				name = email;continue;
    			}
    			if(!emailToName.containsKey(name)) {
    				emailToName.put(email, name);
    			}
    			if(!emailToId.containsKey(email)) {
    				emailToId.put(email, count++);
    			}
    			unionFind.union(emailToId.get(account.get(1)), emailToId.get(email));
    		}
    	}
    	HashMap<Integer, List<String>> res = new HashMap<>();
    	for(Entry<String, Integer> entry:emailToId.entrySet()) {
    		int parent = unionFind.find(entry.getValue());
    		res.computeIfAbsent(parent, x->new ArrayList<>()).add(entry.getKey());
    	}

    	for(List<String> a:res.values()) {
    		Collections.sort(a);
    		a.add(0, emailToName.get(a.get(0)));
    	}
    	return new ArrayList<>(res.values());
    }
}