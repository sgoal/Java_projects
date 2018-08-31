package my.concurrent;

public class VolatileTest {
	private volatile int race = 0;
	public void  increace() {
		race++;
	}
	public static void main(String[] args) {
		int threadNum =20;
		final VolatileTest volatileTest = new VolatileTest();
		for(int i=0;i<threadNum;i++) {
			Thread aThread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int j = 0; j < 1000; j++) {
						volatileTest.increace();
					}
					
				}
			});
			aThread.start();
		}
		
		while (Thread.activeCount()>1) {
			Thread.yield();
		}
		System.out.println(volatileTest.race);
	}
}
