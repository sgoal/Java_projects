package my.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegeTest {
	static int race_int = 0;
	static void increace() {
		race_int++;
	}
	public static void main(String[] args) {
		final AtomicInteger atomicInteger = new AtomicInteger(0);
		final AtomicInteger rightAtomicInteger = new AtomicInteger(0);
		final CASCounter casCounter = new CASCounter(0);
		for (int i = 0; i < 20; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					for (int j = 0; j < 1000; j++) {
						atomicInteger.set(atomicInteger.get()+1);
						increace();
						rightAtomicInteger.incrementAndGet();
						try {
							casCounter.increment();
						} catch (Throwable e) {
							e.printStackTrace();
						}
						
					}
					
				}
			}).start();
			
			
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(atomicInteger.get());
		System.out.println(race_int);
		System.out.println(rightAtomicInteger.get());
		System.out.println(casCounter.getValue());
	}
}
