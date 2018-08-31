package my.concurrent;

public class CASCounter{
	private SimulatedCAS value;

	public CASCounter(int newValue) {
		value = new SimulatedCAS(newValue);
	}
	public int getValue() {return value.get();}
	
	public int increment() {
		int v=value.get();
		while(v!=value.compareAndSwap(v, v+1)) {
			v=value.get();
		}
//		do{
//			v = value.get();
//		}while(v != value.compareAndSwap(v, v+1));
		return v+1;
	}
	
}
