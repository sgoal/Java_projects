package my.concurrent;


public class ThreadState extends Thread{
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			waitState();
			
			synchronized (this) {
				
			}
			break;
		}
	}
	
	public synchronized void waitState() {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//LockSupport.park();
	}
	

	
	public static void main(String[] args) {
		ThreadState thread = new ThreadState();
		System.out.println("new state: "+thread.getState());
		thread.start();
		System.out.println("runnable state: "+thread.getState());
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
		}
		System.out.println("timed wait state: "+thread.getState());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("wait state: "+thread.getState());
		synchronized (thread) {
			thread.notify();
			System.out.println("blocked state: "+thread.getState());
		}
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("terminated state: "+thread.getState());
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
