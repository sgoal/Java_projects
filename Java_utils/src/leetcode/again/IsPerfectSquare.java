package leetcode.again;

public class IsPerfectSquare {
	boolean isPerfectSquare(int num) {
		if(num<=1)return true;
		long l=0,r=num/2, i=0,temp=0;
		while(l<=r) {
			i = l+(r-l)/2;
			temp =i*i;
			if(temp==num)return true;
			else if (temp<num) l=i+1;
			else r = i-1;
		}
		return false;
	}
	public static void main(String[] args) {
		IsPerfectSquare solution = new IsPerfectSquare();
		System.out.println(solution.isPerfectSquare(2147483647));
		System.out.println(solution.isPerfectSquare(808201));
		System.out.println(solution.isPerfectSquare(9));
		System.out.println(solution.isPerfectSquare(16));
	}
}
