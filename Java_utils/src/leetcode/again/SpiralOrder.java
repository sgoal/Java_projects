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
        int rown = matrix.length,coln = matrix[0].length;
        int row=0,col=0,d = 0;
        int len = rown*coln;
        int up=0,down=rown,left=0,right=coln;
        for(int i=0;i<len;i++) {
        	System.out.println(row + "  " + col+" d " + d );
        	res.add(matrix[row][col]);
        	
        	row += dir[d][0];
        	col += dir[d][1];
        	
        	//System.out.println(row + "  " + col);
        	if(col>=right) {col=right-1;row++;d = (d+1)%4;}
        	
        	if(row>=down) {row=down-1;col++;d = (d+1)%4;}
        	if(col==right) {right--;col=right-1;}
//        	if(row==down)down--;
        	if(col<left){col=left;left++;d = (d+1)%4;}
        	if(row<up){col=up;up++;d = (d+1)%4;}
        }
        return res;
    }
    public static void main(String[] args) {
    	SpiralOrder solution = new SpiralOrder();
    	int [][] test = {{1,2,3},{4,5,6},{7,8,9}};
    	System.out.println(solution.spiralOrder(test));
	}
}
