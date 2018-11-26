package leetcode.again;

import java.util.Arrays;

//https://leetcode.com/problems/diagonal-traverse/
//https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1167/
public class FindDiagonalOrder {
	public int[] findDiagonalOrder1(int[][] matrix) {
		if(matrix==null||matrix.length==0)return new int[0];
		int rown = matrix.length,coln=matrix[0].length;
		int len = coln*rown;
		int res[] = new int[len];
		int dir[][] = {{-1,1},{1,-1}};//right-up,left-down
		int row=0,col=0;
		int d = 0;
		for(int i=0;i<len;i++) {

			res[i] = matrix[row][col];
			row += dir[d][0];
			col += dir[d][1];
	
			if(col>=coln) {col=coln-1;row+=2;d=1-d;}
			if(row>=rown) {row=rown-1;col+=2;d=1-d;}
			if(row<0) {row=0;d=1-d;}
			if(col<0) {col=0;d=1-d;}
		}
		return res;
	}
	
	/**
	 * i+j == constant
	 * i+j is even,up-right
	 * @param matrix
	 * @return
	 */
	public int[] findDiagonalOrder(int[][] matrix) {
		if(matrix==null||matrix.length==0)return new int[0];
		int rown = matrix.length,coln=matrix[0].length;
		int len = coln*rown;
		int res[] = new int[len];
		int row=0,col=0;
		int count = 0;
		for(int i=0;i<len;i++) {
			res[i]=matrix[row][col];
			if(count%2==0) {
				row--;
				col++;
				int add = 0;
				
				if(col>=coln) {col=coln-1;row+=2;add=1;}
				if(row<0) {row=0;add=1;} 
				count += add;
			}
			else {
				row++;
				col--;
				int add = 0;
				
				if(row>=rown) {row=rown-1;col+=2;add=1;}
				if(col<0) {col=0;add=1;}
				count += add;
			}
		
		}
		return res;
	}

	public static void main(String[] args) {
		FindDiagonalOrder solution = new FindDiagonalOrder();
		int[][] test = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(Arrays.toString(solution.findDiagonalOrder(test)));
		test = new int[][] { { 3 }, { 2 } };
		System.out.println(Arrays.toString(solution.findDiagonalOrder(test)));
	}
}
