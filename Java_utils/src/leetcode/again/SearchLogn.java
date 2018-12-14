package leetcode.again;

//https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1017/
public class SearchLogn {
    public int search(int[] nums, int target) {
        if(nums.length==0)return -1;
        int start = 0,end = nums.length-1,mid = 0;
        while(start<end) {
        	
        	mid = (end-start)/2+start;
        	System.out.println(mid + " " + start + "  " + end );
        	if(target==nums[start])return start;
        	if(target==nums[mid])return mid;
        	if(target==nums[end])return end;
        	if(nums[start]<nums[mid]) {//sorted
        		if(target<nums[start]||target>nums[mid]) {
        			start = mid+1;
        		}else {
        			end = mid-1;
        		}
        	}
        	else {
        		if(target<nums[mid]||target>nums[end]) {
        			end = mid-1;
        		}else {
        			start = mid+1;
        		}
        	}
        	System.out.println(mid + " " + start + "  " + end );
        }
        return nums[mid]==target?mid:-1;
    }
    public static void main(String[] args) {
    	SearchLogn solution = new SearchLogn();
//    	System.out.println(solution.search(new int[] {4,5,6,7,0,1,2}, 3));
//    	System.out.println(solution.search(new int[] {4,5,6,7,0,1,2}, 5));
//    	System.out.println(solution.search(new int[] {6,7,0,1,2,3,4,5}, 5));
//    	System.out.println(solution.search(new int[] {1,2,3,4,5,6}, 4));
//    	System.out.println(solution.search(new int[] {3,1}, 0));
    	System.out.println(solution.search(new int[] {8,1,2,3,4,5,6,7}, 6));
	}
}