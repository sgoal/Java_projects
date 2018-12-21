package my.threading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC {
	static class SyncPrinter implements Runnable {
		Object prev;
		Object next;
		Object self;
		char c;
		CountDownLatch startLatch;
		public SyncPrinter(char cur, Object prev, Object self, Object next,CountDownLatch latch) {
			this.prev = prev;
			this.next = next;
			this.self = self;
			c = cur;
			startLatch = latch;
		}

		@Override
		public void run() {
			int count = 0;
			startLatch.countDown();
			while (count <10) {
				synchronized (prev) {
					synchronized (self) {
						System.out.print(c);
						count++;
						self.notifyAll();
						
					}
					try {
						  
						/**
                         * JVM会在wait()对象锁的线程中随机选取一线程，赋予其对象锁，唤醒线程，继续执行。没办法结束线程
                         */
						//prev.wait();    
						
						if(count<10) {
							prev.wait();    
						}else {
							prev.notifyAll();
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}

	}
	static void method1() throws Exception{
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		
		CountDownLatch startLatcha = new CountDownLatch(1);
		CountDownLatch startLatchb= new CountDownLatch(1);
		CountDownLatch startLatchc= new CountDownLatch(1);
		Thread threadA = new Thread(new SyncPrinter('A', c, a, b,startLatcha));
		Thread threadB = new Thread(new SyncPrinter('B', a, b, c,startLatchb));
		Thread threadC = new Thread(new SyncPrinter('C', b, c, a,startLatchc));
		threadA.start();
		startLatcha.await();
		threadB.start();
		startLatchb.await();
		threadC.start();
		
		threadC.join();
	}
	
	static class LockPrinter implements Runnable{
		static int state = 0;
		ReentrantLock lock;
		char p;
		int mod;
		public LockPrinter(ReentrantLock lock, char c, int mod) {
			this.lock = lock;
			p = c;
			this.mod = mod;
		}
		@Override
		public void run() {
			int count = 10;
			while(count>0) {
				try {
					lock.lock();
					
					while(state%3==mod) {
						System.out.print(p);
						count--;
						state++;
					}
				} finally {
					lock.unlock();
				}
				
				
				
			}
			
		}
		
	}
	static void method2() throws Exception {
		ReentrantLock lock = new ReentrantLock();
		Thread threadA = new Thread(new LockPrinter(lock, 'A', 0));
		Thread threadB = new Thread(new LockPrinter(lock, 'B', 1));
		Thread threadC = new Thread(new LockPrinter(lock, 'C', 2));
		threadA.start();
		threadB.start();
		threadC.start();
		threadC.join();
	}
	
	static class ConditionPrinter implements Runnable{
		static ReentrantLock lock = new ReentrantLock();
		static Condition A = lock.newCondition();
		static Condition B = lock.newCondition();
		static Condition C = lock.newCondition();
		static int state =0;
		
		char c = 0;
		int mod=0;
		public ConditionPrinter(int mod, char c) {
			this.c = c;
			this.mod = mod;
		}
		@Override
		public void run() {
			int count = 0;
			while(count<10) {
				try {
					lock.lock();
					while (state%3!=mod) {
						if(mod==0)
							A.await();//释放锁
						if(mod==1)
							B.await();
						if(mod==2)
							C.await();
					}
					System.out.print(c);
					count++;
					state++;
					if(mod==0)
						B.signal();//唤醒后一个,释放锁以后另外一个才会能获取锁
					if(mod==1)
						C.signal();
					if(mod==2)
						A.signal();
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					lock.unlock();
				}
			}
			
		}
		
	}
	static void method3() throws Exception {
		Thread threadA = new Thread(new ConditionPrinter(0,'A'));
		Thread threadB = new Thread(new ConditionPrinter(1,'B'));
		Thread threadC = new Thread(new ConditionPrinter(2,'C'));
		threadA.start();
		threadB.start();
		threadC.start();
		threadC.join();
	}
	public static void main(String[] args) throws Exception {
		method1();
		System.out.println();
		method2();
		System.out.println();
		method3();
		
	}
}
