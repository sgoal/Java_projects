package my.threading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;

public class TwoThreadingPrint {
	static void method1() {
		Object lock = new Object();
		CountDownLatch latch = new CountDownLatch(1);
		Thread threadA = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				for(int i=0;i<5;i++)
					synchronized (lock) {
						System.out.print((2*i)+" ");
						lock.notifyAll();
						if(latch.getCount()>0)
							latch.countDown();
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					
			}
		});
		
		Thread threadB = new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							latch.await();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						for(int i=0;i<5;i++)
							synchronized (lock) {
								
								System.out.print((2*i+1)+" ");
								lock.notifyAll();
								try {
									lock.wait();
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							
							
					}
		});
		
		threadA.start();
		threadB.start();
		try {
			threadA.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void method2() {
		Exchanger<Integer> exchanger = new Exchanger<>();
		CountDownLatch latch = new CountDownLatch(1);
		Thread threadA = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				int i = 0;
				while(i<10) {
					System.out.print(i+" ");
					if(latch.getCount()>0)
						latch.countDown();
					try {
						exchanger.exchange(i);
						i+=2;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		
		Thread threadB = new Thread(new Runnable() {
			
			@Override
			public void run() {
				int i = 1;
				while(i<10) {
					try {
						latch.await();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.print(i+ " ");
					try {
						exchanger.exchange(i);
						i+=2;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
		});
		
		threadA.start();
		threadB.start();
		try {
			threadA.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		method1();
		method2();
	}
}
