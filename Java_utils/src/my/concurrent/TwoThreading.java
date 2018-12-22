package my.concurrent;

public class TwoThreading {
	public static void main(String[] args) {
		Object lock = new Object();
		int[] nums = new int[] {1,2,3,4,5,6,7,8,9,10};
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.print(nums[i%10]);
				}
				
			}
		});
	}
}
