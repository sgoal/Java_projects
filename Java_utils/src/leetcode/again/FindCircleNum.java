package leetcode.again;

import java.util.Arrays;
class UnionFind{
	int data[];
	int count=0;
	UnionFind(int size){
		data= new int[size+1];
		Arrays.fill(data, -1);
		count = size;
	}
	/**
	 * find set contain x,return parent index
	 * @param x
	 * @return
	 */
	int find(int x) {
		if(data[x]<0)return x;
		return data[x]=find(data[x]);
	}
	
	int find_naive(int x) {
		if(data[x]<0)return x;
		while(data[x]>=0)
			x = data[x];
		return x;
					
	}
	
	int union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if(px==py)return -1;
		if(data[px]<data[px]) {
			data[px]+= data[py];
			data[py]=px;
		}else {
			data[py]+= data[px];
			data[px]=py;
		}
		System.out.println(count);
		count--;
		return 0;				
	}
	
	int size(int x) {
		return -data[find(x)];				
	}
	int count() {return count;}
	
}
//https://leetcode-cn.com/problems/friend-circles/
public class FindCircleNum {
	

	
    public int findCircleNum1(int[][] M) {
        int count = 0,N=M.length;
        boolean[][] seen = new boolean[N][N];
        for(int i=0;i<N;i++)
        	for(int j=0;j<N;j++) {
        		if(!seen[i][j]&&M[i][j]==1) {
        			count++;
        			dfs(M, i, j, seen);
        		}
        	}
        return count;
    }
    
    public int findCircleNum(int[][] M) {
        int count = 0,N=M.length;
        UnionFind union = new UnionFind(N);
        for(int i=0;i<N;i++)
        	for(int j=0;j<N;j++) {
        		if(M[i][j]==1)
        		union.union(i, j);
        	}
        return union.count();
    }
    
    void dfs(int [][]M, int i, int j, boolean[][] seen) {
    	if(seen[i][j]||M[i][j]==0)return;
    	seen[i][j]=true;
    	for(int x=0;x<M.length;x++) {
    		dfs(M, j, x, seen);
    	}
    }
    
    public static void main(String[] args) {
		int[][] M = {{1,1,0},{1,1,0},{0,0,1}};
		FindCircleNum solution = new FindCircleNum();
		System.out.println(solution.findCircleNum(M));
	}
}