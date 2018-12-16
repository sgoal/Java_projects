package leetcode.again;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 */

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class MergeInterval {
	public List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, (x,y)->x.start-y.start);
		int n = intervals.size();
		List<Interval> ans = new ArrayList<>();
		for(int i=0;i<n;i++) {
			if(i==0) {ans.add(intervals.get(i));continue;}
			Interval cur = ans.get(ans.size()-1),next=intervals.get(i);
			if(cur.end>=next.start)
				ans.set(ans.size()-1, new Interval(cur.start, Math.max(next.end,cur.end)));
			else
				ans.add(next);
			}
		return ans;
	}
}