package leetcode.again;
//https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1046/
public class GetPermutation {
    String res = "";
    int num = 0;
	public String getPermutation(int n, int k) {
		res = "";
		boolean[] seen = new boolean[n+1];
		helper(1, "", 0, n, k,seen);
        return res;
    }
	boolean helper(int index, String temp, int step, int n, int k,boolean[] seen) {
        if(num==k) {
        	res=temp;
        	return true;
        }

        for(int i=1;i<=n;i++) {
        	if(seen[i])continue;
        	seen[i]=true;
            if(temp.length()==n-1)
            	num++;
        	if(helper(index+1, temp+i, step, n, k,seen)) {
        		return true;
        	}
        	seen[i]=false;
        }
        return false;
    }
	public static void main(String[] args) {
		GetPermutation solution = new GetPermutation();
		System.out.println(solution.getPermutation(3, 5));
	}
}
