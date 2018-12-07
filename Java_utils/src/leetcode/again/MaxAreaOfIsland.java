package leetcode.again;
//https://leetcode.com/problems/max-area-of-island/solution/
public class MaxAreaOfIsland {
	int max = 0;
	int area = 0;
    public int maxAreaOfIsland1(int[][] grid) {
    	max=0;
    	boolean[][] seen = new boolean[grid.length][grid[0].length];
    	for(int i=0;i<grid.length;i++)
    		for(int j=0;j<grid[0].length;j++) {
    			area = 0;
    			dfs(grid, seen, i, j);
    			}
    	return max;
    }
    
    void dfs(int[][] grid, boolean[][] seen, int i, int j ) {
    	if(i<0||j<0||i>=grid.length||j>=grid[0].length)return;
    	if(seen[i][j]||grid[i][j]==0)return;
    	seen[i][j]=true;
    	if(grid[i][j]==1)area++;

    	max = Math.max(max, area);
    	System.out.println(i+ " " + j + " " + grid[i][j] +" " + area);
    	dfs(grid, seen, i+1, j);
    	dfs(grid, seen, i-1, j);
    	dfs(grid, seen, i, j+1);
    	dfs(grid, seen, i, j-1);
    }
    
    public int maxAreaOfIsland(int[][] grid) {
    	max=0;
    	boolean[][] seen = new boolean[grid.length][grid[0].length];
    	for(int i=0;i<grid.length;i++)
    		for(int j=0;j<grid[0].length;j++) {
    			max = Math.max(max, areaCalc(grid,seen,i,j));
    			}
    	return max;
    }
    int areaCalc(int[][] grid, boolean[][] seen, int i, int j ) {
    	if(i<0||j<0||i>=grid.length||j>=grid[0].length)return 0;
    	if(seen[i][j]||grid[i][j]==0)return 0;
    	seen[i][j]=true;
    	int res = 0;
    	if(grid[i][j]==1)res++;
    	res +=areaCalc(grid, seen, i+1, j);
    	res+=areaCalc(grid, seen, i-1, j);
    	res+=areaCalc(grid, seen, i, j+1);
    	res+=areaCalc(grid, seen, i, j-1);
    	return res;
    }
    
    int bfs(int[][] grid, boolean[][] seen, int i, int j ) {
    	if(i<0||j<0||i>=grid.length||j>=grid[0].length)return 0;
    	if(seen[i][j]||grid[i][j]==0)return 0;
    	seen[i][j]=true;
    	int res = 0;
    	if(grid[i][j]==1)res++;
    	res +=areaCalc(grid, seen, i+1, j);
    	res+=areaCalc(grid, seen, i-1, j);
    	res+=areaCalc(grid, seen, i, j+1);
    	res+=areaCalc(grid, seen, i, j-1);
    	return res;
    }
    public static void main(String[] args) {
    	int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
    	MaxAreaOfIsland solution = new MaxAreaOfIsland();
    	System.out.println(solution.maxAreaOfIsland(grid));
    	
    	int [][]grid0 = {{1,1,},{1,0}};

    	System.out.println(solution.maxAreaOfIsland(grid0));
	}
}