package leetcode.again;

//https://leetcode.com/problems/maximize-distance-to-closest-person/
public class MaxDistToClosest {
    public int maxDistToClosest(int[] seats) {
        int count0 = 0;
    	int res = 0;
    	boolean has0 =false;
    	for(int i=0;i<seats.length;i++) {
        	if(seats[i]==0) {
        		count0++;
        		System.out.println(count0 +"-----" + res%2);
        		if(i==seats.length-1) {
        			res = Math.max(res, count0);
        		}else if(seats[i+1]==1) {
        			if(!has0)
        				res = Math.max(count0, res);
        			else if(count0%2==1)
        				res = Math.max(count0/2+1, res);
        			else
        				res = Math.max(count0/2, res);	
        		}
        	}
        	else {
        		has0=true;
        		count0=0;
        	}
        }

    	return res;
    }
    public static void main(String[] args) {
    	MaxDistToClosest solution = new MaxDistToClosest();
    	System.out.println(solution.maxDistToClosest(new int[] {
    			1,0,0,0,1,0,1	
    	}));
    	System.out.println(solution.maxDistToClosest(new int[] {
    			1,0,0,0	
    	}));
    	System.out.println(solution.maxDistToClosest(new int[] {
    			0,0	,1
    	}));
    	System.out.println(solution.maxDistToClosest(new int[] {
    			0,0,0,0	,1,0,1
    	}));
	}
}