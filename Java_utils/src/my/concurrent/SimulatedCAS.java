package my.concurrent;

public class SimulatedCAS {
	private int value;
	SimulatedCAS(int newValue){
		value = newValue;
	}
	public synchronized int get() {
		return value;
	}
	
	public synchronized int compareAndSwap(int expectedValue, int newValue) {
		int oldValue = value;
		if(oldValue==expectedValue)
			value = newValue;
		return oldValue;
	}
	
	public synchronized boolean compareAndSet(int expectedValue, int newValue) {
		return (expectedValue == compareAndSwap(expectedValue, newValue));
	}
}

