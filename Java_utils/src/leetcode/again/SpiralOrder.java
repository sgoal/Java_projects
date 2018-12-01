package leetcode.again;

import java.util.ArrayList;
import java.util.List;

//TODO to fix
//https://leetcode.com/problems/spiral-matrix/
//https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1168/
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix==null||matrix.length==0)return res;
        int[][] dir= {{0,1},{1,0},{0,-1},{-1,0}};//left,down,right,up
        boolean[][] seen = new boolean[matrix.length][matrix[0].length];
        int rown = matrix.length,coln = matrix[0].length;
        int row=0,col=0,d = 0;
        int len = rown*coln;
        for(int i=0;i<len;i++) {
//        	System.out.println(row + "  " + col+" d " + d );
        	res.add(matrix[row][col]);
        	
        	int rowt = row+dir[d][0];
        	int colt = col + dir[d][1];
        	seen[row][col]=true;
        	if(rowt>=0&&colt>=0&&rowt<rown&&colt<coln&&!seen[rowt][colt]) {
        		row = rowt;col=colt;
        	}else {
				d = (d+1)%4;
				row+=dir[d][0];
				col += dir[d][1];
			}
        }
        return res;
    }
    public static void main(String[] args) {
    	SpiralOrder solution = new SpiralOrder();
    	int [][] test = {{1,2,3},{4,5,6},{7,8,9}};
    	System.out.println(solution.spiralOrder(test));
	}
}
